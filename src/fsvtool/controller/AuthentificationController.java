/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fsvtool.controller;

import fsvtool.gui.GUILogin;
import fsvtool.persistance.EntityManager;
import fsvtool.persistance.IUser;
import fsvtool.persistance.UserProvider;

/**
 *
 * @author Marcel
 */
public class AuthentificationController extends AbstractController{
    private GUILogin login;

    public AuthentificationController(EntityManager em) {
        super(em);
        login = new GUILogin();
        login.setVisible(true);
        UserProvider up = em.getUserProvider();
        IUser u = up.getUserByUserName(login.getUsername());
        
        if (u != null && u.getPassword().equals("")) {
            
        }
    }
    
}
