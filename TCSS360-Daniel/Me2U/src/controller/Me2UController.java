/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.swing.JDialog;
import javax.swing.JPopupMenu;
import javax.swing.JTextArea;
import model.*;
import view.*;

/**
 *
 * @author David and Daniel 
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

        homeView.getHowToDonateItem().addMouseListener(
                new java.awt.event.MouseAdapter() {
            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) {
                howToDonateButtonClicked();
            }
        }
        );

        homeView.getVolunteerItem().addMouseListener(
                new java.awt.event.MouseAdapter() {
            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) {
                volunteeringClicked();
            }
        }
        );

        homeView.getPickUpEligibilityItem().addMouseListener(
                new java.awt.event.MouseAdapter() {
            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pickupEligibilityClicked();
            }
        }
        );

        homeView.getItemsWeTakeItem().addMouseListener(
                new java.awt.event.MouseAdapter() {
            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) {
                itemsWeTakeClicked();
            }
        }
        );
                homeView.getEligibilityItem().addMouseListener(
                new java.awt.event.MouseAdapter() {
            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) {
                eligibilityClicked();
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

    private void howToDonateButtonClicked() {
        JDialog howToDonateDialog = new JDialog();
        howToDonateDialog.setTitle("How To Donate");

        JTextArea howToDonateText = new JTextArea("\n o Click “Donate Now” under donations. \n"
                + "   - Doing this will take you to the “Donation Page”\n"
                + " o Select items you want by selecting the category and then the item.\n"
                + "   - You set the quantity by entering the number of items of that type \n"
                + "     you are donating, then clicking the “Add” button. \n"
                + "   - If you make a mistake and add the wrong item or an incorrect amount, \n"
                + "     you can delete the item from the “Cart” by selecting it and pressing \n"
                + "     the “Remove Item” button. \n"
                + "   - The number of points you will get from the donations is displayed \n"
                + "     in the “Cart Points” box. Donate more to compete on the Leaderboard!\n"
                + " o Once you have added all the items to the Cart, click the “Donate \n"
                + "     Now” button to finish your donation. \n");
        howToDonateText.setEditable(false);
        howToDonateDialog.add(howToDonateText);
        howToDonateDialog.pack();
        howToDonateDialog.setLocationRelativeTo(null);
        howToDonateDialog.setResizable(false);
        howToDonateDialog.setEnabled(true);
        howToDonateDialog.setVisible(true);

    }

    private void volunteeringClicked() {
        JDialog volunteeringDialog = new JDialog();
        volunteeringDialog.setTitle("How To Volunteer");

        JTextArea volunteeringText = new JTextArea("\n o If you would like to volunteer please come down  \n"
                + "    to our office!\n o Alternatively, you can call to get a list of  \n"
                + "    upcoming events. Our phone number is (253) 555 - 1234  \n"
                + "    Hope to hear from you soon! \n");
        volunteeringText.setEditable(false);
        volunteeringDialog.add(volunteeringText);
        volunteeringDialog.pack();
        volunteeringDialog.setLocationRelativeTo(null);
        volunteeringDialog.setResizable(false);
        volunteeringDialog.setEnabled(true);
        volunteeringDialog.setVisible(true);

    }

    private void pickupEligibilityClicked() {
        JDialog pickupEligibilityDialog = new JDialog();
        pickupEligibilityDialog.setTitle("Pickup Eligibility");

        JTextArea pickupEligibilityText = new JTextArea(
                "\n o To be eligible for pickup you must be \n"
                + "    within 20 miles of Tacoma. We apologize \n"
                + "    if you are not within this limit, and \n"
                + "    promise we are hoping to expand soon! \n");
        pickupEligibilityText.setEditable(false);
        pickupEligibilityDialog.add(pickupEligibilityText);
        pickupEligibilityDialog.pack();
        pickupEligibilityDialog.setLocationRelativeTo(null);
        pickupEligibilityDialog.setResizable(false);
        pickupEligibilityDialog.setEnabled(true);
        pickupEligibilityDialog.setVisible(true);

    }

    private void itemsWeTakeClicked() {
        JDialog itemsWeTakeDialog = new JDialog();
        itemsWeTakeDialog.setTitle("Items We Take");

        JTextArea itemsWeTakeText = new JTextArea(
                "                       \n"
                + " o Food \n"
                + "   - Baby Food \n"
                + "   - Baby Formula \n"
                + "   - Rice \n"
                + "   - Canned Fruit \n"
                + "   - Dried Beans \n"
                + "   - Bread \n"
                + "   - Dried Milk \n"
                + "   - Canned Soup \n\n"
                + " o Clothing \n"
                + "   - Jacket \n"
                + "   - Diapers \n"
                + "   - Gloves \n"
                + "   - Wool Hat \n"
                + "   - Wool Socks \n\n"
                + " o Hygiene \n"
                + "   - Hand Sanitizer \n"
                + "   - Disinfectant Wipes       \n"
                + "   - Shampoo \n"
                + "   - Bar Soap \n"
                + "   - Toothbrush \n"
                + "   - Toothpaste \n"
                + "   - Deodorant \n\n"
                + " o First Aid \n"
                + "   - Neosporin \n"
                + "   - Hydrogen Peroxide        \n"
                + "   - Gauze \n"
                + "   - Band-Aid \n"
                + "   - Flu Vaccine \n\n"
                + " o Furniture \n"


        
        );
        itemsWeTakeText.setEditable(false);
        itemsWeTakeDialog.add(itemsWeTakeText);
        itemsWeTakeDialog.pack();
        itemsWeTakeDialog.setLocationRelativeTo(null);
        itemsWeTakeDialog.setResizable(false);
        itemsWeTakeDialog.setEnabled(true);
        itemsWeTakeDialog.setVisible(true);

    }
    
        private void eligibilityClicked() {
        JDialog eligibilityDialog = new JDialog();
        eligibilityDialog.setTitle("Eligibility");

        JTextArea eligibilityText = new JTextArea(
                          "\n o You can find out if you are eligible for aid by a simple \n"
                        + "  calculation. \n\n"
                        + "   - First, calculate your Household Income:Need Ratio \n\n"
                        + "  Household Income:Need Ratio = Sum of income of every person \n"
                        + "  living int he household divided by the the number of poeple \n"
                        + "  living in your household. \n\n"
                        + " o If your Household Income:Need Ratio is < 1000 you are Eligible ");
        eligibilityText.setEditable(false); 
        eligibilityDialog.add(eligibilityText);
        eligibilityDialog.pack();
        eligibilityDialog.setLocationRelativeTo(null);
        eligibilityDialog.setResizable(false);
        eligibilityDialog.setEnabled(true);
        eligibilityDialog.setVisible(true);

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
