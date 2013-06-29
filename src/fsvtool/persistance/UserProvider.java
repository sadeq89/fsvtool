/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fsvtool.persistance;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ahmet
 */
public class UserProvider extends AbstractProvider {
    
    protected String createSQL = "CREATE TABLE IF NOT EXISTS FSV_USER ("+
            " id INT AUTO_INCREMENT PRIMARY KEY,"+
            " name VARCHAR(64) NOT NULL,"+
            " firstname VARCHAR(64) NOT NULL,"+
            " email VARCHAR(128) NOT NULL UNIQUE,"+
            " username VARCHAR(64) NOT NULL UNIQUE,"+
            " password VARCHAR(256) NOT NULL,"+
            " phone_nr VARCHAR(20) NOT NULL" +
            " ); \n"+
            "CREATE TABLE IF NOT EXISTS fsv_user_skill ("+
            " id INT AUTO_INCREMENT PRIMARY KEY,"+
            " user_id INT, "+
            " type INT,"+
            " FOREIGN KEY(user_id) REFERENCES fsv_user(id) "+
            " );";

    public UserProvider(EntityManager em) {
        super(em);
    }
    
    public IUser getUserByUserName(String name) {
        PreparedStatement stm;
        try {
            stm = em.getConn().prepareStatement(
                    "SELECT id, name, firstname, email, username, password, phone_nr"
                    + " FROM FSV_USER WHERE username = ?");
            stm.setString(1, name);
            ResultSet rs = stm.executeQuery();
            if (rs.first()) {
                return buildUserObject(rs);
            }
            else {
                return null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserProvider.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public IUser getUserByEMail(String eMail) {
        PreparedStatement stm;
        try {
            stm = em.getConn().prepareStatement(
                    "SELECT id, name, firstname, email, username, password, phone_nr"
                    + " FROM FSV_USER WHERE email = ?");
            stm.setString(1, eMail);
            ResultSet rs = stm.executeQuery();
            if (rs.first()) {
                return buildUserObject(rs);
            }
            else {
                return null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserProvider.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public IUser getUserById(int id) {
        PreparedStatement stm;
        try {
            stm = em.getConn().prepareStatement(
                    "SELECT id, name, firstname, email, username, password, phone_nr"
                    + " FROM FSV_USER WHERE id = ?");
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            if (rs.first()) {
                return buildUserObject(rs);
            }
            else {
                return null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserProvider.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public void saveUser(IUser user) {
        Integer id = user.getId();
        
        if (id != null) {
            // Update
            String sql = "UPDATE FSV_USER "
                    + "SET name=?, firstname=?, email=?, username=?, password=?, phone_nr=? "
                    + "WHERE id = ?";
            try {
                PreparedStatement stm = em.getConn().prepareStatement(sql);
                stm.setString(1, user.getName());
                stm.setString(2, user.getFirstname());
                stm.setString(3, user.getEMail());
                stm.setString(4, user.getUsername());
                stm.setString(5, user.getPassword());
                stm.setString(6, user.getPhoneNr());
                stm.setInt(7, user.getId());
                stm.execute();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        else {
            // Insert
            String sql = "INSERT INTO FSV_USER "
                    + "(name, firstname, email, username, password, phone_nr) "
                    + "VALUES (?, ?, ?, ?, ?, ?) ";
            try {
                PreparedStatement stm = em.getConn().prepareStatement(sql);
                stm.setString(1, user.getName());
                stm.setString(2, user.getFirstname());
                stm.setString(3, user.getEMail());
                stm.setString(4, user.getUsername());
                stm.setString(5, user.getPassword());
                stm.setString(6, user.getPhoneNr());
                stm.execute();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public String getCreateSQL() {
        return this.createSQL;
    }
    
    public IUser createUser() {
        return new User();
    }
    
    private User buildUserObject(ResultSet rs) throws SQLException {
        User user = new User(rs.getInt("id"));
        user.setName(rs.getString("name"));
        user.setFirstname(rs.getString("firstname"));
        user.setUsername(rs.getString("username"));
        user.setEMail(rs.getString("email"));
        user.setPassword(rs.getString("password"));
        user.setPhoneNr(rs.getString("phone_nr"));
        return user;
    }
}
