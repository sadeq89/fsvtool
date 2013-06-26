/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fsvtool.controller;

import fsvtool.gui.GUICreateGame;
import fsvtool.persistance.EntityManager;
import fsvtool.persistance.GameProvider;
import fsvtool.persistance.IGame;
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
        
    }
    
    public void saveGame(){
        IGame game = em.getGameProvider().createGame();
        
        game.setDate(this.gui.getDate());
        game.setGameType(this.gui.getGameType());
        game.setTime(this.gui.getTime());
        game.setGameLocation(this.gui.getGameLocation());
        game.setMaxPlayerCount(this.gui.getPlayerCount());
        
        this.em.getGameProvider().saveGame(game);
        this.gui.setVisible(false);
    }

    public void show() {
       this.gui.setVisible(true);
    }
    
}
