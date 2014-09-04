/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crygetter.utils;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
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
    private OutputStream os;

    public StreamGobblerUI( InputStream is, String type, JTextPane textArea, Color textColor, Color backgroundTextColor ) {
        this( is, type, textArea, textColor, backgroundTextColor, null );
    }
    
    public StreamGobblerUI( InputStream is, String type, JTextPane textArea, Color textColor, Color backgroundTextColor, OutputStream redirect ) {
        this.is = is;
        this.type = type;
        this.textArea = textArea;
        this.textColor = textColor;
        this.backgroundTextColor = backgroundTextColor;
        this.os = redirect;
    }

    public void run() {
        
        try {

            PrintWriter pw = null;
            
            if ( os != null ) {
                pw = new PrintWriter( os );
            }
            
            InputStreamReader isr = new InputStreamReader( is );
            BufferedReader br = new BufferedReader( isr );
            String line = null;
            
            while ( ( line = br.readLine() ) != null ) {
                if ( pw != null ) {
                    pw.println( line );
                }
                SwingUtilities.invokeLater( new JTextAreaUpdater( textArea,
                        type + "> " + line + "\n", textColor, backgroundTextColor ) );
            }
            
            if ( pw != null ) {
                pw.flush();
                pw.close();
            }
            
        } catch ( IOException ioe ) {
            Utils.showExceptionMessage( null, ioe );
        }
        
    }
    
}
