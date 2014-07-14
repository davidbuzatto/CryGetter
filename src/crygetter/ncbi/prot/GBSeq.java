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
    "gbSeqLocus",
    "gbSeqLength",
    "gbSeqStrandedness",
    "gbSeqMoltype",
    "gbSeqTopology",
    "gbSeqDivision",
    "gbSeqUpdateDate",
    "gbSeqCreateDate",
    "gbSeqUpdateRelease",
    "gbSeqCreateRelease",
    "gbSeqDefinition",
    "gbSeqPrimaryAccession",
    "gbSeqEntryVersion",
    "gbSeqAccessionVersion",
    "gbSeqOtherSeqids",
    "gbSeqSecondaryAccessions",
    "gbSeqProject",
    "gbSeqKeywords",
    "gbSeqSegment",
    "gbSeqSource",
    "gbSeqOrganism",
    "gbSeqTaxonomy",
    "gbSeqReferences",
    "gbSeqComment",
    "gbSeqCommentSet",
    "gbSeqStrucComments",
    "gbSeqPrimary",
    "gbSeqSourceDb",
    "gbSeqDatabaseReference",
    "gbSeqFeatureTable",
    "gbSeqFeatureSet",
    "gbSeqSequence",
    "gbSeqContig",
    "gbSeqAltSeq",
    "gbSeqXrefs"
})
@XmlRootElement(name = "GBSeq")
public class GBSeq {

    @XmlElement(name = "GBSeq_locus")
    protected String gbSeqLocus;
    @XmlElement(name = "GBSeq_length", required = true)
    protected String gbSeqLength;
    @XmlElement(name = "GBSeq_strandedness")
    protected String gbSeqStrandedness;
    @XmlElement(name = "GBSeq_moltype", required = true)
    protected String gbSeqMoltype;
    @XmlElement(name = "GBSeq_topology")
    protected String gbSeqTopology;
    @XmlElement(name = "GBSeq_division")
    protected String gbSeqDivision;
    @XmlElement(name = "GBSeq_update-date")
    protected String gbSeqUpdateDate;
    @XmlElement(name = "GBSeq_create-date")
    protected String gbSeqCreateDate;
    @XmlElement(name = "GBSeq_update-release")
    protected String gbSeqUpdateRelease;
    @XmlElement(name = "GBSeq_create-release")
    protected String gbSeqCreateRelease;
    @XmlElement(name = "GBSeq_definition")
    protected String gbSeqDefinition;
    @XmlElement(name = "GBSeq_primary-accession")
    protected String gbSeqPrimaryAccession;
    @XmlElement(name = "GBSeq_entry-version")
    protected String gbSeqEntryVersion;
    @XmlElement(name = "GBSeq_accession-version")
    protected String gbSeqAccessionVersion;
    @XmlElement(name = "GBSeq_other-seqids")
    protected GBSeqOtherSeqids gbSeqOtherSeqids;
    @XmlElement(name = "GBSeq_secondary-accessions")
    protected GBSeqSecondaryAccessions gbSeqSecondaryAccessions;
    @XmlElement(name = "GBSeq_project")
    protected String gbSeqProject;
    @XmlElement(name = "GBSeq_keywords")
    protected GBSeqKeywords gbSeqKeywords;
    @XmlElement(name = "GBSeq_segment")
    protected String gbSeqSegment;
    @XmlElement(name = "GBSeq_source")
    protected String gbSeqSource;
    @XmlElement(name = "GBSeq_organism")
    protected String gbSeqOrganism;
    @XmlElement(name = "GBSeq_taxonomy")
    protected String gbSeqTaxonomy;
    @XmlElement(name = "GBSeq_references")
    protected GBSeqReferences gbSeqReferences;
    @XmlElement(name = "GBSeq_comment")
    protected String gbSeqComment;
    @XmlElement(name = "GBSeq_comment-set")
    protected GBSeqCommentSet gbSeqCommentSet;
    @XmlElement(name = "GBSeq_struc-comments")
    protected GBSeqStrucComments gbSeqStrucComments;
    @XmlElement(name = "GBSeq_primary")
    protected String gbSeqPrimary;
    @XmlElement(name = "GBSeq_source-db")
    protected String gbSeqSourceDb;
    @XmlElement(name = "GBSeq_database-reference")
    protected String gbSeqDatabaseReference;
    @XmlElement(name = "GBSeq_feature-table")
    protected GBSeqFeatureTable gbSeqFeatureTable;
    @XmlElement(name = "GBSeq_feature-set")
    protected GBSeqFeatureSet gbSeqFeatureSet;
    @XmlElement(name = "GBSeq_sequence")
    protected String gbSeqSequence;
    @XmlElement(name = "GBSeq_contig")
    protected String gbSeqContig;
    @XmlElement(name = "GBSeq_alt-seq")
    protected GBSeqAltSeq gbSeqAltSeq;
    @XmlElement(name = "GBSeq_xrefs")
    protected GBSeqXrefs gbSeqXrefs;

