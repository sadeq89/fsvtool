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
    private GUIMainFrame mainFrame;
    
    public AuthentificationController(EntityManager em) {
        super(em);
        login = new GUILogin();
        login.setController(this);
        login.setVisible(true);
       
        
        
    }
    
    public void action(java.awt.event.ActionEvent evt){
        switch(evt.getActionCommand()){
            case GUILogin.REGISTER:
                reg = new GUIRegistration();
                reg.setVisible(true);
                reg.setController(this);
                login.setVisible(false);
                break;
            case GUIRegistration.CANCEL:
                login.setVisible(true);
                reg.setVisible(false);
                break;
            case GUILogin.LOGIN:
                UserProvider up = em.getUserProvider();
                IUser user = up.getUserByUserName(login.getUsername());
                if (user != null && user.getPassword().equals(login.getPassword())) {
                    em.setLoggedinUser(user);
                    mainController = new MainController(em);
                    login.setVisible(false);
                }
                else{
                    login.setErrorShowResult(true);
                }
            case GUILogin.EXIT:
                System.exit(0);
            case GUIRegistration.FREGISTER:
//                mainFrame = new GUIMainFrame(mainController);
                
        }
    }
}
