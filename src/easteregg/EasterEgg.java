/*
 * Team 1 0
 * Sandeep Heera, Ziliang Wang, Jayden Tan, Daniel Wood, David Foster
 * EasterEgg.java
 * This program is an implementation of the user stories posted in the
 * Easter Egg assignment.
 */

package easteregg;

import java.util.Scanner;

public class EasterEgg {
    //Constant strings
    public static final String EE_STRING = "EE";
    public static final String PROMPT_STRING = "Enter the magic phrase: ";
    public static final String TRIG_WAR = "Easter Egg Triggered!";
    public static final String TEAM_NAME = "Team 1 0";
    public static final String MEMBERS = "Sandeep Heera, Daniel Wood, Ziliang Wang, David Foster, Jayden Tan";//ADD YOUR NAME HERE
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic 
        Scanner c = new Scanner(System.in);
        String userInput = new String("");
        
        do{
            System.out.println(PROMPT_STRING);
            userInput = new String(c.nextLine());
            
        }while(!userInput.equals(EE_STRING));
        
        System.out.println(TRIG_WAR);
        System.out.println(TEAM_NAME);
        System.out.println(MEMBERS);
        c.close();
    }
    
}
