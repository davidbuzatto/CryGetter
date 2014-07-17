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
    "gbReferenceReference",
    "gbReferencePosition",
    "gbReferenceAuthors",
    "gbReferenceConsortium",
    "gbReferenceTitle",
    "gbReferenceJournal",
    "gbReferenceXref",
    "gbReferencePubmed",
    "gbReferenceRemark"
})
@XmlRootElement(name = "GBReference")
public class GBReference {

    @XmlElement(name = "GBReference_reference", required = true)
    protected String gbReferenceReference;
    @XmlElement(name = "GBReference_position")
    protected String gbReferencePosition;
    @XmlElement(name = "GBReference_authors")
    protected GBReferenceAuthors gbReferenceAuthors;
    @XmlElement(name = "GBReference_consortium")
    protected String gbReferenceConsortium;
    @XmlElement(name = "GBReference_title")
    protected String gbReferenceTitle;
    @XmlElement(name = "GBReference_journal", required = true)
    protected String gbReferenceJournal;
    @XmlElement(name = "GBReference_xref")
    protected GBReferenceXref gbReferenceXref;
    @XmlElement(name = "GBReference_pubmed")
    protected String gbReferencePubmed;
    @XmlElement(name = "GBReference_remark")
    protected String gbReferenceRemark;

    /**
     * Obtém o valor da propriedade gbReferenceReference.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGBReferenceReference() {
        return gbReferenceReference;
    }

    /**
     * Define o valor da propriedade gbReferenceReference.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGBReferenceReference(String value) {
        this.gbReferenceReference = value;
    }

    /**
     * Obtém o valor da propriedade gbReferencePosition.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGBReferencePosition() {
        return gbReferencePosition;
    }

    /**
     * Define o valor da propriedade gbReferencePosition.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGBReferencePosition(String value) {
        this.gbReferencePosition = value;
    }

    /**
     * Obtém o valor da propriedade gbReferenceAuthors.
     * 
     * @return
     *     possible object is
     *     {@link GBReferenceAuthors }
     *     
     */
    public GBReferenceAuthors getGBReferenceAuthors() {
        return gbReferenceAuthors;
    }

    /**
     * Define o valor da propriedade gbReferenceAuthors.
     * 
     * @param value
     *     allowed object is
     *     {@link GBReferenceAuthors }
     *     
     */
    public void setGBReferenceAuthors(GBReferenceAuthors value) {
        this.gbReferenceAuthors = value;
    }

    /**
     * Obtém o valor da propriedade gbReferenceConsortium.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGBReferenceConsortium() {
        return gbReferenceConsortium;
    }

    /**
     * Define o valor da propriedade gbReferenceConsortium.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGBReferenceConsortium(String value) {
        this.gbReferenceConsortium = value;
    }

    /**
     * Obtém o valor da propriedade gbReferenceTitle.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGBReferenceTitle() {
        return gbReferenceTitle;
    }

    /**
     * Define o valor da propriedade gbReferenceTitle.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGBReferenceTitle(String value) {
        this.gbReferenceTitle = value;
    }

    /**
     * Obtém o valor da propriedade gbReferenceJournal.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGBReferenceJournal() {
        return gbReferenceJournal;
    }

    /**
     * Define o valor da propriedade gbReferenceJournal.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGBReferenceJournal(String value) {
        this.gbReferenceJournal = value;
    }

    /**
     * Obtém o valor da propriedade gbReferenceXref.
     * 
     * @return
     *     possible object is
     *     {@link GBReferenceXref }
     *     
     */
    public GBReferenceXref getGBReferenceXref() {
        return gbReferenceXref;
    }

    /**
     * Define o valor da propriedade gbReferenceXref.
     * 
     * @param value
     *     allowed object is
     *     {@link GBReferenceXref }
     *     
     */
    public void setGBReferenceXref(GBReferenceXref value) {
        this.gbReferenceXref = value;
    }

    /**
     * Obtém o valor da propriedade gbReferencePubmed.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGBReferencePubmed() {
        return gbReferencePubmed;
    }

    /**
     * Define o valor da propriedade gbReferencePubmed.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGBReferencePubmed(String value) {
        this.gbReferencePubmed = value;
    }

    /**
     * Obtém o valor da propriedade gbReferenceRemark.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGBReferenceRemark() {
        return gbReferenceRemark;
    }

    /**
     * Define o valor da propriedade gbReferenceRemark.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGBReferenceRemark(String value) {
        this.gbReferenceRemark = value;
    }
    
    @Override
    public String toString() {
        
        StringBuilder sb = new StringBuilder();
        
        if ( gbReferenceAuthors != null ) {
            for ( GBAuthor a : gbReferenceAuthors.getGBAuthor() ) {
                sb.append( a.getvalue() ).append( "; " );
            }
        }
        
        return sb.toString();
        
    }
    
}
