package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Model.*;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import model.Me2Umodel;

public class AdminHomePage extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField categoryTextField;
	private JTextField itemNameTextField;
	private JTextField qtyTextField;
	private JTextField optimalTextField;
	private DefaultTableModel model;
	private Inventory inventory;
	private JTextField valueTextField;
	private JLabel valueLabel;

	/**
	 * Create the frame.
	 */

	public AdminHomePage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);               
		this.inventory = Me2Umodel.myInventory;
		setBounds(100, 100, 600, 553);
		setVisible(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		 
		
		createFunctionalityButtons(contentPane);
		createSubFunctionalityButtons(contentPane);
		setUpTable(contentPane);
		setUpItemLabelField(contentPane);
		

		
		valueTextField = new JTextField();
		valueTextField.setBounds(101, 444, 130, 26);
		contentPane.add(valueTextField);
		valueTextField.setColumns(10);
	}

	/**
	 * this method set up the labels and text fields
	 *  for category, item name, quantity, optimal quantity
	 * @param contentPane
	 */
	private void setUpItemLabelField(JPanel contentPane) {
		//category label
		JLabel categoryLabel = new JLabel("Category");
		categoryLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		categoryLabel.setBounds(6, 322, 84, 16);
		contentPane.add(categoryLabel);
		
		//item name label
		JLabel itemNameLabel = new JLabel("Item Name");
		itemNameLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		itemNameLabel.setBounds(6, 355, 84, 16);
		contentPane.add(itemNameLabel);
		
		//quantity label
		JLabel quantityLabel = new JLabel("Quantity");
		quantityLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		quantityLabel.setBounds(5, 388, 85, 16);
		contentPane.add(quantityLabel);
		
		//optimal quantity label
		JLabel optimalQtyLabel = new JLabel("Optimlal Qty");
		optimalQtyLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		optimalQtyLabel.setBounds(5, 421, 84, 16);
		contentPane.add(optimalQtyLabel);
		
		//category text field
		categoryTextField = new JTextField();
		categoryTextField.setBounds(102, 317, 130, 26);
		contentPane.add(categoryTextField);
		categoryTextField.setColumns(10);
		
		//item name text field
		itemNameTextField = new JTextField();
		itemNameTextField.setBounds(102, 350, 130, 26);
		contentPane.add(itemNameTextField);
		itemNameTextField.setColumns(10);
		
		//quantity text field
		qtyTextField = new JTextField();
		qtyTextField.setBounds(102, 383, 130, 26);
		contentPane.add(qtyTextField);
		qtyTextField.setColumns(10);
		
		//optimal quantity text field
		optimalTextField = new JTextField();
		optimalTextField.setBounds(101, 416, 130, 26);
		contentPane.add(optimalTextField);
		optimalTextField.setColumns(10);
		
		valueLabel = new JLabel("Value");
		valueLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		valueLabel.setBounds(29, 449, 61, 16);
		contentPane.add(valueLabel);
	}
	
/**
 * Set up the JTable with the item data loaded initially
 * and set up the scroll pane surround the JTable
 * @param contentPane - a JPanel for the view
 */
	private void setUpTable(JPanel contentPane){
		String[] columns = {"Category", "Item Name", "Quantity", "Optimal Quantity", "Value"};

		
		//create a scroll pane surround the JTable
		//the table is inside the scroll pane
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(5, 41, 580, 269);
		contentPane.add(scrollPane);
		
		//create the JTable with given data and column information
		

		
		model = new DefaultTableModel(getItemListArray(), columns);
		table = new JTable(model);
		
		scrollPane.setViewportView(table);
	}
 
/**
 * create a list of buttons which is irrelevant to the data
 * the buttons are [back] [refresh] [log out]
 * @param contentPane - a JPanel of the view
 */
	private void createSubFunctionalityButtons(JPanel contentPane) {
		//refresh button
		JButton refreshButton = new JButton("Refresh");
		refreshButton.addActionListener(new loadItems());
		refreshButton.setBounds(491, 6, 94, 35);
		contentPane.add(refreshButton);
		refreshButton.addActionListener(new loadItems());
		
		//back button
		JButton backButton = new JButton("<Back");
		backButton.setBounds(0, 0, 75, 29);
		contentPane.add(backButton);
		backButton.addActionListener(new backward());
		
		//log out button
		JButton logOutButton = new JButton("Log Out");
		logOutButton.setBounds(491, 479, 94, 46);
		contentPane.add(logOutButton);
		logOutButton.addActionListener(new logOutAccount());
	}
	
