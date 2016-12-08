package gui;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EtchedBorder;
/**
 * @author Ziliang Wang
 *	
 */
public class LeaderBoardPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8175864166245445277L;

	private final JTextArea myActionArea;
    
    public LeaderBoardPanel() {
        super();
        myActionArea = new JTextArea("Hello world!");
        start();
    }

	private void start() {
	    setLayout(new BorderLayout());
		add(new JLabel("Leader Board: "), BorderLayout.NORTH);
	    // Modify some properties.
	    myActionArea.setRows(21);
	    myActionArea.setColumns(13);
	    myActionArea.setBackground(Color.WHITE);
	    setBorder(new EtchedBorder());
	    add(myActionArea);
	}

}