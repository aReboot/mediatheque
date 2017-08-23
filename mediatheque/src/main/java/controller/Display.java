/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import access.DaoDocument;
import access.DaoFicheLecture;
import access.DaoNouvelle;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import model.Document;
import model.Fichelecture;
import model.Nouvelle;

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
    
    public Document RetrieveSelectDocument(){
        return selectDocument;
    }
    
}

