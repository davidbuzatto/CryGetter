/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package crygetter.gui;

import crygetter.model.CryToxin;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;

/**
 * Cry Toxin table cell renderer.
 * 
 * @author David Buzatto
 */
public class CryToxinTableCellRender extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent( JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column ) {
        
        CryToxin ct = (CryToxin) table.getModel().getValueAt( row, 0 );
        Boolean alinhar = (Boolean) table.getModel().getValueAt( row, 2 );
        
        if ( isSelected ) {
            setBackground( ct.classColor.darker() );
            setForeground( ct.classColor.brighter() );
        } else {
            setBackground( ct.classColor );
            setForeground( table.getForeground() );
        }
        
        if ( alinhar ) {
            setBackground( ct.classColor.darker().darker() );
            setForeground( ct.classColor.brighter() );
        }
        
        setBorder( new LineBorder( ct.classColor.darker() ) );
        setText( value.toString() );
        setEnabled( table.isEnabled() );
        setFont( table.getFont() );
        setOpaque( true );

        return this;
        
    }
    
}
