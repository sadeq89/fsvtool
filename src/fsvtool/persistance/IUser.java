/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fsvtool.persistance;

import java.util.List;

/**
 *
 * @author ahmet
 */
public interface IUser {
    
    public static final int SKILL_TYPE_FOOTBALL = 0;
    public static final int SKILL_TYPE_HANDBALL = 1;
    public static final int SKILL_TYPE_VOLLEYBALL = 2;
    
    String createSQL = "CREATE TABLE IF NOT EXISTS fsv_user ("+
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
            " )";
    
    public Integer getId();
    
    public String getName();
    
    public void setName(String name);
    
    public String getFirstname();
    
    public void setFirstname(String firstname);
    
    public String getEMail();
    
    public void setEMail(String eMail);
    
    public String getUsername();
    
    public void setUsername(String username);
    
    public String getPassword();
    
    public void setPassword(String password);
    
    public String getPhoneNr();
    
    public void setPhoneNr(String phoneNr);
    
    public String getPLZ();
    
    public void setPLZ(String plz);
    
    public int getSkill(int type);
    
    public void setSkill(int type, int value);
}
