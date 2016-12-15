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
public class Me2UController {
    Inventory myInventory;
    UserList myUserList;
    User myUser;
    Me2Ugui homeView;
    
    public Me2UController(Inventory theInventory, UserList theUserList, User theUser) {
        myInventory = theInventory;
        myUserList = theUserList;
        myUser = theUser;
        homeView = new Me2Ugui();
        homeView.getNameLabel().setText(myUser.getName());
        if (myUser.getType() == 0) {
            homeView.getAdminButton().setVisible(true);
        }
        addListeners();
    }
    
    private void addListeners() {
        homeView.getFrame().addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                myInventory.serializeInventory();
                myUserList.serializeUserList();
                System.exit(0);
            }
        });
        
        homeView.getdButton().addMouseListener(
            new java.awt.event.MouseAdapter() {
                @Override
                public void mousePressed(java.awt.event.MouseEvent evt) {
                    dButtonClicked();
                }
            }
        );
       
        
        homeView.getrButton().addMouseListener(
            new java.awt.event.MouseAdapter() {
                @Override
                public void mousePressed(java.awt.event.MouseEvent evt) {
                    rButtonClicked();
                }
            }
        );
        
        homeView.getDonateItem().addMouseListener(
            new java.awt.event.MouseAdapter() {
                @Override
                public void mousePressed(java.awt.event.MouseEvent evt) {
                    donateItemClicked();
                }
            }
        );
        
        homeView.getReqAidItem().addMouseListener(
            new java.awt.event.MouseAdapter() {
                @Override
                public void mousePressed(java.awt.event.MouseEvent evt) {
                    reqAidItemClicked();
                }
            }
        );
        
        homeView.getLogoutButton().addMouseListener(
            new java.awt.event.MouseAdapter() {
                @Override
                public void mousePressed(java.awt.event.MouseEvent evt) {
                    logoutButtonClicked();
                }
            }
        );
        
        homeView.getAdminButton().addMouseListener(
            new java.awt.event.MouseAdapter() {
                @Override
                public void mousePressed(java.awt.event.MouseEvent evt) {
                    adminButtonClicked();
                }
            }
        );
    }
    
    private void dButtonClicked() {
        homeView.getPopupD().show(homeView.getdButton(), homeView.getdButton().getX(), homeView.getdButton().getY() + 30);
    }
    
    private void rButtonClicked() {
        homeView.getPopupR().show(homeView.getrButton(), homeView.getrButton().getX(), homeView.getrButton().getY() + 30);
    }
    
    private void donateItemClicked() {
        homeView.getFrame().dispose();
        DonorController controller = new DonorController(myInventory, myUserList, myUser);
    }
    
    private void reqAidItemClicked() {
        homeView.getFrame().dispose();
        RecipientController controller = new RecipientController(myInventory, myUserList, myUser);
    }
    
    private void logoutButtonClicked() {
        homeView.getFrame().dispose();
        LoginController controller = new LoginController(myInventory, myUserList);
    }
    
    private void adminButtonClicked() {
        homeView.getFrame().dispose();
        AdminController controller = new AdminController(myInventory, myUserList, myUser);
    }
    
}
