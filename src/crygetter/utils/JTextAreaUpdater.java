/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package crygetter.utils;

import java.awt.Color;
import javax.swing.JTextPane;

/**
 * A Runnable to update JTextPanes, appending lines.
 * 
 * @author David Buzatto
 */
public class JTextAreaUpdater implements Runnable {

    private JTextPane textArea;
    private String newLine;
    private Color textColor;
    private Color backgroundTextColor;

    public JTextAreaUpdater( JTextPane textArea, String newLine, Color textColor, Color backgroundTextColor ) {
        this.textArea = textArea;
        this.newLine = newLine;
        this.textColor = textColor;
        this.backgroundTextColor = backgroundTextColor;
    }

    @Override
    public void run() {
        Utils.appendToPane( textArea, newLine, textColor, backgroundTextColor );
    }

}
