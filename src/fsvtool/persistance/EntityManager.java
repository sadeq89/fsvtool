/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fsvtool.persistance;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author ahmet
 */
public class EntityManager {
    private Connection conn;
    
    private UserProvider userProvider;
    

    public EntityManager(Connection conn) {
        this.conn = conn;
        this.initProvider();
        this.initDb();
    }

    public Connection getConn() {
        return conn;
    }
    
    private void initProvider() {
        this.userProvider = new UserProvider(this);
    }
    
    private void initDb() {
        try {
            conn.createStatement().execute(this.userProvider.getCreateSQL());
        } catch (SQLException e) {
            System.out.print(e);
        }
    }
    
    public UserProvider getUserProvider() {
        return this.userProvider;
    }
}
