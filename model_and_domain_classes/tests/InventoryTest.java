/**
 * Sandeep Heera
 * InventoryTest.java
 * J-Unit tests for the Inventory class.
 */
import java.io.File;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * J-Unit tests for the Inventory class.
 * 
 * @author Sandeep Heera
 */
public class InventoryTest {
    Inventory instance;
    ArrayList<Item> items;
    ArrayList<CarePackage> packList;
    
    public InventoryTest() {
        items = new ArrayList<>();
        Item jacket = new Item("Jacket", "Clothing", 2, 5, 40);
        Item shoes = new Item("Jordans", "Shoes", 1, 3, 75);
        Item oj = new Item("Orange Juice", "Food", 15, 50, 5);
        Item cannedFruit = new Item("Canned Pineapple", "Food", 3, 6, 3);
        Item sofa = new Item("Sofa", "Furniture", 1, 1, 100);
        
        items.add(jacket);
        items.add(shoes);
        items.add(oj);
        items.add(cannedFruit);
        items.add(sofa);
        
        packList = new ArrayList<>();
        ArrayList<Item> packItemList = new ArrayList<>();
        
        CarePackage cPack = new CarePackage("Care 1", packItemList);
        cPack.addItem(cannedFruit.getItemName(), cannedFruit.getItemType(),
                      3, cannedFruit.getValue(), items);
        packList.add(cPack);
        
        instance = new Inventory(items, packList);
    }

