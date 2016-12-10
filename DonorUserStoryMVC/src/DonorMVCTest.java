
import controller.DonorController;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sonny
 */
public class DonorMVCTest {
    public static void main(String[] args){
        DonorController controller = new DonorController();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                controller.getDonorView().setVisible(true);
            }
        });
    }
    
}
