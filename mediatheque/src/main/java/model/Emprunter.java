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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Adrien
 */
@Entity
@Table(name = "emprunter")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Emprunter.findAll", query = "SELECT e FROM Emprunter e")
    , @NamedQuery(name = "Emprunter.findByIdEmprunter", query = "SELECT e FROM Emprunter e WHERE e.idEmprunter = :idEmprunter")
    , @NamedQuery(name = "Emprunter.findByDateEmprunt", query = "SELECT e FROM Emprunter e WHERE e.dateEmprunt = :dateEmprunt")
    , @NamedQuery(name = "Emprunter.findByDateRetour", query = "SELECT e FROM Emprunter e WHERE e.dateRetour = :dateRetour")})
public class Emprunter implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idEmprunter")
    private Integer idEmprunter;
    @Column(name = "dateEmprunt")
    @Temporal(TemporalType.DATE)
    private Date dateEmprunt;
    @Column(name = "dateRetour")
    @Temporal(TemporalType.DATE)
    private Date dateRetour;
    @JoinColumn(name = "idDocument", referencedColumnName = "idDocument")
    @ManyToOne
    private Document idDocument;
    @JoinColumn(name = "idUtilisateur", referencedColumnName = "idUtilisateur")
    @ManyToOne
    private Utilisateur idUtilisateur;

    public Emprunter() {
    }

    public Emprunter(Integer idEmprunter) {
        this.idEmprunter = idEmprunter;
    }

    public Integer getIdEmprunter() {
        return idEmprunter;
    }

    public void setIdEmprunter(Integer idEmprunter) {
        this.idEmprunter = idEmprunter;
    }

    public Date getDateEmprunt() {
        return dateEmprunt;
    }

    public void setDateEmprunt(Date dateEmprunt) {
        this.dateEmprunt = dateEmprunt;
    }

    public Date getDateRetour() {
        return dateRetour;
    }

    public void setDateRetour(Date dateRetour) {
        this.dateRetour = dateRetour;
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
        hash += (idEmprunter != null ? idEmprunter.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Emprunter)) {
            return false;
        }
        Emprunter other = (Emprunter) object;
        if ((this.idEmprunter == null && other.idEmprunter != null) || (this.idEmprunter != null && !this.idEmprunter.equals(other.idEmprunter))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Emprunter[ idEmprunter=" + idEmprunter + " ]";
    }
    
}
