/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package crygetter.utils;

import crygetter.model.CryToxin;
import crygetter.ncbi.prot.GBSet;
import java.awt.Component;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
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
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
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
    
    private static final int BUFFER = 2048;
    
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
     * Parse BtNomenclature cry toxin list and generates a CryToxin list.
     * 
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
                    break;
                }
                
            }
            
            if ( ct.ncbiProtein != null ) {
                ctList.add( ct );
            }

        }
            
        return ctList;
        
    }
    
    /**
     * Extracts NCBI protein data from a CryToxin list and stores the data in 
     * a xml file under the "results" folder.
     * 
     * @param ctList CryToxin list.
     * @param howMany How many proteins to extract?
     * @throws IOException
     */
    public static void extractNCBIProteinData( List<CryToxin> ctList, int howMany ) 
            throws IOException {
        
        int count = 0;
        Date d = new Date();
        
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
     * Reads a file with valid xml containing NCBI protein data and returns
     * a GBSet.
     * 
     * @param file The file to be read.
     * @return A GBSet containing all the data from the valid CryToxin list
     * @throws IOException
     * @throws JAXBException
     * @throws ParserConfigurationException
     * @throws SAXException 
     */
    public static GBSet getGBSet( File file ) 
            throws IOException, JAXBException, 
            ParserConfigurationException, SAXException {
        
        JAXBContext jc = JAXBContext.newInstance( "crygetter.ncbi.prot" );
        SAXParserFactory spf = SAXParserFactory.newInstance();
        spf.setFeature( XMLConstants.FEATURE_SECURE_PROCESSING, false );
        XMLReader xmlReader = spf.newSAXParser().getXMLReader();
        InputSource inputSource = new InputSource( new FileReader( file ) );
        SAXSource source = new SAXSource( xmlReader, inputSource );

        Unmarshaller unmarshaller = jc.createUnmarshaller();
        return ( GBSet ) unmarshaller.unmarshal( source );
        
    }
    
    
    /**
     * Zips a set of files in one file.
     * 
     * @param destination File to contain the zipped files.
     * @param files Files to be zipped.
     * @throws IOException 
     */
    public static void zip( File destination, File... files ) 
            throws IOException {
      
        BufferedInputStream origin = null;
        FileOutputStream dest = new FileOutputStream( destination );
        
        try ( ZipOutputStream out = new ZipOutputStream( new BufferedOutputStream( dest ) ) ) {
            
            byte data[] = new byte[BUFFER];
            
            for ( int i = 0; i < files.length; i++ ) {
                
                FileInputStream fi = new FileInputStream(files[i]);
                origin = new BufferedInputStream( fi, BUFFER );
                ZipEntry entry = new ZipEntry( files[i].getName() );
                out.putNextEntry(entry);
                int count;
                
                while ( ( count = origin.read( data, 0, BUFFER ) ) != -1 ) {
                    out.write(data, 0, count);
                }
                
                origin.close();
                
            }
            
        }
        
    }
    
    /**
     * Unzips a file and return a list of the unziped files.
     * 
     * @param target File to be unzipped.
     * @return A lista with the files that where unzipped.
     * @throws IOException 
     */
    public static List<File> unzip( File target ) throws IOException {
        
        List<File> unzippedFiles = new ArrayList<>();
        BufferedOutputStream dest = null;
        FileInputStream fis = new  FileInputStream( target );
        ZipEntry entry = null;
        
        try ( ZipInputStream zis = new ZipInputStream( new BufferedInputStream( fis ) ) ) {
        
            while ( ( entry = zis.getNextEntry() ) != null ) {
                
                int count;
                byte data[] = new byte[BUFFER];
                
                // write the files to the disk
                File unf = new File( target.getParentFile().getAbsolutePath() + "/" + entry.getName() );
                unzippedFiles.add( unf );
                
                FileOutputStream fos = new FileOutputStream( unf );
                dest = new BufferedOutputStream( fos, BUFFER );
                
                while ( ( count = zis.read( data, 0, BUFFER ) ) != -1 ) {
                    dest.write(data, 0, count);
                }
                
                dest.flush();
                dest.close();
                
            }
            
        }
        
        return unzippedFiles;
        
    }
    
    /**
     * Format a protein proteinSequence in 6 columns per line, ith 10 aa each column.
     * 
     * @param seq Sequence to be formated.
     * @return Formated proteinSequence.
     */
    public static String formatProtein( String seq ) {
        
        StringBuilder sb = new StringBuilder();
        
        int count = 0;
        boolean first = true;
        List<String> lineList = new ArrayList<>();
        
        for ( char c : seq.toCharArray() ) {
            
            if ( count % 60 == 0 && !first ) {
                lineList.add( sb.toString().trim() );
                sb = new StringBuilder();
            }
            
            first = false;
            
            if ( count % 10 == 0 ) {                
                sb.append( " " );
            }
            
            sb.append( c );
            
            count++;
            
        }
        
        lineList.add( sb.toString().trim() );
        
        sb = new StringBuilder();
        
        for ( String s : lineList ) {
            sb.append( s ).append( "\n" );
        }
        
        return sb.toString();
        
    }
    
    public static void showExceptionMessage( Component parent, Throwable t ) {
        
        StringBuilder sb = new StringBuilder();
        
        sb.append( "Ocorreu um erro inesperado na execução da tarefa requisitada.\n" );
        sb.append( "Os dados do erro podem ser vistos abaixo:\n\n" );
        
        sb.append( t.getLocalizedMessage() );
        sb.append( t.toString() ).append( "\n" );
        sb.append( "Stack Trace:\n" );
        
        for ( StackTraceElement e : t.getStackTrace() ) {
            sb.append( e.toString() ).append( "\n" );
        }
        
        JTextArea tArea = new JTextArea( 20, 50 );
        tArea.setText( sb.toString() );
        JScrollPane sp = new JScrollPane( tArea );
        
        JOptionPane.showMessageDialog( parent, sp,
                "ERRO", JOptionPane.ERROR_MESSAGE );
        
    }
    
}
