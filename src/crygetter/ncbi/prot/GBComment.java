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
    "gbCommentType",
    "gbCommentParagraphs"
})
@XmlRootElement(name = "GBComment")
public class GBComment {

    @XmlElement(name = "GBComment_type")
    protected String gbCommentType;
    @XmlElement(name = "GBComment_paragraphs", required = true)
    protected GBCommentParagraphs gbCommentParagraphs;

    /**
     * Obtém o valor da propriedade gbCommentType.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGBCommentType() {
        return gbCommentType;
    }

    /**
     * Define o valor da propriedade gbCommentType.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGBCommentType(String value) {
        this.gbCommentType = value;
    }

    /**
     * Obtém o valor da propriedade gbCommentParagraphs.
     * 
     * @return
     *     possible object is
     *     {@link GBCommentParagraphs }
     *     
     */
    public GBCommentParagraphs getGBCommentParagraphs() {
        return gbCommentParagraphs;
    }

    /**
     * Define o valor da propriedade gbCommentParagraphs.
     * 
     * @param value
     *     allowed object is
     *     {@link GBCommentParagraphs }
     *     
     */
    public void setGBCommentParagraphs(GBCommentParagraphs value) {
        this.gbCommentParagraphs = value;
    }

}
