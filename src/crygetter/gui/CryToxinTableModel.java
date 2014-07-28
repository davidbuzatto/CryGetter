/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package crygetter.gui;

import javax.swing.table.DefaultTableModel;

/**
 * Table model for Cry Toxin Table.
 * 
 * @author David Buzatto
 */
public class CryToxinTableModel extends DefaultTableModel {

    public CryToxinTableModel( Object[] columnNames, int rowCount ) {
        super( columnNames, rowCount );
    }

    @Override
    public Class<?> getColumnClass( int columnIndex ) {
        return getValueAt( 0, columnIndex ).getClass();
    }

    @Override
    public boolean isCellEditable( int row, int column ) {
        return column == 2;
    }
    
}
