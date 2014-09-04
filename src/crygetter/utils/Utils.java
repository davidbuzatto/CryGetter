/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package crygetter.utils;

import crygetter.model.CryToxin;
import crygetter.ncbi.prot.GBSet;
import iubio.readseq.BioseqFormats;
import iubio.readseq.BioseqWriterIface;
import iubio.readseq.Readseq;
import java.awt.Color;
import java.awt.Component;
import java.awt.Desktop;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.AttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
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
    private static final Color outOK = new Color( 22, 142, 170 );
    private static final Color outError = Color.RED;
    private static final Color codeOK = new Color( 32, 160, 47 );
    private static final Color codeError = Color.RED;
    
    private static final String whitespaceChars =  ""       /* dummy empty string for homogeneity */
                + "\\u0009" // CHARACTER TABULATION
                + "\\u000A" // LINE FEED (LF)
                + "\\u000B" // LINE TABULATION
                + "\\u000C" // FORM FEED (FF)
                + "\\u000D" // CARRIAGE RETURN (CR)
                + "\\u0020" // SPACE
                + "\\u0085" // NEXT LINE (NEL) 
                + "\\u00A0" // NO-BREAK SPACE
                + "\\u1680" // OGHAM SPACE MARK
                + "\\u180E" // MONGOLIAN VOWEL SEPARATOR
                + "\\u2000" // EN QUAD 
                + "\\u2001" // EM QUAD 
                + "\\u2002" // EN SPACE
                + "\\u2003" // EM SPACE
                + "\\u2004" // THREE-PER-EM SPACE
                + "\\u2005" // FOUR-PER-EM SPACE
                + "\\u2006" // SIX-PER-EM SPACE
                + "\\u2007" // FIGURE SPACE
                + "\\u2008" // PUNCTUATION SPACE
                + "\\u2009" // THIN SPACE
                + "\\u200A" // HAIR SPACE
                + "\\u2028" // LINE SEPARATOR
                + "\\u2029" // PARAGRAPH SEPARATOR
                + "\\u202F" // NARROW NO-BREAK SPACE
                + "\\u205F" // MEDIUM MATHEMATICAL SPACE
                + "\\u3000" // IDEOGRAPHIC SPACE
                ;
    
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
        
        String filePath = String.format( "temp/sequenceData-%tY-%tm-%td-(%tH-%tM-%tS)-size=%d.xml", 
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
     * Format a protein sequence in 6 columns per line, with 10 aa for each column.
     * 
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
        
        return sb.toString().substring( 0, sb.length() - 1 );
        
    }
    
    /**
     * Format a protein sequence in 6 columns per line, with 10 aa for each column.
     * Considering a previous quantity of processed chars.
     * 
     * @param seq Sequence to be formated.
     * @param jump How many chars to jump.
     * @return Formated proteinSequence.
     */
    public static String formatProtein( String seq, int jump ) {
        
        StringBuilder sb = new StringBuilder();
        
        int count = jump;
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
        
        return sb.toString().substring( 0, sb.length() - 1 ).trim();
        
    }
    
    /**
     * Count how many occurrences of a char appears in a string.
     * 
     * @param string String to be searched
     * @param searchFor Character to be searched
     * @return Amount of chars that where found
     */
    public static int countChar( String string, char searchFor ) {
        
        int count = 0;
        
        for ( char c : string.toCharArray() ) {
            if ( c == searchFor ) {
                count++;
            }
        }
        
        return count;
        
    }
    
    /**
     * Shows a message box with exception details.
     * 
     * @param parent Parent component of the message bos.
     * @param t Throwable with the exception details.
     */
    public static void showExceptionMessage( Component parent, Throwable t ) {
        
        StringBuilder sb = new StringBuilder();
        
        sb.append( "An unexpected error occured during the execution of the requested task.\n" );
        sb.append( "The error data can be seen below:\n\n" );
        
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
                "ERROR", JOptionPane.ERROR_MESSAGE );
        
    }
    
    /**
     * Append some text in one JTextPane, using colors.
     * 
     * @param textPane Text pane to be appended.
     * @param text Text to be appended.
     * @param foregroundColor Color of the foreground of the text.
     * @param backgroundColor Color of the background of the text.
     */
    public static void appendToPane( JTextPane textPane, String text, Color foregroundColor, Color backgroundColor ) {
        
        StyleContext sc = StyleContext.getDefaultStyleContext();
        
        AttributeSet aset = sc.addAttribute( SimpleAttributeSet.EMPTY, StyleConstants.Foreground, foregroundColor );
        aset = sc.addAttribute( aset, StyleConstants.Background, backgroundColor );
        //aset = sc.addAttribute( aset, StyleConstants.FontFamily, "Lucida Console" );
        //aset = sc.addAttribute( aset, StyleConstants.Alignment, StyleConstants.ALIGN_JUSTIFIED );

        int len = textPane.getDocument().getLength();
        textPane.setCaretPosition( len );
        textPane.setCharacterAttributes( aset, false );
        textPane.replaceSelection( text );
        
    }
    
    /**
     * Set the text pane text.
     * 
     * @param textPane Text pane to be appended.
     * @param text Text to be appended.
     * @param foregroundColor Color of the foreground of the text.
     * @param backgroundColor Color of the background of the text.
     */
    public static void setTextToPane( JTextPane textPane, String text, Color foregroundColor, Color backgroundColor ) {
        
        StyleContext sc = StyleContext.getDefaultStyleContext();
        
        AttributeSet aset = sc.addAttribute( SimpleAttributeSet.EMPTY, StyleConstants.Foreground, foregroundColor );
        aset = sc.addAttribute( aset, StyleConstants.Background, backgroundColor );
        textPane.setCharacterAttributes( aset, false );
        
        textPane.setText( text );
        
    }
    
    /**
     * Formats raw fasta data into the format with columns.
     * 
     * @param header Text of the header (after >)
     * @param rawData Data to be formated.
     * @param columns Number of columns
     */
    public static String formatAsFasta( String header, String rawData, int columns) {
        
        StringBuilder sb = new StringBuilder();
        sb.append( ">" ).append( header ).append( "\n" );
        
        int count = 1;
        
        for ( char c : rawData.toCharArray() ) {
            sb.append( c );
            if ( count % columns == 0 ) {
                sb.append( "\n" );
            }
            count++;
        }
        
        return sb.toString();
        
    }
    
    /**
     * Converts a file written in clustal format to another format
     * 
     * @param readFromFile File with data formatted in clustal format
     * @param outFormatName Format to convert to
     * @param fileName File that will be generated
     * @throws IOException 
     */
    public static void convertBiologicalDataFile( String readFromFile, String outFormatName, String fileName ) 
            throws IOException {
        
        int outid = BioseqFormats.formatFromName( outFormatName );
        BioseqWriterIface seqWriter = BioseqFormats.newWriter( outid );

        try ( FileWriter fw = new FileWriter( "temp/" + fileName ) ) {
            
            seqWriter.setOutput( fw );
            seqWriter.writeHeader();
            
            try ( FileReader fr = new FileReader( "temp/" + readFromFile ) ) {
                
                Readseq rd = new Readseq();
                rd.setInputObject( fr );
                
                if ( rd.isKnownFormat() && rd.readInit() ) {
                    rd.readTo( seqWriter );
                }
                
                seqWriter.writeTrailer();
                
            }
            
        }
        
    }
    
    /**
     * Runs ClustalW from a file and write in another the results.
     * 
     * @param readFrom File to read.
     * @param fileNameBase File to write.
     * @throws IOException
     * @throws InterruptedException 
     */
    public static void runClustalW( String readFrom, String fileNameBase ) 
            throws IOException, InterruptedException {
            
        Runtime rt = Runtime.getRuntime();
        Process proc = rt.exec( "clustal/clustalw2.exe -INFILE=temp/" + readFrom + " -ALIGN -TREE -TYPE=PROTEIN -OUTORDER=INPUT -OUTFILE=temp/" + fileNameBase + ".aln" );

        StreamGobbler errorGobbler = new StreamGobbler( proc.getErrorStream(), "ERROR" );
        StreamGobbler outputGobbler = new StreamGobbler( proc.getInputStream(), "OUTPUT" );

        // start
        errorGobbler.start();
        outputGobbler.start();

        // any error???
        int exitVal = proc.waitFor();
        System.out.println( "Exit Value: " + exitVal );
        
    }
    
    /**
     * Runs ClustalO from a file and write in another the results.
     * 
     * @param readFrom File to read.
     * @param fileNameBase File to write.
     * @throws IOException
     * @throws InterruptedException 
     */
    public static void runClustalO( String readFrom, String fileNameBase ) 
            throws IOException, InterruptedException {
            
        Runtime rt = Runtime.getRuntime();
        Process proc = rt.exec( "clustal/clustalo.exe -i temp/" + readFrom + " --infmt=fasta --outfile=temp/" + fileNameBase + ".aln --outfmt=clustal --force -v" );

        StreamGobbler errorGobbler = new StreamGobbler( proc.getErrorStream(), "ERROR" );
        StreamGobbler outputGobbler = new StreamGobbler( proc.getInputStream(), "OUTPUT" );

        // start
        errorGobbler.start();
        outputGobbler.start();

        // any error???
        int exitVal = proc.waitFor();
        System.out.println( "Exit Value: " + exitVal );
        
    }
    
    /**
     * Runs ClustalW from a file and write in another the results, loggin the output
     * in a JTextArea.
     * 
     * @param readFrom File to read.
     * @param fileName File to write.
     * @param textArea JTextPane to log the output.
     * @param btnAlign Button that starts alignment process.
     * @param lblWait Label to show status.
     * @throws IOException
     * @throws InterruptedException 
     */
    public static void runClustalWUI( final String readFrom, final String fileName, final JTextPane textArea, final JButton btnAlign, final JLabel lblWait ) 
            throws IOException, InterruptedException {
        
        new Thread( new Runnable() {

            @Override
            public void run() {
                
                try {
                    
                    btnAlign.setEnabled( false );
                    lblWait.setText( "Wait, processing the alignment..." );
                    
                    Runtime rt = Runtime.getRuntime();
                    Process proc = rt.exec( "clustal/clustalw2.exe -INFILE=temp/" + readFrom + " -ALIGN -TREE -TYPE=PROTEIN -OUTORDER=INPUT -OUTFILE=temp/" + fileName + " -SEQNOS=ON" );

                    StreamGobblerUI errorGobbler = new StreamGobblerUI( proc.getErrorStream(), "ClustalW - ERROR", textArea, outError, Color.WHITE );
                    StreamGobblerUI outputGobbler = new StreamGobblerUI( proc.getInputStream(), "ClustalW - OUTPUT", textArea, outOK, Color.WHITE );

                    // start
                    errorGobbler.start();
                    outputGobbler.start();

                    // any error???
                    int exitVal = proc.waitFor();
                    if ( exitVal == 0 ) {
                        SwingUtilities.invokeLater( new JTextAreaUpdater( textArea,
                                "Output Value: " + exitVal, codeOK, Color.WHITE ) );
                    } else {
                        SwingUtilities.invokeLater( new JTextAreaUpdater( textArea,
                                "Output Value: " + exitVal, codeError, Color.WHITE ) );
                    }
                    
                    SwingUtilities.invokeLater( new SaveAlignmentFileTask( 
                            new File( "temp/" + fileName ),
                            new File( "temp/" + readFrom ),
                            new File( "temp/" + readFrom.replace( ".fasta", ".dnd" ) )));
                
                } catch ( IOException | InterruptedException exc ) {
                    Utils.showExceptionMessage( null, exc );
                } finally {
                    btnAlign.setEnabled( true );
                    lblWait.setText( " " );
                }
            }
            
        }).start();
        
    }
    
    /**
     * Runs Clustal Omega from a file and write in another the results, loggin the output
     * in a JTextArea.
     * 
     * @param readFrom File to read.
     * @param fileName File to write.
     * @param textArea JTextPane to log the output.
     * @param btnAlign Button that starts alignment process.
     * @param lblWait Label to show status.
     * @throws IOException
     * @throws InterruptedException 
     */
    public static void runClustalOUI( final String readFrom, final String fileName, final JTextPane textArea, final JButton btnAlign, final JLabel lblWait ) 
            throws IOException, InterruptedException {
        
        new Thread( new Runnable() {

            @Override
            public void run() {
                
                try {
                    
                    btnAlign.setEnabled( false );
                    lblWait.setText( "Wait, processing the alignment..." );
                    
                    Runtime rt = Runtime.getRuntime();
                    Process proc = rt.exec( "clustal/clustalo.exe -i temp/" + readFrom + " --infmt=fasta --outfile=temp/" + fileName + " --outfmt=clustal --force -v --resno" );

                    StreamGobblerUI errorGobbler = new StreamGobblerUI( proc.getErrorStream(), "Clustal Omega - ERROR", textArea, outError, Color.WHITE );
                    StreamGobblerUI outputGobbler = new StreamGobblerUI( proc.getInputStream(), "Clustal Omega - OUTPUT", textArea, outOK, Color.WHITE );

                    // start
                    errorGobbler.start();
                    outputGobbler.start();

                    // any error???
                    int exitVal = proc.waitFor();
                    if ( exitVal == 0 ) {
                        SwingUtilities.invokeLater( new JTextAreaUpdater( textArea,
                                "Output Value: " + exitVal, codeOK, Color.WHITE ) );
                    } else {
                        SwingUtilities.invokeLater( new JTextAreaUpdater( textArea,
                                "Output Value: " + exitVal, codeError, Color.WHITE ) );
                    }
                    
                    SwingUtilities.invokeLater( new SaveAlignmentFileTask( 
                            new File( "temp/" + fileName ),
                            new File( "temp/" + readFrom )));
                
                } catch ( IOException | InterruptedException exc ) {
                    Utils.showExceptionMessage( null, exc );
                } finally {
                    btnAlign.setEnabled( true );
                    lblWait.setText( " " );
                }
            }
            
        }).start();
        
    }
    
    /**
     * Runs MUSCLE from a file and write in another the results, loggin the output
     * in a JTextArea.
     * 
     * @param readFrom File to read.
     * @param fileName File to write.
     * @param textArea JTextPane to log the output.
     * @param btnAlign Button that starts alignment process.
     * @param lblWait Label to show status.
     * @throws IOException
     * @throws InterruptedException 
     */
    public static void runMUSCLEUI( final String readFrom, final String fileName, final JTextPane textArea, final JButton btnAlign, final JLabel lblWait ) 
            throws IOException, InterruptedException {
        
        new Thread( new Runnable() {

            @Override
            public void run() {
                
                try {
                    
                    btnAlign.setEnabled( false );
                    lblWait.setText( "Wait, processing the alignment..." );
                    
                    Runtime rt = Runtime.getRuntime();
                    Process proc = rt.exec( "muscle/muscle3.8.31_i86win32.exe -in temp/" + readFrom + " -clw -out temp/" + fileName );

                    // muscle output directed to stderr
                    StreamGobblerUI errorGobbler = new StreamGobblerUI( proc.getErrorStream(), "MUSCLE - OUTPUT", textArea, outOK, Color.WHITE );
                    StreamGobblerUI outputGobbler = new StreamGobblerUI( proc.getInputStream(), "MUSCLE - OUTPUT", textArea, outOK, Color.WHITE );

                    // start
                    errorGobbler.start();
                    outputGobbler.start();

                    // any error???
                    int exitVal = proc.waitFor();
                    if ( exitVal == 0 ) {
                        SwingUtilities.invokeLater( new JTextAreaUpdater( textArea,
                                "Output Value: " + exitVal, codeOK, Color.WHITE ) );
                    } else {
                        SwingUtilities.invokeLater( new JTextAreaUpdater( textArea,
                                "Output Value: " + exitVal, codeError, Color.WHITE ) );
                    }
                    
                    SwingUtilities.invokeLater( new SaveAlignmentFileTask( 
                            new File( "temp/" + fileName ),
                            new File( "temp/" + readFrom ) ));
                
                } catch ( IOException | InterruptedException exc ) {
                    Utils.showExceptionMessage( null, exc );
                } finally {
                    btnAlign.setEnabled( true );
                    lblWait.setText( " " );
                }
            }
            
        }).start();
        
    }
    
    /**
     * Runs a generic command related to multiplie alignment sequence (MSA), 
     * logging output to a JTextPane.
     * 
     * @param readFrom File name to read from (complete path)
     * @param fileName File name (without extension) to write.
     * @param fileExtension Extension of the file (represents the format generated)
     * @param fileDescription Description of the file (used to save in a JFileChooser)
     * @param command Comando que será executado.
     * @param errorPrefix Error prefix for output (stderr)
     * @param outPrefix Standard prefix for output (stdout)
     * @param outOKColor Color to use for standard output
     * @param outErrorColor Color to use for error output
     * @param codeOKColor Color to use for no error code
     * @param codeErrorColor Color to use for error code
     * @param textArea JTextPane to log the process output
     * @param lblWait Label to show the progress
     * @param btns Buttons to change state
     * @param filesToDelete Files that need to be deleted after the process execution.
     * @throws IOException
     * @throws InterruptedException 
     */
    public static void runAlignmentProgram( 
            final String readFrom,
            final String fileName,
            final String fileExtension,
            final String fileDescription,
            final String command, 
            final String outPrefix, 
            final String errorPrefix, 
            final Color outOKColor,
            final Color outErrorColor, 
            final Color codeOKColor,
            final Color codeErrorColor, 
            final JTextPane textArea,
            final JLabel lblWait,
            final JButton[] btns,
            final File... filesToDelete ) 
            throws IOException, InterruptedException {
        
        new Thread( new Runnable() {

            @Override
            public void run() {
                
                try {
                    
                    for ( JButton b : btns ) {
                        b.setEnabled( false );
                    }
                    lblWait.setText( "Wait..." );
                    
                    SwingUtilities.invokeLater( new JTextAreaUpdater( textArea,
                                "Command: " + command + "\n\n", Color.BLACK, Color.WHITE ) );
                    
                    Runtime rt = Runtime.getRuntime();
                    Process proc = rt.exec( command );

                    StreamGobblerUI outputGobbler = new StreamGobblerUI( proc.getInputStream(), outPrefix, textArea, outOKColor, Color.WHITE );
                    StreamGobblerUI errorGobbler = new StreamGobblerUI( proc.getErrorStream(), errorPrefix, textArea, outErrorColor, Color.WHITE );

                    errorGobbler.start();
                    outputGobbler.start();

                    int exitVal = proc.waitFor();
                    if ( exitVal == 0 ) {
                        SwingUtilities.invokeLater( new JTextAreaUpdater( textArea,
                                "\nOutput Value: " + exitVal + " - Process Finished Successfully!", codeOKColor, Color.WHITE ) );
                        
                        SwingUtilities.invokeLater( new SaveGeneralAlignmentFileTask( 
                                fileName,
                                fileExtension,
                                fileDescription,
                                filesToDelete ) );
                        
                    } else {
                        SwingUtilities.invokeLater( new JTextAreaUpdater( textArea,
                                "\nOutput Value: " + exitVal + " - Process Finished With Error!", codeErrorColor, Color.WHITE ) );
                    }
                
                } catch ( IOException | InterruptedException exc ) {
                    Utils.showExceptionMessage( null, exc );
                } finally {
                    for ( JButton b : btns ) {
                        b.setEnabled( true );
                    }
                    lblWait.setText( " " );
                }
            }
            
        }).start();
        
    }
    
    /**
     * A runnable to save alignment file and remove temporary files.
     */
    private static class SaveAlignmentFileTask implements Runnable {

        File fileToMove;
        File[] filesToDelete;

        SaveAlignmentFileTask( File fileToMove, File... filesToDelete ) {
            this.fileToMove = fileToMove;
            this.filesToDelete = filesToDelete;
        }

        @Override
        public void run() {

            JFileChooser jfc = new JFileChooser();
            FileNameExtensionFilter fnef = new FileNameExtensionFilter( 
                    "Clustal Alignment File (*.aln)", "aln" );

            for ( FileFilter f : jfc.getChoosableFileFilters() ) {
                jfc.removeChoosableFileFilter( f );
            }

            jfc.setFileFilter( fnef );
            jfc.setDialogTitle( "Save Alignment" );
            jfc.setFileSelectionMode( JFileChooser.FILES_ONLY );
            jfc.setMultiSelectionEnabled( false );

            if ( jfc.showSaveDialog( null ) == JFileChooser.APPROVE_OPTION ) {

                File f = jfc.getSelectedFile();

                if ( f.getName().lastIndexOf( ".aln" ) == -1 ) {
                    f = new File( f.getAbsolutePath() + ".aln" );
                }

                if ( !f.exists() || 
                        ( f.exists() && JOptionPane.showConfirmDialog( 
                          null, "O arquivo já existe. Deseja sobrescrevê-lo?", "Aviso", 
                          JOptionPane.OK_CANCEL_OPTION ) == JOptionPane.OK_OPTION ) ) {

                    f.delete();
                    fileToMove.renameTo( f );

                }

            } else {
                fileToMove.delete();
            }

            for ( File fd : filesToDelete ) {
                fd.delete();
            }

        }

    }
    
    /**
     * A runnable to save alignment file and remove temporary files.
     */
    private static class SaveGeneralAlignmentFileTask implements Runnable {

        File fileToMove;
        File[] filesToDelete;
        String fileDescription;
        String fileExtension;

        SaveGeneralAlignmentFileTask( String fileBaseName, String fileExtension, String fileDescription, File... filesToDelete ) {
            this.fileToMove = new File( fileBaseName + "." + fileExtension );
            this.filesToDelete = filesToDelete;
            this.fileDescription = fileDescription;
            this.fileExtension = fileExtension;
        }

        @Override
        public void run() {

            JFileChooser jfc = new JFileChooser();
            FileNameExtensionFilter fnef = new FileNameExtensionFilter( 
                    String.format( "%s (*.%s)", fileDescription, fileExtension ), fileExtension );

            for ( FileFilter f : jfc.getChoosableFileFilters() ) {
                jfc.removeChoosableFileFilter( f );
            }

            jfc.setFileFilter( fnef );
            jfc.setDialogTitle( "Salvar Alinhamento" );
            jfc.setFileSelectionMode( JFileChooser.FILES_ONLY );
            jfc.setMultiSelectionEnabled( false );

            if ( jfc.showSaveDialog( null ) == JFileChooser.APPROVE_OPTION ) {

                File f = jfc.getSelectedFile();

                if ( f.getName().lastIndexOf( "." + fileExtension ) == -1 ) {
                    f = new File( f.getAbsolutePath() + "." + fileExtension );
                }

                if ( !f.exists() || 
                        ( f.exists() && JOptionPane.showConfirmDialog( 
                          null, "The file already exists. Do you want to overwrite it?", "Warning", 
                          JOptionPane.OK_CANCEL_OPTION ) == JOptionPane.OK_OPTION ) ) {

                    f.delete();
                    fileToMove.renameTo( f );
                    
                    /*if ( fileExtension.equals( "aln" ) ) {
                        
                        try {
                            
                            generateAlignmentData( f, new File( "view/data.js" ), 60 );
                            
                            if ( JOptionPane.showConfirmDialog( null, "Do you want to see the alignment result?",
                                    "View Alignment", JOptionPane.OK_CANCEL_OPTION ) == JOptionPane.OK_OPTION ) {
                                
                                if ( Desktop.isDesktopSupported() ) {
                                    try {
                                        Desktop.getDesktop().browse( new File( "view/view.html" ).toURI() );
                                    } catch ( IOException exc ) {
                                        Utils.showExceptionMessage( null, exc );
                                    }
                                }
                                
                            }
                            
                        } catch ( IOException exc ) {
                            Utils.showExceptionMessage( null, exc );
                        }
                        
                    }*/
                    
                }

            } else {
                fileToMove.delete();
            }

            for ( File fd : filesToDelete ) {
                fd.delete();
            }

        }

    }
    
    /**
     * Extracts alignment data from a .aln (clustal format) file..
     * 
     * @param fileToRead Alignment file, in Clutal Format, to read.
     * @param lineLength Length of the line to generate.
     * @return A map with the data extracted data.
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static Map<String, List<String>> extractAlignmentData( File fileToRead, int lineLength ) 
            throws FileNotFoundException, IOException {
        
           
        Scanner s = new Scanner( fileToRead );
        Pattern p = Pattern.compile( "(\\w+)(["+ whitespaceChars + "]+)([\\w[-]]+)["+ whitespaceChars + "]*\\d*" );
        Map<String, String> data = new LinkedHashMap<>();
        data.put( "aln", "" );
        
        boolean start = false;
        int sizeId = 0;
        int sizeSpc = 0;
        
        while ( s.hasNextLine() ) {
            
            String line = s.nextLine();
        
            if ( start == false && line.startsWith( "Cry" ) ) {
                start = true;
            }
            
            if ( start ) {
                
                if ( !line.equals( "" ) ) {
                    
                    Matcher m = p.matcher( line.trim() );
                    
                    if ( m.matches() ) {
                        
                        String cId = m.group( 1 );
                        String aln = m.group( 3 );
                        sizeId = cId.length();
                        sizeSpc = m.group( 2 ).length();
                        
                        if ( data.containsKey( cId ) ) {
                            data.replace( cId, data.get( cId ) + aln );
                        } else {
                            data.put( cId, aln );
                        }
                        
                    } else {
                        data.replace( "aln", data.get( "aln" ) + line.substring( sizeId + sizeSpc ) );
                    }
                    
                }
                
            }
            
        }
        
        // size correction
        int max = 0;
        
        for ( Map.Entry<String, String> e : data.entrySet() ) {
            int t = e.getValue().length();
            if ( t > max ) {
                max = t;
            }
        }
        
        int tSeq = data.get( "aln" ).length();
        int dif = max - tSeq;
        
        StringBuilder sb = new StringBuilder();
        for ( int i = 0; i < dif; i++ ) {
            sb.append( " " );
        }
        
        data.replace( "aln", data.get( "aln" ) + sb.toString() );
        
        Map<String, List<String>> export = new LinkedHashMap<>();
        
        for ( Map.Entry<String, String> e : data.entrySet() ) {
            
            List<String> sequences = new ArrayList<>();
            String id = e.getKey();
            String seq = e.getValue();
            
            while ( seq.length() >= lineLength ) {
                sequences.add( seq.substring( 0, lineLength ) );
                seq = seq.substring( lineLength );
            }
            
            if ( seq.length() > 0 ) {
                sequences.add( seq );
            }
            
            export.put( id, sequences );
            
        }
        
        return export;
        
    }
    
    /**
     * Generates alignment data to be showed.
     * 
     * @param fileToRead Alignment file, in Clutal Format, to read.
     * @param fileToWrite File to write the processed alignment data.
     * @param lineLength Line length.
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static void generateAlignmentData( File fileToRead, File fileToWrite, int lineLength ) 
            throws FileNotFoundException, IOException {
        
        Map<String, List<String>> export = extractAlignmentData( fileToRead, lineLength );
        
        boolean hasData = true;
        
        try ( FileWriter fw = new FileWriter( fileToWrite ) ) {
            
            fw.write( "var data = [" );
            
            while ( hasData ) {
                
                fw.write( "{sec:[" );
                
                for ( Map.Entry<String, List<String>> e : export.entrySet() ) {

                    String id = e.getKey();
                    List<String> seq = e.getValue();

                    if ( seq.size() > 0 ) {
                        
                        fw.write( String.format( "{id:\"%s\",seq:\"%s\"},", id, seq.remove( 0 ) ) );

                    } else {
                        hasData = false;
                        break;
                    }

                }
                
                fw.write( "{id:null,seq:null}]}," );

            }
            
            fw.write( "{sec:null}];" );
            
        }
        
    }
    
    /**
     * Runs MView program to generate alignment visualization.
     * 
     * @param perlExe Path to Perl executable.
     * @param command Command to execute.
     * @param writeIn Path of the file to write htmk output.
     * @param errorPrefix Error prefix for output (stderr)
     * @param outPrefix Standard prefix for output (stdout)
     * @param outOKColor Color to use for standard output
     * @param outErrorColor Color to use for error output
     * @param codeOKColor Color to use for no error code
     * @param codeErrorColor Color to use for error code
     * @param textArea JTextPane to log the process output
     * @param lblWait Label to show the progress
     * @param btns Buttons to change state.
     * @throws IOException
     * @throws InterruptedException 
     */
    public static void runMView( 
            final String perlExe,
            final String command,
            final String writeIn, 
            final String outPrefix, 
            final String errorPrefix, 
            final Color outOKColor,
            final Color outErrorColor, 
            final Color codeOKColor,
            final Color codeErrorColor, 
            final JTextPane textArea,
            final JLabel lblWait,
            final JButton... btns ) 
            throws IOException, InterruptedException {
        
        new Thread( new Runnable() {

            @Override
            public void run() {
                
                try {
                    
                    for ( JButton b : btns ) {
                        b.setEnabled( false );
                    }
                    lblWait.setText( "Wait..." );
                    
                    SwingUtilities.invokeLater( new JTextAreaUpdater( textArea,
                                "Command: " + command + "\n\n", Color.BLACK, Color.WHITE ) );
                    
                    ProcessBuilder pb = new ProcessBuilder( command );
                    pb.directory( new File( "mview/bin" ) );
                    Process proc = pb.start();

                    StreamGobblerUI outputGobbler = new StreamGobblerUI( proc.getInputStream(), outPrefix, textArea, outOKColor, Color.WHITE, new FileOutputStream( new File( writeIn ) ) );
                    StreamGobblerUI errorGobbler = new StreamGobblerUI( proc.getErrorStream(), errorPrefix, textArea, outErrorColor, Color.WHITE );

                    errorGobbler.start();
                    outputGobbler.start();

                    int exitVal = proc.waitFor();
                    if ( exitVal == 0 ) {
                        SwingUtilities.invokeLater( new JTextAreaUpdater( textArea,
                                "\nOutput Value: " + exitVal + " - Process Finished Successfully!", codeOKColor, Color.WHITE ) );
                        if ( Desktop.isDesktopSupported() ) {
                            try {
                                Desktop.getDesktop().browse( new File( writeIn ).toURI() );
                            } catch ( IOException exc ) {
                                Utils.showExceptionMessage( null, exc );
                            }
                        }
                    } else {
                        SwingUtilities.invokeLater( new JTextAreaUpdater( textArea,
                                "\nOutput Value: " + exitVal + " - Process Finished With Error!", codeErrorColor, Color.WHITE ) );
                    }
                
                } catch ( IOException | InterruptedException exc ) {
                    Utils.showExceptionMessage( null, exc );
                } finally {
                    for ( JButton b : btns ) {
                        b.setEnabled( true );
                    }
                    lblWait.setText( " " );
                }
            }
            
        }).start();
        
    }
    
    /**
     * Recursively deletes a directory.
     * 
     * @param dir  Directory to delete.
     */
    public static void recursiveDelete( File dir ) {
        
        if ( dir.isFile() ) {
            dir.delete();
        } else {
            for ( File fr : dir.listFiles() ) {
                recursiveDelete( fr );
            }
            dir.delete();
        }
        
    }
    
}
