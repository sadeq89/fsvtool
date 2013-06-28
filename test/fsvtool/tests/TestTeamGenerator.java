package fsvtool.tests;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import fsvtool.persistance.Game;
import fsvtool.persistance.IGame;
import fsvtool.persistance.IUser;
import fsvtool.persistance.TeamGenerator;
import fsvtool.persistance.User;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author Marcel
 */
public class TestTeamGenerator {

    User[] user = new User[12];
    Game game1 = new Game();
    Game game2 = new Game();
    Game game3 = new Game();

    @Test
    public void checkGenerateTeams() {
        initUser();

        game1.setGameType(IGame.TYPE_SOCCER);
        game1.addPlayerToTeam(user[0], IGame.TEAM_NO_TEAM);
        game1.addPlayerToTeam(user[4], IGame.TEAM_NO_TEAM);
        game1.addPlayerToTeam(user[5], IGame.TEAM_NO_TEAM);
        game1.addPlayerToTeam(user[8], IGame.TEAM_NO_TEAM);
        System.out.println(game1.getPlayerInTeam(IGame.TEAM_NO_TEAM));

        TeamGenerator tg = new TeamGenerator();
        tg.generateTeams(game1);

        System.out.println("Team1: " + game1.getPlayerInTeam(1));
        System.out.println("Team2: " + game1.getPlayerInTeam(2));

        game2.setGameType(IGame.TYPE_SOCCER);
        game2.addPlayerToTeam(user[0], IGame.TEAM_NO_TEAM);
        game2.addPlayerToTeam(user[1], IGame.TEAM_NO_TEAM);
        game2.addPlayerToTeam(user[4], IGame.TEAM_NO_TEAM);
        game2.addPlayerToTeam(user[5], IGame.TEAM_NO_TEAM);
        game2.addPlayerToTeam(user[8], IGame.TEAM_NO_TEAM);
        game2.addPlayerToTeam(user[9], IGame.TEAM_NO_TEAM);
        System.out.println(game2.getPlayerInTeam(IGame.TEAM_NO_TEAM));

        tg.generateTeams(game2);

        System.out.println("Team1: " + game2.getPlayerInTeam(1));
        System.out.println("Team2: " + game2.getPlayerInTeam(2));

        game3.setGameType(IGame.TYPE_SOCCER);
        game3.addPlayerToTeam(user[4], IGame.TEAM_NO_TEAM);
        game3.addPlayerToTeam(user[10], IGame.TEAM_NO_TEAM);        
        game3.addPlayerToTeam(user[8], IGame.TEAM_NO_TEAM);        
        game3.addPlayerToTeam(user[5], IGame.TEAM_NO_TEAM);
        game3.addPlayerToTeam(user[9], IGame.TEAM_NO_TEAM);       
        game3.addPlayerToTeam(user[6], IGame.TEAM_NO_TEAM);
        game3.addPlayerToTeam(user[0], IGame.TEAM_NO_TEAM);        
        game3.addPlayerToTeam(user[7], IGame.TEAM_NO_TEAM);


        System.out.println(game3.getPlayerInTeam(IGame.TEAM_NO_TEAM));

        tg.generateTeams(game3);

        System.out.println("Team1: " + game3.getPlayerInTeam(1));
        System.out.println("Team2: " + game3.getPlayerInTeam(2));
    }

    private void initUser() {
        for (int i = 0; i < 12; i++) {
            user[i] = new User();
        }

        for (int i = 0; i < 4; i++) {
            user[i].setSkill(IGame.TYPE_SOCCER, IUser.SKILL_VALUE_BAD);
        }
        for (int i = 4; i < 8; i++) {
            user[i].setSkill(IGame.TYPE_SOCCER, IUser.SKILL_VALUE_MIDDLE);
        }
        for (int i = 8; i < 12; i++) {
            user[i].setSkill(IGame.TYPE_SOCCER, IUser.SKILL_VALUE_GREAT);
        }

    }
}