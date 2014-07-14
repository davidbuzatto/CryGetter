/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package crygetter.model;

/**
 * Models a cry toxin general data obtained from BtNomenclature.info
 * 
 * @author David Buzatto
 */
public class CryToxin {
    
    public String name;
    public String accessionNo;
    public String ncbiProtein;
    public String ncbiNucleotide;
    public String authors;
    public String year;
    public String sourceStrain;
    public String comment;
    public String ncbiURL;
    public String ncbiURL2;

    @Override
    public String toString() {
        return "CryToxin{" + "name=" + name + ", accessionNo=" + accessionNo + ", ncbiProtein=" + ncbiProtein + ", ncbiNucleotide=" + ncbiNucleotide + ", authors=" + authors + ", year=" + year + ", sourceStrain=" + sourceStrain + ", comment=" + comment + ", ncbiURL=" + ncbiURL + ", ncbiURL2=" + ncbiURL2 + '}';
    }
    
}
