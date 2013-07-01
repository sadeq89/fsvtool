/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fsvtool.controller;

import fsvtool.persistance.EntityManager;
import fsvtool.persistance.IGame;
import fsvtool.persistance.IUser;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Marcel
 */
public class LeaveGameController extends AbstractController {

    private List<IGame> gameList;

    public LeaveGameController(EntityManager em, List<IGame> gameList) {
        super(em);
        this.gameList = gameList;
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
            List<IUser> l = game.getPlayerInTeam(IGame.TEAM_A);
            for (int i = 0; i < l.size(); i++) {
                game.addPlayerToTeam(l.get(i), IGame.TEAM_NO_TEAM);
            }
            l = game.getPlayerInTeam(IGame.TEAM_B);
            for (int i = 0; i < l.size(); i++) {
                game.addPlayerToTeam(l.get(i), IGame.TEAM_NO_TEAM);
            }

        }
    }
}
