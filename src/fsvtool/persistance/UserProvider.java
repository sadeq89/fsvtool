/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fsvtool.persistance;

/**
 *
 * @author ahmet
 */
public class UserProvider extends AbstractProvider {
    
    protected String createSQL = "CREATE TABLE IF NOT EXISTS FSV_USER ("+
            " id INT AUTO_INCREMENT PRIMARY KEY,"+
            " name VARCHAR(64) NOT NULL,"+
            " firstname VARCHAR(64) NOT NULL,"+
            " email VARCHAR(128) NOT NULL UNIQUE,"+
            " username VARCHAR(64) NOT NULL UNIQUE,"+
            " password VARCHAR(256) NOT NULL,"+
            " phone_nr VARCHAR(20) NOT NULL,"+
            " plz VARCHAR(5) NOT NULL "+
            " ); \n"+
            "CREATE TABLE IF NOT EXISTS fsv_user_skill ("+
            " id INT AUTO_INCREMENT PRIMARY KEY,"+
            " user_id INT, "+
            " type INT,"+
            " FOREIGN KEY(user_id) REFERENCES fsv_user(id) "+
            " );";

    public UserProvider(EntityManager em) {
        super(em);
    }
    
    public IUser getUserByUserName(String name) {
        return null;
    }

    @Override
    public String getCreateSQL() {
        return this.createSQL;
    }
}
