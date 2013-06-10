/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fsvtool.persistance;

/**
 *
 * @author S.Ahmet
 */
public class GameProvider extends AbstractProvider {
    
    private String createSQL = "CREATE TABLE \"FSV_GAME\"\n" +
        "(\n" +
        "   ID integer PRIMARY KEY NOT NULL,\n" +
        "   GAME_TYPE integer NOT NULL,\n" +
        "   DATE date NOT NULL,\n" +
        "   TIME time NOT NULL,\n" +
        "   PLAYER_COUNT integer NOT NULL\n" +
        ");\n" +
        "CREATE UNIQUE INDEX PRIMARY_KEY_26 ON \"FSV_GAME\"(ID);";

    public GameProvider(EntityManager em) {
        super(em);
    }
    
}
