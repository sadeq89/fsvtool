/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fsvtool.persistance;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
        "   DATE date NOT NULL,\n" +
        "   TIME time NOT NULL,\n" +
        "   PLAYER_COUNT integer NOT NULL\n" +
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
}