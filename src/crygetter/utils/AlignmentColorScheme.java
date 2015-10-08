/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crygetter.utils;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author David
 */
public class AlignmentColorScheme {
    
    public static final Map<ResultColorScheme, Map<Character, Color>> colorMap = new HashMap<>();
    
    public enum ResultColorScheme {
        CLUSTALX,
        HELYX_PROPENSITY,
        STRAND_PROPENSITY,
        TURN_PROPENSITY,
        HYDROPHOBICITY,
        TAYLOR,
        ZAPPO,
        BURIED_INDEX
    }
    
    static {
        
        HashMap<Character, Color> clustalMap = new HashMap<>();
        HashMap<Character, Color> helyxMap = new HashMap<>();
        HashMap<Character, Color> strandMap = new HashMap<>();
        HashMap<Character, Color> turnMap = new HashMap<>();
        HashMap<Character, Color> hydroMap = new HashMap<>();
        HashMap<Character, Color> taylorMap = new HashMap<>();
        HashMap<Character, Color> zappoMap = new HashMap<>();
        HashMap<Character, Color> buriedMap = new HashMap<>();
        
        colorMap.put( ResultColorScheme.CLUSTALX, clustalMap );
        colorMap.put( ResultColorScheme.HELYX_PROPENSITY, helyxMap );
        colorMap.put( ResultColorScheme.STRAND_PROPENSITY, strandMap );
        colorMap.put( ResultColorScheme.TURN_PROPENSITY, turnMap );
        colorMap.put( ResultColorScheme.HYDROPHOBICITY, hydroMap );
        colorMap.put( ResultColorScheme.TAYLOR, taylorMap );
        colorMap.put( ResultColorScheme.ZAPPO, zappoMap );
        colorMap.put( ResultColorScheme.BURIED_INDEX, buriedMap );
        
        clustalMap.put( 'A', Utils.hexToColor( "#80B3E6" ) );
        clustalMap.put( 'R', Utils.hexToColor( "#E6331A" ) );
        clustalMap.put( 'N', Utils.hexToColor( "#1ACC1A" ) );
        clustalMap.put( 'D', Utils.hexToColor( "#CC4DCC" ) );
        clustalMap.put( 'C', Utils.hexToColor( "#80B3E6" ) );
        clustalMap.put( 'E', Utils.hexToColor( "#CC4DCC" ) );
        clustalMap.put( 'Q', Utils.hexToColor( "#1ACC1A" ) );
        clustalMap.put( 'G', Utils.hexToColor( "#E6994D" ) );
        clustalMap.put( 'H', Utils.hexToColor( "#1AB3B3" ) );
        clustalMap.put( 'I', Utils.hexToColor( "#80B3E6" ) );
        clustalMap.put( 'L', Utils.hexToColor( "#80B3E6" ) );
        clustalMap.put( 'K', Utils.hexToColor( "#E6331A" ) );
        clustalMap.put( 'M', Utils.hexToColor( "#80B3E6" ) );
        clustalMap.put( 'F', Utils.hexToColor( "#80B3E6" ) );
        clustalMap.put( 'P', Utils.hexToColor( "#CCCC00" ) );
        clustalMap.put( 'S', Utils.hexToColor( "#1ACC1A" ) );
        clustalMap.put( 'T', Utils.hexToColor( "#1ACC1A" ) );
        clustalMap.put( 'W', Utils.hexToColor( "#80B3E6" ) );
        clustalMap.put( 'Y', Utils.hexToColor( "#1AB3B3" ) );
        clustalMap.put( 'V', Utils.hexToColor( "#80B3E6" ) );
        clustalMap.put( '-', Color.WHITE );
        
        helyxMap.put( 'A', Utils.hexToColor( "#E718E7" ) );
        helyxMap.put( 'R', Utils.hexToColor( "#6F906F" ) );
        helyxMap.put( 'N', Utils.hexToColor( "#1BE41B" ) );
        helyxMap.put( 'D', Utils.hexToColor( "#778877" ) );
        helyxMap.put( 'C', Utils.hexToColor( "#23DC23" ) );
        helyxMap.put( 'E', Utils.hexToColor( "#FF00FF" ) );
        helyxMap.put( 'Q', Utils.hexToColor( "#926D92" ) );
        helyxMap.put( 'G', Utils.hexToColor( "#01FF00" ) );
        helyxMap.put( 'H', Utils.hexToColor( "#758A75" ) );
        helyxMap.put( 'I', Utils.hexToColor( "#8A758A" ) );
        helyxMap.put( 'L', Utils.hexToColor( "#AE51AE" ) );
        helyxMap.put( 'K', Utils.hexToColor( "#A05FA0" ) );
        helyxMap.put( 'M', Utils.hexToColor( "#EF10EF" ) );
        helyxMap.put( 'F', Utils.hexToColor( "#986798" ) );
        helyxMap.put( 'P', Utils.hexToColor( "#01FF00" ) );
        helyxMap.put( 'S', Utils.hexToColor( "#36C936" ) );
        helyxMap.put( 'T', Utils.hexToColor( "#47B847" ) );
        helyxMap.put( 'W', Utils.hexToColor( "#8A758A" ) );
        helyxMap.put( 'Y', Utils.hexToColor( "#21DE21" ) );
        helyxMap.put( 'V', Utils.hexToColor( "#857A85" ) );
        helyxMap.put( '-', Color.WHITE );
        
        strandMap.put( 'A', Utils.hexToColor( "#5858A7" ) );
        strandMap.put( 'R', Utils.hexToColor( "#6B6B94" ) );
        strandMap.put( 'N', Utils.hexToColor( "#64649B" ) );
        strandMap.put( 'D', Utils.hexToColor( "#2121DE" ) );
        strandMap.put( 'C', Utils.hexToColor( "#9D9D62" ) );
        strandMap.put( 'E', Utils.hexToColor( "#0000FF" ) );
        strandMap.put( 'Q', Utils.hexToColor( "#8C8C73" ) );
        strandMap.put( 'G', Utils.hexToColor( "#4949B6" ) );
        strandMap.put( 'H', Utils.hexToColor( "#60609F" ) );
        strandMap.put( 'I', Utils.hexToColor( "#ECEC13" ) );
        strandMap.put( 'L', Utils.hexToColor( "#B2B24D" ) );
        strandMap.put( 'K', Utils.hexToColor( "#4747B8" ) );
        strandMap.put( 'M', Utils.hexToColor( "#82827D" ) );
        strandMap.put( 'F', Utils.hexToColor( "#C2C23D" ) );
        strandMap.put( 'P', Utils.hexToColor( "#2323DC" ) );
        strandMap.put( 'S', Utils.hexToColor( "#4949B6" ) );
        strandMap.put( 'T', Utils.hexToColor( "#9D9D62" ) );
        strandMap.put( 'W', Utils.hexToColor( "#C0C03F" ) );
        strandMap.put( 'Y', Utils.hexToColor( "#D3D32C" ) );
        strandMap.put( 'V', Utils.hexToColor( "#FFFF00" ) );
        strandMap.put( '-', Color.WHITE );

        turnMap.put( 'A', Utils.hexToColor( "#2CD3D3" ) );
        turnMap.put( 'R', Utils.hexToColor( "#708F8F" ) );
        turnMap.put( 'N', Utils.hexToColor( "#FF0000" ) );
        turnMap.put( 'D', Utils.hexToColor( "#E81717" ) );
        turnMap.put( 'C', Utils.hexToColor( "#A85757" ) );
        turnMap.put( 'E', Utils.hexToColor( "#3FC0C0" ) );
        turnMap.put( 'Q', Utils.hexToColor( "#778888" ) );
        turnMap.put( 'G', Utils.hexToColor( "#FF0000" ) );
        turnMap.put( 'H', Utils.hexToColor( "#708F8F" ) );
        turnMap.put( 'I', Utils.hexToColor( "#01FFFF" ) );
        turnMap.put( 'L', Utils.hexToColor( "#1CE3E3" ) );
        turnMap.put( 'K', Utils.hexToColor( "#7E8181" ) );
        turnMap.put( 'M', Utils.hexToColor( "#1EE1E1" ) );
        turnMap.put( 'F', Utils.hexToColor( "#1EE1E1" ) );
        turnMap.put( 'P', Utils.hexToColor( "#F60909" ) );
        turnMap.put( 'S', Utils.hexToColor( "#E11E1E" ) );
        turnMap.put( 'T', Utils.hexToColor( "#738C8C" ) );
        turnMap.put( 'W', Utils.hexToColor( "#738C8C" ) );
        turnMap.put( 'Y', Utils.hexToColor( "#9D6262" ) );
        turnMap.put( 'V', Utils.hexToColor( "#08F8F8" ) );
        turnMap.put( '-', Color.WHITE );

        hydroMap.put( 'A', Utils.hexToColor( "#AD0052" ) );
        hydroMap.put( 'R', Utils.hexToColor( "#0000FF" ) );
        hydroMap.put( 'N', Utils.hexToColor( "#0C00F3" ) );
        hydroMap.put( 'D', Utils.hexToColor( "#0C00F3" ) );
        hydroMap.put( 'C', Utils.hexToColor( "#C2003D" ) );
        hydroMap.put( 'E', Utils.hexToColor( "#0C00F3" ) );
        hydroMap.put( 'Q', Utils.hexToColor( "#0C00F3" ) );
        hydroMap.put( 'G', Utils.hexToColor( "#6A0095" ) );
        hydroMap.put( 'H', Utils.hexToColor( "#1500EA" ) );
        hydroMap.put( 'I', Utils.hexToColor( "#FF0000" ) );
        hydroMap.put( 'L', Utils.hexToColor( "#EA0015" ) );
        hydroMap.put( 'K', Utils.hexToColor( "#0000FF" ) );
        hydroMap.put( 'M', Utils.hexToColor( "#B0004F" ) );
        hydroMap.put( 'F', Utils.hexToColor( "#CB0034" ) );
        hydroMap.put( 'P', Utils.hexToColor( "#4600B9" ) );
        hydroMap.put( 'S', Utils.hexToColor( "#5E00A1" ) );
        hydroMap.put( 'T', Utils.hexToColor( "#61009E" ) );
        hydroMap.put( 'W', Utils.hexToColor( "#5B00A4" ) );
        hydroMap.put( 'Y', Utils.hexToColor( "#4F00B0" ) );
        hydroMap.put( 'V', Utils.hexToColor( "#F60009" ) );
        hydroMap.put( '-', Color.WHITE );

        taylorMap.put( 'A', Utils.hexToColor( "#CCFF00" ) );
        taylorMap.put( 'R', Utils.hexToColor( "#0000FF" ) );
        taylorMap.put( 'N', Utils.hexToColor( "#CC00FF" ) );
        taylorMap.put( 'D', Utils.hexToColor( "#FF0000" ) );
        taylorMap.put( 'C', Utils.hexToColor( "#FFFF00" ) );
        taylorMap.put( 'E', Utils.hexToColor( "#FF0066" ) );
        taylorMap.put( 'Q', Utils.hexToColor( "#FF00CC" ) );
        taylorMap.put( 'G', Utils.hexToColor( "#FF9900" ) );
        taylorMap.put( 'H', Utils.hexToColor( "#0066FF" ) );
        taylorMap.put( 'I', Utils.hexToColor( "#66FF00" ) );
        taylorMap.put( 'L', Utils.hexToColor( "#33FF00" ) );
        taylorMap.put( 'K', Utils.hexToColor( "#6600FF" ) );
        taylorMap.put( 'M', Utils.hexToColor( "#01FF00" ) );
        taylorMap.put( 'F', Utils.hexToColor( "#01FF66" ) );
        taylorMap.put( 'P', Utils.hexToColor( "#FFCC00" ) );
        taylorMap.put( 'S', Utils.hexToColor( "#FF3300" ) );
        taylorMap.put( 'T', Utils.hexToColor( "#FF6600" ) );
        taylorMap.put( 'W', Utils.hexToColor( "#00CCFF" ) );
        taylorMap.put( 'Y', Utils.hexToColor( "#01FFCC" ) );
        taylorMap.put( 'V', Utils.hexToColor( "#99FF00" ) );
        taylorMap.put( '-', Color.WHITE );

        zappoMap.put( 'A', Utils.hexToColor( "#FFAFAF" ) );
        zappoMap.put( 'R', Utils.hexToColor( "#6464FF" ) );
        zappoMap.put( 'N', Utils.hexToColor( "#01FF00" ) );
        zappoMap.put( 'D', Utils.hexToColor( "#FF0000" ) );
        zappoMap.put( 'C', Utils.hexToColor( "#FFFF00" ) );
        zappoMap.put( 'E', Utils.hexToColor( "#FF0000" ) );
        zappoMap.put( 'Q', Utils.hexToColor( "#01FF00" ) );
        zappoMap.put( 'G', Utils.hexToColor( "#FF00FF" ) );
        zappoMap.put( 'H', Utils.hexToColor( "#6464FF" ) );
        zappoMap.put( 'I', Utils.hexToColor( "#FFAFAF" ) );
        zappoMap.put( 'L', Utils.hexToColor( "#FFAFAF" ) );
        zappoMap.put( 'K', Utils.hexToColor( "#6464FF" ) );
        zappoMap.put( 'M', Utils.hexToColor( "#FFAFAF" ) );
        zappoMap.put( 'F', Utils.hexToColor( "#FFC800" ) );
        zappoMap.put( 'P', Utils.hexToColor( "#FF00FF" ) );
        zappoMap.put( 'S', Utils.hexToColor( "#01FF00" ) );
        zappoMap.put( 'T', Utils.hexToColor( "#01FF00" ) );
        zappoMap.put( 'W', Utils.hexToColor( "#FFC800" ) );
        zappoMap.put( 'Y', Utils.hexToColor( "#FFC800" ) );
        zappoMap.put( 'V', Utils.hexToColor( "#FFAFAF" ) );
        zappoMap.put( '-', Color.WHITE );

        buriedMap.put( 'A', Utils.hexToColor( "#00A35C" ) );
        buriedMap.put( 'R', Utils.hexToColor( "#01FC03" ) );
        buriedMap.put( 'N', Utils.hexToColor( "#01EB14" ) );
        buriedMap.put( 'D', Utils.hexToColor( "#01EB14" ) );
        buriedMap.put( 'C', Utils.hexToColor( "#0000FF" ) );
        buriedMap.put( 'E', Utils.hexToColor( "#01F10E" ) );
        buriedMap.put( 'Q', Utils.hexToColor( "#01F10E" ) );
        buriedMap.put( 'G', Utils.hexToColor( "#009D62" ) );
        buriedMap.put( 'H', Utils.hexToColor( "#00D52A" ) );
        buriedMap.put( 'I', Utils.hexToColor( "#0054AB" ) );
        buriedMap.put( 'L', Utils.hexToColor( "#007B84" ) );
        buriedMap.put( 'K', Utils.hexToColor( "#01FF00" ) );
        buriedMap.put( 'M', Utils.hexToColor( "#009768" ) );
        buriedMap.put( 'F', Utils.hexToColor( "#008778" ) );
        buriedMap.put( 'P', Utils.hexToColor( "#01E01F" ) );
        buriedMap.put( 'S', Utils.hexToColor( "#00D52A" ) );
        buriedMap.put( 'T', Utils.hexToColor( "#00DB24" ) );
        buriedMap.put( 'W', Utils.hexToColor( "#00A857" ) );
        buriedMap.put( 'Y', Utils.hexToColor( "#01E619" ) );
        buriedMap.put( 'V', Utils.hexToColor( "#005FA0" ) );
        buriedMap.put( '-', Color.WHITE );
        
    }
    
}
