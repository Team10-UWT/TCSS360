package view;

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
import java.awt.Font;
import javafx.scene.control.RadioButton;
import model.Me2Umodel;
import model.User;


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
	private JFrame myFrame;
        private JLabel nameTakenLabel;
        private RadioButton dradio;
        private RadioButton rradio;
        private JButton registerButton;

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
		contentPane.add(passwordLabel());
                contentPane.add(nameTakenLabel());	
		contentPane.add(idText());
		contentPane.add(nameText());
		contentPane.add(passwordText());
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
        
        private JLabel nameTakenLabel() {
            nameTakenLabel = new JLabel("Sorry this username is taken.");
            nameTakenLabel.setBounds(25, 110, 220, 16);
            nameTakenLabel.setForeground(Color.RED);
            nameTakenLabel.setVisible(false);
            return nameTakenLabel;
        }
        public JLabel getNameTakenLabel() {
            return nameTakenLabel;
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

	private JLabel passwordLabel() {
		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(25, 84, 61, 16);
		return passwordLabel;
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
        
        public JTextField getIDText() {
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
        
        public JTextField getNameText() {
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
        
        public JTextField getPasswordText() {
            return passwordText;
        }

	/**
	 * set up register button
	 * @return register button
	 */
	private JButton registerButton() {
		registerButton = new JButton("Register");
		registerButton.setForeground(new Color(51, 204, 255));
		registerButton.setBounds(315, 201, 117, 53);
		return registerButton;
	}
        
        public JButton getRegisterButton() {
            return registerButton;
        }
        
        public void close() {
            myFrame.dispose();
        }		
}