/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fsvtool.controller;

import fsvtool.persistance.EntityManager;
import fsvtool.persistance.IGame;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Marcel
 */
public class LeaveGameController extends AbstractController{
    private List<IGame> gameList;
    
    public LeaveGameController(EntityManager em, List<IGame> gamelist) {
        super(em);
        this.gameList = gameList;
    }

    void deleteParticipation() {
        Iterator<IGame> it = gameList.iterator();
        while(it.hasNext()){
            IGame tmpGame = it.next();
            //TO DO
            em.getGameProvider().saveGame(tmpGame);
        }
        
    }
}
