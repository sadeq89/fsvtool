/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fsvtool;

import fsvtool.controller.MainController;
import fsvtool.persistance.EntityManager;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Sadeq
 */
public class FSVtool {
    private static Connection connectDB() throws ClassNotFoundException, SQLException{
        Class.forName("org.h2.Driver");
        String dbUrl = "jdbc:h2:"+System.getProperty("user.home")+"/fsvtool";
        System.out.print(dbUrl+"\n");
        return DriverManager.getConnection(dbUrl);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Connection conn = FSVtool.connectDB();
            EntityManager em = new EntityManager(conn);s
        } catch (ClassNotFoundException | SQLException e) {
            System.err.print("Kann keine Datenbankverbindung aufbauen\n"
                    +"Exception message: "+e.getMessage()+"\n"
                    +"Stack trace: ");
            e.printStackTrace(System.err);
        }
    }
}
