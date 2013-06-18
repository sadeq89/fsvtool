/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fsvtool.persistance;

import java.util.Date;

/**
 *
 * @author ahmet
 */
public class Game implements IGame{
    
    Integer id = null;
    
    Date date = null;
    private Integer count;

    public Game() {
    }

    public Game(Integer id) {
        this.id = id;
    }

    @Override
    public Integer getId() {
        return this.id;
    }

    @Override
    public Date getDate() {
        return this.date;
    }
    
    public void setDate(Date d) {
        this.date = d;
    }

    @Override
    public Integer getCount() {
        return this.count;
    }
    
    public void setCount(Integer c) {
        this.count = c;
    }

    @Override
    public void addUser(IUser u) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
