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
public interface IGame {
    public static int TYPE_VOLLEYBALL = 0;
    public static int TYPE_FOOTBALL = 1;
    public static int TYPE_HANDBALL = 2;
    
    public Integer getId();
    
    public Date getDate();
    
    public Integer getPlayerCount();
    
    public String getLocation();
    
    public boolean isInGame();
    
    public void addUser(IUser u);
}
