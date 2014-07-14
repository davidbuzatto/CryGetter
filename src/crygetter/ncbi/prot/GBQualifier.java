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
    "gbQualifierName",
    "gbQualifierValue"
})
@XmlRootElement(name = "GBQualifier")
public class GBQualifier {

    @XmlElement(name = "GBQualifier_name", required = true)
    protected String gbQualifierName;
    @XmlElement(name = "GBQualifier_value")
    protected String gbQualifierValue;

    /**
     * Obtém o valor da propriedade gbQualifierName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGBQualifierName() {
        return gbQualifierName;
    }

    /**
     * Define o valor da propriedade gbQualifierName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGBQualifierName(String value) {
        this.gbQualifierName = value;
    }

    /**
     * Obtém o valor da propriedade gbQualifierValue.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGBQualifierValue() {
        return gbQualifierValue;
    }

    /**
     * Define o valor da propriedade gbQualifierValue.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGBQualifierValue(String value) {
        this.gbQualifierValue = value;
    }

}
