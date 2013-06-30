/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fsvtool.tests;

import fsvtool.controller.AuthentificationController;
import fsvtool.persistance.User;
import junit.framework.*;
import java.util.logging.Logger;

/**
 *
 * @author WellY
 */
public class TestLoginRegistration extends TestCase{
    
    private static final Logger logger = Logger.getLogger(TestLoginRegistration.class.getName());
    
    User user1 = new User();
    User user2 = new User();
    User user3 = new User();
    User userNull = new User();;
    User userTyped1 = new User();
    User userTyped2 = new User();
    User userTyped3 = new User();
    User userTypedNull = new User();

    
    public void testLoginCheck(){
        user1.setUsername("muster1");
        user1.setPassword("1234");
        
        user2.setUsername("muster2");
        user2.setPassword("1234");
        
        userTyped1.setUsername("muster1");
        userTyped1.setPassword("1234");
        
        userTyped2.setUsername("muster2");
        userTyped2.setPassword("123a");
        
        assertTrue(AuthentificationController.loginCheck(user1, userTyped1.getPassword()));
        assertFalse(AuthentificationController.loginCheck(user1, userTypedNull.getPassword()));
        assertFalse(AuthentificationController.loginCheck(user1, userTyped2.getPassword())); 
        
        logger.info("Test LoginCheck in FSVTool erfolgreich!");
    }
    
    public void testRegistration(){
        user1.setEMail("muster@mustermail.de");
        user1.setUsername("muster1");
        
        user2.setEMail("muster2@mustermail.de");
        user2.setUsername("muster2");
        
        user3.setEMail("muster3@mustermail.de");
        user3.setUsername("muster3");
        
        userTyped1.setEMail("muster@mustermail.de");
        userTyped1.setUsername("muster1");
        
        userTyped2.setEMail("muster2@mustermail.de");
        userTyped2.setUsername("muster2");
        
        userTyped3.setEMail("muster3@mustermail.de");
        userTyped3.setUsername("muster3");
        
        assertTrue(AuthentificationController.registerExistingCheck(user1, user1, userTyped1.getEMail(), userTyped1.getUsername()));
        assertFalse(AuthentificationController.registerExistingCheck(user2, user2, userTyped1.getUsername(), userTyped1.getEMail()));
        assertFalse(AuthentificationController.registerExistingCheck(userNull, userNull, userTyped1.getUsername(), userTyped1.getEMail()));
        
        assertTrue(AuthentificationController.registerExMailCheck(user1, userTyped1.getEMail()));
        assertFalse(AuthentificationController.registerExMailCheck(user3, userTyped1.getEMail()));
        assertTrue(AuthentificationController.registerExUsernameCheck(user1, user1.getUsername()));
        assertFalse(AuthentificationController.registerExUsernameCheck(user2, userTyped3.getUsername()));
        
        logger.info("Test RegistrationExistingMailandUsernameCheck in FSVTool erfolgreich!");
    }
}
