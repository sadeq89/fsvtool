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
public interface IGame {
    
    public static int TYPE_SOCCER = 0;
    public static int TYPE_VOLLEYBALL = 1;
    public static int TYPE_HANDBALL = 2;
    
    public static int TEAM_NO_TEAM = 0;
    public static int TEAM_A = 1;
    public static int TEAM_B = 2;
    
    public Integer getId();
    
    public Date getDate();
    
    public void setDate(Date d);
    
    public Time getTime();
    
    public void setTime(Time t);
    
    public Integer getMaxPlayerCount();
    
    public void setMaxPlayerCount(Integer c);
    
    public String getGameLocation();
    
    public void setGameLocation(String location);
    
    public boolean isInGame();
    
    public int getGameType();
    
    public void setGameType(int type);

    public Integer getPlayerInGameCount();
    
    /**
     * Returns a List of player from the selected team.
     * 
     * @param team
     * @return The List pf player
     */
    public List<IUser> getPlayerInTeam(int team);
    
    /**
     * Add a player to a team in this game.
     * The team is should be on of IGame.TEAM_* constant.
     * @param player
     * @param team 
     */
    public void addPlayerToTeam(IUser player, int team);
    
    /**
     * Remive the user From the Game.
     * The team is not important.
     * @param player 
     */
    public void removePlayerFromGame(IUser player);
}
