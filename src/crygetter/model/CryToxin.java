/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package crygetter.model;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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
    
    public transient String proteinSequence;
    public transient String proteinSequenceInterval;
    public transient String proteinSequenceName;
    public transient List<CryToxinDomain> domains = new ArrayList<>();
    
    //public transient Color classColor = new Color( 172, 204, 234 );
    public transient Color classColor = Color.WHITE;
    public transient String proteinClass = "";
    
    public CryToxinDomain getDomain( int domainNumber ) {
        return domains.get( domainNumber - 1 );
    }
    
    public String getDomainInterval( int domainNumber ) {
        CryToxinDomain domain = domains.get( domainNumber - 1 );
        SequenceInterval interval = domain.interval;
        return interval.start + ".." + interval.end;
    }
    
    public String getDomainSequence( int domainNumber ) {
        CryToxinDomain domain = domains.get( domainNumber - 1 );
        SequenceInterval interval = domain.interval;
        return proteinSequence.substring( interval.start - 1, interval.end );
    }

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
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode( this.name );
        return hash;
    }

    @Override
    public boolean equals( Object obj ) {
        if ( obj == null ) {
            return false;
        }
        if ( getClass() != obj.getClass() ) {
            return false;
        }
        final CryToxin other = (CryToxin) obj;
        if ( !Objects.equals( this.name, other.name ) ) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return name;
    }
    
}
