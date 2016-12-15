package controller;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import model.*;
import view.*;

public class AdminController {
	
	private Inventory inventory;
        private UserList myUserList;
	private AdminHomePage admin;
	private DefaultTableModel model;
        private User myUser;
	
	public AdminController(Inventory theInventory, UserList theUserList, User theUser){
		inventory = theInventory;
                myUserList = theUserList;
                myUser = theUser;
		admin =  new AdminHomePage();
		initialLoadItem();
		addListeners();
	}
	
	private void initialLoadItem(){
		String[] columns = {"Category", "Item Name", "Quantity", "Optimal Quantity", "Value"};
		model = new DefaultTableModel(getItemListArray(), columns);
		admin.getTable().setModel(model);
	}
	
	private void addListeners(){
		admin.getTable().getSelectionModel().addListSelectionListener(new rowSelectListener());
		admin.getClearButton().addActionListener(new clearItemTextField());
		admin.getLogOutButton().addActionListener(new logOutAccount());
		admin.getAddButton().addActionListener(new addItem());
		admin.getUpdateButton().addActionListener(new updateItem());
		admin.getDeleteButton().addActionListener(new deleteItem());
		admin.getBackButton().addActionListener(new backward());
                
                admin.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                        inventory.serializeInventory();
                        myUserList.serializeUserList();
                        System.exit(0);
                    }
                });
	}
	
	
	private Object[][] getItemListArray(){
		Object[][] datas = new Object[inventory.getItemList().size()][5];
		for(int i = 0; i< inventory.getItemList().size(); i++) {
			datas[i][0] = inventory.getItemList().get(i).getItemType();
			datas[i][1] = inventory.getItemList().get(i).getItemName();
			datas[i][2] = inventory.getItemList().get(i).getQuantity();
			datas[i][3] = inventory.getItemList().get(i).getOptimalQuantity();
			datas[i][4] = inventory.getItemList().get(i).getValue();
		}
		return datas;
	}
	
	
	/**
	 * This is the action listener for go back to the main page view
	 * @author Jayden Tan
	 *
	 */
	private class backward implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			admin.dispose();
			Me2UController controller = new Me2UController(inventory, myUserList, myUser);
		}
		
	}	
	
	/**
	 * This is the action listener for update an item's information in the inventory
	 * @author Jayden Tan
	 *
	 */
	private class updateItem implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String category = admin.getCategoryTextField().getText();
			String itemName = admin.getItemNameTextField().getText();
			String quantity = admin.getQtyTextField().getText();
			String optimalQty = admin.getOptimalTextField().getText();
			String value = admin.getValueTextField().getText();
			
			if(admin.getTable().getSelectedRow() == -1) {
				JOptionPane.showMessageDialog(admin.getContentPane(), "Please select an item to update", "Inane error", JOptionPane.ERROR_MESSAGE);
			}else if(category.isEmpty() || itemName.isEmpty() || quantity.isEmpty() || optimalQty.isEmpty()){
				JOptionPane.showMessageDialog(admin.getContentPane(), "Please fill all blank text fields", "Inane error", JOptionPane.ERROR_MESSAGE);
			}else {
				int i = admin.getTable().getSelectedRow();
				model.setValueAt(category, i, 0);
				model.setValueAt(itemName, i, 1);
				model.setValueAt(quantity, i, 2);
				model.setValueAt(optimalQty, i, 3);
				
				inventory.getItemList().get(i).setItemType(category);
				inventory.getItemList().get(i).setItemName(itemName);
				inventory.getItemList().get(i).setQuantity(Integer.parseInt(quantity));
				inventory.getItemList().get(i).setOptimalQuantity(Integer.parseInt(optimalQty));
				inventory.getItemList().get(i).setValue(Integer.parseInt(value));
				inventory.serializeInventory();
				JOptionPane.showMessageDialog(admin.getContentPane(), "Update item Successfully!");
			}		
		}
		
	}
	
	/**
	 * This is the action listener for delete an item in the inventory
	 * @author Jayden Tan
	 *
	 */
	private class deleteItem implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			int i = admin.getTable().getSelectedRow();
			System.out.println("Table row = " + i);
			
			if(i == -1) {
				JOptionPane.showMessageDialog(admin.getContentPane(), "Please select an item to delete", "Inane error", JOptionPane.ERROR_MESSAGE);
			}else {
				model.removeRow(i);
				inventory.deleteItem(inventory.getItemList().get(i).getItemName());
				inventory.serializeInventory();
				JOptionPane.showMessageDialog(admin.getContentPane(), "Delete item Successfully!");
			}
		}
		
	}
	
	
	
	/**
	 * This is the action listener for add an item in the inventory
	 * @author Jayden Tan
	 *
	 */
	private class addItem implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String category = admin.getCategoryTextField().getText();
			String itemName = admin.getItemNameTextField().getText();
			String quantity = admin.getQtyTextField().getText();
			String optimalQty = admin.getOptimalTextField().getText();
			String value = admin.getValueTextField().getText();
			
			if(category.isEmpty() || itemName.isEmpty() || quantity.isEmpty() || optimalQty.isEmpty() || value.isEmpty()){	
				JOptionPane.showMessageDialog(admin.getContentPane(), "Please fill in all blank text fields!", "Inane error", JOptionPane.ERROR_MESSAGE);
			} else {
				//The tableModel is behind the JTable handles all of the data behind the table
				//In order to add and remove row from a table, you need to use a DefaulTableModel
				
				inventory.addItem(category, itemName, Integer.parseInt(quantity), Integer.parseInt(optimalQty), Integer.parseInt(value));
				
				String[] row = {category, itemName, quantity, optimalQty, value};
				model.addRow(row);
				JOptionPane.showMessageDialog(admin.getContentPane(), "Add Item Successfully!");
				inventory.serializeInventory();
				admin.emptyTextField();
			}
		}
		
	}
	
	/**
	 * This is the action listener for log out as the admin
	 * It will return back to the log in page view
	 * @author Jayden Tan
	 *
	 */
	private class logOutAccount implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			admin.dispose();
                        LoginController controller = new LoginController(inventory, myUserList);
			
		}
		
	}
	
	/**
	 * This is the action listener to clear the all the text field to empty string
	 */
	private class clearItemTextField implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			admin.emptyTextField();
		}
		
	}
	
	private class rowSelectListener implements ListSelectionListener {
		@Override
		
		public void valueChanged(ListSelectionEvent e) {
			int i = admin.getTable().getSelectedRow();
			if(i > -1) {
				admin.getCategoryTextField().setText(admin.getTable().getValueAt(i, 0).toString());
				admin.getItemNameTextField().setText(admin.getTable().getValueAt(i, 1).toString());
				admin.getQtyTextField().setText(admin.getTable().getValueAt(i, 2).toString());
				admin.getOptimalTextField().setText(admin.getTable().getValueAt(i, 3).toString());
				admin.getValueTextField().setText(admin.getTable().getValueAt(i, 4).toString());
			}
			
		}
	}
}