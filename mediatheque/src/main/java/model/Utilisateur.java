/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Adrien
 */
@Entity
@Table(name = "utilisateur")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Utilisateur.findAll", query = "SELECT u FROM Utilisateur u")
    , @NamedQuery(name = "Utilisateur.findByIdUtilisateur", query = "SELECT u FROM Utilisateur u WHERE u.idUtilisateur = :idUtilisateur")
    , @NamedQuery(name = "Utilisateur.findByNom", query = "SELECT u FROM Utilisateur u WHERE u.nom = :nom")
    , @NamedQuery(name = "Utilisateur.findByPrenom", query = "SELECT u FROM Utilisateur u WHERE u.prenom = :prenom")
    , @NamedQuery(name = "Utilisateur.findByDateNaissance", query = "SELECT u FROM Utilisateur u WHERE u.dateNaissance = :dateNaissance")
    , @NamedQuery(name = "Utilisateur.findByNumVoie", query = "SELECT u FROM Utilisateur u WHERE u.numVoie = :numVoie")
    , @NamedQuery(name = "Utilisateur.findByVoie", query = "SELECT u FROM Utilisateur u WHERE u.voie = :voie")
    , @NamedQuery(name = "Utilisateur.findByCp", query = "SELECT u FROM Utilisateur u WHERE u.cp = :cp")
    , @NamedQuery(name = "Utilisateur.findByVille", query = "SELECT u FROM Utilisateur u WHERE u.ville = :ville")
    , @NamedQuery(name = "Utilisateur.findByEmail", query = "SELECT u FROM Utilisateur u WHERE u.email = :email")
    , @NamedQuery(name = "Utilisateur.findByMotPasse", query = "SELECT u FROM Utilisateur u WHERE u.motPasse = :motPasse")
    , @NamedQuery(name = "Utilisateur.findByGroupe", query = "SELECT u FROM Utilisateur u WHERE u.groupe = :groupe")
    , @NamedQuery(name = "Utilisateur.findByPseudo", query = "SELECT u FROM Utilisateur u WHERE u.pseudo = :pseudo")
    , @NamedQuery(name = "Utilisateur.findByFormeUtilisationSite", query = "SELECT u FROM Utilisateur u WHERE u.formeUtilisationSite = :formeUtilisationSite")})
public class Utilisateur implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idUtilisateur")
    private Integer idUtilisateur;
    @Size(max = 128)
    @Column(name = "nom")
    private String nom;
    @Size(max = 128)
    @Column(name = "prenom")
    private String prenom;
    @Column(name = "dateNaissance")
    @Temporal(TemporalType.DATE)
    private Date dateNaissance;
    @Size(max = 10)
    @Column(name = "numVoie")
    private String numVoie;
    @Size(max = 256)
    @Column(name = "voie")
    private String voie;
    @Size(max = 45)
    @Column(name = "cp")
    private String cp;
    @Size(max = 128)
    @Column(name = "ville")
    private String ville;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "motPasse")
    private String motPasse;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "groupe")
    private String groupe;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "pseudo")
    private String pseudo;
    @Column(name = "formeUtilisationSite")
    private Short formeUtilisationSite;
    @OneToMany(mappedBy = "idUtilisateur")
    private Collection<Fichelecture> fichelectureCollection;
    @OneToMany(mappedBy = "idUtilisateur")
    private Collection<Emprunter> emprunterCollection;
    @OneToMany(mappedBy = "idUtilisateur")
    private Collection<Nouvelle> nouvelleCollection;

    public Utilisateur() {
    }

    public Utilisateur(Integer idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public Utilisateur(Integer idUtilisateur, String email, String motPasse, String groupe, String pseudo) {
        this.idUtilisateur = idUtilisateur;
        this.email = email;
        this.motPasse = motPasse;
        this.groupe = groupe;
        this.pseudo = pseudo;
    }

    public Integer getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(Integer idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getNumVoie() {
        return numVoie;
    }

    public void setNumVoie(String numVoie) {
        this.numVoie = numVoie;
    }

    public String getVoie() {
        return voie;
    }

    public void setVoie(String voie) {
        this.voie = voie;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMotPasse() {
        return motPasse;
    }

    public void setMotPasse(String motPasse) {
        this.motPasse = motPasse;
    }

    public String getGroupe() {
        return groupe;
    }

    public void setGroupe(String groupe) {
        this.groupe = groupe;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public Short getFormeUtilisationSite() {
        return formeUtilisationSite;
    }

    public void setFormeUtilisationSite(Short formeUtilisationSite) {
        this.formeUtilisationSite = formeUtilisationSite;
    }

    @XmlTransient
    public Collection<Fichelecture> getFichelectureCollection() {
        return fichelectureCollection;
    }

    public void setFichelectureCollection(Collection<Fichelecture> fichelectureCollection) {
        this.fichelectureCollection = fichelectureCollection;
    }

    @XmlTransient
    public Collection<Emprunter> getEmprunterCollection() {
        return emprunterCollection;
    }

    public void setEmprunterCollection(Collection<Emprunter> emprunterCollection) {
        this.emprunterCollection = emprunterCollection;
    }

    @XmlTransient
    public Collection<Nouvelle> getNouvelleCollection() {
        return nouvelleCollection;
    }

    public void setNouvelleCollection(Collection<Nouvelle> nouvelleCollection) {
        this.nouvelleCollection = nouvelleCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUtilisateur != null ? idUtilisateur.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Utilisateur)) {
            return false;
        }
        Utilisateur other = (Utilisateur) object;
        if ((this.idUtilisateur == null && other.idUtilisateur != null) || (this.idUtilisateur != null && !this.idUtilisateur.equals(other.idUtilisateur))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Utilisateur[ idUtilisateur=" + idUtilisateur + " ]";
    }
    
}
