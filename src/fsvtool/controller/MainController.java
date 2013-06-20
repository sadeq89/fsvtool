/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fsvtool.controller;

import fsvtool.gui.GUIMainFrame;
import fsvtool.persistance.EntityManager;
import fsvtool.persistance.GamesTableModell;
import fsvtool.persistance.IGame;
import fsvtool.persistance.IUser;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Marcel
 */
public class MainController extends AbstractController {

    private final GUIMainFrame gui;
    private CreateGameController createGameController;
    private UserConfigController userConfigController;

    public MainController(EntityManager em) {
        super(em);
        this.gui = new GUIMainFrame(this);
        this.gui.setVisible(true);
    }

    public void action(java.awt.event.ActionEvent evt) {
        switch (evt.getActionCommand()) {
            case GUIMainFrame.NEUES_SPIEL:
                this.createGameController = new CreateGameController(this.em);
                break;
            case GUIMainFrame.TEILNEHMEN:
                //TO DO
                break;
            case GUIMainFrame.STORNIEREN:
                //TO DO
                break;
            case GUIMainFrame.LOGOUT:
                System.exit(0);
            case GUIMainFrame.EINSTELLUNGEN:
                this.userConfigController = new UserConfigController(this.em);
                break;

        }
    }

    public void GenerateTeams(IGame game) {
        if (game.getPlayerInGameCount() != game.getMaxPlayerCount()) {
            return;
        }

        //int[] skillCountTeam1 = new int[]{0, 0, 0};
        int skillTotalTeam1 = 0;
        //int[] skillCountTeam2 = new int[]{0, 0, 0};
        int skillTotalTeam2 = 0;;
        //int playerCountTeam1 = 0;
        //int playerCountTeam2 = 0;
        int tmpTeam = 0;

        List team1 = new ArrayList<IUser>();
        List team2 = new ArrayList<IUser>();

        List<IUser> player = game.getPlayer();
        Iterator it = player.iterator();

        while (it.hasNext()) {
            IUser tmpUser = (IUser) it.next();

            if (!it.hasNext()) {
                if (team1.size() < team2.size()) {
                    tmpTeam = 1;
                } else {
                    tmpTeam = 2;
                }
            } else {
                if (team1.size() == team2.size()) {
                    if (skillTotalTeam1 <= skillTotalTeam2) {
                        tmpTeam = 2; //spezieller fall wenn eine höhere Zahl noch ausgleichen könnte
                    } else {
                        tmpTeam = 1;
                    }
                } else {
                    if (skillTotalTeam1 < skillTotalTeam2) {
                        tmpTeam = 1;
                    } else if (skillTotalTeam1 > skillTotalTeam2) {
                        tmpTeam = 2;
                    }
                }
            }

            if (tmpTeam == 1) {
                team1.add(tmpUser);
            } else {
                team2.add(tmpUser);
            }


        }
    }

    public GamesTableModell getTable() {
        return this.em.getGameProvider().getTableModell();
    }
}
