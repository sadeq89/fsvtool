/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fsvtool.controller;

import fsvtool.gui.GUIMainFrame;
import fsvtool.persistance.EntityManager;
import fsvtool.persistance.GamesTableModell;
import fsvtool.persistance.IGame;
import fsvtool.persistance.TeamGenerator;
import java.util.List;


/**
 *
 * @author Marcel
 */
public class MainController extends AbstractController {

    private final GUIMainFrame gui;
    private CreateGameController createGameController;
    private UserConfigController userConfigController;
    private EnterGameController enterGameController;

    public MainController(EntityManager em) {
        super(em);
        this.gui = new GUIMainFrame(this);
        this.gui.setVisible(true);
    }

    public void action(java.awt.event.ActionEvent evt) {
        
        switch (evt.getActionCommand()) {
            case GUIMainFrame.NEUES_SPIEL:
                this.createGameController = new CreateGameController(this.em);
                this.createGameController.show();
                break;
            case GUIMainFrame.TEILNEHMEN:
                
                this.enterGameController = new EnterGameController(this.em, (List<IGame>) evt.getSource());
                this.enterGameController.setParticipation();
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

    public void generateTeams(IGame game) {
        TeamGenerator tg = new TeamGenerator();
        tg.generateTeams(game);
    }
    
    public GamesTableModell getTable() {
        return this.em.getGameProvider().getTableModell();
    }
}
