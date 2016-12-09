package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EtchedBorder;
import model.User;

/**
 * @author Ziliang Wang, Daniel Wood
 *
 */
public class LeaderBoardPanel extends JPanel {

    /**
     *
     */
    private static final long serialVersionUID = 8175864166245445277L;

    private final JTextArea myActionArea;

    public LeaderBoardPanel() {
        super();
        myActionArea = new JTextArea(""
                + "\n PinkElephant92 \n Points: 249937 \n"
                + "\n______________________________\n\n"
                + " Donationator3000 \n Points: 238311 \n"
                + "\n______________________________\n\n"
                + " PhilanthroPEtchr \n Points: 210065 \n"
                + "\n______________________________\n\n"
                + " CaringGiver1 \n Points: 20501 \n"
                + "\n______________________________\n\n"
                + " Vegeta \n Points: 9001");
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