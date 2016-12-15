/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.hasItems;
import org.hamcrest.Matcher;
import org.hamcrest.core.CombinableMatcher;

/**
 *
 * @author Ryan Glaser
 * JUnit test for Cart 
 */
public class CartTest {
    Cart myCart;
    ArrayList<Item> itemList;
    
    Inventory inventory;
    CarePackage carePack;
    
    public CartTest() {
        Item chickenNoodleSoup = new Item("Campbell's Chicken Noodle Soup", "Food", 2, 5, 4);
        Item toothBrush = new Item("Tooth Brush", "Medical", 2, 50, 2);
        
        Item cellPhone = new Item("Cell Phone", "Other", 2, 10, 15);
        
        
        myCart = new Cart();
        myCart.addItem(chickenNoodleSoup);
        myCart.addItem(toothBrush);
        
        myCart.addItem(cellPhone);
        itemList = new ArrayList<>();
        
        itemList.add(new Item("Campbell's Tomato Soup", "Food", 10, 0, 4));
        itemList.add(new Item("Band-Aids", "Medical", 10, 0, 2));
        itemList.add(new Item("Beef Jerky", "Food", 10, 0, 1));
        itemList.add(new Item("Flash Light", "Other", 1, 0, 15));
        
        carePack = new CarePackage("One Week Survival", itemList);
        carePack.setQuantity(itemList);
        
        assertNotNull(myCart);
    }


    /**
     * Test of addItem method, of class Cart.
     */
    @Test
    public void testAddItem() {
        System.out.println("addItem");
        Item bread = new Item("Bread", "Food", 2, 40, 1);
       // Cart instance = new Cart();
        myCart.addItem(bread);
        
        assertEquals(bread.getItemName(), myCart.getItem("Bread").getItemName());
        assertEquals(true, myCart.itemExists("Bread"));
        assertEquals(2, myCart.getItem("Bread").getQuantity());
        myCart.addItem(bread);
        assertNotEquals(4, myCart.getItem("Bread").getQuantity());
    }

    /**
     * Test of addCarePackage method, of class Cart.
     */
    @Test
    public void testAddCarePackage() {
        System.out.println("addCarePackage");
        ArrayList<CarePackage> cPacks = new ArrayList<>();
        cPacks.add(carePack);
        myCart.addCarePackage(carePack);
        assertEquals(cPacks,myCart.getCarePackages());
        assertTrue(myCart.carePackageExists("One Week Survival"));
        assertEquals(1,myCart.getCarePackages().remove(0).getQuantity());
    }

    /**
     * Test of removeItem method, of class Cart.
     */
    @Test
    public void testRemoveItem() {
        System.out.println("removeItem");
        String item = "Cell Phone";
        myCart.removeItem(item);
        assertFalse(myCart.itemExists(item));
    }

    /**
     * Test of removeCarePackage method, of class Cart.
     */
    @Test
    public void testRemoveCarePackage() {
        System.out.println("removeCarePackage");
        String pack = carePack.getPackageName();
        myCart.addCarePackage(carePack);
        myCart.removeCarePackage(pack);
        assertFalse(myCart.carePackageExists(pack));
    }

    /**
     * Test of getItems method, of class Cart.
     */
    @Test
    public void testGetItems() {
        System.out.println("getItems");
        Item chickenNoodleSoup = new Item("Campbell's Chicken Noodle Soup", "Food", 2, 5, 4);
        Item toothBrush = new Item("Tooth Brush", "Medical", 2, 50, 2);
        Item cellPhone = new Item("Cell Phone", "Other", 2, 10, 15);
        ArrayList<Item> items = new ArrayList<>();
        items.add(chickenNoodleSoup);
        items.add(toothBrush);
        items.add(cellPhone);
        ArrayList<Item> result = myCart.getItems();
        assertEquals(items, result);
    }

    /**
     * Test of getCarePackages method, of class Cart.
     */
    @Test
    public void testGetCarePackages() {
        System.out.println("getCarePackages");
        ArrayList<CarePackage> exp =new ArrayList<>();
        exp.add(carePack);
        myCart.addCarePackage(carePack);
        ArrayList<CarePackage> result = myCart.getCarePackages();
        assertEquals(exp, result);
        
    }

    /**
     * Test of itemExists method, of class Cart.
     */
    @Test
    public void testItemExists() {
        System.out.println("itemExists");
        String itemName = "Tooth Brush";
       
        assertTrue(myCart.itemExists(itemName));
        assertFalse(myCart.itemExists("Candy"));
        
    }

    /**
     * Test of getItem method, of class Cart.
     */
    @Test
    public void testGetItem() {
        System.out.println("getItem");
        Item cellPhone = new Item("Cell Phone", "Other", 2, 10, 15);
        assertEquals(cellPhone, myCart.getItem("Cell Phone"));
        
    }

    /**
     * Test of carePackageExists method, of class Cart.
     */
    @Test
    public void testCarePackageExists() {
        System.out.println("carePackageExists");
        assertFalse(myCart.carePackageExists("One Week Survival"));
        myCart.addCarePackage(carePack);
        assertTrue(myCart.carePackageExists("One Week Survival"));
        
    }

    /**
     * Test of getCartValue method, of class Cart.
     */
    @Test
    public void testGetCartValue() {
        System.out.println("getCartValue");

        assertEquals(42, myCart.getCartValue());
        myCart.addItem(new Item("Bread", "Food", 2, 40, 1));
        assertEquals(44,myCart.getCartValue());
        
    }


    
}
