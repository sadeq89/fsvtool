/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fsvtool.controller;

import fsvtool.gui.GUIUserConfig;
import fsvtool.persistance.EntityManager;

/**
 *
 * @author Marcel
 */
public class UserConfigController extends AbstractController{
    private final GUIUserConfig gui;

    public UserConfigController(EntityManager em) {
        super(em);
        this.gui = new GUIUserConfig(this);
        this.gui.setVisible(true);
    }
    
    
    public void save(){
        this.gui.getVorname();
        //usw..
    }
}
