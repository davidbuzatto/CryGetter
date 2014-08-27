/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package crygetter.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Class to represent amino acids.
 * 
 * @author David Buzatto
 */
public class AminoAcid {
    
    public String name;
    public String threeLetter;
    public String oneLetter;
    public String group;
    public String sideChainGroup;
    public String sideChainPolarity;
    public String sideChainCharge;
    public String hydropathyIndex;
    public String molecularMass;
    public String vanderWaalsVolume;
    public String frequencyInProteins;
    public String surfaceArea;
    public List<String> observations;
    public String pdbFile;
    public String pngFile;

    public AminoAcid() {
        observations = new ArrayList<>();
    }
    
    @Override
    public String toString() {
        return "AminoAcid{" + "name=" + name + ", threeLetter=" + threeLetter + ", oneLetter=" + oneLetter + ", sideChainPolarity=" + sideChainPolarity + ", sideChainCharge=" + sideChainCharge + ", hydropathyIndex=" + hydropathyIndex + ", pdbFile=" + pdbFile + ", pngFile=" + pngFile + '}';
    }
    
}
