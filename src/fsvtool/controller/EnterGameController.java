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
    private MainController mainController;
    
    public EnterGameController(EntityManager em, List<IGame> gameList) {
        super(em);
        this.gameList = gameList;
    }

    void setParticipation() {
        Iterator<IGame> it = gameList.iterator();
        while(it.hasNext()){
            IGame tmpGame = it.next();
            tmpGame.addPlayerToTeam(em.getLoggedinUser(),IGame.TEAM_NO_TEAM);
            checkTeamsCanBeGenerated(tmpGame);
            em.getGameProvider().saveGame(tmpGame);
        }
        
    }

    private void checkTeamsCanBeGenerated(IGame game) {
        if(game.getPlayerInGameCount()==game.getMaxPlayerCount()){
            mainController.generateTeams(game);
        }
    }
}
