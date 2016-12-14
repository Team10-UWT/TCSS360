/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me2u;
import view.*;
import model.*;
import controller.*;
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
        
        //RecipientController test2 = new RecipientController();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //test.getDonorView().setVisible(true);
                //test2.getRecipView().setVisible(true);
                LoginController controller = new LoginController(myInventory, myUserList);
            }
        });
    }
    
}
