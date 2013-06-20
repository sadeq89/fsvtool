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
    
    public AuthentificationController(EntityManager em) {
        super(em);
        login = new GUILogin();
        login.setController(this);
        login.setVisible(true);
    }
    
    public void action(java.awt.event.ActionEvent evt){
        switch(evt.getActionCommand()){
            case GUILogin.REGISTRATION:
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
                    new MainController(em);
                    login.setVisible(false);
                    break;
                }
                else{
                    login.setErrorShowResult(true);
                    break;
                }
            case GUILogin.EXIT:
                System.exit(0);
            case GUIRegistration.REGISTER:
                IUser newUser = em.getUserProvider().createUser();
                newUser.setUsername(reg.getUsernameInput());
                newUser.setPassword(reg.getPasswordInput());
                newUser.setFirstname(reg.getFirstNameInput());
                newUser.setName(reg.getSurnameInput());
                newUser.setEMail(reg.getMailInput());
                newUser.setPhoneNr(reg.getPhoneInput());
                
                new MainController(em);
                login.setVisible(false);
                break;
        }
    }
}
