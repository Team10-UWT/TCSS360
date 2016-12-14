package view;
import javax.swing.*;

import model.Inventory;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Me2Ugui {
    /**Set north panel. */
    private final JPanel myNorthPanel = new JPanel();
    private int PADDING = 30;  
    private JButton dButton = new JButton("Donations"); 
    private JButton rButton = new JButton("Receive Aid");
    private JFrame frame;
    private JComponent southPanel;
    private NewsPanel news;
    private JPopupMenu popupD;
    private JPopupMenu popupR;
    private JMenuItem reqAidItem;
    private JMenuItem donateItem;
    private JButton logoutButton;
    private JButton adminButton;
    private JLabel nameLabel;
    
    public Me2Ugui() {
    	initialize();  	
    }
    
    private void initialize() {
        frame = new JFrame("Me 2 U");
        frame.setPreferredSize(new Dimension(720, 480));
        frame.setBackground(Color.WHITE);        
        southPanel = new JPanel();
        southPanel.setBackground(Color.WHITE);
        news = new NewsPanel();
        news.setBackground(Color.LIGHT_GRAY);
        news.setPreferredSize(new Dimension(200, 400));
        final MostNeededItemPanel moi = new MostNeededItemPanel();
        moi.setBackground(Color.RED);
        moi.setPreferredSize(new Dimension(200, 400));
        final LeaderBoardPanel lbp = new LeaderBoardPanel();
        lbp.setBackground(Color.CYAN);
        lbp.setPreferredSize(new Dimension(200, 400));     
        final Box centerBox = new Box(BoxLayout.LINE_AXIS);
        centerBox.add(news);
        centerBox.add(Box.createHorizontalStrut(PADDING));
        centerBox.add(moi);
        centerBox.add(Box.createHorizontalStrut(PADDING));
        centerBox.add(lbp);
        southPanel.add(centerBox);   
        frame.getContentPane().add(getNorthPanel(), BorderLayout.NORTH);
        frame.add(southPanel, BorderLayout.CENTER);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }
    
    private JPanel getNorthPanel() {
        myNorthPanel.add(createDonationButton());
        myNorthPanel.add(createRecipientButton());
        nameLabel = new JLabel("User");
        myNorthPanel.add(nameLabel);
        logoutButton = new JButton("Logout");
        myNorthPanel.add(logoutButton);
        adminButton = new JButton("Admin Page");
        adminButton.setVisible(false);
        myNorthPanel.add(adminButton);
        myNorthPanel.setLayout(new FlowLayout(FlowLayout.LEFT));  
		return myNorthPanel;
    }
    
    private JButton createDonationButton() {
    	popupD = new JPopupMenu();  	
        popupD.add(new JMenuItem("How To Donate")); 
        popupD.addSeparator();       
        popupD.add(new JMenuItem("Volunteering")); 
        popupD.addSeparator();       
        popupD.add(new JMenuItem("Pick Up Eligibility")); 
        popupD.addSeparator();
        popupD.add(new JMenuItem("Items We Take"));
        popupD.addSeparator();
        donateItem = new JMenuItem("Donate Now!");
        popupD.add(donateItem);
	return dButton;
    } 
    
    private JButton createRecipientButton() {   
        popupR = new JPopupMenu();      
        popupR.add(new JMenuItem("Eligibility")); 
        popupR.addSeparator();    
        popupR.add(new JMenuItem("Package Options")); 
        popupR.addSeparator();
        reqAidItem = new JMenuItem("Request Aid!");
        popupR.add(reqAidItem);
        return rButton;
    }
    public JMenuItem getReqAidItem() {
        return reqAidItem;
    }
    public JMenuItem getDonateItem() {
        return donateItem;
    }
    public JPopupMenu getPopupR() {
        return popupR;
    }
    public JPopupMenu getPopupD() {
        return popupD;
    }
    public JFrame getFrame() {
        return frame;
    }
    public JButton getdButton() {
        return dButton;
    }
    public JButton getrButton() {
        return rButton;
    }
    public JLabel getNameLabel() {
        return nameLabel;
    }
    public JButton getLogoutButton() {
        return logoutButton;
    }
    public JButton getAdminButton() {
        return adminButton;
    }
}