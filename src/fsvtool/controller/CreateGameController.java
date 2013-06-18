/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fsvtool.controller;

import fsvtool.gui.GUICreateGame;
import fsvtool.persistance.EntityManager;
import java.util.Date;
/**
 *
 * @author Marcel
 */
public class CreateGameController extends AbstractController{
    private final GUICreateGame gui;

    public CreateGameController(EntityManager em) {
        super(em);
        this.gui = new GUICreateGame(this);
        this.gui.setVisible(true);
    }
    
    public void saveGame(){
        
    Date date = new Date();
    
    
    }
    
}
