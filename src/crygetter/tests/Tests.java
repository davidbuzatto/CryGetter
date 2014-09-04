/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package crygetter.tests;

import crygetter.utils.StreamGobbler;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;

/**
 * A simple test class to do experiences.
 * 
 * @author David Buzatto
 */
public class Tests {
    
    public static void main( String[] args ) throws Exception {
        
        
        String alignmentColoring = "identity";   // NONE, identity, any, consensus, grup
        String alignmentColorMap = "NONE";       // NONE, CCLUSTAL, CLUSTAL, CHARGE, CYS, DC1, GPCR, HXLIN, NARDI, P1, PC1, POLAR1
        String alignmentGroupMap = "NONE";       // NONE, CYS, P1
        String consensusColoring = "any";        // NONE, identity, any
        String consensusColorMap = "NONE";       // NONE, CCLUSTAL, CLUSTAL, CHARGE, CYS, DC1, GPCR, HXLIN, NARDI, P1, PC1, POLAR1
        String consensusGroupMap = "NONE";       // NONE, CYS, P1
        
        String perlExe = "C:/perl/perl/bin/perl.exe";
        String baseCommand = "mview -in clustal -ruler on -html head -bold -consensus on -css on -width 60";
        String input = "C:/Users/David/Desktop/a.aln";
        
        String otherParameters = "";
        
        if ( !alignmentColoring.equals( "NONE" ) ) {
            otherParameters += "-coloring " + alignmentColoring;
        }
        
        if ( !alignmentColorMap.equals( "NONE" ) ) {
            otherParameters += "-colormap " + alignmentColorMap;
        }
        
        if ( !alignmentGroupMap.equals( "NONE" ) ) {
            otherParameters += "-groupmap " + alignmentGroupMap;
        }
        
        if ( !consensusColoring.equals( "NONE" ) ) {
            otherParameters += "-con_coloring " + consensusColoring;
        }
        
        if ( !consensusColorMap.equals( "NONE" ) ) {
            otherParameters += "-con_colormap " + consensusColorMap;
        }
        
        if ( !consensusGroupMap.equals( "NONE" ) ) {
            otherParameters += "-con_groupmap " + consensusGroupMap;
        }
        
        ProcessBuilder pb = new ProcessBuilder( String.format( "\"%s\" %s %s \"%s\"", perlExe, baseCommand, otherParameters, input ) );
        pb.directory( new File( "mview/bin" ) );
        Process p = pb.start();
        
        StreamGobbler sgError = new StreamGobbler( p.getErrorStream(), "MView ERROR" );
        StreamGobbler sgOk = new StreamGobbler( p.getInputStream(), "MView OK", new FileOutputStream( new File( "view/mview.html" ) ) );
        
        sgError.start();
        sgOk.start();
        
        
    }
    
}
