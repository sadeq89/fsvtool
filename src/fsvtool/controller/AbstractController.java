/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fsvtool.controller;

import fsvtool.persistance.EntityManager;

/**
 *
 * @author ahmet
 */
public abstract class AbstractController {
    protected EntityManager em;

    public AbstractController(EntityManager em) {
        this.em = em;
    }
}
