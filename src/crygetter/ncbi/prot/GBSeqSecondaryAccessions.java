//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.2.8-b130911.1802 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2014.07.14 às 04:02:13 PM BRT 
//


package crygetter.ncbi.prot;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "gbSecondaryAccn"
})
@XmlRootElement(name = "GBSeq_secondary-accessions")
public class GBSeqSecondaryAccessions {

    @XmlElement(name = "GBSecondary-accn")
    protected List<GBSecondaryAccn> gbSecondaryAccn;

    /**
     * Gets the value of the gbSecondaryAccn property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the gbSecondaryAccn property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGBSecondaryAccn().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GBSecondaryAccn }
     * 
     * 
     */
    public List<GBSecondaryAccn> getGBSecondaryAccn() {
        if (gbSecondaryAccn == null) {
            gbSecondaryAccn = new ArrayList<GBSecondaryAccn>();
        }
        return this.gbSecondaryAccn;
    }

}
