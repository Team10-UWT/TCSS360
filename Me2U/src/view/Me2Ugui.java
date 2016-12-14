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
    
    private static JButton dButton = new JButton("Donations");
    
    private static JButton rButton = new JButton("Receive Aid");

    
    public Me2Ugui() {
    	//inventory.deserializeInventory();
    	start();
    	
    }
    
    public void start() {
        final JFrame frame = new JFrame("Me 2 U");
        frame.setPreferredSize(new Dimension(720, 480));
        frame.setBackground(Color.WHITE);
        
        final JComponent southPanel = new JPanel();
        southPanel.setBackground(Color.WHITE);

        final NewsPanel news = new NewsPanel();
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
        myNorthPanel.setLayout(new FlowLayout(FlowLayout.LEFT));  
		return myNorthPanel;
    }
    
    public JButton createDonationButton() {
    	final JPopupMenu popup = new JPopupMenu();
    	
        popup.add(new JMenuItem("How To Donate")); /*{
			private static final long serialVersionUID = 3743894585986691777L;

			public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Option 1 selected");
            }
        }));*/
        popup.addSeparator();
        
        popup.add(new JMenuItem("Volunteering")); /*{
			private static final long serialVersionUID = -291201761480013467L;

			public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Option 2 selected");
            }
        }));*/
        popup.addSeparator();
        
        popup.add(new JMenuItem("Pick Up Eligibility")); /*{
			private static final long serialVersionUID = 3743894585986691777L;

			public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Option 1 selected");
            }
        }));*/
        popup.addSeparator();
        
        popup.add(new JMenuItem(new AbstractAction("Items We Take"){
			private static final long serialVersionUID = -291201761480013467L;
			public void actionPerformed(ActionEvent e) {
                new ItemList();
            }
        }));
        popup.addSeparator();
        
        popup.add(new JMenuItem("Donate Now!")); /*{
			private static final long serialVersionUID = -291201761480013467L;

			public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Option 2 selected");
            }
        }));*/
        
        dButton.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                popup.show(dButton, dButton.getX(), dButton.getY() + 30);
            }
        });
		return dButton;
    }
    
    public JButton createRecipientButton() {

        
        final JPopupMenu popup = new JPopupMenu();
        
        popup.add(new JMenuItem("Eligibility")); /*{
			private static final long serialVersionUID = 3743894585986691777L;

			public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Option 1 selected");
            }
        }));*/
        popup.addSeparator();
        
        popup.add(new JMenuItem("Package Options")); /*{
			private static final long serialVersionUID = -291201761480013467L;

			public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Option 2 selected");
            }
        }));*/
        popup.addSeparator();
        
        popup.add(new JMenuItem("Request Aid!")); /*{
			private static final long serialVersionUID = -291201761480013467L;

			public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Option 2 selected");
            }
        }));*/
        
        rButton.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                popup.show(dButton, rButton.getX(), rButton.getY() + 30);
            }
        });
		return rButton;
    }
    
    

}