/*
 * Jayden Tan
 * TCSS360
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;

/**
 * This program allow user to register their user account
 * @author Jayden Tan
 *
 */
public class Register {

	private JPanel contentPane;
	private JTextField idText;
	private JTextField nameText;
	private JTextField passwordText;
	private JTextField addressText;
	private JTextField phoneNumberText;
	private JTextField emailText;
	private JFrame myFrame;


	/**
	 * Create the frame.
	 */
	public Register() {
		myFrame = new JFrame();
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		myFrame.setContentPane(contentPane);
		contentPane.setLayout(null);
		myFrame.setLocationRelativeTo(null);
		
		
		contentPane.add(customerIDLabel());
		contentPane.add(nameLabel());
		contentPane.add(addressLabel());
		contentPane.add(phoneNumberLabel());
		contentPane.add(passwordLabel());
		contentPane.add(emailLabel());	
		contentPane.add(idText());
		contentPane.add(nameText());
		contentPane.add(passwordText());
		contentPane.add(addressText());
		contentPane.add(phoneNumberText());
		contentPane.add(emailText());
		contentPane.add(registerButton());
		myFrame.setVisible(true);
		
	}
	
	/**
	 * set up user id label
	 * @return user id label
	 */
	private JLabel customerIDLabel() {
		JLabel userIDLabel = new JLabel("User ID");
		userIDLabel.setBounds(25, 28, 85, 16);
		return userIDLabel;
	}
	
	/**
	 * set up user name label
	 * @return user name label
	 */
	private JLabel nameLabel() {
		JLabel nameLabel = new JLabel("Name");
		nameLabel.setBounds(25, 56, 61, 16);
		return nameLabel;
	}
	
	/**
	 * set up user address label
	 * @return user address label
	 */
	private JLabel addressLabel() {
		JLabel addressLabel = new JLabel("Address");
		addressLabel.setBounds(25, 112, 61, 16);
		return addressLabel;
	}
	
	/**
	 * set up user phone number label
	 * @return user phone number label
	 */
	private JLabel phoneNumberLabel() {
		JLabel phoneNumberLabel = new JLabel("Phone #");
		phoneNumberLabel.setBounds(25, 140, 61, 16);
		return phoneNumberLabel;
	}
	
	/**
	 * set up user password label
	 * @return password label
	 */
	private JLabel passwordLabel() {
		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(25, 84, 61, 16);
		return passwordLabel;
	}
	
	/**
	 * set up email label
	 * @return email Label
	 */
	private JLabel emailLabel() {
		JLabel emailLabel = new JLabel("Email");
		emailLabel.setBounds(25, 168, 61, 16);
		return emailLabel;
	}
	
	
	/**
	 * set up user id text field
	 * @return user id text field
	 */
	private JTextField idText() {
		idText = new JTextField();
		idText.setBounds(122, 23, 228, 26);
		idText.setColumns(10);
		return idText;
	}
	/**
	 * set up user name text field
	 * @return user name text field
	 */
	private JTextField nameText() {
		nameText = new JTextField();
		nameText.setBounds(122, 51, 228, 26);
		nameText.setColumns(10);
		return nameText;
	}
	/**
	 * set up user password text field
	 * @return user password text field
	 */
	private JTextField passwordText() {
		passwordText = new JTextField();
		passwordText.setBounds(122, 79, 228, 26);
		passwordText.setColumns(10);
		return passwordText;
	}
	/**
	 * set up user address text field
	 * @return user address text field
	 */
	private JTextField addressText() {
		addressText = new JTextField();
		addressText.setBounds(122, 107, 228, 26);
		addressText.setColumns(10);
		return addressText;
	}
	/**
	 * set up phone number text field
	 * @return phone number text field
	 */
	private JTextField phoneNumberText() {
		phoneNumberText = new JTextField();
		phoneNumberText.setBounds(122, 135, 228, 26);
		phoneNumberText.setColumns(10);
		return phoneNumberText;
	}
	/**
	 * set up email text field
	 * @return email text field
	 */
	private JTextField emailText() {
		emailText = new JTextField();
		emailText.setBounds(122, 163, 228, 26);
		emailText.setColumns(10);
		return emailText;
	}
	
	/**
	 * set up register button
	 * @return register button
	 */
	private JButton registerButton() {
		JButton registerButton = new JButton("Register");
		registerButton.setForeground(new Color(51, 204, 255));
		registerButton.setBounds(315, 201, 117, 53);
		registerButton.addActionListener(new registerListener());
		return registerButton;
	}
/**
 * This is the register action listener create a user account in the users list
 * using the provided information	
 * @author Jayden Tan
 *
 */
	private class registerListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
