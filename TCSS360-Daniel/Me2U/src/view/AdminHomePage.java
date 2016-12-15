package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class AdminHomePage extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField categoryTextField;
	private JTextField itemNameTextField;
	private JTextField qtyTextField;
	private JTextField optimalTextField;
	private DefaultTableModel model;
	private JTextField valueTextField;
	private JLabel valueLabel;
	private JButton backButton;
	private JButton logOutButton;
	private JButton clearButton;
	private JButton addButton;
	private JButton updateButton;
	private JButton deleteButton;

	/**
	 * Create the frame.
	 */

	public AdminHomePage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		

		//create a scroll pane surround the JTable
		//the table is inside the scroll pane
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(5, 41, 580, 269);
		contentPane.add(scrollPane);
		
		//create the JTable with given data and column information
		model = new DefaultTableModel();
		table = new JTable(model);
		table.setDefaultEditor(Object.class, null);
		
		scrollPane.setViewportView(table);
	}
 
/**
 * create a list of buttons which is irrelevant to the data
 * the buttons are [back] [refresh] [log out]
 * @param contentPane - a JPanel of the view
 */
	private void createSubFunctionalityButtons(JPanel contentPane) {
		
		
		//back button
		backButton = new JButton("Home");
		backButton.setBounds(0, 0, 75, 29);
		contentPane.add(backButton);
		
		//log out button
		logOutButton = new JButton("Log Out");
		logOutButton.setBounds(491, 479, 94, 46);
		contentPane.add(logOutButton);
	}
	
/**
 * Create a list of functional button to support admin's manipulate item data
 * the list of buttons are [search] [Clear] [Add] [Update] [Delete]
 * @param contentPane - a JPanel of the View
 */
	private void createFunctionalityButtons(JPanel contentPane) {
		
		//clear button
		clearButton = new JButton("Clear");
		clearButton.setBounds(244, 317, 117, 29);
		contentPane.add(clearButton);
		
		//add button
		addButton = new JButton("Add");
		addButton.setBounds(244, 350, 117, 29);
		contentPane.add(addButton);
		
		//update button
		updateButton = new JButton("Update");
		updateButton.setBounds(244, 383, 117, 29);
		contentPane.add(updateButton);
		
		//delete button
		deleteButton = new JButton("Delete");
		deleteButton.setBounds(243, 416, 117, 29);
		contentPane.add(deleteButton);
	}
	
        
	
	public void emptyTextField() {
		categoryTextField.setText("");
		itemNameTextField.setText("");
		qtyTextField.setText("");
		optimalTextField.setText("");
		valueTextField.setText("");
	}
	

	
	public JButton getBackButton() {
		return backButton;
	}
	
	public JButton getLogOutButton(){
		return logOutButton;
	}
	
	public JButton getClearButton(){
		return clearButton;
	}
	
	public JButton getAddButton(){
		return addButton;
	}
	
	public JButton getUpdateButton(){
		return updateButton;
	}
	
	public JButton getDeleteButton(){
		return deleteButton;
	}
	
	public JTable getTable(){
		return table;
	}
	
	public JTextField getCategoryTextField(){
		return categoryTextField;
	}
	
	public JTextField getItemNameTextField(){
		return itemNameTextField;
	}
	
	public JTextField getQtyTextField(){
		return qtyTextField;
	}
	
	public JTextField getOptimalTextField(){
		return optimalTextField;
	}
	
	public JTextField getValueTextField(){
		return valueTextField;
	}
	
	public JPanel getContentPane(){
		return contentPane;
	}
	
	public DefaultTableModel getModel(){
		return model;
	}
	
}