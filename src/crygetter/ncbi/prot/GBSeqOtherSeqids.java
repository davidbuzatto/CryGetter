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
    "gbSeqid"
})
@XmlRootElement(name = "GBSeq_other-seqids")
public class GBSeqOtherSeqids {

    @XmlElement(name = "GBSeqid")
    protected List<GBSeqid> gbSeqid;

    /**
     * Gets the value of the gbSeqid property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the gbSeqid property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGBSeqid().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GBSeqid }
     * 
     * 
     */
    public List<GBSeqid> getGBSeqid() {
        if (gbSeqid == null) {
            gbSeqid = new ArrayList<GBSeqid>();
        }
        return this.gbSeqid;
    }

}
