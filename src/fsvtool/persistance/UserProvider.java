/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fsvtool.persistance;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author ahmet
 */
public class UserProvider extends AbstractProvider {

    Map<Integer, User> usersById = new HashMap<>();
    Map<String, User> usersByEMail = new HashMap<>();
    Map<String, User> usersByUserName = new HashMap<>();
    protected String createSQL = "CREATE TABLE IF NOT EXISTS FSV_USER ("
            + " id INT AUTO_INCREMENT PRIMARY KEY,"
            + " name VARCHAR(64) NOT NULL,"
            + " firstname VARCHAR(64) NOT NULL,"
            + " email VARCHAR(128) NOT NULL UNIQUE,"
            + " username VARCHAR(64) NOT NULL UNIQUE,"
            + " password VARCHAR(256) NOT NULL,"
            + " phone_nr VARCHAR(20) NOT NULL"
            + " ); \n"
            + "CREATE TABLE IF NOT EXISTS fsv_user_skill ("
            + " user_id INT, "
            + " type INT, "
            + " skill_value INT, "
            + " CONSTRAINT IF NOT EXISTS FSV_GAME_USER_PKEY PRIMARY KEY(USER_ID, TYPE) "
            + " );";

    public UserProvider(EntityManager em) {
        super(em);
    }

    public IUser getUserByUserName(String name) {
        if (this.usersByUserName.containsKey(name)) {
            return this.usersByUserName.get(name);
        }

        PreparedStatement stm;
        try {
            stm = em.getConn().prepareStatement(
                    "SELECT id, name, firstname, email, username, password, phone_nr"
                    + " FROM FSV_USER WHERE username = ?");
            stm.setString(1, name);
            ResultSet rs = stm.executeQuery();
            if (rs.first()) {
                return buildUserObject(rs);
            } else {
                return null;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public IUser getUserByEMail(String eMail) {
        if (this.usersByEMail.containsKey(eMail)) {
            return this.usersByEMail.get(eMail);
        }

        PreparedStatement stm;
        try {
            stm = em.getConn().prepareStatement(
                    "SELECT id, name, firstname, email, username, password, phone_nr"
                    + " FROM FSV_USER WHERE email = ?");
            stm.setString(1, eMail);
            ResultSet rs = stm.executeQuery();
            if (rs.first()) {
                return buildUserObject(rs);
            } else {
                return null;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public IUser getUserById(int id) {
        if (this.usersById.containsKey(id)) {
            return this.usersById.get(id);
        }


        PreparedStatement stm;
        try {
            stm = em.getConn().prepareStatement(
                    "SELECT id, name, firstname, email, username, password, phone_nr"
                    + " FROM FSV_USER WHERE id = ?");
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            if (rs.first()) {
                return buildUserObject(rs);
            } else {
                return null;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
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
                this.saveSkills(user);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } else {
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

                ResultSet keys = stm.getGeneratedKeys();
                keys.next();

                // Cast to user and set id
                ((User) user).setId(keys.getInt(1));
                this.saveSkills(user);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    private void saveSkills(IUser u) {
        // Remove the connection first
        PreparedStatement stm;
        String sql = "DELETE FROM fsv_user_skill "
                + " WHERE USER_ID = ?";
        try {
            stm = em.getConn().prepareStatement(sql);
            stm.setInt(1, u.getId());
            stm.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        sql = "INSERT INTO fsv_user_skill "
                + "(user_id, type, skill_value) "
                + "VALUES (?, ?, ?)";

        try {
            stm = em.getConn().prepareStatement(sql);
            stm.setInt(1, u.getId());
            stm.setInt(2, IUser.SKILL_TYPE_HANDBALL);
            stm.setInt(3, u.getSkill(IUser.SKILL_TYPE_HANDBALL));
            stm.execute();

            stm = em.getConn().prepareStatement(sql);
            stm.setInt(1, u.getId());
            stm.setInt(2, IUser.SKILL_TYPE_SOCCER);
            stm.setInt(3, u.getSkill(IUser.SKILL_TYPE_SOCCER));
            stm.execute();

            stm = em.getConn().prepareStatement(sql);
            stm.setInt(1, u.getId());
            stm.setInt(2, IUser.SKILL_TYPE_VOLLEYBALL);
            stm.setInt(3, u.getSkill(IUser.SKILL_TYPE_VOLLEYBALL));
            stm.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public String getCreateSQL() {
        return this.createSQL;
    }

    public IUser createUser() {
        return new User();
    }

    private void saveToMap(User user) {
        this.usersById.put(user.getId(), user);
        this.usersByEMail.put(user.getEMail(), user);
        this.usersByUserName.put(user.getUsername(), user);
    }

    private User buildUserObject(ResultSet rs) throws SQLException {
        User user = new User(rs.getInt("id"));
        user.setName(rs.getString("name"));
        user.setFirstname(rs.getString("firstname"));
        user.setUsername(rs.getString("username"));
        user.setEMail(rs.getString("email"));
        user.setPassword(rs.getString("password"));
        user.setPhoneNr(rs.getString("phone_nr"));
        setSkills(user);
        saveToMap(user);
        return user;
    }

    /*
     * IF NOT EXISTS fsv_user_skill ("+
     " user_id INT, "+
     " type INT, " + 
     " skill_value IN
     */
    private void setSkills(User user) {
        String sql = "SELECT type, skill_value FROM fsv_user_skill "
                + "WHERE user_id = ?";

        try {
            PreparedStatement stm = em.getConn().prepareStatement(sql);
            stm.setInt(1, user.getId());
            ResultSet rs = stm.executeQuery();
            
            while (rs.next()) {
                user.setSkill(rs.getInt("type"), rs.getInt("skill_value"));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
