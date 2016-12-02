/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me2u;

import java.io.Serializable;

/**
 *
 * @author Daniel
 */
public class User implements Serializable{
    String myUsername;
    String myFirstName;
    String myLastName;
    String myPassword;
    String mySecurityQuestion;
    String mySecurityAnswer;
    int    myPoints;
    int    myType; 
    // Cart   myCart    // uninstantiated cart class
    
    public User(final String theUserName, final String theFirstName, final String theLastName, final  String thePassword, 
            final String theQuestion, final String theAnswer, 
            final int thePoints,final int theType) {
        myUsername = theUserName;
        myFirstName = theFirstName;
        myLastName = theLastName;
        myPassword = thePassword;
        mySecurityQuestion = theQuestion;
        mySecurityAnswer = theAnswer;
        myPoints = thePoints;
        myType = theType;

    }
    
    public int addPoints(int thePoints) {
        myPoints +=thePoints;
        return myPoints;
    }
    
    public int reductPoints(final int thePoints) {
        myPoints -= thePoints;
        return myPoints;
    }
    
    
    public String getSecurityQuestion() {
        return mySecurityQuestion;
    }
    
    
    public String retrievePassword(final String theAnswer) {
        final String result;
        if (theAnswer.compareTo(mySecurityAnswer) == 0) {
            result = myPassword;
        } else {
            result = "incorrect";
        }
        return result;
    }
    
    public void printUser() {
        System.out.println(myFirstName+", "+myPassword+", "+", "+mySecurityQuestion+", "+
        mySecurityAnswer+", "+myPoints+", "+myType);
    }

    public String getUsername() {
        return myUsername;
    }
    

}
