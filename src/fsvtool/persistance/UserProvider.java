/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fsvtool.persistance;

/**
 *
 * @author ahmet
 */
public class UserProvider {
    private EntityManager em;
    
    private String createSQL = "CREATE TABLE IF NOT EXISTS fsv_user ("+
            " id INT AUTO_INCREMENT PRIMARY KEY,"+
            " name VARCHAR(64) NOT NULL,"+
            " vorname VARCHAR(64) NOT NULL,"+
            " password VARCHAR(256) NOT NULL,"+
            " phone_nr VARCHAR(20) NOT NULL,"+
            " plz VARCHAR(5) NOT NULL "+
            " ); \n"+
            "CREATE TABLE IF NOT EXISTS fsv_user_skill ("+
            " id INT AUTO_INCREMENT PRIMARY KEY,"+
            " user_id INT, "+
            " "+
            " FOREIGN KEY(user_id) REFERENCES fsv_user(id) "+
            " )";

    public UserProvider(EntityManager em) {
        this.em = em;
    }
    
    public String getCreateSQL() {
        return this.createSQL;
    }
    
    public UserInterface getUserByName(String name) {
        return new User();
    }
}
