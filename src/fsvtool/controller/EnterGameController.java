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
class EnterGameController extends AbstractController {

    private List<IGame> gameList;

    public EnterGameController(EntityManager em, List<IGame> gameList) {
        super(em);
        this.gameList = gameList;
    }

    void setParticipation() {
        Iterator<IGame> it = gameList.iterator();
        while(it.hasNext()){
            IGame tmpGame = it.next();
            tmpGame.addUser(em.getLoggedinUser());
            em.getGameProvider().saveGame(tmpGame);
        }
        
    }
}
