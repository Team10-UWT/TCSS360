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
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author David
 */
public class Me2Umodel {
/**
 * @param args the command line arguments
*/
    private static final String FILENAME = "userList.ser";
    public UsersList myUsers;
    private Inventory myInventory;
    
    public Me2Umodel() {
        myUsers = readUserListFromFile();
        myInventory = new Inventory();
        //myInventory.deserializeInventory();
        
    }
    
    public static UsersList readUserListFromFile() {
        try {
            ObjectInputStream objectInput = new ObjectInputStream(new FileInputStream(FILENAME));
            return (UsersList) objectInput.readObject();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Me2U.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(Me2U.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static int writeUserListToFile(final UsersList theUsers) {
        try {
            ObjectOutputStream objectOutput = new ObjectOutputStream(new FileOutputStream(FILENAME));
            objectOutput.writeObject(theUsers);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Me2U.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Me2U.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 1;
    }
    
}
