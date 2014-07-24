/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crygetter.utils;

import java.io.*;

/**
 * A class to consume processed streams.
 * 
 * @author David Buzatto
 * Based on: When Runtime.exe() Won't
 * URL: http://www.javaworld.com/article/2071275/core-java/when-runtime-exec---won-t.html?page=1
 */
public class StreamGobbler extends Thread {

    InputStream is;
    String type;
    OutputStream os;

    public StreamGobbler( InputStream is, String type ) {
        this( is, type, null );
    }

    public StreamGobbler( InputStream is, String type, OutputStream redirect ) {
        this.is = is;
        this.type = type;
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
                System.out.println( type + ">" + line );
            }
            
            if ( pw != null ) {
                pw.flush();
            }
            
        } catch ( IOException ioe ) {
            ioe.printStackTrace();
        }
        
    }
    
}