    /**
     * Test of itemExists method, of class Inventory.
     */
    @Test
    public void testItemExistsTrue() {
        System.out.println("itemExists");
        String itemName = "Sofa";
        boolean expResult = true;
        boolean result = instance.itemExists(itemName);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of itemExists method, of class Inventory.
     */
    @Test
    public void testItemExistsFalse() {
        System.out.println("itemExists");
        String itemName = "Not in inventory";
        boolean expResult = false;
        boolean result = instance.itemExists(itemName);
        assertEquals(expResult, result);
    }

    /**
     * Test of getItem method, of class Inventory.
     */
    @Test
    public void testGetItem() {
        System.out.println("getItem");
        String itemName = "Jordans that aren't here";
        Item expResult = null;
        Item result = instance.getItem(itemName);
        assertEquals(expResult, result);
    }

    /**
     * Test of getQuantity method, of class Inventory.
     */
    @Test
    public void testGetQuantity() {
        System.out.println("getQuantity");
        String itemName = "Canned Pineapple";
        int expResult = 3;
        int result = instance.getQuantity(itemName);
        assertEquals(expResult, result);
    }

    /**
     * Test of addItem method, of class Inventory.
     */
    @Test
    public void testAddItem() {
        System.out.println("addItem");
        String itemName = "Beanie";
        String itemType = "Clothing";
        int quantity = 1;
        int optimalQuantity = 100;
        int itemValue = 10;
        instance.addItem(itemName, itemType, quantity, optimalQuantity, 
                         itemValue);
        boolean test = instance.itemExists(itemName);
        assertEquals(true, test);
    }

    /**
     * Test of deleteItem method, of class Inventory.
     */
    @Test
    public void testDeleteItem() {
        System.out.println("deleteItem");
        String itemName = "Sofa";
        instance.deleteItem(itemName);
        boolean test = instance.itemExists(itemName);
        assertEquals(false, test);
    }

    /**
     * Test of updateItemName method, of class Inventory.
     */
    @Test
    public void testUpdateItemName() {
        System.out.println("updateItemName");
        String itemName = "Jordans";
        String newName = "Jordan Classics";
        instance.updateItemName(itemName, newName);
        boolean testOne = instance.itemExists(itemName);
        assertEquals(testOne, false);
        boolean testTwo = instance.itemExists(newName);
        assertEquals(true, testTwo);
    }

    /**
     * Test of updateItemType method, of class Inventory.
     */
    @Test
    public void testUpdateItemType() {
        System.out.println("updateItemType");
        String itemName = "Jacket";
        String newType = "Outdoor clothing";
        instance.updateItemType(itemName, newType);
        String type = instance.getItem(itemName).getItemType();
        assertEquals(newType, instance.getItem(itemName).getItemType());
    }

    /**
     * Test of updateItemQuantity method, of class Inventory.
     */
    @Test
    public void testUpdateItemQuantity() {
        System.out.println("updateItemQuantity");
        String itemName = "Orange Juice";
        int newQuantity = 45;
        instance.updateItemQuantity(itemName, newQuantity);
        assertEquals(newQuantity, instance.getItem(itemName).getQuantity());
    }

    /**
     * Test of updateItemOptimalQuantity method, of class Inventory.
     */
    @Test
    public void testUpdateItemOptimalQuantity() {
        System.out.println("updateItemOptimalQuantity");
        String itemName = "Orange Juice";
        int newOptimalQuantity = 5;
        instance.updateItemOptimalQuantity(itemName, newOptimalQuantity);
        assertEquals(newOptimalQuantity, 
                     instance.getItem(itemName).getOptimalQuantity());
    }

    /**
     * Test of updateItemValue method, of class Inventory.
     */
    @Test
    public void testUpdateItemValue() {
        System.out.println("updateItemValue");
        String itemName = "Sofa";
        int newValue = 10;
        instance.updateItemValue(itemName, newValue);
        assertEquals(newValue, instance.getItem(itemName).getValue());
    }

    /**
     * Test of getNeeded method, of class Inventory.
     */
    @Test
    public void testGetNeeded() {
        
        System.out.println("getNeeded");
        ArrayList<Item> items = new ArrayList<>();
        Item jacket = new Item("Jacket", "Clothing", 2, 5, 40);
        Item shoes = new Item("Jordans", "Shoes", 1, 3, 75);
        Item oj = new Item("Orange Juice", "Food", 15, 50, 5);
        Item cannedFruit = new Item("Canned Pineapple", "Food", 4, 6, 3);
        Item sofa = new Item("Sofa", "Furniture", 1, 1, 100);
        
        items.add(jacket);
        items.add(shoes);
        items.add(oj);
        items.add(cannedFruit);
        items.add(sofa);
       
        instance = new Inventory(items, null);
        
        Item jacket1 = new Item("Jacket", "Clothing", 2, 5, 40);
        Item shoes1 = new Item("Jordans", "Shoes", 1, 3, 75);
        Item oj1 = new Item("Orange Juice", "Food", 15, 50, 5);
        
        ArrayList<Item> result = instance.getNeeded();
        boolean test = result.contains(jacket1) && result.contains(shoes1) &&
                       result.contains(oj1);
        assertEquals(true, test);
    }

    /**
     * Test of getItemsOfType method, of class Inventory.
     */
    @Test
    public void testGetItemsOfType() {
        System.out.println("getItemsOfType");
        ArrayList<Item> items = new ArrayList<Item>();
        Item jacket = new Item("Jacket", "Clothing", 2, 5, 40);
        Item shoes = new Item("Jordans", "Shoes", 1, 3, 75);
        Item oj = new Item("Orange Juice", "Food", 15, 50, 5);
        Item cannedFruit = new Item("Canned Pineapple", "Food", 4, 6, 3);
        Item sofa = new Item("Sofa", "Furniture", 1, 1, 100);
        
        items.add(jacket);
        items.add(shoes);
        items.add(oj);
        items.add(cannedFruit);
        items.add(sofa);
       
        instance = new Inventory(items, null);
        
        Item oj1 = new Item("Orange Juice", "Food", 15, 50, 5);
        Item cannedFruit1 = new Item("Canned Pineapple", "Food", 4, 6, 3);
        String itemType = "Food";
        
        ArrayList<Item> result = instance.getItemsOfType(itemType);
        boolean test = result.contains(oj1) && result.contains(cannedFruit1);
        assertEquals(true, test);
    }

    /**
     * Test of packageExists method, of class Inventory.
     */
    @Test
    public void testPackageExists() {
        System.out.println("packageExists");
        String packageName = "Care 1";
        boolean expResult = true;
        boolean result = instance.packageExists(packageName);
        assertEquals(expResult, result);
    }

    /**
     * Test of getPackage method, of class Inventory.
     */
    @Test
    public void testGetPackage() {
        System.out.println("getPackage");
        String packageName = "Care 1";
        CarePackage expResult = packList.get(0);
        CarePackage result = instance.getPackage(packageName);
        assertEquals(expResult, result);
    }

    /**
     * Test of getPackageQuantity method, of class Inventory.
     */
    @Test
    public void testGetPackageQuantity() {
        System.out.println("getPackageQuantity");
        String packageName = "Care 1";
        int expResult = 3;
        instance.updateItemQuantity("Canned Pineapple", 9);
        int result = instance.getPackageQuantity(packageName);
        assertEquals(expResult, result);
    }

    /**
     * Test of updatePackages method, of class Inventory.
     */
    @Test
    public void testUpdatePackages() {
        System.out.println("updatePackages");
        instance.updateItemName("Canned Pineapple", "Gourmet Pineapple");
        String itemName = "Canned Pineapple";
        Item updatedItem = instance.getItem("Gourmet Pineapple");
        instance.updatePackages(itemName, updatedItem);
        assertEquals(true, 
        instance.getPackage("Care 1").itemExists("Gourmet Pineapple"));
    }

    /**
     * Test of addPackage method, of class Inventory.
     */
    @Test
    public void testAddPackage() {
        System.out.println("addPackage");
        CarePackage carePackage = new CarePackage("Care 2", items);
        instance.addPackage(carePackage);
        assertEquals(true, 
                     instance.packageExists(carePackage.getPackageName()));
    }

    /**
     * Test of getPackageList method, of class Inventory.
     */
    @Test
    public void testGetPackageList() {
        System.out.println("getPackageList");
        ArrayList<CarePackage> expResult = packList;
        ArrayList<CarePackage> result = instance.getPackageList();
        assertEquals(expResult, result);
    }

    /**
     * Test of deletePackage method, of class Inventory.
     */
    @Test
    public void testDeletePackage() {
        System.out.println("deletePackage");
        String packageName = packList.get(0).getPackageName();
        CarePackage pack = packList.get(0);
        instance.deletePackage(packageName);
        boolean expResult = false;
        assertEquals(expResult, instance.packageExists(packageName));
        instance.addPackage(pack);
    }

    /**
     * Test of serializeInventory method, of class Inventory.
     */
    @Test
    public void testSerializeInventory() {
        System.out.println("serializeInventory");
        instance.serializeInventory();
        boolean expResult = true;
        File f = new File("items");
        assertEquals(expResult, f.exists());
    }

    /**
     * Test of deserializeInventory method, of class Inventory.
     */
    @Test
    public void testDeserializeInventory() {
        System.out.println("deserializeInventory");
        instance = null;
        ArrayList<Item> itemsList = new ArrayList<>();
        ArrayList<CarePackage> packages = new ArrayList<>();
        instance = new Inventory(itemsList, packages);
        instance.deserializeInventory();
        boolean expResult = true;
        assertEquals(expResult, instance.getItemList().equals(items) && 
                     instance.getPackageList().equals(packList));
    }

    /**
     * Test of getItemList method, of class Inventory.
     */
    @Test
    public void testGetItemList() {
        System.out.println("getItemList");
        ArrayList<Item> expResult = items;
        ArrayList<Item> result = instance.getItemList();
        assertEquals(expResult, result);
    }
}
