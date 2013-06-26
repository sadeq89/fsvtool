/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fsvtool.controller;

import fsvtool.gui.GUIUserConfig;
import fsvtool.persistance.EntityManager;
import fsvtool.persistance.IUser;
import java.awt.event.ActionEvent;





public class UserConfigController extends AbstractController{
    private final GUIUserConfig gui;

    public UserConfigController(EntityManager em) {
        super(em);
        
        
        this.gui = new GUIUserConfig(this);
        
        IUser user = em.getLoggedinUser();  // Momentan eigeloggter User wird gespeichert
        
        this.gui.setBenutzername(user.getUsername());
        this.gui.setFirstname(user.getFirstname());
        this.gui.setSurname(user.getName());
        this.gui.setTel(user.getPhoneNr());
        this.gui.setEMail(user.getEMail());
        this.gui.setVisible(true);
    }
    
  
    
    
    // Speichermethode für die Übertragung zur Datenbank:
    public void save(){
        IUser user = em.getLoggedinUser();
        
        user.setName(this.gui.getSurname());
        user.setUsername(this.gui.getBenutzername());
        user.setFirstname(this.gui.getFirstname());
        user.setEMail(this.gui.getEMail());
        user.setPhoneNr(this.gui.getTel());
        
        
        this.em.getUserProvider().saveUser(user);
        this.gui.setVisible(false);
        
        
        
        
    }
}
