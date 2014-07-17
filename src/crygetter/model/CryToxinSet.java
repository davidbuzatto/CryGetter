/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package crygetter.model;

import java.util.List;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

/**
 * A CryToxin set.
 * 
 * @author David Buzatto
 */
@Root( name = "CryToxinSet" )
public class CryToxinSet {

    @ElementList( inline = true )
    public List<CryToxin> cryToxins;
    
}
