/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crygetter.utils;

import java.awt.Color;
import java.io.*;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;

/**
 * A class to consume processed streams and log the results into a JTextArea.
 * 
 * @author David Buzatto
 * Based on: When Runtime.exe() Won't
 * URL: http://www.javaworld.com/article/2071275/core-java/when-runtime-exec---won-t.html?page=1
 */
public class StreamGobblerUI extends Thread {

    private InputStream is;
    private String type;
    private JTextPane textArea;
    private Color textColor;
    private Color backgroundTextColor;

    public StreamGobblerUI( InputStream is, String type, JTextPane textArea, Color textColor, Color backgroundTextColor ) {
        this.is = is;
        this.type = type;
        this.textArea = textArea;
        this.textColor = textColor;
        this.backgroundTextColor = backgroundTextColor;
    }

    public void run() {
        
        try {

            InputStreamReader isr = new InputStreamReader( is );
            BufferedReader br = new BufferedReader( isr );
            String line = null;
            
            while ( ( line = br.readLine() ) != null ) {
                SwingUtilities.invokeLater( new JTextAreaUpdater( textArea,
                        type + "> ", textColor.darker(), backgroundTextColor ) );
                SwingUtilities.invokeLater( new JTextAreaUpdater( textArea,
                        line + "\n", textColor, backgroundTextColor ) );
            }
            
        } catch ( IOException ioe ) {
            ioe.printStackTrace();
        }
        
    }
    
}
