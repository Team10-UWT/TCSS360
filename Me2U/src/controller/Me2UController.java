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
    }
}
