/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package crygetter.gui;

import crygetter.model.CryToxin;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 * A customized list cell renderer to show cry proteins classes.
 * 
 * @author David Buzatto
 */
public class CryToxinListCellRenderer extends JLabel implements ListCellRenderer<CryToxin> {

    @Override
    public Component getListCellRendererComponent( JList<? extends CryToxin> list, CryToxin value, int index, boolean isSelected, boolean cellHasFocus ) {
        
        if ( isSelected ) {
            setBackground( value.classColor.darker() );
            setForeground( value.classColor.brighter() );
        } else {
            setBackground( value.classColor );
            setForeground( list.getForeground() );
        }
        
        setText( value.toString() );
        setEnabled( list.isEnabled() );
        setFont( list.getFont() );
        setOpaque( true );
        
        return this;
        
    }
    
}
