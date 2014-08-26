/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package crygetter.gui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 * A JPanel that shows images.
 * 
 * @author David Buzatto
 */
public class ImagePanel extends JPanel {

    private BufferedImage img;
    
    @Override
    protected void paintComponent( Graphics g ) {
        super.paintComponent( g );
        
        if ( img != null ) {
            g.drawImage( img, 0, 0, null );
        }
        
    }
    
    public void setImage( InputStream in ) throws IOException {
        img = ImageIO.read( in );
    }
    
}
