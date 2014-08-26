/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package crygetter.model;

/**
 * Class to represent amino acids.
 * 
 * @author David Buzatto
 */
public class AminoAcid {
    
    public String name;
    public String threeLetter;
    public String oneLetter;
    public String sideChainPolarity;
    public String sideChainCharge;
    public String hydropathyIndex;
    public String pdbFile;
    public String pngFile;

    @Override
    public String toString() {
        return "AminoAcid{" + "name=" + name + ", threeLetter=" + threeLetter + ", oneLetter=" + oneLetter + ", sideChainPolarity=" + sideChainPolarity + ", sideChainCharge=" + sideChainCharge + ", hydropathyIndex=" + hydropathyIndex + ", pdbFile=" + pdbFile + ", pngFile=" + pngFile + '}';
    }
    
}
