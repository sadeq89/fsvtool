/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fsvtool.controller;

import fsvtool.gui.GUIUserConfig;
import fsvtool.persistance.EntityManager;
import fsvtool.persistance.IUser;




public class UserConfigController extends AbstractController{
    private final GUIUserConfig gui;

    public UserConfigController(EntityManager em) {
        super(em);
        IUser user = em.getLoggedinUser();
        
        this.gui = new GUIUserConfig(this);
        
        this.gui.setBenutzername(user.getUsername());
        this.gui.setVorname(user.getFirstname());
        this.gui.setName(user.getName());
        this.gui.setTel(user.getPhoneNr());
        this.gui.setEMail(user.getEMail());
        
        
        this.gui.setVisible(true);
    }
    
    
    public void save(){
        this.gui.getVorname();
        //usw..
    }
}
