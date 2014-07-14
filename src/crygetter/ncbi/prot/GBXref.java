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
    "gbXrefDbname",
    "gbXrefId"
})
@XmlRootElement(name = "GBXref")
public class GBXref {

    @XmlElement(name = "GBXref_dbname", required = true)
    protected String gbXrefDbname;
    @XmlElement(name = "GBXref_id", required = true)
    protected String gbXrefId;

    /**
     * Obtém o valor da propriedade gbXrefDbname.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGBXrefDbname() {
        return gbXrefDbname;
    }

    /**
     * Define o valor da propriedade gbXrefDbname.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGBXrefDbname(String value) {
        this.gbXrefDbname = value;
    }

    /**
     * Obtém o valor da propriedade gbXrefId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGBXrefId() {
        return gbXrefId;
    }

    /**
     * Define o valor da propriedade gbXrefId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGBXrefId(String value) {
        this.gbXrefId = value;
    }

}
