/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package crygetter.gui;

/**
 * A class to represent a difference between two aminoacids.
 * 
 * @author David Buzatto
 */
public class AminoacidDifference {
    
    char aa1;
    char aa2;
    int position;
    
    public AminoacidDifference( char aa1, char aa2, int position ) {
        this.aa1 = aa1;
        this.aa2 = aa2;
        this.position = position;
    }

    @Override
    public String toString() {
        return "AminoacidDifference{" + "aa1=" + aa1 + ", aa2=" + aa2 + ", position=" + position + '}';
    }
    
}
