/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fsvtool.persistance;

/**
 *
 * @author ahmet
 */
class User implements IUser {
    
    private int id;
    private String name;
    private String firstname;
    private String eMail;
    private String username;
    private String password;
    private String phoneNr;
    private String plz;
    private int[] skills = new int[3];

    public User() {
    }

    public User(int id) {
        this.id = id;
    }
    
    @Override
    public int getId() {
        return this.id;
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
    public String getPLZ() {
        return this.plz;
    }

    @Override
    public void setPLZ(String plz) {
        this.plz = plz;
    }

    @Override
    public int getSkill(int type) {
        return this.skills[type];
    }

    @Override
    public void setSkill(int type, int value) {
        this.skills[type] = value;
    }
}
