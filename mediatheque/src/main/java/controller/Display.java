/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import access.DaoDocument;
import access.DaoFicheLecture;
import access.DaoNouvelle;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import model.Document;
import model.Fichelecture;
import model.Nouvelle;
import org.primefaces.event.UnselectEvent;

/**
 *
 * @author Adrien
 */
@SessionScoped
@Named
public class Display implements Serializable {

    @Inject
    private DaoDocument daoDocument;
    @Inject
    private DaoFicheLecture daoFicheLecture;
    @Inject
    private DaoNouvelle daoNouvelle;
    
    private Document selectDocument;
    private Nouvelle selectNouvelle;
    
    private ExternalContext external;
/*
*########################################################################################
#########################################################################################
--------------------------------------------METHODES-------------------------------------
#########################################################################################
#########################################################################################
*/   


public void setSelectDocument(Document selectDocument){
    this.selectDocument=selectDocument;
}


public void setSelectNouvelle (Nouvelle selectNouvelle){
    this.selectNouvelle=selectNouvelle;
}
    

    //methode pour la data table afin de selectionner une ligne
    public void onRowSelect() throws IOException {
         external = FacesContext.getCurrentInstance().getExternalContext();
         external.redirect("faces/ficheNouvelle.xhtml");
    }
 
    
   public void onRowUnselect() throws IOException {
        external = FacesContext.getCurrentInstance().getExternalContext();
         external.redirect("faces/ficheNouvelle.xhtml");
   }



    
/*
*########################################################################################
#########################################################################################
--------------------------------------------GUETTERS-------------------------------------
#########################################################################################
#########################################################################################
*/
    public List<Document> getAllDocuments() {
        return daoDocument.findAll();
    }
    
    public List<Fichelecture> getAllFicheslecture() {
        return daoFicheLecture.findAll();
    }
    
    public List<Nouvelle> getAllNouvelles() {
        return daoNouvelle.findAll();
    }
    
    public Document retrieveSelectDocument(){
        return selectDocument;
    }

    public Document getSelectDocument() {
        return selectDocument;
    }
    
    public Nouvelle getSelectNouvelle(){
        return selectNouvelle;
    }

    public Nouvelle retrieveSelectNouvelle(){
        return selectNouvelle;
    }
    
}

