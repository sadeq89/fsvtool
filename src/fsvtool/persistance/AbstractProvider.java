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
    protected EntityManager em;

    public AbstractProvider(EntityManager em) {
        this.em = em;
    }
    
    public EntityManager getEntityManager() {
        return em;
    }
    
    /**
     * Returns the SQL code to generate needed tables
     * 
     * @return String
     */
    public abstract String getCreateSQL();
}
