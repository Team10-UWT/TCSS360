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
 * class. This class also contains an arraylist of CarePackages which can 
 * likewise have it's individual elements modified.
 * 
 * @author Sandeep Heera
 */
public class Inventory implements java.io.Serializable{
    public static final double NEED_RATIO = 0.5;
    
    private ArrayList<Item> itemList;
    private ArrayList<CarePackage> packageList;
    
    /**
     * Default constructor.
     * 
     * @param itemList arraylist of items in inventory
     * @param packageList arraylist of CarePackages in inventory
     */
    public Inventory(ArrayList<Item> itemList, 
                     ArrayList<CarePackage> packageList){
        this.itemList = new ArrayList<>();
        this.itemList = itemList;
        this.packageList = new ArrayList<>();
        this.packageList = packageList;
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
     * @return the item that has the name as itemName or null otherwise
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
     * 
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
     * Also traverses through the package list and deletes the item if it 
     * exists in any of the packages.
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
                    
                    if(!this.packageList.isEmpty()){
                        Iterator packIt =(Iterator) packageList.iterator();
                        CarePackage carePackage;

                        //traverse through the package list
                        while(packIt.hasNext()){
                            carePackage = (CarePackage) packIt.next();
                            if(carePackage.itemExists(itemName)){
                                carePackage.deleteItem(itemName);
                            }
                        }
                    }
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
            updatePackages(itemName, getItem(newName));
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
            updatePackages(itemName, getItem(itemName));
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
            updatePackages(itemName, getItem(itemName));
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
    
    /**
     * Iterates through the package list to determine if a care package
     * with the name packageName exists. Returns true if found or false 
     * otherwise.
     * 
     * @param packageName name of care package to search for
     * @return true if the care package exists or false otherwise
     */
    public boolean packageExists(String packageName){
        Iterator it = (Iterator) packageList.iterator();
        CarePackage carePackage;
        
        while(it.hasNext()){    //iterate through the package list
            carePackage = (CarePackage) it.next();
            if(carePackage.getPackageName().equals(packageName)){
                return true;
            }
        }
        return false;
    }
    
    /**
     * Returns the CarePackage in inventory with the name packageName.
     * 
     * @param packageName name of the package
     * @return CarePackage with name packageName or null otherwise
     */
    public CarePackage getPackage(String packageName){
        Iterator it = (Iterator) packageList.iterator();
        CarePackage carePackage;
        
        while(it.hasNext()){    //iterate through the package list
            carePackage = (CarePackage) it.next();
            if(carePackage.getPackageName().equals(packageName)){
                return carePackage;
            }
        }
        return null;
    }
    
    /**
     * Returns the quantity of a package with the name packageName provided 
     * it exists in the package list.
     * 
     * @param packageName name of the package to search for
     * @return quantity of the package if it exists or -1 otherwise
     */
    public int getPackageQuantity(String packageName){
        if(packageExists(packageName)){
            return getPackage(packageName).getQuantity();
        }
        return -1;
    }
    
    /**
     * Iterates through the packages list and determines if the item with the
     * name itemName is present in any of the packages. Updates the name, 
     * type, and value. This should be called any time the name, type or value
     * of an item has changed.
     * 
     * @param itemName name of the item to update
     * @param updatedItem updated item
     */
    public void updatePackages(String itemName, Item updatedItem){
        if(!this.packageList.isEmpty()){
            Iterator it =(Iterator) packageList.iterator();
            CarePackage carePackage;
            
            while(it.hasNext()){    //traverse through the package list
                carePackage = (CarePackage) it.next();
                if(carePackage.itemExists(itemName)){   //update the item
                    carePackage.updateItemType(itemName, 
                                updatedItem.getItemType());
                    carePackage.updateItemValue(itemName,
                                updatedItem.getValue());
                    carePackage.updateItemName(itemName, 
                                updatedItem.getItemName());
                }
            }
        }
    }
}