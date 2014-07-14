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
    "gbFeatureSetAnnotSource",
    "gbFeatureSetFeatures"
})
@XmlRootElement(name = "GBFeatureSet")
public class GBFeatureSet {

    @XmlElement(name = "GBFeatureSet_annot-source")
    protected String gbFeatureSetAnnotSource;
    @XmlElement(name = "GBFeatureSet_features", required = true)
    protected GBFeatureSetFeatures gbFeatureSetFeatures;

    /**
     * Obtém o valor da propriedade gbFeatureSetAnnotSource.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGBFeatureSetAnnotSource() {
        return gbFeatureSetAnnotSource;
    }

    /**
     * Define o valor da propriedade gbFeatureSetAnnotSource.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGBFeatureSetAnnotSource(String value) {
        this.gbFeatureSetAnnotSource = value;
    }

    /**
     * Obtém o valor da propriedade gbFeatureSetFeatures.
     * 
     * @return
     *     possible object is
     *     {@link GBFeatureSetFeatures }
     *     
     */
    public GBFeatureSetFeatures getGBFeatureSetFeatures() {
        return gbFeatureSetFeatures;
    }

    /**
     * Define o valor da propriedade gbFeatureSetFeatures.
     * 
     * @param value
     *     allowed object is
     *     {@link GBFeatureSetFeatures }
     *     
     */
    public void setGBFeatureSetFeatures(GBFeatureSetFeatures value) {
        this.gbFeatureSetFeatures = value;
    }

}
