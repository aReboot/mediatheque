/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Adrien
 */
@Entity
@Table(name = "fichelecture")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fichelecture.findAll", query = "SELECT f FROM Fichelecture f")
    , @NamedQuery(name = "Fichelecture.findByIdFichelecture", query = "SELECT f FROM Fichelecture f WHERE f.idFichelecture = :idFichelecture")
    , @NamedQuery(name = "Fichelecture.findByDateFichelecture", query = "SELECT f FROM Fichelecture f WHERE f.dateFichelecture = :dateFichelecture")
    , @NamedQuery(name = "Fichelecture.findByCommentaire", query = "SELECT f FROM Fichelecture f WHERE f.commentaire = :commentaire")
    , @NamedQuery(name = "Fichelecture.findByNote", query = "SELECT f FROM Fichelecture f WHERE f.note = :note")})
public class Fichelecture implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idFichelecture")
    private Integer idFichelecture;
    @Column(name = "dateFichelecture")
    @Temporal(TemporalType.DATE)
    private Date dateFichelecture;
    @Size(max = 255)
    @Column(name = "commentaire")
    private String commentaire;
    @Column(name = "note")
    private Integer note;
    @JoinColumn(name = "idDocument", referencedColumnName = "idDocument")
    @ManyToOne
    private Document idDocument;
    @JoinColumn(name = "idUtilisateur", referencedColumnName = "idUtilisateur")
    @ManyToOne
    private Utilisateur idUtilisateur;

    public Fichelecture() {
    }

    public Fichelecture(Integer idFichelecture) {
        this.idFichelecture = idFichelecture;
    }

    public Integer getIdFichelecture() {
        return idFichelecture;
    }

    public void setIdFichelecture(Integer idFichelecture) {
        this.idFichelecture = idFichelecture;
    }

    public Date getDateFichelecture() {
        return dateFichelecture;
    }

    public void setDateFichelecture(Date dateFichelecture) {
        this.dateFichelecture = dateFichelecture;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public Integer getNote() {
        return note;
    }

    public void setNote(Integer note) {
        this.note = note;
    }

    public Document getIdDocument() {
        return idDocument;
    }

    public void setIdDocument(Document idDocument) {
        this.idDocument = idDocument;
    }

    public Utilisateur getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(Utilisateur idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFichelecture != null ? idFichelecture.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fichelecture)) {
            return false;
        }
        Fichelecture other = (Fichelecture) object;
        if ((this.idFichelecture == null && other.idFichelecture != null) || (this.idFichelecture != null && !this.idFichelecture.equals(other.idFichelecture))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Fichelecture[ idFichelecture=" + idFichelecture + " ]";
    }
    
}
