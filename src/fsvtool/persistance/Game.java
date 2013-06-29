/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fsvtool.persistance;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
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
    private Time time;
    private ArrayList<IUser> teamA;
    private ArrayList<IUser> teamB;
    private ArrayList<IUser> teamNoTeam;

    public Game() {
        teamA = new ArrayList<>();
        teamB = new ArrayList<>();
        teamNoTeam = new ArrayList<>();
    }

    public Game(Integer id) {
        this();
        this.id = id;
    }

    @Override
    public Integer getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
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
        return this.teamA.size()+this.teamB.size()+this.teamNoTeam.size();
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
    public List<IUser> getPlayerInTeam(int team) {
        switch (team) {
            case IGame.TEAM_A:
                return this.teamA;
            case IGame.TEAM_B:
                return this.teamB;
            case IGame.TEAM_NO_TEAM:
                return this.teamNoTeam;
        }
        throw new IllegalArgumentException("team value "+team+" does not exist. Use a Value from IGame");
    }

    @Override
    public void addPlayerToTeam(IUser player, int team) {
        switch (team) {
            case IGame.TEAM_A:
                // Remove first from others if presented
                this.teamB.remove(player);
                this.teamNoTeam.remove(player);
                // Than add
                this.teamA.add(player);
                return;
            case IGame.TEAM_B:
                this.teamA.remove(player);
                this.teamNoTeam.remove(player);
                this.teamB.add(player);
                return;
            case IGame.TEAM_NO_TEAM:
                this.teamA.remove(player);
                this.teamB.remove(player);
                this.teamNoTeam.add(player);
                return;
        }
        throw new IllegalArgumentException("team value "+team+" does not exist. Use a Value from IGame");
    }

    @Override
    public void removePlayerFromGame(IUser player) {
        this.teamA.remove(player);
        this.teamB.remove(player);
        this.teamNoTeam.remove(player);
    }

}
