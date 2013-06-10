/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fsvtool.persistance;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author ahmet
 */
public class EntityManager {
    private Connection conn;
    
    private UserProvider userProvider;
    private GameProvider gameProvider;
    

    public EntityManager(Connection conn) {
        this.conn = conn;
        this.initProvider();
        this.initDb();
    }

    public Connection getConn() {
        return conn;
    }
    
    public Statement createStatement() throws SQLException {
        return conn.createStatement();
    }
    
    private void initProvider() {
        this.userProvider = new UserProvider(this);
        this.gameProvider = new GameProvider(this);
    }
    
    private void initDb() {
        try {
            conn.createStatement().execute(this.userProvider.getCreateSQL());
            conn.createStatement().execute(this.gameProvider.getCreateSQL());
        } catch (SQLException e) {
            e.printStackTrace(System.err);
        }
    }
    
    public UserProvider getUserProvider() {
        return this.userProvider;
    }
    
    public IUser getLoggedinUser() {
        return null;
    }
}
