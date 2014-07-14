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
    "gbStrucCommentName",
    "gbStrucCommentItems"
})
@XmlRootElement(name = "GBStrucComment")
public class GBStrucComment {

    @XmlElement(name = "GBStrucComment_name")
    protected String gbStrucCommentName;
    @XmlElement(name = "GBStrucComment_items", required = true)
    protected GBStrucCommentItems gbStrucCommentItems;

    /**
     * Obtém o valor da propriedade gbStrucCommentName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGBStrucCommentName() {
        return gbStrucCommentName;
    }

    /**
     * Define o valor da propriedade gbStrucCommentName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGBStrucCommentName(String value) {
        this.gbStrucCommentName = value;
    }

    /**
     * Obtém o valor da propriedade gbStrucCommentItems.
     * 
     * @return
     *     possible object is
     *     {@link GBStrucCommentItems }
     *     
     */
    public GBStrucCommentItems getGBStrucCommentItems() {
        return gbStrucCommentItems;
    }

    /**
     * Define o valor da propriedade gbStrucCommentItems.
     * 
     * @param value
     *     allowed object is
     *     {@link GBStrucCommentItems }
     *     
     */
    public void setGBStrucCommentItems(GBStrucCommentItems value) {
        this.gbStrucCommentItems = value;
    }

}