/**
 * Create a list of functional button to support admin's manipulate item data
 * the list of buttons are [search] [Clear] [Add] [Update] [Delete]
 * @param contentPane - a JPanel of the View
 */
	private void createFunctionalityButtons(JPanel contentPane) {
		
		//clear button
		JButton clearButton = new JButton("Clear");
		clearButton.setBounds(244, 317, 117, 29);
		contentPane.add(clearButton);
		clearButton.addActionListener(new clearItemTextField());
		
		//add button
		JButton addButton = new JButton("Add");
		addButton.setBounds(244, 350, 117, 29);
		contentPane.add(addButton);
		addButton.addActionListener(new addItem());
		
		//update button
		JButton updateButton = new JButton("Update");
		updateButton.setBounds(244, 383, 117, 29);
		contentPane.add(updateButton);
		updateButton.addActionListener(new updateItem());
		
		//delete button
		JButton deleteButton = new JButton("Delete");
		deleteButton.setBounds(243, 416, 117, 29);
		contentPane.add(deleteButton);
		deleteButton.addActionListener(new deleteItem());
	}
	
	private void emptyTextField() {
		categoryTextField.setText("");
		itemNameTextField.setText("");
		qtyTextField.setText("");
		optimalTextField.setText("");
		valueTextField.setText("");
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
	 * This is the action listener to clear the all the text field to empty string
	 */
	private class clearItemTextField implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			emptyTextField();
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
			String category = categoryTextField.getText();
			String itemName = itemNameTextField.getText();
			String quantity = qtyTextField.getText();
			String optimalQty = optimalTextField.getText();
			String value = valueTextField.getText();
			
			if(category.isEmpty() || itemName.isEmpty() || quantity.isEmpty() || optimalQty.isEmpty() || value.isEmpty()){	
				JOptionPane.showMessageDialog(contentPane, "Please fill in all blank text fields!", "Inane error", JOptionPane.ERROR_MESSAGE);
			} else {
				//The tableModel is behind the JTable handles all of the data behind the table
				//In order to add and remove row from a table, you need to use a DefaulTableModel
				
				inventory.addItem(category, itemName, Integer.parseInt(quantity), Integer.parseInt(optimalQty), Integer.parseInt(value));
				
				String[] row = {category, itemName, quantity, optimalQty, value};
				model.addRow(row);
				JOptionPane.showMessageDialog(contentPane, "Add Item Successfully!");
				inventory.serializeInventory();
				emptyTextField();
			}
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
			String category = categoryTextField.getText();
			String itemName = itemNameTextField.getText();
			String quantity = qtyTextField.getText();
			String optimalQty = optimalTextField.getText();
			String value = valueTextField.getText();
			
			if(table.getSelectedRow() == -1) {
				JOptionPane.showMessageDialog(contentPane, "Please select an item to update", "Inane error", JOptionPane.ERROR_MESSAGE);
			}else if(category.isEmpty() || itemName.isEmpty() || quantity.isEmpty() || optimalQty.isEmpty()){
				JOptionPane.showMessageDialog(contentPane, "Please fill all blank text fields", "Inane error", JOptionPane.ERROR_MESSAGE);
			}else {
				model.setValueAt(category, table.getSelectedRow(), 0);
				model.setValueAt(itemName, table.getSelectedRow(), 1);
				model.setValueAt(quantity, table.getSelectedRow(), 2);
				model.setValueAt(optimalQty, table.getSelectedRow(), 3);
				int i = table.getSelectedRow();
				inventory.getItemList().get(i).setItemType(category);
				inventory.getItemList().get(i).setItemName(itemName);
				inventory.getItemList().get(i).setQuantity(Integer.parseInt(quantity));
				inventory.getItemList().get(i).setOptimalQuantity(Integer.parseInt(optimalQty));
				inventory.getItemList().get(i).setValue(Integer.parseInt(value));
				inventory.serializeInventory();
				JOptionPane.showMessageDialog(contentPane, "Update item Successfully!");
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
			int i = table.getSelectedRow();
			System.out.println("Table row = " + i);
			
			if(i == -1) {
				JOptionPane.showMessageDialog(contentPane, "Please select an item to delete", "Inane error", JOptionPane.ERROR_MESSAGE);
			}else {
				model.removeRow(i);
				inventory.deleteItem(inventory.getItemList().get(i).getItemName());
				inventory.serializeInventory();
				JOptionPane.showMessageDialog(contentPane, "Delete item Successfully!");
			}
		}
		
	}
	
	/**
	 * This is the action listener when admin wants to refresh to the latest item data
	 * @author Jayden Tan
	 *
	 */
	private class loadItems implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			table.setModel(model);
			repaint();
		}
		
	}
	
	/**
	 * This is the action listener for go back to the main page view
	 * @author Jayden Tan
	 *
	 */
	private class backward implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
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
			// TODO Auto-generated method stub
			
		}
		
	}
}