/**
 * Sandeep Heera
 * CarePackage.java
 * This class is a representation of a care package in Me2U's inventory.
 */
import java.util.ArrayList;
import java.util.Iterator;

/**
 * This class represents pre-defined care packages. These packages have a 
 * pre-determined number of items and are intended to be updated in the 
 * Inventory class.
 * 
 * @author Sandeep Heera
 */
public class CarePackage implements java.io.Serializable{
    private String packageName;
    ArrayList<Item> itemList;
    int quantity;
    int packageValue;
    
    /**
     * Default constructor.
     * 
     * @param packageName name of the package
     * @param itemList items contained in the package
     */
    public CarePackage(String packageName, ArrayList<Item> itemList){
        this.packageName = packageName;
        this.itemList = new ArrayList<>();
        this.itemList = itemList;
        this.quantity = 0;
        this.packageValue = 0;
    }
    
    /**
     * Returns the name of the package.
     * 
     * @return name of the package
     */
    public String getPackageName(){
        return this.packageName;
    }
    
    /**
     * Returns the items contained in the package.
     * @return an arraylist containing the items in the package
     */
    public ArrayList<Item> getItemList(){
        return this.itemList;
    }
    
    /**
     * Returns the number of packages that are available.
     * 
     * @return quantity of the package
     */
    public int getQuantity(){
        return this.quantity;
    }
    
    /**
     * Returns the value of the package.
     * 
     * @return value of the package
     */
    public int getPackageValue(){
        return this.packageValue;
    }
    
    /**
     * Sets a new name for the package.
     * 
     * @param newName new name of the package
     */
    public void setPackageName(String newName){
        this.packageName = new String(newName);
    }
    
    /**
     * Sets a new item list for the package.
     * 
     * @param newList arraylist of new items
     */
    public void setItemList(ArrayList<Item> newList){
        this.itemList = newList;
    }
    
    /**
     * Sets a new quantity for the package. Should be set by the Inventory 
     * class any time inventory changes or the item list for package changes.
     * 
     * @param newQuantity new quantity of the package
     */
    public void setQuantity(int newQuantity){
        this.quantity = newQuantity;
    }
    
    /**
     * Sets a new package value for the package. This method iterates through 
     * the item list and finds the summation of all of the items present to 
     * determine the value of the package. This should be called any time an
     * adjustment is made to the list of items in the package.
     */
    public void setPackageValue(){      
        if(!itemList.isEmpty()){
            int newPackageValue = 0;
            Iterator it = (Iterator) itemList.iterator();
            Item item;

            while(it.hasNext()){    //iterate through the list
                item = (Item) it.next();
                //add to the new value
                newPackageValue += item.getQuantity() * item.getValue();
            }
            this.packageValue = newPackageValue;
        }
    }
    
    /**
     * Checks to see if there is an item with the name itemName in the package.
     * Returns true if it exists or false otherwise.
     * 
     * @param itemName name of the item to search for
     * @return true if the item exists or false otherwise
     */
    public boolean itemExists(String itemName){
        Iterator it = (Iterator) itemList.iterator();
        Item item;
        
        while(it.hasNext()){    //iterate through the list
            item = (Item) it.next();
            if(item.getItemName().equals(itemName)){
                return true;
            }
        }
        return false;   //didn't find the item
    }
    
    /**
     * Returns the item with name itemName if it exists in the item list for
     * this package or null if it is not present.
     * 
     * @param itemName name of the item to search for
     * @return the item with name itemName if it exists or null otherwise
     */
    public Item getItem(String itemName){
        Iterator it = (Iterator) itemList.iterator();
        Item item;
        
        while(it.hasNext()){    //iterate through the list
            item = (Item) it.next();
            //if the item has the same name as the parameter, return it
            if(item.getItemName().equals(itemName)){
                return item;
            }
        }
        return null;    //item was not found
    }
    
    /**
     * Adds a new item with the specified parameters and adds it to the item
     * list for this package provided an item with that name does not already 
     * exist.
     * 
     * @param itemName name of the item
     * @param itemType type of the item
     * @param quantity quantity of the item in this package
     * @param itemValue value of the item
     */
    public void addItem(String itemName, String itemType, int quantity,
                        int itemValue){
        if(!itemExists(itemName)){
            //create new item
            Item item = new Item(itemName, itemType, quantity, 0,
                                 itemValue);
            //add it to the item list
            itemList.add(item);
        }
    }
    
    /**
     * Returns the quantity of the item in the item list of the package 
     * provided it exists.
     * 
     * @param itemName name of the item to search for
     * @return quantity of the item or -1 if it is not found
     */
    public int getItemQuantity(String itemName){
        if(itemExists(itemName)){
            return getItem(itemName).getQuantity();
        }
        else{
            return -1;
        }
    }
    
    /**
     * Deletes the item with the same name as the parameter provided it exists.
     * 
     * @param itemName name of the item to be deleted
     */
    public void deleteItem(String itemName){
        if(itemExists(itemName)){
            Iterator it = (Iterator) itemList.iterator();
            Item item;
            
            while(it.hasNext()){    //iterate through the list to find the item
                item = (Item) it.next();
                
                if(item.getItemName().equals(itemName)){
                    it.remove();    //remove item
                }
            }
        }
    }
    
    /**
     * Updates the name of the item with the name itemName provided
     * it exists.
     * 
     * @param itemName name of the item to be updated in the package list
     * @param newName new name of the item
     */
    public void updateItemName(String itemName, String newName){
        if(itemExists(itemName)){   //if the item exists
            Item item = getItem(itemName);
            
            item.setItemName(newName);  //update the name
        }
    }
    
    /**
     * Updates the type of the item with the name itemName provided
     * it exists.
     * 
     * @param itemName name of the item to be updated in the package
     * @param newType new type of the item
     */
    public void updateItemType(String itemName, String newType){
        if(itemExists(itemName)){   //if the item exists
            Item item = getItem(itemName);
            
            item.setItemType(newType);  //update the type
        }
    }
    
    /**
     * Updates the quantity of the item with the name itemName provided
     * it exists.
     * 
     * @param itemName name of the item to be updated in the package
     * @param newQuantity new quantity of the item
     */
    public void updateItemQuantity(String itemName, int newQuantity){
        if(itemExists(itemName)){   //if the item exists
            Item item = getItem(itemName);
            
            item.setQuantity(newQuantity);  //update the quantity
        }
    }
    
    /**
     * Updates the value of the item with the name itemName provided
     * it exists.
     * 
     * @param itemName name of the item to be updated in the package
     * @param newValue new value of the item
     */
    public void updateItemValue(String itemName, int newValue){
        if(itemExists(itemName)){   //if the item exists
            Item item = getItem(itemName);
            
            item.setValue(newValue);  //update the value
        }
    }
}
