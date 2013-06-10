/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fsvtool.controller;

import fsvtool.gui.GUICreateGame;
import fsvtool.persistance.EntityManager;

/**
 *
 * @author Marcel
 */
public class CreateGameController extends AbstractController{
    private final GUICreateGame gui;

    public CreateGameController(EntityManager em) {
        super(em);
        this.gui = new GUICreateGame();
        this.gui.setVisible(true);
    }
    
}