    /**
     * Obtém o valor da propriedade gbSeqLocus.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGBSeqLocus() {
        return gbSeqLocus;
    }

    /**
     * Define o valor da propriedade gbSeqLocus.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGBSeqLocus(String value) {
        this.gbSeqLocus = value;
    }

    /**
     * Obtém o valor da propriedade gbSeqLength.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGBSeqLength() {
        return gbSeqLength;
    }

    /**
     * Define o valor da propriedade gbSeqLength.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGBSeqLength(String value) {
        this.gbSeqLength = value;
    }

    /**
     * Obtém o valor da propriedade gbSeqStrandedness.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGBSeqStrandedness() {
        return gbSeqStrandedness;
    }

    /**
     * Define o valor da propriedade gbSeqStrandedness.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGBSeqStrandedness(String value) {
        this.gbSeqStrandedness = value;
    }

    /**
     * Obtém o valor da propriedade gbSeqMoltype.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGBSeqMoltype() {
        return gbSeqMoltype;
    }

    /**
     * Define o valor da propriedade gbSeqMoltype.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGBSeqMoltype(String value) {
        this.gbSeqMoltype = value;
    }

    /**
     * Obtém o valor da propriedade gbSeqTopology.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGBSeqTopology() {
        return gbSeqTopology;
    }

    /**
     * Define o valor da propriedade gbSeqTopology.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGBSeqTopology(String value) {
        this.gbSeqTopology = value;
    }

    /**
     * Obtém o valor da propriedade gbSeqDivision.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGBSeqDivision() {
        return gbSeqDivision;
    }

    /**
     * Define o valor da propriedade gbSeqDivision.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGBSeqDivision(String value) {
        this.gbSeqDivision = value;
    }

    /**
     * Obtém o valor da propriedade gbSeqUpdateDate.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGBSeqUpdateDate() {
        return gbSeqUpdateDate;
    }

    /**
     * Define o valor da propriedade gbSeqUpdateDate.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGBSeqUpdateDate(String value) {
        this.gbSeqUpdateDate = value;
    }

    /**
     * Obtém o valor da propriedade gbSeqCreateDate.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGBSeqCreateDate() {
        return gbSeqCreateDate;
    }

    /**
     * Define o valor da propriedade gbSeqCreateDate.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGBSeqCreateDate(String value) {
        this.gbSeqCreateDate = value;
    }

    /**
     * Obtém o valor da propriedade gbSeqUpdateRelease.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGBSeqUpdateRelease() {
        return gbSeqUpdateRelease;
    }

    /**
     * Define o valor da propriedade gbSeqUpdateRelease.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGBSeqUpdateRelease(String value) {
        this.gbSeqUpdateRelease = value;
    }

    /**
     * Obtém o valor da propriedade gbSeqCreateRelease.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGBSeqCreateRelease() {
        return gbSeqCreateRelease;
    }

    /**
     * Define o valor da propriedade gbSeqCreateRelease.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGBSeqCreateRelease(String value) {
        this.gbSeqCreateRelease = value;
    }

    /**
     * Obtém o valor da propriedade gbSeqDefinition.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGBSeqDefinition() {
        return gbSeqDefinition;
    }

    /**
     * Define o valor da propriedade gbSeqDefinition.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGBSeqDefinition(String value) {
        this.gbSeqDefinition = value;
    }

    /**
     * Obtém o valor da propriedade gbSeqPrimaryAccession.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGBSeqPrimaryAccession() {
        return gbSeqPrimaryAccession;
    }

    /**
     * Define o valor da propriedade gbSeqPrimaryAccession.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGBSeqPrimaryAccession(String value) {
        this.gbSeqPrimaryAccession = value;
    }

    /**
     * Obtém o valor da propriedade gbSeqEntryVersion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGBSeqEntryVersion() {
        return gbSeqEntryVersion;
    }

    /**
     * Define o valor da propriedade gbSeqEntryVersion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGBSeqEntryVersion(String value) {
        this.gbSeqEntryVersion = value;
    }

    /**
     * Obtém o valor da propriedade gbSeqAccessionVersion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGBSeqAccessionVersion() {
        return gbSeqAccessionVersion;
    }

    /**
     * Define o valor da propriedade gbSeqAccessionVersion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGBSeqAccessionVersion(String value) {
        this.gbSeqAccessionVersion = value;
    }

    /**
     * Obtém o valor da propriedade gbSeqOtherSeqids.
     * 
     * @return
     *     possible object is
     *     {@link GBSeqOtherSeqids }
     *     
     */
    public GBSeqOtherSeqids getGBSeqOtherSeqids() {
        return gbSeqOtherSeqids;
    }

