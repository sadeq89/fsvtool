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
    
    protected String createSQL = "CREATE TABLE IF NOT EXISTS FSV_GAME\n" +
        "(\n" +
        "   ID integer PRIMARY KEY NOT NULL,\n" +
        "   GAME_TYPE integer NOT NULL,\n" +
        "   GAME_DATE DATE NOT NULL,\n" + 
        "   GAME_TIME TIME NOT NULL,\n" + 
        "   LOCATION VARCHAR(255) NOT NULL,\n" +
        "   MAX_PLAYER_COUNT integer NOT NULL\n" +
        "   PLAYER_IN_GAME integer NOT NULL\n" + 
        ");\n" +
        "CREATE UNIQUE INDEX IF NOT EXISTS PRIMARY_KEY_FSV_GAME ON FSV_GAME(ID);" + 
        "CREATE TABLE IF NOT EXISTS FSV_GAME_USER\n" +
        "(\n" +
        "   GAME_ID integer NOT NULL,\n" +
        "   USER_ID integer NOT NULL,\n" +
        "   CONSTRAINT IF NOT EXISTS FSV_GAME_USER_PKEY PRIMARY KEY(GAME_ID, USER_ID)\n" +
        ");\n";
    
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
        String sql = "SELECT count(*) FROM FSV_GAME;";
        try {
            Statement stm = this.em.createStatement();
            ResultSet result = stm.executeQuery(sql);
            return result.getInt(1);
        } catch (SQLException ex) {
            Logger.getLogger(GameProvider.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }
    
    public IGame getGameById(Integer id) {
        PreparedStatement stm;
        try {
            stm = em.getConn().prepareStatement(
                    "SELECT id, game_type, game_date, game_time, lacation, "
                    + " max_player_count, player_in_game "
                    + " FROM FSV_GAME WHERE id = ?");
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            if (rs.first()) {
                Game game = new Game(rs.getInt("id"));
                game.setGameType(rs.getInt("game_type"));
                game.setDate(rs.getDate("game_date"));
                game.setTime(rs.getTime("game_time"));
                game.setGameLocation(rs.getString("location"));
                game.setMaxPlayerCount(rs.getInt("player_count"));
                game.setPlayerInGameCount(rs.getInt("player_in_game"));
                
                return game;
            }
            else {
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
            stm = em.getConn().prepareStatement("SELECT g.id as id, g.game_date as date, "
                    + " g.game_time as time, "
                    + " g.max_player_count as player_count, g.player_in_game as player_in_game "
                    + " g.location as location, gu.user_id as user_id "
                    + " FROM FSV_GAME g"
                    + " LEFT JOIN FSV_GAME_USER gu ON g.id = gu.game_id"
                    + " WHERE (gu.user_id IS NULL OR gu.user_id = ?");
            Integer loggedinUserId = em.getLoggedinUser().getId();
            stm.setInt(1, loggedinUserId);
            ResultSet rs = stm.executeQuery();
            
            // Liste mit Game objecten füllen
            while (rs.next()) {
                Game game = new Game(rs.getInt("id"));
                game.setDate(rs.getDate("date"));
                game.setTime(rs.getTime("time"));
                game.setMaxPlayerCount(rs.getInt("player_count"));
                game.setPlayerInGameCount(rs.getInt("player_in_game"));
                game.setGameLocation(rs.getString("location"));
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

        /* GAME_TYPE integer NOT NULL,\n" +
        "   DATE DATETIME NOT NULL,\n" + 
        "   LOCATION VARCHAR(255) NOT NULL,\n" +
        "   MAX_PLAYER_COUNT integer NOT NULL\n" +
        "   PLAYER_IN_GAME integer NOT NULL\n"
         */
        // Insert
        String sql = "INSERT INTO FSV_USER "
                + "(game_type, game_date, game_time, location, MAX_PLAYER_COUNT, PLAYER_IN_GAME) "
                + "VALUES (?, ?, ?, ?, ?, ?) ";
        try {
            PreparedStatement stm = em.getConn().prepareStatement(sql);
            stm.setInt(1, game.getGameType());
            stm.setDate(2, game.getDate());
            stm.setTime(3, game.getTime());
            stm.setString(4, game.getGameLocation());
            stm.setInt(5, game.getMaxPlayerCount());
            stm.setInt(6, 0);
        } catch (SQLException ex) {
            Logger.getLogger(UserProvider.class.getName()).log(Level.SEVERE, null, ex);
        }


    }
    
    public IGame createGame(){
        
        return new Game();
    }
}
