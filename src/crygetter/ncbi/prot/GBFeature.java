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
    "gbFeatureKey",
    "gbFeatureLocation",
    "gbFeatureIntervals",
    "gbFeatureOperator",
    "gbFeaturePartial5",
    "gbFeaturePartial3",
    "gbFeatureQuals",
    "gbFeatureXrefs"
})
@XmlRootElement(name = "GBFeature")
public class GBFeature {

    @XmlElement(name = "GBFeature_key", required = true)
    protected String gbFeatureKey;
    @XmlElement(name = "GBFeature_location", required = true)
    protected String gbFeatureLocation;
    @XmlElement(name = "GBFeature_intervals")
    protected GBFeatureIntervals gbFeatureIntervals;
    @XmlElement(name = "GBFeature_operator")
    protected String gbFeatureOperator;
    @XmlElement(name = "GBFeature_partial5")
    protected GBFeaturePartial5 gbFeaturePartial5;
    @XmlElement(name = "GBFeature_partial3")
    protected GBFeaturePartial3 gbFeaturePartial3;
    @XmlElement(name = "GBFeature_quals")
    protected GBFeatureQuals gbFeatureQuals;
    @XmlElement(name = "GBFeature_xrefs")
    protected GBFeatureXrefs gbFeatureXrefs;

    /**
     * Obtém o valor da propriedade gbFeatureKey.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGBFeatureKey() {
        return gbFeatureKey;
    }

    /**
     * Define o valor da propriedade gbFeatureKey.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGBFeatureKey(String value) {
        this.gbFeatureKey = value;
    }

    /**
     * Obtém o valor da propriedade gbFeatureLocation.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGBFeatureLocation() {
        return gbFeatureLocation;
    }

    /**
     * Define o valor da propriedade gbFeatureLocation.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGBFeatureLocation(String value) {
        this.gbFeatureLocation = value;
    }

    /**
     * Obtém o valor da propriedade gbFeatureIntervals.
     * 
     * @return
     *     possible object is
     *     {@link GBFeatureIntervals }
     *     
     */
    public GBFeatureIntervals getGBFeatureIntervals() {
        return gbFeatureIntervals;
    }

    /**
     * Define o valor da propriedade gbFeatureIntervals.
     * 
     * @param value
     *     allowed object is
     *     {@link GBFeatureIntervals }
     *     
     */
    public void setGBFeatureIntervals(GBFeatureIntervals value) {
        this.gbFeatureIntervals = value;
    }

    /**
     * Obtém o valor da propriedade gbFeatureOperator.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGBFeatureOperator() {
        return gbFeatureOperator;
    }

    /**
     * Define o valor da propriedade gbFeatureOperator.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGBFeatureOperator(String value) {
        this.gbFeatureOperator = value;
    }

    /**
     * Obtém o valor da propriedade gbFeaturePartial5.
     * 
     * @return
     *     possible object is
     *     {@link GBFeaturePartial5 }
     *     
     */
    public GBFeaturePartial5 getGBFeaturePartial5() {
        return gbFeaturePartial5;
    }

    /**
     * Define o valor da propriedade gbFeaturePartial5.
     * 
     * @param value
     *     allowed object is
     *     {@link GBFeaturePartial5 }
     *     
     */
    public void setGBFeaturePartial5(GBFeaturePartial5 value) {
        this.gbFeaturePartial5 = value;
    }

    /**
     * Obtém o valor da propriedade gbFeaturePartial3.
     * 
     * @return
     *     possible object is
     *     {@link GBFeaturePartial3 }
     *     
     */
    public GBFeaturePartial3 getGBFeaturePartial3() {
        return gbFeaturePartial3;
    }

    /**
     * Define o valor da propriedade gbFeaturePartial3.
     * 
     * @param value
     *     allowed object is
     *     {@link GBFeaturePartial3 }
     *     
     */
    public void setGBFeaturePartial3(GBFeaturePartial3 value) {
        this.gbFeaturePartial3 = value;
    }

    /**
     * Obtém o valor da propriedade gbFeatureQuals.
     * 
     * @return
     *     possible object is
     *     {@link GBFeatureQuals }
     *     
     */
    public GBFeatureQuals getGBFeatureQuals() {
        return gbFeatureQuals;
    }

    /**
     * Define o valor da propriedade gbFeatureQuals.
     * 
     * @param value
     *     allowed object is
     *     {@link GBFeatureQuals }
     *     
     */
    public void setGBFeatureQuals(GBFeatureQuals value) {
        this.gbFeatureQuals = value;
    }

    /**
     * Obtém o valor da propriedade gbFeatureXrefs.
     * 
     * @return
     *     possible object is
     *     {@link GBFeatureXrefs }
     *     
     */
    public GBFeatureXrefs getGBFeatureXrefs() {
        return gbFeatureXrefs;
    }

    /**
     * Define o valor da propriedade gbFeatureXrefs.
     * 
     * @param value
     *     allowed object is
     *     {@link GBFeatureXrefs }
     *     
     */
    public void setGBFeatureXrefs(GBFeatureXrefs value) {
        this.gbFeatureXrefs = value;
    }

}
