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
    public static int TYPE_VOLLEYBALL = 0;
    public static int TYPE_FOOTBALL = 1;
    public static int TYPE_HANDBALL = 2;
    
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
    
    public void addUser(IUser u);
    
    public int getGameType();
    
    public void setGameType(int type);

    public Integer getPlayerInGameCount();
    
    //so oder so ähnlich für die teamberechnung nötig...
    public List<IUser> getPlayer();
    public void setTeams(int team, List<IUser> player);
}
