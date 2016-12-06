package gui;
import java.awt.EventQueue;

import Model.Inventory;

/**
 * @author Ziliang Wang
 * @version Fall 2016
 */
public final class Me2UguiMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Inventory inventory = new Inventory();
		inventory.deserializeInventory();
		System.out.println(inventory);
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Me2Ugui me2u = new Me2Ugui();
            }
        });
	}

}
