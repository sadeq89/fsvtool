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
import fsvtool.persistance.TeamGenerator;
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
                this.enterGameController = new EnterGameController(this.em, (List<IGame>) evt.getSource(), this);
                this.enterGameController.setParticipation();
                break;
            case GUIMainFrame.STORNIEREN:
                this.leaveGameController = new LeaveGameController(this.em, (List<IGame>) evt.getSource(), this);
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
            resetTeams(game);
            generateTeams(game);
            createTeamOutput(game);  
        } else {
            gui.showNotEnoughPlayer(game.getPlayerInGameCount(),game.getMaxPlayerCount());
        }
    }

    public void gameClosed(IGame game) {
        gui.showGameClosedDialog(game.getMaxPlayerCount());
    }

    private void createTeamOutput(IGame game) {
        //List<String> strTeamA = new ArrayList<>();
        //List<String> strTeamB = new ArrayList<>();
        
        StringBuffer strTeamA = new StringBuffer();
        StringBuffer strTeamB = new StringBuffer();
        List<IUser> teamA = game.getPlayerInTeam(IGame.TEAM_A);
        List<IUser> teamB = game.getPlayerInTeam(IGame.TEAM_B);
        Iterator it1 = teamA.iterator();
        Iterator it2 = teamB.iterator();
        while(it1.hasNext()){
           IUser tmpUser = (IUser)it1.next();
           strTeamA.append("\n    ")
                   .append(tmpUser.toString())
                   .append(": Stärke ")
                   .append(tmpUser.getSkill(game.getGameType()));
        }
        while(it2.hasNext()){
           IUser tmpUser = (IUser)it2.next();
           strTeamB.append("\n    ")
                   .append(tmpUser.toString())
                   .append(": Stärke ")
                   .append(tmpUser.getSkill(game.getGameType()));
        }
        gui.showTeamDialog(strTeamA.toString(),strTeamB.toString());
    }
    public void resetTeams(IGame game){
        if (game.getPlayerInGameCount() == game.getMaxPlayerCount()) {
            List<IUser> teamA = new ArrayList<>();
            List<IUser> teamB = new ArrayList<>();
            teamA.addAll(game.getPlayerInTeam(IGame.TEAM_A));
            teamB.addAll(game.getPlayerInTeam(IGame.TEAM_B));
            for (int i = 0; i < teamA.size(); i++) {
                game.addPlayerToTeam(teamA.get(i), IGame.TEAM_NO_TEAM);
            }
            for (int i = 0; i < teamB.size(); i++) {
                game.addPlayerToTeam(teamB.get(i), IGame.TEAM_NO_TEAM);
            }


        }
    }
}
