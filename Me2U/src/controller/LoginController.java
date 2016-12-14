/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import java.util.Arrays;
import model.*;
import view.*;
/**
 *
 * @author David
 */
public class LoginController {
    Inventory myInventory;
    UserList myUserList;
    UserLogin loginView;
    public LoginController(Inventory theInventory, UserList theUserList) {
        myInventory = theInventory;
        myUserList = theUserList;
        loginView = new UserLogin();
        addListeners();
    }
    
    private void addListeners() {
        
        loginView.getLoginButton().addMouseListener(
            new java.awt.event.MouseAdapter() {
                @Override
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    loginButtonMouseClicked();
                }
            });
        
        loginView.getRegisterButton().addMouseListener(
            new java.awt.event.MouseAdapter() {
                @Override
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    registerButtonMouseClicked();
                }
            });
    }
    
    private void loginButtonMouseClicked() {
        if(myUserList.userExists(myUserList.getUser(loginView.getUserNameText().getText()))){
            User user = myUserList.getUser(loginView.getUserNameText().getText());
                if (Arrays.equals(user.getPassword().toCharArray(), loginView.getPasswordField().getPassword())) {
                    System.out.println("User authenticated");
                    loginView.close();
                        if (user.getType() == 0) {
                            //AdminController admincontroller = new AdminController(myInventory, myUserList);
                        } else {
                          //Me2UController homecontroller = new Me2UController(myInventory, myUserList);
                        }                    
                } else {
                    loginView.getIncorrectLoginLabel().setVisible(true);
                }
        } else {
            loginView.getIncorrectLoginLabel().setVisible(true);
        }
    }
    
    private void registerButtonMouseClicked() {
        loginView.close();
        //RegisterController controller = new RegisterController(myInventory, myUserList);
    }
}
