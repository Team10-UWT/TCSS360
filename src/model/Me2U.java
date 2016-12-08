/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.function.BiConsumer;
import java.util.logging.Level;
import java.util.logging.Logger;
import jdk.nashorn.internal.objects.NativeArray;

/**
 *
 * @author Daniel
 */
public class Me2U {

    /**
     * @param args the command line arguments
     */
    private static final String FILENAME = "userList.ser";

    public static void main(String theargs[]) {

        User[] myUsers = new User[10];
        UsersList UsersList = new UsersList();

        File fileToRead = new File("userList");
//        System.out.print("FileReading = " + generateUserList(fileToRead));
        User user1 = new User("DisIsDan", "Daniel", "Wood", "12345", "What does the fox say?", "RindDing", 9001, 1);

        User user2 = new User("PinkElephant", "Bailey", "Gigeraldi", "54321", "What shouldn’t you try?", "this at home", 9001, 2);

        myUsers[0] = user1;
        myUsers[1] = user2;
        UsersList.putUser(user1.getUsername(), user1);
        UsersList.putUser(user2.getUsername(), user2);

//        System.out.println("trying to write users to file: " + writeUserListToFile(myUsers));

        System.out.println("trying to write users to file: " + writeUserListToFile(UsersList));


        System.out.println("this prints after creating the file");

//        User[] newListOfUsers = new User[10];

        UsersList newList = readUserListFromFile();
        UsersList.myUserTable.forEach((String key, User value) -> {
            System.out.println(value.myUsername);
        });


//        newListOfUsers = readUserListFromFile();
//        printUsers(newListOfUsers);
    }

//    public static int writeUserListToFile(User[] theUsers) {
//        try {
//            ObjectOutputStream objectOutput = new ObjectOutputStream(new FileOutputStream(FILENAME));
//            objectOutput.writeObject(theUsers);
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(Me2U.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IOException ex) {
//            Logger.getLogger(Me2U.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return 1;
//    }
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

//        public static User[] readUserListFromFile() {
//        try {
//            ObjectInputStream objectInput = new ObjectInputStream(new FileInputStream(FILENAME));
//            return (User[]) objectInput.readObject();
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(Me2U.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IOException ex) {
//            Logger.getLogger(Me2U.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(Me2U.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return null;
//    }
//    private static int generateUserList(final File theFileName) {
//        String line = null;
//        try {
//            FileReader fileReader = new FileReader(theFileName);
//
//            try (BufferedReader bufferedReader = new BufferedReader(fileReader)) {
//                while ((line = bufferedReader.readLine()) != null) {
//                    System.out.println(line);
//                }
//            }
//        } catch (FileNotFoundException e) {
//            System.out.println("File Not Found");
//            return -1;
//        } catch (IOException ex) {
//            System.out.println("Error Reading File");
//            return -2;
//        }
//        return 1;
//    }

    
    
    
//    private static void printUsers(User[] newListOfUsers) {
//        int i = 0;
//        while (newListOfUsers[i] != null) {
//            newListOfUsers[i].printUser();
//            i++;
//        }
//    }

}
