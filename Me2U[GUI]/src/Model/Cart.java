/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author David
 */
public class Cart {
    private ArrayList<Item> itemList;
    private ArrayList<CarePackage> carePackageList;
    
    public Cart() {
        itemList = new ArrayList<>();
        carePackageList = new ArrayList<>();
    }
    
    public Cart(Cart theCart) {
        this.itemList = theCart.getItems();
        this.carePackageList = theCart.getCarePackages();
    }
    
    public void checkout() {
        
    }
    
    public void addItem(Item theItem) {
        if (!itemExists(theItem.getItemName())){
            itemList.add(new Item(theItem.getItemName(), theItem.getItemType(), 
                    1, theItem.getOptimalQuantity(), theItem.getValue()));
        } else {
            Iterator it = (Iterator) this.itemList.iterator();
            Item item;
            while(it.hasNext()){    //iterate through the list
                item = (Item) it.next();
                if(item.getItemName().equals(theItem.getItemName())){
                    item.setQuantity(theItem.getQuantity()+1);
                }
            }
        }
    }
    
    public void addCarePackage(CarePackage thePackage){
        if (!carePackageExists(thePackage.getPackageName())) {
            carePackageList.add(new CarePackage(thePackage.getPackageName(), 
                    thePackage.getItemList()));
        }
    }
    
    public void removeItem(String theItem) {
        if (itemExists(theItem)){
            Iterator it = (Iterator) this.itemList.iterator();
            Item item;
            while(it.hasNext()) {
                item = (Item) it.next();
                if (item.getItemName().equals(theItem)){
                    it.remove();
                }
            }
        }
    }
    
    public void removeCarePackage(String thePackage) {
        if (carePackageExists(thePackage)) {
            Iterator it = (Iterator) this.carePackageList.iterator();
            CarePackage carePackage;
            while(it.hasNext()) {
                carePackage = (CarePackage) it.next();
                if (carePackage.getPackageName().equals(thePackage)) {
                    it.remove();
                }
            }
        }
    }
    
    public ArrayList<Item> getItems() {
        return this.itemList;
    }
    
    public ArrayList<CarePackage> getCarePackages() {
        return this.carePackageList;
    }
    
    private boolean itemExists(String itemName){
        Iterator it = (Iterator) this.itemList.iterator();
        
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
    
    public boolean carePackageExists(String packageName){
        Iterator it = (Iterator) this.carePackageList.iterator();
        CarePackage carePackage;
        
        while(it.hasNext()){    //iterate through the package list
            carePackage = (CarePackage) it.next();
            if(carePackage.getPackageName().equals(packageName)){
                return true;
            }
        }
        return false;
    }
}
