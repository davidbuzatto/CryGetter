/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package crygetter.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Models a cry toxin general data obtained from BtNomenclature.info
 * 
 * @author David Buzatto
 */
@Root( name = "CryToxin" )
public class CryToxin {
    
    @Element( required = false )
    public String name;
    
    @Element( required = false )
    public String accessionNo;
    
    @Element( required = false )
    public String ncbiProtein;
    
    @Element( required = false )
    public String ncbiNucleotide;
    
    @Element( required = false )
    public String authors;
    
    @Element( required = false )
    public String year;
    
    @Element( required = false )
    public String sourceStrain;
    
    @Element( required = false )
    public String comment;
    
    @Element( required = false )
    public String ncbiURL;
    
    @Element( required = false )
    public String ncbiURL2;

    public boolean hasNCBIData() {
        return ncbiProtein != null;
    }
    
    public String detail() {
        return "CryToxin{" + "name=" + name + ", accessionNo=" + accessionNo + 
                ", ncbiProtein=" + ncbiProtein + ", ncbiNucleotide=" + 
                ncbiNucleotide + ", authors=" + authors + ", year=" + 
                year + ", sourceStrain=" + sourceStrain + ", comment=" + 
                comment + ", ncbiURL=" + ncbiURL + ", ncbiURL2=" + ncbiURL2 + '}';
    }
    
    @Override
    public String toString() {
        return name;
    }
    
}
