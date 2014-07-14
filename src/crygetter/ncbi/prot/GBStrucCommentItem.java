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
    "gbStrucCommentItemTag",
    "gbStrucCommentItemValue",
    "gbStrucCommentItemUrl"
})
@XmlRootElement(name = "GBStrucCommentItem")
public class GBStrucCommentItem {

    @XmlElement(name = "GBStrucCommentItem_tag")
    protected String gbStrucCommentItemTag;
    @XmlElement(name = "GBStrucCommentItem_value")
    protected String gbStrucCommentItemValue;
    @XmlElement(name = "GBStrucCommentItem_url")
    protected String gbStrucCommentItemUrl;

    /**
     * Obtém o valor da propriedade gbStrucCommentItemTag.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGBStrucCommentItemTag() {
        return gbStrucCommentItemTag;
    }

    /**
     * Define o valor da propriedade gbStrucCommentItemTag.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGBStrucCommentItemTag(String value) {
        this.gbStrucCommentItemTag = value;
    }

    /**
     * Obtém o valor da propriedade gbStrucCommentItemValue.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGBStrucCommentItemValue() {
        return gbStrucCommentItemValue;
    }

    /**
     * Define o valor da propriedade gbStrucCommentItemValue.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGBStrucCommentItemValue(String value) {
        this.gbStrucCommentItemValue = value;
    }

    /**
     * Obtém o valor da propriedade gbStrucCommentItemUrl.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGBStrucCommentItemUrl() {
        return gbStrucCommentItemUrl;
    }

    /**
     * Define o valor da propriedade gbStrucCommentItemUrl.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGBStrucCommentItemUrl(String value) {
        this.gbStrucCommentItemUrl = value;
    }

}
