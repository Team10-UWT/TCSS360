/**
 * Sandeep Heera
 * Inventory.java
 * This class is a representation of Me2U's physical inventory.
 */
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Class which represents current inventory. The inventory is stored in an 
 * arraylist of items. Items can be added, removed, and modified from this
 * class.
 * 
 * @author Sandeep Heera
 */
public class Inventory implements java.io.Serializable{
    public static final double NEED_RATIO = 0.5;
    
    private ArrayList<Item> itemList;
    
    /**
     * Default constructor.
     * 
     * @param itemList arraylist of items in inventory
     */
    public Inventory(ArrayList<Item> itemList){
        this.itemList = new ArrayList<>();
        this.itemList = itemList;
    }
    
    /**
     * Iterates through the item list and returns true if an item with the
     * same name as the parameter exists in inventory or false otherwise.
     * 
     * @param itemName name of the item to search for
     * @return true if the item exists or false otherwise
     */
    public boolean itemExists(String itemName){
        Iterator it = (Iterator) itemList.iterator();
        
        Item item;
        while(it.hasNext()){    //iterate through the list
            item = (Item) it.next();
            //if the item has the same name as the parameter, return true
            if(item.getItemName().equals(itemName)){
                return true;
            }
        }
        return false;
    }
    
     /**
     * Iterates through the item list and returns the item with the
     * same name as the parameter in inventory.
     * 
     * @param itemName name of the item to return
     * @return the item that has the name as itemName
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
     * Iterates through the item list and looks for an item that has the 
     * same name as the parameter. If found, returns the quantity of the item 
     * or -1 if the item is not present.
     * @param itemName
     * @return quantity of item if it exists or -1 otherwise
     */
    public int getQuantity(String itemName){
        if(itemExists(itemName)){
            Item item = getItem(itemName);
            
            return item.getQuantity();
        }
        else{
            return -1;
        }
    }
    
    /**
     * Adds a new item with the specified parameters and adds it to the item
     * list provided an item with that name does not already exist.
     * 
     * @param itemName name of the item
     * @param itemType type of the item
     * @param quantity quantity of the item
     * @param optimalQuantity optimal quantity of the item
     * @param itemValue value of the item
     */
    public void addItem(String itemName, String itemType, int quantity,
                        int optimalQuantity, int itemValue){
        if(!itemExists(itemName)){
            //create new item
            Item item = new Item(itemName, itemType, quantity, optimalQuantity,
                                 itemValue);
            //add it to the item list
            itemList.add(item);
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
     * @param itemName name of the item to be updated in inventory
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
     * @param itemName name of the item to be updated in inventory
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
     * @param itemName name of the item to be updated in inventory
     * @param newQuantity new quantity of the item
     */
    public void updateItemQuantity(String itemName, int newQuantity){
        if(itemExists(itemName)){   //if the item exists
            Item item = getItem(itemName);
            
            item.setQuantity(newQuantity);  //update the quantity
        }
    }
    
    /**
     * Updates the optimal quantity of the item with the name itemName provided
     * it exists.
     * 
     * @param itemName name of the item to be updated in inventory
     * @param newOptimalQuantity new optimal quantity of the item
     */
    public void updateItemOptimalQuantity(String itemName, 
                                          int newOptimalQuantity){
        if(itemExists(itemName)){   //if the item exists
            Item item = getItem(itemName);
            
            //update the optimal quantity
            item.setOptimalQuantity(newOptimalQuantity);
        }
    }
    
    /**
     * Updates the value of the item with the name itemName provided
     * it exists.
     * 
     * @param itemName name of the item to be updated in inventory
     * @param newValue new value of the item
     */
    public void updateItemValue(String itemName, int newValue){
        if(itemExists(itemName)){   //if the item exists
            Item item = getItem(itemName);
            
            item.setValue(newValue);  //update the value
        }
    }
    
    /**
     * Returns an arraylist of items that have a quantity to optimal quantity
     * ratio that is <= NEED_RATIO.
     * 
     * @return arraylist of needed items
     */
    public ArrayList<Item> getNeeded(){
        ArrayList<Item> neededItems = new ArrayList<>();
        
        Iterator it = (Iterator) itemList.iterator();
        Item item;
        double ratio;
        
        while(it.hasNext()){    //iterate through the list to find the items
            item = (Item) it.next();
            ratio = (double) item.getQuantity() / item.getOptimalQuantity();
            if(ratio <= NEED_RATIO){
                Item neededItem = new Item(item.getItemName(), 
                                           item.getItemType(),
                                           item.getQuantity(), 
                                           item.getOptimalQuantity(),
                                           item.getValue());
                neededItems.add(neededItem);    //add it to the list
            }
        }
        
        return neededItems;
    }
    
    /**
     * Returns an arraylist of items that have the same type as itemType.
     * 
     * @param itemType item type to search for
     * @return arraylist of items of type itemType
     */
    public ArrayList<Item> getItemsOfType(String itemType){
        ArrayList<Item> itemsOfType = new ArrayList<>();
        
        Iterator it = (Iterator) itemList.iterator();
        Item item;
        
        while(it.hasNext()){    //iterate through the list to find the items
            item = (Item) it.next();
            if(item.getItemType().equals(itemType)){
                Item neededItem = new Item(item.getItemName(), 
                                           item.getItemType(),
                                           item.getQuantity(), 
                                           item.getOptimalQuantity(),
                                           item.getValue());
                itemsOfType.add(neededItem);    //add it to the list
            }
        }
        
        return itemsOfType;
    }
}