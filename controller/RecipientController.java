
/**
 * Sandeep Heera
 * RecipientController.java
 * This is the view for the donation page.
 */
package controller;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import model.*;
import view.*;
import javax.swing.JOptionPane; 

/**
 * This class is the controller for the donor view class. It holds an instance
 * of the model and donor view. It is meant to be an intermediary between 
 * the view and model in order to adhere to the requirements of the MVC 
 * developmental pattern.
 * 
 * @author Sandeep Heera
 * @author Ziliang
 */
public class RecipientController {
    private Inventory inventory;
    private UserList myUserList;
    private User myUser;
    private Cart cart;
    private RecipientView recipView;
    private String itemToCheck = new String();
    private String cartItemToCheck = new String();
    private int defaultPoint = 300;
    
    /**
     * Default constructor. Initializes the model members, deserializes
     * inventory, and prepares the event handlers.
     */
    public RecipientController(Inventory theInventory, UserList theUserList, User theUser){
        inventory = theInventory;
        cart = new Cart();
        recipView = new RecipientView();
        myUserList = theUserList;
        myUser = theUser;
        this.addListeners();
    }
    
    /**
     * Add event handlers to the swing elements in the view.
     */
    private void addListeners(){
        
        recipView.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                inventory.serializeInventory();
                myUserList.serializeUserList();
                System.exit(0);
            }
        });
        
        this.recipView.getRemoveItemButton().addMouseListener(
            new java.awt.event.MouseAdapter() {
                @Override
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    removeButtonMouseClicked();
                }
            }
        );
	
        this.recipView.getRequestAidButton().addMouseListener(
            new java.awt.event.MouseAdapter() {
                @Override
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    requestAidButtonMouseClicked();
                }
            }
        );
		
        this.recipView.getBackButton().addMouseListener(
            new java.awt.event.MouseAdapter() {
                @Override
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    backButtonActionPerformed();
                }
            }
        );
        
        this.recipView.getAddItemButton().addMouseListener(
            new java.awt.event.MouseAdapter() {
                @Override
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    quantityAddButtonMouseClicked();
                }
            }
        );
        
        this.recipView.getCategoryList().addListSelectionListener(
            new javax.swing.event.ListSelectionListener() {
                @Override
                public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                    categoryListValueChanged(evt);
                }
            }
        );

        this.recipView.getCartList().addListSelectionListener(
            new javax.swing.event.ListSelectionListener() {
                @Override
                public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                    cartListValueChanged(evt);
                }
            }
        );

        this.recipView.getItemList().addListSelectionListener(
            new javax.swing.event.ListSelectionListener() {
                @Override
                public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                    categoryItemsValueChanged(evt);
                }
            }
        );
    }        
    
    /**
     * Returns the DonorView of this DonorController object.
     * 
     * @return DonorView of this DonorController object
     */
    public RecipientView getRecipView(){
        return this.recipView;
    }
    /**
     * The application when the donor clicks back.
     */
    private void backButtonActionPerformed() {                                             
        recipView.dispose();
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
            String s = this.recipView.getCategoryList().getSelectedValue();
            System.out.println(s);
            if(s.equals("Packages")){
                String packageInfo = new String();
                ArrayList<CarePackage> packageList = inventory.getPackageList();
                for(int i = 0; i < packageList.size();i++){
                    packageInfo += packageList.get(i);
                }
                this.recipView.getPackagesTextArea().setText("Package List: \n\n" + packageInfo);
                this.recipView.getPackagesPopUp().pack();
                this.recipView.getPackagesPopUp().setVisible(true);
            }
            else{
                ArrayList<Item> items = inventory.getItemsOfType(s.toLowerCase());
               ((DefaultListModel)this.recipView.getItemList().getModel()).clear();
                for(int i = 0;i < items.size();i++){
                    ((DefaultListModel)this.recipView.getItemList().getModel()).addElement(
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
    private void requestAidButtonMouseClicked() {                                             
        if(checkAvalibility(cart)) {
            inventory.subCart(cart);
            recipView.dispose();
            Me2UController controller = new Me2UController(inventory, myUserList, myUser);
        }
    }
    
    private boolean checkAvalibility(Cart cart) {
        boolean check;
        int value = defaultPoint - cart.getCartValue();
        if(value < 0) {
            JOptionPane.showMessageDialog(null, "You cannot take that much!", "Warnning",
                                    JOptionPane.ERROR_MESSAGE);
            check = false;
        } else {
            check = true;
        }
        return check;
    }

    /**
     * Determines which item the donor has selected in the category items 
     * JList and sets the itemToCheck String equal to that item.
     * 
     * @param evt status of list selection
     */
    private void categoryItemsValueChanged(javax.swing.event.ListSelectionEvent evt) {                                           
        if(!evt.getValueIsAdjusting() && this.recipView.getItemList().getSelectedValue() != null){
            itemToCheck = this.recipView.getItemList().getSelectedValue();
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
        if(!evt.getValueIsAdjusting() && this.recipView.getCartList().getSelectedValue() != null){
            cartItemToCheck = this.recipView.getCartList().getSelectedValue();
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
        if(this.getRecipView().getQuantityTextField().getText() != null &&
           !itemToCheck.equals("") && itemToCheck != null){
            String quantity = this.getRecipView().getQuantityTextField().getText();
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
            this.getRecipView().getQuantityTextField().setText("");
        }
    }                                                                                  
    
    /**
     * Updates the cart JList to reflect the current state of the cart.
     */
    private void setCartList(){
        ((DefaultListModel)this.recipView.getCartList().getModel()).clear();
        ((DefaultListModel)this.recipView.getQuantityList().getModel()).clear();
        ArrayList<Item> items = cart.getItems();
        for(int i = 0;i < items.size();i++){
            ((DefaultListModel)this.recipView.getCartList().getModel()).addElement(items.get(i).getItemName());
            ((DefaultListModel)this.recipView.getQuantityList().getModel()).addElement(items.get(i).getQuantity());
        }
        this.recipView.getCartPointsTextField().setText(Integer.toString(cart.getCartValue()));
    }
}
