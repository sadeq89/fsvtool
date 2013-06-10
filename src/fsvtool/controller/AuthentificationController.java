/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fsvtool.controller;

import fsvtool.persistance.EntityManager;

/**
 *
 * @author Marcel
 */
public class AuthentificationController extends AbstractController{

    public AuthentificationController(EntityManager em) {
        super(em);
        if (em.getLoggedinUser() == null) {
            // Login öffnen
        }
    }
    
}
