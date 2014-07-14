//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.2.8-b130911.1802 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2014.07.14 às 04:02:13 PM BRT 
//


package crygetter.ncbi.prot;

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
    "gbAltSeqDataName",
    "gbAltSeqDataItems"
})
@XmlRootElement(name = "GBAltSeqData")
public class GBAltSeqData {

    @XmlElement(name = "GBAltSeqData_name", required = true)
    protected String gbAltSeqDataName;
    @XmlElement(name = "GBAltSeqData_items")
    protected GBAltSeqDataItems gbAltSeqDataItems;

    /**
     * Obtém o valor da propriedade gbAltSeqDataName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGBAltSeqDataName() {
        return gbAltSeqDataName;
    }

    /**
     * Define o valor da propriedade gbAltSeqDataName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGBAltSeqDataName(String value) {
        this.gbAltSeqDataName = value;
    }

    /**
     * Obtém o valor da propriedade gbAltSeqDataItems.
     * 
     * @return
     *     possible object is
     *     {@link GBAltSeqDataItems }
     *     
     */
    public GBAltSeqDataItems getGBAltSeqDataItems() {
        return gbAltSeqDataItems;
    }

    /**
     * Define o valor da propriedade gbAltSeqDataItems.
     * 
     * @param value
     *     allowed object is
     *     {@link GBAltSeqDataItems }
     *     
     */
    public void setGBAltSeqDataItems(GBAltSeqDataItems value) {
        this.gbAltSeqDataItems = value;
    }

}
