/**
 * Sandeep Heera
 * DonorController.java
 * This is the view for the donation page.
 */
package controller;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import model.*;
import view.*;

/**
 * This class is the controller for the donor view class. It holds an instance
 * of the model and donor view. It is meant to be an intermediary between 
 * the view and model in order to adhere to the requirements of the MVC 
 * developmental pattern.
 * 
 * @author Sandeep Heera
 */
public class DonorController {
    private Inventory inventory;
    private UserList myUserList;
    private User myUser;
    private Cart cart;
    private DonorView donorView;
    private String itemToCheck = new String();
    private String cartItemToCheck = new String();
    
    /**
     * Default constructor. Initializes the model members, deserializes
     * inventory, and prepares the event handlers.
     */
    public DonorController(Inventory theInventory, UserList theUserList, User theUser){
        inventory = theInventory;
        myUserList = theUserList;
        myUser = theUser;
        cart = new Cart();
        donorView = new DonorView();
        addListeners();
    }
    
    /**
     * Add event handlers to the swing elements in the view.
     */
    private void addListeners(){
        
        donorView.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                inventory.serializeInventory();
                myUserList.serializeUserList();
                System.exit(0);
            }
        });
        
        this.donorView.getRemoveItemButton().addMouseListener(
            new java.awt.event.MouseAdapter() {
                @Override
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    removeButtonMouseClicked();
                }
            }
        );
	
        this.donorView.getDonateNowButton().addMouseListener(
            new java.awt.event.MouseAdapter() {
                @Override
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    donateNowButtonMouseClicked();
                }
            }
        );
		
        this.donorView.getAddItemButton().addMouseListener(
            new java.awt.event.MouseAdapter() {
                @Override
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    quantityAddButtonMouseClicked();
                }
            }
        );
        
        this.donorView.getCategoryList().addListSelectionListener(
            new javax.swing.event.ListSelectionListener() {
                @Override
                public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                    categoryListValueChanged(evt);
                }
            }
        );

        this.donorView.getCartList().addListSelectionListener(
            new javax.swing.event.ListSelectionListener() {
                @Override
                public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                    cartListValueChanged(evt);
                }
            }
        );

        this.donorView.getItemList().addListSelectionListener(
            new javax.swing.event.ListSelectionListener() {
                @Override
                public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                    categoryItemsValueChanged(evt);
                }
            }
        );
        
        this.donorView.getBackButton().addMouseListener(
            new java.awt.event.MouseAdapter() {
                @Override
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    backButtonMouseClicked();
                }
            }
        );
    }        
    
    /**
     * Returns the DonorView of this DonorController object.
     * 
     * @return DonorView of this DonorController object
     */
    public DonorView getDonorView(){
        return this.donorView;
    }
      
    private void backButtonMouseClicked() {
        donorView.dispose();
        Me2UController controller = new Me2UController(inventory, myUserList, myUser);
    }
    /**
     * Determines which category the donor has selected and populates the 
     * category items JList depending on that selection.
     * 
     * @param evt status of list selection
     */
    private void categoryListValueChanged(javax.swing.event.ListSelectionEvent evt) {                                          
        if(!evt.getValueIsAdjusting()){
            String s = this.donorView.getCategoryList().getSelectedValue();
            System.out.println(s);
            if(s.equals("Needed Items")){
                ArrayList<Item> items = inventory.getNeeded();
                ((DefaultListModel)this.donorView.getItemList().getModel()).clear();
                for(int i = 0;i < items.size();i++){
                    ((DefaultListModel)this.donorView.getItemList().getModel()).addElement(
                    items.get(i).getItemName());
                }
            }
            else if(s.equals("Packages")){
                String packageInfo = new String();
                ArrayList<CarePackage> packageList = inventory.getPackageList();
                for(int i = 0; i < packageList.size();i++){
                    packageInfo += packageList.get(i);
                }
                this.donorView.getPackagesTextArea().setText("Package List: \n\n" + packageInfo);
                this.donorView.getPackagesPopUp().pack();
                this.donorView.getPackagesPopUp().setVisible(true);
            }
            else{
                ArrayList<Item> items = inventory.getItemsOfType(s.toLowerCase());
               ((DefaultListModel)this.donorView.getItemList().getModel()).clear();
                for(int i = 0;i < items.size();i++){
                    ((DefaultListModel)this.donorView.getItemList().getModel()).addElement(
                    items.get(i).getItemName());
                }
            }
        }
        System.out.println(inventory);
    }            
    
    /**
     * Removes the selected item from the cart.
     */
    private void removeButtonMouseClicked() {                                          
        if(!cartItemToCheck.equals("") && cartItemToCheck != null){
            cart.removeItem(cartItemToCheck);
            setCartList();
        }
    }     
    
    /**
     * The items in the cart will be added to inventory (model) and the updated
     * inventory will be serialized.
     */
    private void donateNowButtonMouseClicked() {                                             
        inventory.addCart(cart);
	myUser.addPoints(cart.getCartValue());
        donorView.dispose();
        Me2UController controller = new Me2UController(inventory, myUserList, myUser);
    }                                            
    
    /**
     * Determines which item the donor has selected in the category items 
     * JList and sets the itemToCheck String equal to that item.
     * 
     * @param evt status of list selection
     */
    private void categoryItemsValueChanged(javax.swing.event.ListSelectionEvent evt) {                                           
        if(!evt.getValueIsAdjusting() && this.donorView.getItemList().getSelectedValue() != null){
            itemToCheck = this.donorView.getItemList().getSelectedValue();
            System.out.println(inventory);
        }
    }                                          
    
    /**
     * Determines which item the donor has selected in the cart JList and sets
     * the cartItemToCheck String equal to that item.
     * 
     * @param evt status of list selection
     */
    private void cartListValueChanged(javax.swing.event.ListSelectionEvent evt) {                                      
        if(!evt.getValueIsAdjusting() && this.donorView.getCartList().getSelectedValue() != null){
            cartItemToCheck = this.donorView.getCartList().getSelectedValue();
            System.out.println(cartItemToCheck);
        }
    }                                     
    
    /**
     * Checks to see if the value in the quantity JTextField is an integer and 
     * that itemToCheck is currently valid (non-null and not an empty String).
     * If the values for both are valid, the item with the name itemToCheck
     * is added to the cart.
     */
    private void quantityAddButtonMouseClicked() {                                               
        if(this.getDonorView().getQuantityTextField().getText() != null &&
           !itemToCheck.equals("") && itemToCheck != null){
            String quantity = this.getDonorView().getQuantityTextField().getText();
            int quant = 0;
            try {
              quant = Integer.parseInt(quantity);
            } 
            catch (NumberFormatException e) {
                System.out.println("Invalid Input");
            }
            System.out.println(quant);
            if(quant > 0 ){
                if(cart.itemExists(itemToCheck)){
                     cart.getItem(itemToCheck).setQuantity(this.cart.getItem(itemToCheck).getQuantity() + quant);
                     setCartList();
                }
                else{
                    this.cart.addItem(new Item(itemToCheck, inventory.getItem(itemToCheck).getItemType(),
                                      quant, 0, inventory.getItem(itemToCheck).getValue()));
                    setCartList();
                }
            }
            this.getDonorView().getQuantityTextField().setText("");
        }
    }                                                                                  
    
    /**
     * Updates the cart JList to reflect the current state of the cart.
     */
    private void setCartList(){
        ((DefaultListModel)this.donorView.getCartList().getModel()).clear();
        ((DefaultListModel)this.donorView.getQuantityList().getModel()).clear();
        ArrayList<Item> items = cart.getItems();
        for(int i = 0;i < items.size();i++){
            ((DefaultListModel)this.donorView.getCartList().getModel()).addElement(items.get(i).getItemName());
            ((DefaultListModel)this.donorView.getQuantityList().getModel()).addElement(items.get(i).getQuantity());
        }
        this.donorView.getCartPointsTextField().setText(Integer.toString(cart.getCartValue()));
    }
    
}
