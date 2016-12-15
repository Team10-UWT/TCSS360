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
public class UserListTest {
    UserList userList;
    User account, account2, account3;
    String userName, userName2;
    String Name;
    String Password;
    int points;
    int type;
    
    public UserListTest() {
        userName = "username";
        userName2 = "user2";
        Name = "User Name";
        Password = "password";
        points = 10;
        type = 1;

        account = new User(userName, Name, Password, points, type); 
        account2 = new User();
        account3 = new User(userName2, Name, Password, points, type);
        
        userList = new UserList();
        userList.addUser(account);
    }

    /**
     * Test of nameTaken method, of class UserList.
     */
    @Test
    public void testNameTaken() {
        System.out.println("nameTaken");
        assertTrue(userList.nameTaken(userName));
        assertFalse(userList.nameTaken("Test"));
    }

    /**
     * Test of userExists method, of class UserList.
     */
    @Test
    public void testUserExists() {
        System.out.println("userExists");
        assertTrue(userList.userExists(account));
        assertFalse(userList.userExists(account2));
    }

    /**
     * Test of addUser method, of class UserList.
     */
    @Test
    public void testAddUser() {
        System.out.println("addUser");
        userList.addUser(account2);
        assertEquals(account2, userList.getUser("JD"));
        assertTrue(userList.userExists(account2));
    }

    /**
     * Test of removeUser method, of class UserList.
     */
    @Test
    public void testRemoveUser() {
        System.out.println("removeUser");
        userList.removeUser(account);
        assertFalse(userList.userExists(account));
        assertNull(userList.getUser(userName));
    }


    /**
     * Test of getUser method, of class UserList.
     */
    @Test
    public void testGetUser() {
        System.out.println("getUser");
        assertEquals(account, userList.getUser(userName));
        userList.addUser(account3);
        assertEquals(account3, userList.getUser(userName2));
        assertNull(userList.getUser("JD"));
    }
    
}
