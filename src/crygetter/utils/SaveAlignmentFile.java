/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package crygetter.utils;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * A Runnable to sabe alignment file and clean up temp folder.
 * 
 * @author David Buzatto
 */
public class SaveAlignmentFile implements Runnable {

    private File fileToMove;
    private File[] filesToDelete;
    
    public SaveAlignmentFile( File fileToMove, File... filesToDelete ) {
        this.fileToMove = fileToMove;
        this.filesToDelete = filesToDelete;
    }
    
    @Override
    public void run() {
        
        JFileChooser jfc = new JFileChooser();
        FileNameExtensionFilter fnef = new FileNameExtensionFilter( 
                "Arquivo de Alinhamento Clustal (*.aln)", "aln" );

        for ( FileFilter f : jfc.getChoosableFileFilters() ) {
            jfc.removeChoosableFileFilter( f );
        }

        jfc.setFileFilter( fnef );
        jfc.setDialogTitle( "Salvar Alinhamento" );
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
