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
    "gbInterval"
})
@XmlRootElement(name = "GBAltSeqItem_interval")
public class GBAltSeqItemInterval {

    @XmlElement(name = "GBInterval", required = true)
    protected GBInterval gbInterval;

    /**
     * Obtém o valor da propriedade gbInterval.
     * 
     * @return
     *     possible object is
     *     {@link GBInterval }
     *     
     */
    public GBInterval getGBInterval() {
        return gbInterval;
    }

    /**
     * Define o valor da propriedade gbInterval.
     * 
     * @param value
     *     allowed object is
     *     {@link GBInterval }
     *     
     */
    public void setGBInterval(GBInterval value) {
        this.gbInterval = value;
    }

}
