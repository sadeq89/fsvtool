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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author Marcel
 */
public class TestTeamGenerator {

    User[] user = new User[12];
    Game game1 = new Game();

    @Test
    public void checkGenerateTeams(){
        initUser();
        
        game1.addPlayerToTeam(user[0], IGame.TEAM_NO_TEAM);
        game1.addPlayerToTeam(user[4], IGame.TEAM_NO_TEAM);
        game1.addPlayerToTeam(user[5], IGame.TEAM_NO_TEAM);
        game1.addPlayerToTeam(user[8], IGame.TEAM_NO_TEAM);
        
        TeamGenerator tg = new TeamGenerator();
        tg.generateTeams(game1);
        
        System.out.println("Team1: " + game1.getPlayerInTeam(1));
        System.out.println("Team2: " + game1.getPlayerInTeam(2));
    }
    
    private void initUser(){
        for(int i=0; i<12; i++){
            user[i] = new User();
        }
        
        for(int i=0; i<4; i++){
            user[i].setSkill(0, 0);
        }
        for(int i=4; i<8; i++){
            user[i].setSkill(0, 1);
        }
        for(int i=8; i<12; i++){
            user[i].setSkill(0, 2);
        }
        
    }
}