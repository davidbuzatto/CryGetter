/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package crygetter;

import crygetter.gui.MainWindow;

/**
 *
 * @author David Buzatto
 */
public class CryGetter {

    /**
     * @param args the command line arguments
     */
    public static void main( String[] args ) throws Exception {
        
        java.awt.EventQueue.invokeLater( new Runnable() {
            public void run() {
                new MainWindow().setVisible( true );
            }
        });
        
    }
    
}
