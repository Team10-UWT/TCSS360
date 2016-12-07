/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author David
 */
public class Me2Umodel {
/**
 * @param args the command line arguments
*/
    public static Inventory myInventory;
    //changed to public static for listener testing in register
    public static UserList myUserList;
    
    public Me2Umodel() {
        
        myInventory = new Inventory();
        myInventory.deserializeInventory();
        myUserList = new UserList();
        myUserList.deserializeUserList();
        myUserList.listUsers();
        System.out.println(myInventory.toString());
        myUserList.serializeUserList();
        myInventory.serializeInventory();
        
        //userlist and inventory seeds in case of deletion
//        myUserList.addUser(new User("davidf94", "David Foster", "pw", 0, 0));
//        myUserList.addUser(new User("Chase69", "Chase", "pw123", 0, 1));
//        myInventory.addItem("Baby Formula", "food", 100, 50, 10);
//        myInventory.addItem("Diapers", "clothing", 27, 30, 3);
//        myInventory.addItem("Gloves", "clothing", 20, 5, 2);
//        myInventory.addItem("Wool Hat", "clothing", 1000, 200, 3);
//        myInventory.addItem("Wool Socks", "clothing", 2, 100, 1);
//        myInventory.addItem("Rice", "food", 200, 1000, 1);
//        myInventory.addItem("Canned Fruit", "food", 300, 300, 2);
//        myInventory.addItem("Dried Beans", "food", 50, 40, 2);
//        myInventory.addItem("Hand Sanitizer", "hygiene", 25, 40, 3);
//        myInventory.addItem("Disinfectant Wipes", "hygiene", 200, 350, 2);
//        myInventory.addItem("Shampoo", "hygiene", 300, 20, 2);
//        myInventory.addItem("Bar Soap", "hygiene", 20, 50, 2);
//        myInventory.addItem("Bread", "food", 400, 500, 1);
//        myInventory.addItem("Toothbrush", "hygiene", 30, 70, 2);
//        myInventory.addItem("Toothpaste", "hygiene", 500, 70, 2);
//        myInventory.addItem("Deodorant", "hygiene", 34, 2, 1);
//        myInventory.addItem("Neosporin", "first aid", 400, 300, 3);
//        myInventory.addItem("Dried Milk", "food", 30, 40, 2);
//        myInventory.addItem("Hydrogen Peroxide", "first aid", 3, 50, 3);
//        myInventory.addItem("Gauze", "first aid", 401, 9001, 2);
//        myInventory.addItem("Band-Aid", "first aid", 300, 700, 2);
//        myInventory.addItem("Canned Soup", "food", 300, 500, 2);
//        myInventory.addItem("Flu Vaccine", "first aid", 20, 100, 10);
//        ArrayList pack1 = new ArrayList<Item>();
//        pack1.add(new Item("Baby Food", "food", 20, 20, 0));
//        pack1.add(new Item("Diapers", "clothing", 20, 20, 0));
//        pack1.add(new Item("Baby Formula", "food", 5, 5, 0));
//        pack1.add(new Item("Disinfectant Wipes", "hygiene", 50, 50, 0));
//        pack1.add(new Item("Hand Sanitizer", "hygiene", 3, 3, 0));
//        myInventory.addPackage(new CarePackage("New Baby", pack1));
//        ArrayList pack2 = new ArrayList<Item>();
//        pack2.add(new Item("Rice", "food", 50, 50, 0));
//        pack2.add(new Item("Bread", "food", 10, 10, 0));
//        pack2.add(new Item("Dried Milk", "food", 10, 10, 0));
//        pack2.add(new Item("Canned Fruit", "food", 15, 15, 0));
//        myInventory.addPackage(new CarePackage("Food Essentials", pack2));
//        ArrayList pack3 = new ArrayList<Item>();
//        pack3.add(new Item("Wool Hat", "clothing", 1, 1, 0));
//        pack3.add(new Item("Wool Socks", "clothing", 1, 1, 0));
//        pack3.add(new Item("Jacket", "clothing", 1, 1, 0));
//        pack3.add(new Item("Flu Vaccine", "first aid", 1, 1, 0));
//        myInventory.addPackage(new CarePackage("Cold Weather", pack3));
//        ArrayList pack4 = new ArrayList<Item>();
//        pack4.add(new Item("Toothbrush", "hygiene", 1, 1, 0));
//        pack4.add(new Item("Toothpaste", "hygiene", 1, 1, 0));
//        pack4.add(new Item("Shampoo", "hygiene", 1, 1, 0));
//        pack4.add(new Item("Bar Soap", "hygiene", 1, 1, 0));
//        pack4.add(new Item("Deodorant", "hygiene", 1, 1, 0));
//        myInventory.addPackage(new CarePackage("Basic Hygiene", pack4));
          
    }
}
