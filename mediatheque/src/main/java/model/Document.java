/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Adrien
 */
@Entity
@Table(name = "document")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Document.findAll", query = "SELECT d FROM Document d")
    , @NamedQuery(name = "Document.findByIdDocument", query = "SELECT d FROM Document d WHERE d.idDocument = :idDocument")
    , @NamedQuery(name = "Document.findByCodeBarre", query = "SELECT d FROM Document d WHERE d.codeBarre = :codeBarre")
    , @NamedQuery(name = "Document.findByTitre", query = "SELECT d FROM Document d WHERE d.titre = :titre")
    , @NamedQuery(name = "Document.findByAuteur", query = "SELECT d FROM Document d WHERE d.auteur = :auteur")
    , @NamedQuery(name = "Document.findByUrlImage", query = "SELECT d FROM Document d WHERE d.urlImage = :urlImage")
    , @NamedQuery(name = "Document.findByEditeur", query = "SELECT d FROM Document d WHERE d.editeur = :editeur")
    , @NamedQuery(name = "Document.findByStatut", query = "SELECT d FROM Document d WHERE d.statut = :statut")})
public class Document implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idDocument")
    private Integer idDocument;
    @Size(max = 128)
    @Column(name = "codeBarre")
    private String codeBarre;
    @Size(max = 128)
    @Column(name = "titre")
    private String titre;
    @Size(max = 256)
    @Column(name = "auteur")
    private String auteur;
    @Lob
    @Size(max = 65535)
    @Column(name = "description")
    private String description;
    @Size(max = 256)
    @Column(name = "urlImage")
    private String urlImage;
    @Size(max = 128)
    @Column(name = "editeur")
    private String editeur;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "statut")
    private String statut;
    @OneToMany(mappedBy = "idDocument")
    private Collection<Fichelecture> fichelectureCollection;
    @JoinColumn(name = "idCategorie", referencedColumnName = "idCategorie")
    @ManyToOne
    private Categorie idCategorie;
    @OneToMany(mappedBy = "idDocument")
    private Collection<Emprunter> emprunterCollection;

    public Document() {
    }

    public Document(Integer idDocument) {
        this.idDocument = idDocument;
    }

    public Document(Integer idDocument, String statut) {
        this.idDocument = idDocument;
        this.statut = statut;
    }

    public Integer getIdDocument() {
        return idDocument;
    }

    public void setIdDocument(Integer idDocument) {
        this.idDocument = idDocument;
    }

    public String getCodeBarre() {
        return codeBarre;
    }

    public void setCodeBarre(String codeBarre) {
        this.codeBarre = codeBarre;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public String getEditeur() {
        return editeur;
    }

    public void setEditeur(String editeur) {
        this.editeur = editeur;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    @XmlTransient
    public Collection<Fichelecture> getFichelectureCollection() {
        return fichelectureCollection;
    }

    public void setFichelectureCollection(Collection<Fichelecture> fichelectureCollection) {
        this.fichelectureCollection = fichelectureCollection;
    }

    public Categorie getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(Categorie idCategorie) {
        this.idCategorie = idCategorie;
    }

    @XmlTransient
    public Collection<Emprunter> getEmprunterCollection() {
        return emprunterCollection;
    }

    public void setEmprunterCollection(Collection<Emprunter> emprunterCollection) {
        this.emprunterCollection = emprunterCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDocument != null ? idDocument.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Document)) {
            return false;
        }
        Document other = (Document) object;
        if ((this.idDocument == null && other.idDocument != null) || (this.idDocument != null && !this.idDocument.equals(other.idDocument))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Document[ idDocument=" + idDocument + " ]";
    }
    
}
