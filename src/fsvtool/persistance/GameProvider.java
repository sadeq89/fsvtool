/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fsvtool.persistance;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author S.Ahmet
 */
public class GameProvider extends AbstractProvider {

    protected String createSQL = "CREATE TABLE IF NOT EXISTS FSV_GAME\n"
            + "(\n"
            + "   ID INT AUTO_INCREMENT PRIMARY KEY NOT NULL,\n"
            + "   GAME_TYPE INT NOT NULL,\n"
            + "   GAME_DATE DATE NOT NULL,\n"
            + "   GAME_TIME TIME NOT NULL,\n"
            + "   LOCATION VARCHAR(255) NOT NULL,\n"
            + "   MAX_PLAYER_COUNT INT NOT NULL\n"
            + ");\n"
            + "CREATE UNIQUE INDEX IF NOT EXISTS PRIMARY_KEY_FSV_GAME ON FSV_GAME(ID);"
            + "CREATE TABLE IF NOT EXISTS FSV_GAME_USER\n"
            + "(\n"
            + "   GAME_ID integer NOT NULL,\n"
            + "   USER_ID integer NOT NULL,\n"
            + "   TEAM integer NOT NULL DEFAULT 0,\n"
            + "   CONSTRAINT IF NOT EXISTS FSV_GAME_USER_PKEY PRIMARY KEY(GAME_ID, USER_ID)\n"
            + ");\n";
    private GamesTableModell gameTableModell;

    public GameProvider(EntityManager em) {
        super(em);
    }

    @Override
    public String getCreateSQL() {
        return this.createSQL;
    }

    public GamesTableModell getTableModell() {
        if (this.gameTableModell == null) {
            this.gameTableModell = new GamesTableModell(this);
        }
        return this.gameTableModell;
    }

    public int getCount() {
        String sql = "SELECT count(*) as count FROM FSV_GAME;";
        try {
            Statement stm = this.em.createStatement();
            ResultSet result = stm.executeQuery(sql);
            result.first();
            return result.getInt("count");
        } catch (SQLException ex) {
            ex.printStackTrace();
            return 0;
        }
    }

    public IGame getGameById(Integer id) {
        PreparedStatement stm;
        try {
            stm = em.getConn().prepareStatement(
                    "SELECT id, game_type, game_date, game_time, lacation, "
                    + " max_player_count "
                    + " FROM FSV_GAME WHERE id = ?");
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            if (rs.first()) {
                Game game = new Game(rs.getInt("id"));
                game.setGameType(rs.getInt("game_type"));
                game.setDate(rs.getDate("game_date"));
                game.setTime(rs.getTime("game_time"));
                game.setGameLocation(rs.getString("location"));
                game.setMaxPlayerCount(rs.getInt("max_player_count"));
                this.fillGameWithPlayer(game);

                return game;
            } else {
                return null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserProvider.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public List<IGame> getAllGames() {
        ArrayList<IGame> list = new ArrayList<>();
        PreparedStatement stm;
        try {
            stm = em.getConn().prepareStatement("SELECT g.ID as id, g.game_date as date, "
                    + " g.game_time as time, g.game_type, "
                    + " g.max_player_count as player_count, "
                    + " g.location as location, gu.user_id as user_id "
                    + " FROM FSV_GAME g"
                    + " LEFT JOIN FSV_GAME_USER gu ON g.id = gu.game_id"
                    + " WHERE (gu.user_id IS NULL OR gu.user_id = ?) ");
            Integer loggedinUserId = em.getLoggedinUser().getId();
            stm.setInt(1, loggedinUserId);
            ResultSet rs = stm.executeQuery();

            // Liste mit Game objecten füllen
            while (rs.next()) {
                Game game = new Game(rs.getInt("id"));
                game.setGameType(rs.getInt("game_type"));
                game.setDate(rs.getDate("date"));
                game.setTime(rs.getTime("time"));
                game.setMaxPlayerCount(rs.getInt("player_count"));
                game.setGameLocation(rs.getString("location"));

                // Add player to the game
                this.fillGameWithPlayer(game);

                // Check if the current user is in game
                Integer userId = rs.getInt("user_id");
                if (userId.equals(loggedinUserId)) {
                    game.setIsInGame(true);
                } else {
                    game.setIsInGame(false);
                }
                list.add(game);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(UserProvider.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public void saveGame(IGame game) {
        Integer id = game.getId();
        String sql;

        if (id != null) {
            sql = "UPDATE FSV_GAME "
                    + "SET GAME_TYPE=?, game_date=?, game_time=?, "
                    + "location=?, MAX_PLAYER_COUNT=? "
                    + "WHERE ID=?";
        } else {
            sql = "INSERT INTO FSV_GAME "
                    + "(GAME_TYPE, game_date, game_time, location, MAX_PLAYER_COUNT) "
                    + "VALUES (?, ?, ?, ?, ?) ";
        }

        try {
            PreparedStatement stm = em.getConn().prepareStatement(sql);
            stm.setInt(1, game.getGameType());
            stm.setDate(2, game.getDate());
            stm.setTime(3, game.getTime());
            stm.setString(4, game.getGameLocation());
            stm.setInt(5, game.getMaxPlayerCount());
            if (id != null) {
                stm.setInt(6, id);
            }
            stm.execute();

            if (id == null) {
                ResultSet keys = stm.getGeneratedKeys();
                keys.next();

                // Cast to game and set id
                ((Game) game).setId(keys.getInt(1));
            }
            sql = "DELETE FROM FSV_GAME_USER "
                    + " WHERE GAME_ID = ? ";
            try {
                stm = em.getConn().prepareStatement(sql);
                stm.setInt(1, game.getId());
                stm.execute();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

            for (IUser user : game.getPlayerInTeam(IGame.TEAM_A)) {
                this.addPlayerToTeam(user, IGame.TEAM_A, game);
            }
            for (IUser user : game.getPlayerInTeam(IGame.TEAM_B)) {
                this.addPlayerToTeam(user, IGame.TEAM_B, game);
            }
            for (IUser user : game.getPlayerInTeam(IGame.TEAM_NO_TEAM)) {
                this.addPlayerToTeam(user, IGame.TEAM_NO_TEAM, game);
            }

            this.gameTableModell.fireTableDataChanged();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void addPlayerToTeam(IUser player, int team, IGame game) {
        PreparedStatement stm;

        // Add it than
        String sql = "INSERT INTO FSV_GAME_USER "
                + "(GAME_ID, USER_ID, TEAM) "
                + "VALUES (?, ?, ?)";
        try {
            stm = em.getConn().prepareStatement(sql);
            stm.setInt(1, game.getId());
            stm.setInt(2, player.getId());
            stm.setInt(3, team);
            stm.execute();
            this.gameTableModell.fireTableDataChanged();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void fillGameWithPlayer(Game game) {
        int teamId;
        IUser user;
        String sql = "SELECT GAME_ID, USER_ID, TEAM "
                + "FROM FSV_GAME_USER "
                + "WHERE GAME_ID = ?";
        try {
            PreparedStatement stm = em.getConn().prepareStatement(sql);
            stm.setInt(1, game.getId());
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                teamId = rs.getInt("TEAM");
                user = this.em.getUserProvider().getUserById(rs.getInt("User_ID"));
                game.addPlayerToTeam(user, teamId);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public IGame createGame() {
        return new Game();
    }
}
