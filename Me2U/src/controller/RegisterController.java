/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import model.*;
import view.*;
/**
 *
 * @author David
 */
public class RegisterController {
    
    Inventory myInventory;
    UserList myUserList;
    Register registerView;
    
    public RegisterController(Inventory theInventory, UserList theUserList) {
        myInventory = theInventory;
        myUserList = theUserList;
        registerView = new Register();
        addListeners();
    }
    
    private void addListeners() {
        
        registerView.getFrame().addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                myInventory.serializeInventory();
                myUserList.serializeUserList();
                System.exit(0);
            }
        });
        
        registerView.getRegisterButton().addMouseListener(
            new java.awt.event.MouseAdapter() {
                @Override
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    registerButtonMouseClicked();
                }
            });
    }
    
    private void registerButtonMouseClicked() {
        if(myUserList.nameTaken(registerView.getNameText().getText())) {
            registerView.getNameTakenLabel().setVisible(true);                      
        } else {
            if (registerView.getIDText().getText().length()>0 
                    && registerView.getNameText().getText().length()>0
                    && registerView.getPasswordText().getText().length()>0) {
                
                User newuser = new User(registerView.getIDText().getText(), registerView.getNameText().getText(),
                    registerView.getPasswordText().getText(), 0, 1);
                myUserList.addUser(newuser);
                System.out.println("user created");
                myUserList.serializeUserList();
                registerView.close();
                if (newuser.getType() == 0) {
                    //AdminController admincontroller = new AdminController(myInventory, myUserList);
                } else {
                    //Me2UController homecontroller = new Me2UController(myInventory, myUserList);
                }
            }
                        
        }
    }
}
