package view;

/*
 * Jayden Tan
 * TCSS360
 */
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;

public class UserLogin{

	private JPanel contentPane;
	private JTextField userNameText;
	private JPasswordField passwordField;
	private JFrame myFrame;
	private JButton registerButton;
        private JButton loginButton;
        private JLabel incorrectLogin;
        
        
	public UserLogin() {		
		//setup the JFrame
		myFrame = new JFrame();
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                myFrame.setBounds(100, 100, 450, 300);
		myFrame.setContentPane(setup());
		myFrame.setLocationRelativeTo(null);
		myFrame.setVisible(true);		
		
	}
        public JFrame getFrame() {
            return myFrame;
        }
        public JButton getRegisterButton(){
            return registerButton;
        }
        public JButton getLoginButton(){
            return loginButton;
        }
	
	/**
	 * setup and  add all the components to the JPanel
	 * @return JPanel
	 */
	private JPanel setup() {
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		contentPane.add(userNameLabel());
		contentPane.add(passwordLabel());
		contentPane.add(userNameText());	
		contentPane.add(passwordField());
                contentPane.add(incorrectLoginlabel());
		contentPane.add(loginButton());
		contentPane.add(registerButton());
		
		return contentPane;
	}
	
	/**
	 * set up username label
	 * @return JLabel
	 */
	private JLabel userNameLabel() {
		JLabel userNameIDLabel = new JLabel("UsernameID: ");
		userNameIDLabel.setBounds(30, 74, 108, 16);
		return userNameIDLabel;
	}
        
	
        private JLabel incorrectLoginlabel() {
                incorrectLogin = new JLabel("Incorrect login/password");
                incorrectLogin.setBounds(50, 40, 200, 16);
                incorrectLogin.setVisible(false);
                incorrectLogin.setBackground(Color.red);
                return incorrectLogin;
        }
	
	/**
	 *set up password label 
	 * @return password label
	 */
	private JLabel passwordLabel() {
		JLabel passwordLabel = new JLabel("Password: ");
		passwordLabel.setBounds(30, 116, 95, 16);
		return passwordLabel;
	}
	
	/**
	 * set up user name text field
	 * @return user name text field
	 */
	private JTextField userNameText() {
		userNameText = new JTextField();
		userNameText.setBounds(162, 69, 181, 26);
		userNameText.setColumns(10);
		return userNameText;
	}
	
        public JTextField getUserNameText() {
            return userNameText;
        }
	/**
	 * set up password text field
	 * @return password field
	 */
	private JPasswordField passwordField() {
		passwordField = new JPasswordField();
		passwordField.setBounds(162, 111, 181, 26);
		return passwordField;
	}
	
        public JPasswordField getPasswordField() {
            return passwordField;
        }
        public JLabel getIncorrectLoginLabel() {
            return incorrectLogin;
        }
        public void close() {
            myFrame.dispose();
        }
	
	/**
	 * set up login button with action listener 
	 * @return log in JButton
	 */
	private JButton loginButton() {
		loginButton = new JButton("Login");
		loginButton.setBackground(Color.WHITE);
		loginButton.setForeground(new Color(51, 204, 255));
		loginButton.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		loginButton.setBounds(303, 173, 117, 80);
		//loginButton.addActionListener(new loginListener());
		return loginButton;
	}
	
	/**
	 * set up register button with action listener
	 * @return register button
	 */
	private JButton registerButton() {
		registerButton = new JButton("Register");
		registerButton.setForeground(new Color(51, 204, 255));
		registerButton.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		registerButton.setBackground(Color.WHITE);
		registerButton.setBounds(30, 173, 117, 80);
		return registerButton;
	}

}