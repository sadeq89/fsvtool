/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fsvtool.persistance;

import fsvtool.comparator.HandballSkillComparator;
import fsvtool.comparator.SoccerSkillComparator;
import fsvtool.comparator.VolleyballSkillComparator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Marcel
 */
public class TeamGenerator {

    private Comparator chooseComparator(IGame game) {
        Comparator cmp = null;
        int gameType = game.getGameType();

        switch (gameType) {
            case IGame.TYPE_SOCCER:
                cmp = new SoccerSkillComparator();
                break;
            case IGame.TYPE_VOLLEYBALL:
                cmp = new VolleyballSkillComparator();
                break;
            case IGame.TYPE_HANDBALL:
                cmp = new HandballSkillComparator();
                break;
        }
        return cmp;
    }

    public void generateTeams(IGame game) {
        int skillTotalTeam1 = 0;
        int skillTotalTeam2 = 0;
        int tmpTeam = 0;

        List team1 = new ArrayList<IUser>();
        List team2 = new ArrayList<IUser>();

        List<IUser> player = new ArrayList<IUser>();
        player.addAll(game.getPlayerInTeam(IGame.TEAM_NO_TEAM));
        Comparator cmp = chooseComparator(game);

        Collections.sort(player, cmp); //Liste nach jeweiligem Typ sortieren
        Iterator it = player.iterator();

        while (it.hasNext()) {
            IUser tmpUser = (IUser) it.next();
          
            if (!it.hasNext()) {    //Wenn keiner mehr kommt muss der letzte der kleineren, bzw. der schlechtesten Mannschaft zugewießen werden
                if (team1.size() < team2.size()) {
                    tmpTeam = 1;
                } else if (team1.size() > team2.size()) {
                    tmpTeam = 2;
                } else if (skillTotalTeam1 < skillTotalTeam2) {
                    tmpTeam = 1;
                } else {
                    tmpTeam = 2;
                }
            } else {    //sonst kann, bei gleicher Größe, der besseren Mannschaft zugewießen werden, weil der Nachfolger ausgleichen kann
                if (team1.size() == team2.size()) {
                    if (skillTotalTeam1 <= skillTotalTeam2)
                    {
                        tmpTeam = 2;
                    } else {
                        tmpTeam = 1;
                    }
                } else { //bei ungleicher Länge wird nach Gesamtstärke des Teams zugewießen, wenn diese gleich, dann entspechend der ungleichen Länge
                    if (skillTotalTeam1 < skillTotalTeam2) {
                        tmpTeam = 1;
                    } else if (skillTotalTeam1 > skillTotalTeam2) {
                        tmpTeam = 2;
                    } else if (team1.size() < team2.size()) {
                        tmpTeam = 1;
                    } else {
                        tmpTeam = 2;
                    }
                }
            }

            

            
            if (tmpTeam == 1) { //Ausgabe
                team1.add(tmpUser);
                skillTotalTeam1 += tmpUser.getSkill(game.getGameType());
                game.addPlayerToTeam(tmpUser, IGame.TEAM_A);
            } else {
                team2.add(tmpUser);
                skillTotalTeam2 += tmpUser.getSkill(game.getGameType());
                game.addPlayerToTeam(tmpUser, IGame.TEAM_B);
            }
        }

    }
}
