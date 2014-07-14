/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package crygetter.utils;

import crygetter.model.CryToxin;
import crygetter.ncbi.prot.GBSet;
import java.io.DataOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.sax.SAXSource;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

/**
 * Utility methods.
 * 
 * @author David Buzatto
 */
public class Utils {
    
    /**
     * Gets data using HTTP POST method.
     * 
     * @param request Base URL
     * @param urlParameters Parameters
     * @return Data from the request
     * @throws MalformedURLException
     * @throws IOException 
     */
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
    
    /**
     * Parse BtNomenclature cry toxin list and generates a CryToxin list
     * with just the entries that have NCBI data.
     * @return A list containing all CryToxin valid data.
     * @throws IOException 
     */
    public static List<CryToxin> getCryToxinList() throws IOException {
        
        List<CryToxin> ctList = new ArrayList<>();
        Document doc = Jsoup.connect( "http://www.lifesci.sussex.ac.uk/home/Neil_Crickmore/Bt/toxins2.html" ).get();
        Elements lines = doc.select( "table tr" );
        Pattern p = Pattern.compile( "\\d+" );
        
        for ( Element line : lines ) {

            CryToxin ct = new CryToxin();
            Elements columns = line.select( "td" );

            ct.name = columns.get( 0 ).text();
            ct.accessionNo = columns.get( 1 ).text();
            //ct.ncbiProtein = columns.get( 2 ).text(); => will be extracted below
            ct.ncbiNucleotide = columns.get( 3 ).text();
            ct.authors = columns.get( 4 ).text();
            ct.year = columns.get( 5 ).text();
            ct.sourceStrain = columns.get( 6 ).text();
            ct.comment = columns.get( 7 ).text();

            Element nameColumn = columns.get( 0 );
            Element accessionColumn = columns.get( 0 );

            for ( Element link : nameColumn.select( "a" ) ) {
                ct.ncbiURL = link.attr( "href" );
                break;
            }

            for ( Element link : accessionColumn.select( "a" ) ) {
                ct.ncbiURL2 = link.attr( "href" );
                break;
            }
            
            // does this cry toxin have protein data?
            // if so, gets its id
            if ( ct.ncbiURL != null && ct.ncbiURL.toLowerCase().contains( "protein" ) ) {
                
                // extracting id from URL
                Matcher m = p.matcher( ct.ncbiURL );
                
                while ( m.find() ) {
                    ct.ncbiProtein = m.group();
                    ctList.add( ct );
                    break;
                }
                
            }

        }
            
        return ctList;
        
    }
    
    /**
     * Extracts NCBI protein data from a valid CryToxin list.
     * 
     * @param howMany How many proteins to extract?
     * @throws IOException
     */
    public static void extractNCBIProteinData( int howMany ) 
            throws IOException {
        
        int count = 0;
        Date d = new Date();
        
        List<CryToxin> ctList = Utils.getCryToxinList();
        String filePath = String.format( "results/sequenceData-%tY-%tm-%td-(%tH-%tM-%tS)-size=%d.xml", 
                d, d, d, d, d, d, howMany <= ctList.size() && howMany > 0 ? howMany : ctList.size() );
            
        StringBuilder sbIds = new StringBuilder();

        for ( CryToxin ct : ctList ) {    

            sbIds.append( ct.ncbiProtein ).append( "," );

            if ( ++count == howMany ) {
                break;
            }

        }

        String ids = sbIds.toString();

        String completeData = Utils.getDataFromRequestViaPost( 
                "http://eutils.ncbi.nlm.nih.gov/entrez/eutils/efetch.fcgi", 
                "tool=crygetter&email=davidbuzatto@ifsp.edu.br&db=protein&retmode=xml&id=" + ids.substring( 0, ids.length() - 1 ) );
        
        // fasta
        /*String fastaData = Utils.getDataFromRequestViaPost( 
                "http://eutils.ncbi.nlm.nih.gov/entrez/eutils/efetch.fcgi",
                "tool=crygetter&email=davidbuzatto@ifsp.edu.br&db=protein&retmode=text&rettype=fasta&id=" + ids.substring( 0, ids.length() - 1 ) );*/
                        
        try ( FileWriter fw = new FileWriter( filePath ) ) {
            fw.write( completeData );
        }
        
    }
    
    /**
     * Reads a valid xml containing NCBI protein data and returns a GBSet.
     * 
     * @param filePath Path to the file contaning the data.
     * @return A GBSet containing all the data from the valid CryToxin list
     * @throws IOException
     * @throws JAXBException
     * @throws ParserConfigurationException
     * @throws SAXException 
     */
    public static GBSet getGBSet( String filePath ) 
            throws IOException, JAXBException, 
            ParserConfigurationException, SAXException {
        
        JAXBContext jc = JAXBContext.newInstance( "crygetter.ncbi.prot" );
        SAXParserFactory spf = SAXParserFactory.newInstance();
        spf.setFeature( XMLConstants.FEATURE_SECURE_PROCESSING, false );
        XMLReader xmlReader = spf.newSAXParser().getXMLReader();
        InputSource inputSource = new InputSource( new FileReader( filePath ) );
        SAXSource source = new SAXSource( xmlReader, inputSource );

        Unmarshaller unmarshaller = jc.createUnmarshaller();
        return ( GBSet ) unmarshaller.unmarshal( source );
        
    }
    
}
