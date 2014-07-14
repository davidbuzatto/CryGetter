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
    "gbAltSeqItem"
})
@XmlRootElement(name = "GBAltSeqData_items")
public class GBAltSeqDataItems {

    @XmlElement(name = "GBAltSeqItem")
    protected List<GBAltSeqItem> gbAltSeqItem;

    /**
     * Gets the value of the gbAltSeqItem property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the gbAltSeqItem property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGBAltSeqItem().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GBAltSeqItem }
     * 
     * 
     */
    public List<GBAltSeqItem> getGBAltSeqItem() {
        if (gbAltSeqItem == null) {
            gbAltSeqItem = new ArrayList<GBAltSeqItem>();
        }
        return this.gbAltSeqItem;
    }

}
