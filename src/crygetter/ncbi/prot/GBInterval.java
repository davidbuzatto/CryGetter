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
    "gbIntervalFrom",
    "gbIntervalTo",
    "gbIntervalPoint",
    "gbIntervalIscomp",
    "gbIntervalInterbp",
    "gbIntervalAccession"
})
@XmlRootElement(name = "GBInterval")
public class GBInterval {

    @XmlElement(name = "GBInterval_from")
    protected String gbIntervalFrom;
    @XmlElement(name = "GBInterval_to")
    protected String gbIntervalTo;
    @XmlElement(name = "GBInterval_point")
    protected String gbIntervalPoint;
    @XmlElement(name = "GBInterval_iscomp")
    protected GBIntervalIscomp gbIntervalIscomp;
    @XmlElement(name = "GBInterval_interbp")
    protected GBIntervalInterbp gbIntervalInterbp;
    @XmlElement(name = "GBInterval_accession", required = true)
    protected String gbIntervalAccession;

    /**
     * Obtém o valor da propriedade gbIntervalFrom.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGBIntervalFrom() {
        return gbIntervalFrom;
    }

    /**
     * Define o valor da propriedade gbIntervalFrom.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGBIntervalFrom(String value) {
        this.gbIntervalFrom = value;
    }

    /**
     * Obtém o valor da propriedade gbIntervalTo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGBIntervalTo() {
        return gbIntervalTo;
    }

    /**
     * Define o valor da propriedade gbIntervalTo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGBIntervalTo(String value) {
        this.gbIntervalTo = value;
    }

    /**
     * Obtém o valor da propriedade gbIntervalPoint.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGBIntervalPoint() {
        return gbIntervalPoint;
    }

    /**
     * Define o valor da propriedade gbIntervalPoint.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGBIntervalPoint(String value) {
        this.gbIntervalPoint = value;
    }

    /**
     * Obtém o valor da propriedade gbIntervalIscomp.
     * 
     * @return
     *     possible object is
     *     {@link GBIntervalIscomp }
     *     
     */
    public GBIntervalIscomp getGBIntervalIscomp() {
        return gbIntervalIscomp;
    }

    /**
     * Define o valor da propriedade gbIntervalIscomp.
     * 
     * @param value
     *     allowed object is
     *     {@link GBIntervalIscomp }
     *     
     */
    public void setGBIntervalIscomp(GBIntervalIscomp value) {
        this.gbIntervalIscomp = value;
    }

    /**
     * Obtém o valor da propriedade gbIntervalInterbp.
     * 
     * @return
     *     possible object is
     *     {@link GBIntervalInterbp }
     *     
     */
    public GBIntervalInterbp getGBIntervalInterbp() {
        return gbIntervalInterbp;
    }

    /**
     * Define o valor da propriedade gbIntervalInterbp.
     * 
     * @param value
     *     allowed object is
     *     {@link GBIntervalInterbp }
     *     
     */
    public void setGBIntervalInterbp(GBIntervalInterbp value) {
        this.gbIntervalInterbp = value;
    }

    /**
     * Obtém o valor da propriedade gbIntervalAccession.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGBIntervalAccession() {
        return gbIntervalAccession;
    }

    /**
     * Define o valor da propriedade gbIntervalAccession.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGBIntervalAccession(String value) {
        this.gbIntervalAccession = value;
    }

}
