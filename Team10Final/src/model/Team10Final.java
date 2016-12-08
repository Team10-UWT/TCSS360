/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import gui.*;
import java.awt.EventQueue;
/**
 *
 * @author David
 */
public class Team10Final {
    private static Me2Umodel me2umodel;
    private static Me2Ugui me2ugui;
    private static UserLogin userlogin;
    private static AdminHomePage adminhomepage;
    private static Register registerView;
    
    public Team10Final() {
        me2umodel = new Me2Umodel();
        //adminhomepage = new AdminHomePage();
        //me2ugui = new Me2Ugui();
        userlogin = new UserLogin();
        //registerView = new Register();
        //add listeners
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Team10Final controller = new Team10Final();
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                
            }
        });
    }
    
}
