/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fsvtool.controller;

import fsvtool.persistance.EntityManager;
import fsvtool.persistance.IGame;
import fsvtool.persistance.IUser;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Marcel
 */
public class LeaveGameController extends AbstractController {

    private List<IGame> gameList;
    private MainController mainController;

    public LeaveGameController(EntityManager em, List<IGame> gameList, MainController mC) {
        super(em);
        this.gameList = gameList;
        this.mainController = mC;
    }

    void deleteParticipation() {
        Iterator<IGame> it = gameList.iterator();
        while (it.hasNext()) {
            IGame tmpGame = it.next();
            checkGameWasClosed(tmpGame);

            tmpGame.removePlayerFromGame(em.getLoggedinUser());
            em.getGameProvider().saveGame(tmpGame);
        }

    }

    private void checkGameWasClosed(IGame game) {
        if (game.getPlayerInGameCount() == game.getMaxPlayerCount()) {
            mainController.resetTeams(game);
        }

    }
}