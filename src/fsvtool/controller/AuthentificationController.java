/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fsvtool.controller;

import fsvtool.gui.GUILogin;
import fsvtool.gui.GUIMainFrame;
import fsvtool.gui.GUIRegistration;
import fsvtool.persistance.EntityManager;
import fsvtool.persistance.IUser;
import fsvtool.persistance.UserProvider;

/**
 *
 * @author Marcel
 */
public class AuthentificationController extends AbstractController{
    private GUILogin login;
    private GUIRegistration reg;
    private MainController mainController;
    
    public AuthentificationController(EntityManager em) {
        super(em);
        login = new GUILogin();
        login.setController(this);
        login.setVisible(true);
       
        
        
    }
    
    public void action(java.awt.event.ActionEvent evt){
        switch(evt.getActionCommand()){
            case "Anmeldung":
                reg = new GUIRegistration();
                reg.setVisible(true);
                reg.setController(this);
                login.setVisible(false);
                break;
            case "Abbrechen":
                login.setVisible(true);
                reg.setVisible(false);
                break;
            case "Login":
                UserProvider up = em.getUserProvider();
                IUser user = up.getUserByUserName(login.getUsername());
                if (user != null && user.getPassword().equals(login.getPassword())) {
                    em.setLoggedinUser(user);
                    mainController = new MainController(em);
                    login.setVisible(false);
                }
                
        }
    }
}