    /**
     * Define o valor da propriedade gbSeqOtherSeqids.
     * 
     * @param value
     *     allowed object is
     *     {@link GBSeqOtherSeqids }
     *     
     */
    public void setGBSeqOtherSeqids(GBSeqOtherSeqids value) {
        this.gbSeqOtherSeqids = value;
    }

    /**
     * Obtém o valor da propriedade gbSeqSecondaryAccessions.
     * 
     * @return
     *     possible object is
     *     {@link GBSeqSecondaryAccessions }
     *     
     */
    public GBSeqSecondaryAccessions getGBSeqSecondaryAccessions() {
        return gbSeqSecondaryAccessions;
    }

    /**
     * Define o valor da propriedade gbSeqSecondaryAccessions.
     * 
     * @param value
     *     allowed object is
     *     {@link GBSeqSecondaryAccessions }
     *     
     */
    public void setGBSeqSecondaryAccessions(GBSeqSecondaryAccessions value) {
        this.gbSeqSecondaryAccessions = value;
    }

    /**
     * Obtém o valor da propriedade gbSeqProject.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGBSeqProject() {
        return gbSeqProject;
    }

    /**
     * Define o valor da propriedade gbSeqProject.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGBSeqProject(String value) {
        this.gbSeqProject = value;
    }

    /**
     * Obtém o valor da propriedade gbSeqKeywords.
     * 
     * @return
     *     possible object is
     *     {@link GBSeqKeywords }
     *     
     */
    public GBSeqKeywords getGBSeqKeywords() {
        return gbSeqKeywords;
    }

    /**
     * Define o valor da propriedade gbSeqKeywords.
     * 
     * @param value
     *     allowed object is
     *     {@link GBSeqKeywords }
     *     
     */
    public void setGBSeqKeywords(GBSeqKeywords value) {
        this.gbSeqKeywords = value;
    }

    /**
     * Obtém o valor da propriedade gbSeqSegment.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGBSeqSegment() {
        return gbSeqSegment;
    }

    /**
     * Define o valor da propriedade gbSeqSegment.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGBSeqSegment(String value) {
        this.gbSeqSegment = value;
    }

    /**
     * Obtém o valor da propriedade gbSeqSource.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGBSeqSource() {
        return gbSeqSource;
    }

    /**
     * Define o valor da propriedade gbSeqSource.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGBSeqSource(String value) {
        this.gbSeqSource = value;
    }

    /**
     * Obtém o valor da propriedade gbSeqOrganism.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGBSeqOrganism() {
        return gbSeqOrganism;
    }

    /**
     * Define o valor da propriedade gbSeqOrganism.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGBSeqOrganism(String value) {
        this.gbSeqOrganism = value;
    }

    /**
     * Obtém o valor da propriedade gbSeqTaxonomy.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGBSeqTaxonomy() {
        return gbSeqTaxonomy;
    }

    /**
     * Define o valor da propriedade gbSeqTaxonomy.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGBSeqTaxonomy(String value) {
        this.gbSeqTaxonomy = value;
    }

    /**
     * Obtém o valor da propriedade gbSeqReferences.
     * 
     * @return
     *     possible object is
     *     {@link GBSeqReferences }
     *     
     */
    public GBSeqReferences getGBSeqReferences() {
        return gbSeqReferences;
    }

    /**
     * Define o valor da propriedade gbSeqReferences.
     * 
     * @param value
     *     allowed object is
     *     {@link GBSeqReferences }
     *     
     */
    public void setGBSeqReferences(GBSeqReferences value) {
        this.gbSeqReferences = value;
    }

    /**
     * Obtém o valor da propriedade gbSeqComment.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGBSeqComment() {
        return gbSeqComment;
    }

    /**
     * Define o valor da propriedade gbSeqComment.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGBSeqComment(String value) {
        this.gbSeqComment = value;
    }

    /**
     * Obtém o valor da propriedade gbSeqCommentSet.
     * 
     * @return
     *     possible object is
     *     {@link GBSeqCommentSet }
     *     
     */
    public GBSeqCommentSet getGBSeqCommentSet() {
        return gbSeqCommentSet;
    }

    /**
     * Define o valor da propriedade gbSeqCommentSet.
     * 
     * @param value
     *     allowed object is
     *     {@link GBSeqCommentSet }
     *     
     */
    public void setGBSeqCommentSet(GBSeqCommentSet value) {
        this.gbSeqCommentSet = value;
    }

