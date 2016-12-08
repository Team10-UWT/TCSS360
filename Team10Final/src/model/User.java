/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Objects;

/**
 *
 * @author David
 */
public class User implements java.io.Serializable {
    private String myUsername;
    private String myName;
    private String myPassword;
    private int myPoints;
    private int myType;
    
    public User() {
        this.myUsername = new String("JD");
        this.myName = new String("John Doe");
        this.myPassword = new String("pw");
        this.myPoints = 0;
        this.myType = 0;
    }
    
    public User(String theUsername, String theName, String thePassword,
            int thePoints, int theType) {
        this.myUsername = theUsername;
        this.myName = theName;
        this.myPassword = thePassword;
        this.myPoints = thePoints;
        this.myType = theType;
    }
    
    public String getUsername() {
        return myUsername;
    } 
    public String getPassword() {
        return myPassword;
    }
    public String getName() {
        return myName;
    }
    public void addPoints(int pointsToAdd) {
        myPoints+=pointsToAdd;
    }
    public void subtractPoints(int pointsToSubtract){
        myPoints-=pointsToSubtract;
    }
    public int getPoints(){
        return myPoints;
    }
    public int getType() {
        return myType;
    }
    @Override
    public boolean equals(Object toCompare) {
        if (!(toCompare instanceof User)) {
            return false;
        } else {
            User user = (User) toCompare;
            if(this.myUsername.equals(user.getUsername()) &&
               this.myName.equals(user.getName()) &&
               this.myPassword.equals(user.getPassword()) &&
               this.myPoints == user.getPoints() &&
               this.myType == user.getType()) {
                return true;
            } else {
                return false;
            }     
        }
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(this.myUsername, this.myName,
                this.myPassword, this.myPoints, this.myType);
    }
    
    @Override
    public String toString() {
        String user = "Username: "+this.getUsername()
                +"\nName: "+this.getName()
                +"\nType: "+this.getType()
                +"\nPoints: "+this.getPoints();
        return user;
    }
}
