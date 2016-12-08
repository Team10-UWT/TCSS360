package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EtchedBorder;
/**
 * @author Ziliang Wang, Daniel Wood
 *	
 */
public class NewsPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8175864166245445277L;

	private final JTextArea myActionArea;
    
    public NewsPanel() {
        super();
        myActionArea = new JTextArea("\n Earthquake on the San Andreas \n Fault affecting millions. "
                + "\n Aid distribution continuing to \n help victims.\n______________________________\n\n"
                + " Donating now helps families \n in need for the holidays. Last \n year over 27,000 families \n were"
                + " helped by generous \n donors.\n______________________________\n\n "
                + "It is uncommon for us to ever \n "
                + "turn away a donation, but \n "
                + "after thanksgiving we have \n "
                + "had a surplus of some \n "
                + "seasonal items. Please \n "
                + "understand if there are any \n "
                + "items we cannot take at this \n "
                + "time and thank you again for \n "
                + "your generosity.");
        myActionArea.setEditable(false);
        
        start();
    }

	private void start() {
	    setLayout(new BorderLayout());
		add(new JLabel("News"), BorderLayout.NORTH);
	    // Modify some properties.
	    myActionArea.setRows(21);
	    myActionArea.setColumns(13);
	    myActionArea.setBackground(Color.WHITE);
	    setBorder(new EtchedBorder());
	    add(myActionArea);
	}

}