/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fsvtool.controller;

import fsvtool.gui.GUILogin;
import fsvtool.gui.GUIRegistration;
import fsvtool.persistance.EntityManager;
import fsvtool.persistance.IUser;
import fsvtool.persistance.UserProvider;
import javax.swing.JOptionPane;

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
                
                if(reg.regFinalCheck()){
                    IUser newUser = em.getUserProvider().createUser();
                    IUser exUserMail = em.getUserProvider().getUserByEMail(reg.getMailInput());
                    IUser exUserName = em.getUserProvider().getUserByUserName(reg.getUsernameInput());
                
                   // if(reg.getUsernameInput().equals(exUserName.getUsername())){
                        //reg.setExistingUserMailError(true);
                        //break;
                   // }
                   // else
                        newUser.setUsername(reg.getUsernameInput());
                
                    newUser.setPassword(reg.getPasswordInput());
                    newUser.setFirstname(reg.getFirstNameInput());
                    newUser.setName(reg.getSurnameInput());
                
                   // if(reg.getMailInput().equals(exUserMail.getEMail())){
                    // reg.setExistingUserMailError(true);
                     //reg.setMailError(reg.existingMail);
                     //break;
                   // }
                   // else
                        newUser.setEMail(reg.getMailInput());
                
                    newUser.setPhoneNr(reg.getPhoneInput());
                
                    em.getUserProvider().saveUser(newUser);
                    em.setLoggedinUser(newUser);
                    new MainController(em);
                
                    reg.setVisible(false);
                    break;
                }
                else
                   JOptionPane.showMessageDialog(null, "Bitte korrigieren Sie die fehlerhafte Eingaben","Anmeldungsfehler",0);

        }
    }
}