    /**
     * Obtém o valor da propriedade gbSeqStrucComments.
     * 
     * @return
     *     possible object is
     *     {@link GBSeqStrucComments }
     *     
     */
    public GBSeqStrucComments getGBSeqStrucComments() {
        return gbSeqStrucComments;
    }

    /**
     * Define o valor da propriedade gbSeqStrucComments.
     * 
     * @param value
     *     allowed object is
     *     {@link GBSeqStrucComments }
     *     
     */
    public void setGBSeqStrucComments(GBSeqStrucComments value) {
        this.gbSeqStrucComments = value;
    }

    /**
     * Obtém o valor da propriedade gbSeqPrimary.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGBSeqPrimary() {
        return gbSeqPrimary;
    }

    /**
     * Define o valor da propriedade gbSeqPrimary.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGBSeqPrimary(String value) {
        this.gbSeqPrimary = value;
    }

    /**
     * Obtém o valor da propriedade gbSeqSourceDb.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGBSeqSourceDb() {
        return gbSeqSourceDb;
    }

    /**
     * Define o valor da propriedade gbSeqSourceDb.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGBSeqSourceDb(String value) {
        this.gbSeqSourceDb = value;
    }

    /**
     * Obtém o valor da propriedade gbSeqDatabaseReference.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGBSeqDatabaseReference() {
        return gbSeqDatabaseReference;
    }

    /**
     * Define o valor da propriedade gbSeqDatabaseReference.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGBSeqDatabaseReference(String value) {
        this.gbSeqDatabaseReference = value;
    }

    /**
     * Obtém o valor da propriedade gbSeqFeatureTable.
     * 
     * @return
     *     possible object is
     *     {@link GBSeqFeatureTable }
     *     
     */
    public GBSeqFeatureTable getGBSeqFeatureTable() {
        return gbSeqFeatureTable;
    }

    /**
     * Define o valor da propriedade gbSeqFeatureTable.
     * 
     * @param value
     *     allowed object is
     *     {@link GBSeqFeatureTable }
     *     
     */
    public void setGBSeqFeatureTable(GBSeqFeatureTable value) {
        this.gbSeqFeatureTable = value;
    }

    /**
     * Obtém o valor da propriedade gbSeqFeatureSet.
     * 
     * @return
     *     possible object is
     *     {@link GBSeqFeatureSet }
     *     
     */
    public GBSeqFeatureSet getGBSeqFeatureSet() {
        return gbSeqFeatureSet;
    }

    /**
     * Define o valor da propriedade gbSeqFeatureSet.
     * 
     * @param value
     *     allowed object is
     *     {@link GBSeqFeatureSet }
     *     
     */
    public void setGBSeqFeatureSet(GBSeqFeatureSet value) {
        this.gbSeqFeatureSet = value;
    }

    /**
     * Obtém o valor da propriedade gbSeqSequence.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGBSeqSequence() {
        return gbSeqSequence;
    }

    /**
     * Define o valor da propriedade gbSeqSequence.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGBSeqSequence(String value) {
        this.gbSeqSequence = value;
    }

    /**
     * Obtém o valor da propriedade gbSeqContig.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGBSeqContig() {
        return gbSeqContig;
    }

    /**
     * Define o valor da propriedade gbSeqContig.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGBSeqContig(String value) {
        this.gbSeqContig = value;
    }

    /**
     * Obtém o valor da propriedade gbSeqAltSeq.
     * 
     * @return
     *     possible object is
     *     {@link GBSeqAltSeq }
     *     
     */
    public GBSeqAltSeq getGBSeqAltSeq() {
        return gbSeqAltSeq;
    }

    /**
     * Define o valor da propriedade gbSeqAltSeq.
     * 
     * @param value
     *     allowed object is
     *     {@link GBSeqAltSeq }
     *     
     */
    public void setGBSeqAltSeq(GBSeqAltSeq value) {
        this.gbSeqAltSeq = value;
    }

    /**
     * Obtém o valor da propriedade gbSeqXrefs.
     * 
     * @return
     *     possible object is
     *     {@link GBSeqXrefs }
     *     
     */
    public GBSeqXrefs getGBSeqXrefs() {
        return gbSeqXrefs;
    }

    /**
     * Define o valor da propriedade gbSeqXrefs.
     * 
     * @param value
     *     allowed object is
     *     {@link GBSeqXrefs }
     *     
     */
    public void setGBSeqXrefs(GBSeqXrefs value) {
        this.gbSeqXrefs = value;
    }

}
