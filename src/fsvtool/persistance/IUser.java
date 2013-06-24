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
    
    public static final int SKILL_TYPE_SOCCER = 0;
    public static final int SKILL_TYPE_HANDBALL = 1;
    public static final int SKILL_TYPE_VOLLEYBALL = 2;
    
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
    
    public int getSkill(int type);
    
    public void setSkill(int type, int value);
}
