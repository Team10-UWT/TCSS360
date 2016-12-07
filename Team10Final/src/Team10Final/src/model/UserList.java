/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author David
 */
public class UserList implements java.io.Serializable {
    private static final String FILENAME = "userlist.ser";
    private ArrayList<User> myUserList;
    
    public UserList() {
        this.myUserList = new ArrayList<>();
    }
    
    public boolean userExists(User theUser) {
        Iterator it = (Iterator) this.myUserList.iterator();
        User user;
        while(it.hasNext()) {
            user = (User) it.next();
            if(user.equals(theUser)){
                return true;
            }
        }
        return false;
    }
    public void addUser(User theUser) {
        if(!userExists(theUser)) {
            myUserList.add(theUser);
        }
    }
    public void removeUser(User theUser) {
        Iterator it = (Iterator) this.myUserList.iterator();
        User user;
        while(it.hasNext()) {
            user = (User) it.next();
            if(user.equals(theUser)) {
                it.remove();
            }
        }
    }
    public void listUsers() {
        Iterator it = (Iterator) this.myUserList.iterator();
        User user;
        while (it.hasNext()) {
            user = (User) it.next();
            System.out.println(user.toString());
        }
    }
    public User getUser(String theUsername) {
        Iterator it = (Iterator) this.myUserList.iterator();
        User user;
        while (it.hasNext()) {
            user = (User) it.next();
            if(user.getUsername().equals(theUsername)) {
                return user;
            }
        }
        return null;
    }
    
    public void serializeUserList(){
        try {
        FileOutputStream fileOut = new FileOutputStream(FILENAME);
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        out.writeObject(this.myUserList);
        out.close();
        fileOut.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void deserializeUserList() {
        try {
            FileInputStream fileIn = new FileInputStream(FILENAME);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            this.myUserList = (ArrayList<User>) in.readObject();
            in.close();
            fileIn.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }        
}
