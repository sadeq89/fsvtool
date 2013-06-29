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
    private EnterGameController enterGameController;
    private LeaveGameController leaveGameController;
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
                this.createGameController.show();
                break;
            case GUIMainFrame.TEILNEHMEN:
                this.enterGameController = new EnterGameController(this.em, (List<IGame>) evt.getSource());
                this.enterGameController.setParticipation();
                break;
            case GUIMainFrame.STORNIEREN:
                this.leaveGameController = new LeaveGameController(this.em, (List<IGame>) evt.getSource());
                this.leaveGameController.deleteParticipation();
                break;
            case GUIMainFrame.LOGOUT:
                System.exit(0);
            case GUIMainFrame.EINSTELLUNGEN:
                this.userConfigController = new UserConfigController(this.em);
                break;
            
            case GUIMainFrame.TEAMS_ANZEIGEN:
                showTeams((IGame) evt.getSource());
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

    private void showTeams(IGame game) {
        if(game.getPlayerInGameCount()==game.getMaxPlayerCount()){
          gui.showTeamDialog(game.getPlayerInTeam(IGame.TEAM_A),game.getPlayerInTeam(IGame.TEAM_B));  
        } else {
            gui.showNotEnoughPlayer(game.getPlayerInGameCount(),game.getMaxPlayerCount());
        }
    }

}
