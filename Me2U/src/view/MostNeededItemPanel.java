package view;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EtchedBorder;

import model.Inventory;
/**
 * @author Ziliang Wang
 *
 */
public class MostNeededItemPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8175864166245445277L;
    
    private Inventory inventory = new Inventory();

	private final JTextArea myActionArea;
    
    public MostNeededItemPanel() {
        super();
        //myItr = theItr;
        inventory.deserializeInventory();
//        inventory.addItem("hshshs", "asdsdaasd", 123, 13, 21);
//        inventory.serializeInventory();
//        inventory.deserializeInventory();
        myActionArea = new JTextArea();
        myActionArea.setEditable(false);
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < inventory.getNeeded().size(); i++) {
        	sb.append(inventory.getNeeded().get(i).getItemName()+ "\n");
        }
       
        myActionArea.append(sb.toString());
        start();
    }
    

	private void start() {
	    setLayout(new BorderLayout());
		add(new JLabel("Most Needed Items: "), BorderLayout.NORTH);
	    // Modify some properties.
	    myActionArea.setRows(21);
	    myActionArea.setColumns(13);
	    myActionArea.setBackground(Color.WHITE);
	    setBorder(new EtchedBorder());
	    add(myActionArea);
	}

}