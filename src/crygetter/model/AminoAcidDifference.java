/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package crygetter.model;

/**
 * A class to represent a difference between two amino acids.
 * 
 * @author David Buzatto
 */
public class AminoAcidDifference {
    
    public char aa1;
    public char aa2;
    public int position;
    public char conservativeStatus;
    
    public AminoAcidDifference( char aa1, char aa2, int position, char conservativeStatus ) {
        this.aa1 = aa1;
        this.aa2 = aa2;
        this.position = position;
        this.conservativeStatus = conservativeStatus;
    }

    @Override
    public String toString() {
        return String.format( "%4d: %c %c   (%c)", position, aa1, aa2, conservativeStatus );
    }
    
}
