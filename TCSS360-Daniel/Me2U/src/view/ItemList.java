package view;
import java.awt.BorderLayout;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * 
 */

/**
 * @author Ziliang
 *
 */
public class ItemList extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7646690470174995894L;
	
    /**
     * Displays all actions performed on the Stack.
     */
    private final JTextArea myActionArea;
    
    /**Set the default frame. */
    private final JFrame myFrame = new JFrame("Item We Take");
    /** The width used in various margins and insets. */
    private static final int PADDING = 40;

	//private final static int SIZE = 30;
	private final static int FRAME_WIDTH = 200;
	private final static int FRAME_HEIGHT = 400;
	
	public ItemList() {
		super();
		start();
		myActionArea = new JTextArea(30 , 30);
	}

	private void start() {
		//setSize(FRAME_WIDTH,FRAME_HEIGHT);
//		myActionArea.append("Test Test All Test Purpose!");
//		myActionArea.setMargin(new Insets(PADDING, PADDING, PADDING, PADDING));
//		myActionArea.setEditable(false);
//		myActionArea.setFocusable(false);
		

		add(new JScrollPane(myActionArea), BorderLayout.CENTER);
		setVisible(true);
		myFrame.setSize(FRAME_WIDTH , FRAME_HEIGHT);
		myFrame.setContentPane(this);
        myFrame.setLocationRelativeTo(null);
        myFrame.setResizable(false);
        myFrame.setVisible(true);
	}

}