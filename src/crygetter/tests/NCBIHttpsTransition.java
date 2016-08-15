/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crygetter.tests;

import crygetter.utils.Utils;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import javax.net.ssl.HttpsURLConnection;

/**
 *
 * @author David
 */
public class NCBIHttpsTransition {
    
    public static void main( String[] args ) throws Exception {
        
        String completeData = getDataFromHttpsRequestViaPost( 
                        "https://eutils.ncbi.nlm.nih.gov/entrez/eutils/efetch.fcgi", 
                        "tool=crygetter&email=davidbuzatto@ifsp.edu.br&db=protein&retmode=xml&id=142765" );
        
        System.out.println( completeData );
        
        
    }
    
    public static String getDataFromRequestViaPost( String request, String urlParameters ) 
            throws MalformedURLException, IOException {
        
        HttpURLConnection con = (HttpURLConnection) new URL( request ).openConnection();           
        con.setDoOutput( true );
        con.setDoInput( true );
        con.setInstanceFollowRedirects( false );
        con.setRequestMethod( "POST" ); 
        con.setRequestProperty( "charset", "utf-8" );
        con.setRequestProperty( "Content-Length", Integer.toString( urlParameters.getBytes().length ) );
        con.setUseCaches( false );
        
        try ( DataOutputStream wr = new DataOutputStream( con.getOutputStream() ) ) {
            wr.writeBytes( urlParameters );
            wr.flush();
        }

        StringBuilder data = new StringBuilder();
        
        try ( Scanner scan = new Scanner( con.getInputStream() ) ) {
            while ( scan.hasNextLine() ) {
                data.append( scan.nextLine() ).append( "\n" );
            }
        }
        
        con.disconnect();
        
        return data.toString();
        
    }
    
    public static String getDataFromHttpsRequestViaPost( String request, String urlParameters ) 
            throws MalformedURLException, IOException {
        
        HttpsURLConnection con = (HttpsURLConnection) new URL( request ).openConnection();           
        con.setDoOutput( true );
        con.setDoInput( true );
        con.setInstanceFollowRedirects( false );
        con.setRequestMethod( "POST" ); 
        con.setRequestProperty( "charset", "utf-8" );
        con.setRequestProperty( "Content-Length", Integer.toString( urlParameters.getBytes().length ) );
        con.setUseCaches( false );
        
        try ( DataOutputStream wr = new DataOutputStream( con.getOutputStream() ) ) {
            wr.writeBytes( urlParameters );
            wr.flush();
        }

        StringBuilder data = new StringBuilder();
        
        try ( Scanner scan = new Scanner( con.getInputStream() ) ) {
            while ( scan.hasNextLine() ) {
                data.append( scan.nextLine() ).append( "\n" );
            }
        }
        
        con.disconnect();
        
        return data.toString();
        
    }
    
}
