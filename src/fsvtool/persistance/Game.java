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
    
    private Integer id = null;
    private Date date = null;
    private Integer count;
    private String location;
    private boolean isLoggedinUserInGame = false;
    private int gameType;
    private Integer playerInGameCount;
    

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
    public Integer getMayPlayerCount() {
        return this.count;
    }
    
    public void setMaxPlayerCount(Integer c) {
        this.count = c;
    }
    
    @Override
    public Integer getPlayerInGameCount() {
        return this.playerInGameCount;
    }
    
    public void setPlayerInGameCount(Integer c) {
        this.playerInGameCount = c;
    }

    @Override
    public void addUser(IUser u) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getLocation() {
        return this.location;
    }
    
    public void setLocation(String l) {
        this.location = l;
    }

    @Override
    public boolean isInGame() {
        return this.isLoggedinUserInGame;
    }
    
    public void setIsInGame(boolean b) {
        this.isLoggedinUserInGame = b;
    }
    
    @Override
    public int getGameType() {
        return this.gameType;
    }
}
