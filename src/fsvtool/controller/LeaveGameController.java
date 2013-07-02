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
            List<IUser> teamA = game.getPlayerInTeam(IGame.TEAM_A);
            List<IUser> teamB = game.getPlayerInTeam(IGame.TEAM_B);
            Iterator itA = teamA.iterator();
            Iterator itB = teamB.iterator();
            while (itA.hasNext()) {
                game.addPlayerToTeam((IUser) itA.next(), IGame.TEAM_NO_TEAM);
            }
            while (itB.hasNext()) {
                game.addPlayerToTeam((IUser) itB.next(), IGame.TEAM_NO_TEAM);
            }
        }


    }

}
