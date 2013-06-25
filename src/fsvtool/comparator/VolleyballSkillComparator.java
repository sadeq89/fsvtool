/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fsvtool.comparator;

import fsvtool.persistance.IUser;
import java.util.Comparator;

/**
 *
 * @author Marcel
 */
public class VolleyballSkillComparator implements Comparator{

    @Override
    public int compare(Object o1, Object o2) {
        final int type = IUser.SKILL_TYPE_VOLLEYBALL;
          if (((IUser)o1).getSkill(type)>((IUser)o2).getSkill(type))
              return 1;
          else if (((IUser)o1).getSkill(type)<((IUser)o2).getSkill(type))
              return -1;
          else
              return 0;
    }
}
