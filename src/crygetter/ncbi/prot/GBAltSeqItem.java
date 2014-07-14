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
    "gbAltSeqItemInterval",
    "gbAltSeqItemIsgap",
    "gbAltSeqItemGapLength",
    "gbAltSeqItemGapType",
    "gbAltSeqItemGapLinkage",
    "gbAltSeqItemGapComment",
    "gbAltSeqItemFirstAccn",
    "gbAltSeqItemLastAccn",
    "gbAltSeqItemValue"
})
@XmlRootElement(name = "GBAltSeqItem")
public class GBAltSeqItem {

    @XmlElement(name = "GBAltSeqItem_interval")
    protected GBAltSeqItemInterval gbAltSeqItemInterval;
    @XmlElement(name = "GBAltSeqItem_isgap")
    protected GBAltSeqItemIsgap gbAltSeqItemIsgap;
    @XmlElement(name = "GBAltSeqItem_gap-length")
    protected String gbAltSeqItemGapLength;
    @XmlElement(name = "GBAltSeqItem_gap-type")
    protected String gbAltSeqItemGapType;
    @XmlElement(name = "GBAltSeqItem_gap-linkage")
    protected String gbAltSeqItemGapLinkage;
    @XmlElement(name = "GBAltSeqItem_gap-comment")
    protected String gbAltSeqItemGapComment;
    @XmlElement(name = "GBAltSeqItem_first-accn")
    protected String gbAltSeqItemFirstAccn;
    @XmlElement(name = "GBAltSeqItem_last-accn")
    protected String gbAltSeqItemLastAccn;
    @XmlElement(name = "GBAltSeqItem_value")
    protected String gbAltSeqItemValue;

    /**
     * Obtém o valor da propriedade gbAltSeqItemInterval.
     * 
     * @return
     *     possible object is
     *     {@link GBAltSeqItemInterval }
     *     
     */
    public GBAltSeqItemInterval getGBAltSeqItemInterval() {
        return gbAltSeqItemInterval;
    }

    /**
     * Define o valor da propriedade gbAltSeqItemInterval.
     * 
     * @param value
     *     allowed object is
     *     {@link GBAltSeqItemInterval }
     *     
     */
    public void setGBAltSeqItemInterval(GBAltSeqItemInterval value) {
        this.gbAltSeqItemInterval = value;
    }

    /**
     * Obtém o valor da propriedade gbAltSeqItemIsgap.
     * 
     * @return
     *     possible object is
     *     {@link GBAltSeqItemIsgap }
     *     
     */
    public GBAltSeqItemIsgap getGBAltSeqItemIsgap() {
        return gbAltSeqItemIsgap;
    }

    /**
     * Define o valor da propriedade gbAltSeqItemIsgap.
     * 
     * @param value
     *     allowed object is
     *     {@link GBAltSeqItemIsgap }
     *     
     */
    public void setGBAltSeqItemIsgap(GBAltSeqItemIsgap value) {
        this.gbAltSeqItemIsgap = value;
    }

    /**
     * Obtém o valor da propriedade gbAltSeqItemGapLength.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGBAltSeqItemGapLength() {
        return gbAltSeqItemGapLength;
    }

    /**
     * Define o valor da propriedade gbAltSeqItemGapLength.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGBAltSeqItemGapLength(String value) {
        this.gbAltSeqItemGapLength = value;
    }

    /**
     * Obtém o valor da propriedade gbAltSeqItemGapType.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGBAltSeqItemGapType() {
        return gbAltSeqItemGapType;
    }

    /**
     * Define o valor da propriedade gbAltSeqItemGapType.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGBAltSeqItemGapType(String value) {
        this.gbAltSeqItemGapType = value;
    }

    /**
     * Obtém o valor da propriedade gbAltSeqItemGapLinkage.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGBAltSeqItemGapLinkage() {
        return gbAltSeqItemGapLinkage;
    }

    /**
     * Define o valor da propriedade gbAltSeqItemGapLinkage.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGBAltSeqItemGapLinkage(String value) {
        this.gbAltSeqItemGapLinkage = value;
    }

    /**
     * Obtém o valor da propriedade gbAltSeqItemGapComment.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGBAltSeqItemGapComment() {
        return gbAltSeqItemGapComment;
    }

    /**
     * Define o valor da propriedade gbAltSeqItemGapComment.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGBAltSeqItemGapComment(String value) {
        this.gbAltSeqItemGapComment = value;
    }

    /**
     * Obtém o valor da propriedade gbAltSeqItemFirstAccn.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGBAltSeqItemFirstAccn() {
        return gbAltSeqItemFirstAccn;
    }

    /**
     * Define o valor da propriedade gbAltSeqItemFirstAccn.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGBAltSeqItemFirstAccn(String value) {
        this.gbAltSeqItemFirstAccn = value;
    }

    /**
     * Obtém o valor da propriedade gbAltSeqItemLastAccn.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGBAltSeqItemLastAccn() {
        return gbAltSeqItemLastAccn;
    }

    /**
     * Define o valor da propriedade gbAltSeqItemLastAccn.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGBAltSeqItemLastAccn(String value) {
        this.gbAltSeqItemLastAccn = value;
    }

    /**
     * Obtém o valor da propriedade gbAltSeqItemValue.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGBAltSeqItemValue() {
        return gbAltSeqItemValue;
    }

    /**
     * Define o valor da propriedade gbAltSeqItemValue.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGBAltSeqItemValue(String value) {
        this.gbAltSeqItemValue = value;
    }

}
