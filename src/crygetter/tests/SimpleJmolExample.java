/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crygetter.tests;

import java.io.IOException;
import javax.swing.JFrame;
import org.biojava.bio.structure.Structure;
import org.biojava.bio.structure.align.gui.jmol.JmolPanel;
import org.biojava.bio.structure.io.PDBFileReader;

/**
 *
 * @author David
 */
public class SimpleJmolExample {

    public static void main( String[] args ) throws IOException {
        
        JFrame f = new JFrame();
        f.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        f.setSize( 300, 300 );
        
        JmolPanel jp = new JmolPanel();
        f.add( jp );
        
        PDBFileReader pdbr = new PDBFileReader();
        Structure struc = pdbr.getStructure( new Object().getClass().getResource( "/val.pdb" ) );
        
        jp.setStructure( struc );
        
        f.setVisible( true );
        
    }

}
