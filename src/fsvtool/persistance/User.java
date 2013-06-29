/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fsvtool.persistance;

/**
 *
 * @author ahmet
 */
public class User implements IUser {
    
    private Integer id = null;
    private String name = null;
    private String firstname = null;
    private String eMail = null;
    private String username = null;
    private String password = null;
    private String phoneNr = null;
    private String plz = null;
    private int[] skills = new int[3];

    public User() {
        // Set default values
        this.skills[IUser.SKILL_TYPE_HANDBALL] = IUser.SKILL_VALUE_BAD;
        this.skills[IUser.SKILL_TYPE_SOCCER] = IUser.SKILL_VALUE_BAD;
        this.skills[IUser.SKILL_TYPE_VOLLEYBALL] = IUser.SKILL_VALUE_BAD;
    }

    public User(int id) {
        this();
        this.id = (Integer) id;
    }
    
    @Override
    public Integer getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getFirstname() {
        return this.firstname;
    }

    @Override
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @Override
    public String getEMail() {
        return this.eMail;
    }

    @Override
    public void setEMail(String eMail) {
        this.eMail = eMail;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getPhoneNr() {
        return this.phoneNr;
    }

    @Override
    public void setPhoneNr(String phoneNr) {
        this.phoneNr = phoneNr;
    }

    @Override
    public int getSkill(int type) {
        return this.skills[type];
    }

    @Override
    public void setSkill(int type, int value) {
        this.skills[type] = value;
    }

    @Override
    public String toString() {
        return new String() + (skills[0]);
    }
    
}
