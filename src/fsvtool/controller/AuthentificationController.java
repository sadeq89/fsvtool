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
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Marcel
 */
public class AuthentificationController extends AbstractController {

    private GUILogin login;
    private GUIRegistration reg;
    private MessageDigest md;

    public AuthentificationController(EntityManager em) {
        super(em);
        login = new GUILogin();
        login.setController(this);
        login.setVisible(true);
        try {
            this.md = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
        }
    }
    
    private String hashPassword(String pw) {
        this.md.reset();
        this.md.update(pw.getBytes());
        byte[] digest = this.md.digest();
        BigInteger bigInt = new BigInteger(1,digest);
        return bigInt.toString(16);
    }

    public void action(String evt) {
        switch (evt) {
            case GUILogin.REGISTRATION:
                reg = new GUIRegistration();

                reg.setVisible(true);
                reg.setController(this);
                login.setVisible(false);
                JOptionPane.showMessageDialog(null, "* Sie können das Kennwort später nicht mehr ändern."
                        + "\n* Bitte füllen Sie alle Felder aus, ansonsten wird die Anmeldung nicht  gespeichert!", "Hinweis!", 1);
                break;
            case GUIRegistration.CANCEL:
                login.setVisible(true);
                reg.setVisible(false);
                break;
            case (GUILogin.LOGIN):
                UserProvider up = em.getUserProvider();
                IUser user = up.getUserByUserName(login.getUsername());

                if (loginCheck(user, hashPassword(login.getPassword()))) {
                    em.setLoggedinUser(user);
                    new MainController(em);
                    login.setVisible(false);
                    break;
                } else {
                    login.setErrorShowResult(true);
                    break;
                }

            case GUILogin.EXIT:
                System.exit(0);
            case GUIRegistration.REGISTER:

                if (reg.regFinalCheck()) {
                    IUser newUser = em.getUserProvider().createUser();
                    IUser exUserMail = em.getUserProvider().getUserByEMail(reg.getMailInput());
                    IUser exUserName = em.getUserProvider().getUserByUserName(reg.getUsernameInput());

                    if (registerExistingCheck(exUserMail, exUserName, reg.getMailInput(), reg.getSurnameInput())) {
                        if (registerExUsernameCheck(exUserName, reg.getUsernameInput())) {
                            reg.setExistingUserNameErrorVisible(true);
                        }
                        else {
                            reg.setExistingUserNameErrorVisible(false);
                        }

                        if (registerExMailCheck(exUserMail, reg.getMailInput())) {
                            reg.setExistingMailErrorVisible(true);
                        }
                        else {
                            reg.setExistingMailErrorVisible(false);
                        }
                        JOptionPane.showMessageDialog(null, "Anmeldungsformular ist fehlerhaft.\n"
                                + "* Sie müssen alle Felder ausfüllen!\n"
                                + "* Sie müssen fehlerhafte Eingaben ändern!", "Anmeldungsfehler", 0);
                        break;
                    } else {
                        newUser.setEMail(reg.getMailInput());
                        newUser.setUsername(reg.getUsernameInput());
                    }

                    newUser.setPassword(hashPassword(reg.getPasswordInput()));
                    newUser.setFirstname(reg.getFirstNameInput());
                    newUser.setName(reg.getSurnameInput());

                    newUser.setPhoneNr(reg.getPhoneInput());

                    em.getUserProvider().saveUser(newUser);
                    em.setLoggedinUser(newUser);
                    new MainController(em);

                    reg.setVisible(false);
                    break;
                } else {
                    JOptionPane.showMessageDialog(null, "Anmeldungsformular ist fehlerhaft.\n      * Sie müssen alle Felder ausfüllen!"
                            + "\n      * Sie müssen fehlerhafte Eingaben ausbessern!", "Anmeldungsfehler", 0);
                }
        }
    }

    public static boolean loginCheck(IUser saved, String typedPass) {
        if (saved != null && saved.getPassword().equals(typedPass)) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean registerExistingCheck(IUser eMail, IUser eUser, String tMail, String tUName) {
        if (registerExUsernameCheck(eUser, tUName) || registerExMailCheck(eMail, tMail)) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean registerExMailCheck(IUser eMail, String tMail) {
        if (eMail != null && tMail.equals(eMail.getEMail())) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean registerExUsernameCheck(IUser eUser, String tUName) {
        if (eUser != null && tUName.equals(eUser.getUsername())) {
            return true;
        } else {
            return false;
        }
    }
}
