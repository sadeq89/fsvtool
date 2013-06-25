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
                JOptionPane.showMessageDialog(null, "* Sie können das Kennwort später nicht mehr ändern."
                        + "\n* Bitte füllen Sie alle Felder aus, ansonsten wird die Anmeldung nicht  gespeichert!","Hinweis!",1);
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
                    
                    if ((exUserMail != null) || (exUserName != null)) {
                        if (reg.getUsernameInput().equals(exUserName.getUsername()) || reg.getMailInput().equals(exUserMail.getEMail())) {
                            if (reg.getUsernameInput().equals(exUserName.getUsername())) {
                                reg.setExistingUserNameErrorVisible(true);
                            }
                            if (reg.getMailInput().equals(exUserMail.getEMail())) {
                                reg.setExistingMailErrorVisible(true);
                            }
                            JOptionPane.showMessageDialog(null, "Anmeldungsformular ist fehlerhaft.\n      * Sie müssen alle Felder ausfüllen!"
                                    + "\n      * Sie müssen fehlerhafte Eingaben ändern!", "Anmeldungsfehler", 0);
                            break;
                        }
                    } 
                    else {
                        newUser.setEMail(reg.getMailInput());
                        newUser.setUsername(reg.getUsernameInput());
                    }


                    newUser.setPassword(reg.getPasswordInput());
                    newUser.setFirstname(reg.getFirstNameInput());
                    newUser.setName(reg.getSurnameInput());

                    newUser.setPhoneNr(reg.getPhoneInput());

                    em.getUserProvider().saveUser(newUser);
                    em.setLoggedinUser(newUser);
                    new MainController(em);

                    reg.setVisible(false);
                    break;
                } else
                    JOptionPane.showMessageDialog(null, "Anmeldungsformular ist fehlerhaft.\n      * Sie müssen alle Felder ausfüllen!"
                            + "\n      * Sie müssen fehlerhafte Eingaben ausbessern!", "Anmeldungsfehler", 0);
        }
    }
}
