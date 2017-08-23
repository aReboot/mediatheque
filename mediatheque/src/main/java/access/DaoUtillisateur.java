/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package access;

import javax.ejb.Stateless;
import model.Utilisateur;

/**
 *
 * @author Adrien
 */
@Stateless
public class DaoUtillisateur extends DaoAbstract<Utilisateur, Integer>{
    
    public Utilisateur findByPseudo(String pseudo) {
        return em.createNamedQuery(getClass().getSimpleName() + ".findByPseudo", entityClass).getSingleResult();
    }
}
