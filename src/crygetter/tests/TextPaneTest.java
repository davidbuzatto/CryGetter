/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crygetter.tests;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;

public class TextPaneTest extends JFrame {

    private JPanel topPanel;
    private JTextPane tPane;
    private JTextField tfield;
    private int counter;
    private Color[] colours = {
        Color.RED,
        Color.BLUE,
        Color.DARK_GRAY,
        Color.PINK,
        Color.BLACK,
        Color.MAGENTA,
        Color.YELLOW,
        Color.ORANGE
    };

    public TextPaneTest() {
        setSize( 400, 400 );
        counter = 0;
    }

    private void createAndDisplayGUI() {
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

        EmptyBorder eb = new EmptyBorder( new Insets( 10, 10, 10, 10 ) );

        tPane = new JTextPane();
        tPane.setBorder( eb );
        tPane.setMargin( new Insets( 5, 5, 5, 5 ) );
        JScrollPane scroller = new JScrollPane();
        scroller.setViewportView( tPane );

        tfield = new JTextField();
        tfield.addActionListener( new ActionListener() {
            public void actionPerformed( ActionEvent ae ) {
                counter++;
                if ( counter == 8 ) {
                    counter = 0;
                }
                String text = tfield.getText() + "\n";
                appendToPane( tPane, text, colours[counter] );
                tfield.selectAll();
            }
        } );

        getContentPane().add( scroller, BorderLayout.CENTER );
        getContentPane().add( tfield, BorderLayout.PAGE_END );

        setSize( 200, 100 );
        setVisible( true );
        tfield.requestFocusInWindow();
    }

    private void appendToPane( JTextPane tp, String msg, Color c ) {
        
        StyleContext sc = StyleContext.getDefaultStyleContext();
        AttributeSet aset = sc.addAttribute( SimpleAttributeSet.EMPTY, StyleConstants.Background, c );

        //aset = sc.addAttribute( aset, StyleConstants.FontFamily, "Lucida Console" );
        //aset = sc.addAttribute( aset, StyleConstants.Alignment, StyleConstants.ALIGN_JUSTIFIED );

        int len = tp.getDocument().getLength();
        tp.setCaretPosition( len );
        tp.setCharacterAttributes( aset, false );
        tp.replaceSelection( msg );
        
    }

    public static void main( String... args ) {
        SwingUtilities.invokeLater( new Runnable() {
            public void run() {
                new TextPaneTest().createAndDisplayGUI();
            }
        } );
    }
}
