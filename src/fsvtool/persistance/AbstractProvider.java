/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fsvtool.persistance;

/**
 *
 * @author S.Ahmet
 */
public abstract class AbstractProvider {
    private EntityManager em;
    
    private String createSQL;

    public AbstractProvider(EntityManager em) {
        this.em = em;
    }
    
    public EntityManager getEntityManager() {
        return em;
    }
    
    public String getCreateSQL() {
        return this.createSQL;
    }
}
