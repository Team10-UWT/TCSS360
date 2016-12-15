/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me2u;
import model.*;
import controller.*;
import java.util.ArrayList;
/**
 *
 * @author David
 */
public class Me2U {
    public static void main(String[] args) {
        //Me2Umodel model = new Me2Umodel();
        //AdminHomePage test = new AdminHomePage();
        //DonorController test = new DonorController();
        Inventory myInventory = new Inventory();
        myInventory.deserializeInventory();
        UserList myUserList = new UserList();
        myUserList.deserializeUserList();
        
        ArrayList<Item> itemList = new ArrayList<>();
        
        itemList.add(new Item("Campbell's Tomato Soup", "food", 10, 0, 4));
        itemList.add(new Item("Band-Aids", "first aid", 10, 0, 2));
        itemList.add(new Item("Beef Jerky", "food", 10, 0, 1));
        itemList.add(new Item("Flash Light", "other", 1, 0, 15));
        
        CarePackage carePack = new CarePackage("One Week Survival", itemList);
        
        ArrayList<Item> itemList2 = new ArrayList<>();
        
        itemList2.add(new Item("Jacket", "clothing", 1, 9, 2));
        itemList2.add(new Item("Gloves", "clothing", 1, 5, 2));
        itemList2.add(new Item("Wool Socks", "clothing", 2, 100, 1));
        itemList2.add(new Item("Wool Hat", "clothing", 1, 200, 3));
        
        
        CarePackage carePack2 = new CarePackage("Warm Clothes", itemList2);
        
        ArrayList<Item> itemList3 = new ArrayList<>();
        
        itemList3.add(new Item("Hand Sanitizer", "hygiene", 2, 40, 3));
        itemList3.add(new Item("Shampoo", "hygiene", 1, 20, 2));
        itemList3.add(new Item("Disinfectant Wipes", "hygiene", 2, 350, 2));
        itemList3.add(new Item("Bar Soap", "hygiene", 1, 50, 2));
        itemList3.add(new Item("Toothbrush", "hygiene", 1, 70, 2));
        itemList3.add(new Item("Toothpaste", "hygiene", 1, 70, 2));
        itemList3.add(new Item("Deodorant", "hygiene", 1, 2, 1));

        CarePackage carePack3 = new CarePackage("Hygiene Pack", itemList3);
        
        
        
        //myInventory.deletePackage("One Week Survival");
        //myInventory.deletePackage("Warm Clothes");
        //myInventory.deletePackage("Hygiene Pack");
        
        
        myInventory.addPackage(carePack);
        myInventory.addPackage(carePack2);
        myInventory.addPackage(carePack3);
        
        //RecipientController test2 = new RecipientController();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //test.getDonorView().setVisible(true);
                //test2.getRecipView().setVisible(true);
                LoginController controller = new LoginController(myInventory, myUserList);
                /*
                Run this code once then delete it to create an Admin account for Professor Weiss
                myUserList.addUser(new User("Jdawg", "Jeffery Weiss", "123", 0,0));
                */
            }
        });
    }
    
}
