/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * @author Daniel
 */
public class UsersList implements Serializable {

    /* A hashmap to hold all of the users. */
    static ConcurrentHashMap<String, User> myUserTable;

    public UsersList() {
        myUserTable = new ConcurrentHashMap<>();
    }
    
    /**
     * A method to check if the username is taken. 
     * @param theUsernameToCheck the name to check
     * @return true if there is a user with that username, false otherwise. 
     */
    public boolean UserNameIsTaken(final String theUsernameToCheck) {
        return myUserTable.containsKey(theUsernameToCheck);
    }
    
    /**
     * A method for putting a new user into the user list.
     * @param theUsername the username / key of the new user you want to add. 
     * @param theUser the User object you want to add. 
     */
    public void putUser(final String theUsername,final User theUser) {
        myUserTable.put(theUsername, theUser);
    }
    
    /**
     * A method to get the User from the list of users. 
     * @param theUserName the username of the user to get. 
     * @return the user object you want to get.
     */
    public User getUser(final String theUserName) {
        return myUserTable.get(theUserName);
    } 
}
