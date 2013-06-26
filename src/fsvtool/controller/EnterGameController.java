/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fsvtool.controller;

import fsvtool.persistance.EntityManager;
import fsvtool.persistance.IGame;
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
        System.out.println(gameList.toString());
        // db operations
    }
}
