/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fsvtool.persistance;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

/**
 *
 * @author ahmet
 */
public class Game implements IGame {

    private Integer id = null;
    private Date date = null;
    private Integer count;
    private String location;
    private boolean isLoggedinUserInGame = false;
    private int gameType;
    private Integer playerInGameCount;
    private Time time;

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

    @Override
    public void setDate(Date d) {
        this.date = d;
    }

    @Override
    public Integer getMaxPlayerCount() {
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
    public String getGameLocation() {
        return this.location;
    }

    @Override
    public void setGameLocation(String l) {
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

    @Override
    public Time getTime() {
        return this.time;
    }

    @Override
    public void setTime(Time t) {
        this.time = t;
    }

    @Override
    public void setGameType(int type) {
        this.gameType = type;
    }

    @Override
    public List<IUser> getPlayer() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setTeams(int team, List<IUser> player) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
