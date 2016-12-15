/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ryan Glaser
 */
public class UserTest {
    User account, account2;
    String userName;
    String Name;
    String Password;
    int points;
    int type;
    
    public UserTest() {
        userName = "username";
        Name = "User Name";
        Password = "password";
        points = 10;
        type = 1;
        
        account = new User(userName, Name, Password, points, type); 
        account2 = new User();
    }
    
    

    /**
     * Test of getUsername method, of class User.
     */
    @Test
    public void testGetUsername() {
        System.out.println("getUsername");
        assertEquals(userName, account.getUsername());
        assertEquals("JD", account2.getUsername());
    }

    /**
     * Test of getPassword method, of class User.
     */
    @Test
    public void testGetPassword() {
        System.out.println("getPassword");
        assertEquals(Password, account.getPassword());
        assertEquals("pw", account2.getPassword());
    }

    /**
     * Test of getName method, of class User.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        assertEquals(Name, account.getName());
        assertEquals("John Doe", account2.getName());
        
    }

    /**
     * Test of addPoints method, of class User.
     */
    @Test
    public void testAddPoints() {
        System.out.println("addPoints");
        account.addPoints(100);
        assertEquals(points + 100,account.getPoints() );
        account2.addPoints(10);
        assertEquals(10, account2.getPoints());
        
    }

    /**
     * Test of subtractPoints method, of class User.
     */
    @Test
    public void testSubtractPoints() {
        System.out.println("subtractPoints");
        account.subtractPoints(1);
        assertEquals(points - 1,account.getPoints() );
        account2.addPoints(10);
        account2.subtractPoints(1);
        assertEquals(9, account2.getPoints());
    }

    /**
     * Test of getPoints method, of class User.
     */
    @Test
    public void testGetPoints() {
        System.out.println("getPoints");
        assertEquals(points,account.getPoints() );
        assertEquals(0, account2.getPoints());
    }

    /**
     * Test of getType method, of class User.
     */
    @Test
    public void testGetType() {
        System.out.println("getType");
        assertEquals(type,account.getType() );
        assertEquals(0, account2.getType());
    }

    /**
     * Test of equals method, of class User.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        User exp = new User(userName, Name, Password, points, type );
        User exp2 = new User();
        assertTrue( account.equals(exp));
        assertTrue(account2.equals(exp2));
        User exp3 = new User("testName", "Test Name", Password, 10, 1);
        assertFalse(account.equals(exp3));
    }

    /**
     * Test of hashCode method, of class User.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        User exp = new User(userName, Name, Password, points, type );
        User exp2 = new User();
        assertEquals(exp.hashCode(), account.hashCode());
        assertEquals(exp2.hashCode(), account2.hashCode());
        assertNotEquals(account2.hashCode(), account.hashCode());
        
    }

    /**
     * Test of toString method, of class User.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        String test = "Username: "+userName
                +"\nName: "+ Name
                +"\nType: "+ type
                +"\nPoints: "+points;
        String test2 = "Username: "+"JD"
                +"\nName: "+ "John Doe"
                +"\nType: "+ "0"
                +"\nPoints: "+ "0";
        assertEquals(test, account.toString());
        assertEquals(test2, account2.toString());
    }
    
}
