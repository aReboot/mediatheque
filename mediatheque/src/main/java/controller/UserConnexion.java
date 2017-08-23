/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import access.DaoUtillisateur;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import model.Utilisateur;

/**
 *
 * @author Adrien
 */
@SessionScoped
@Named
public class UserConnexion implements Serializable {

    @Inject
    private DaoUtillisateur daoUtillisateur;
    private Utilisateur currentUser;
    private String user;
    private String inputPassword;
    private String EncryptedPassword;
    
    
    public boolean comparePassword() {
        return EncryptedPassword.equals(getUserPassword());
    }
    
    private void encryptPassword() throws NoSuchAlgorithmException {
        String tmpPassword = getInputPassword();
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        byte[] encodeHash = messageDigest.digest(tmpPassword.getBytes(StandardCharsets.UTF_8));
        tmpPassword = Base64.getEncoder().encodeToString(encodeHash);
        EncryptedPassword = tmpPassword;
    }
    
    private String getUserPassword() {
        return daoUtillisateur.findByPseudo(user).getMotPasse();
    }

    public String getUser() {
        return user;
    }

    public String getInputPassword() {
        return inputPassword;
    }

    public void setInputPassword(String password) {
        this.inputPassword = password;
    }

    public String getEncryptedPassword() {
        return EncryptedPassword;
    }

    public void setEncryptedPassword(String EncryptedPassword) {
        this.EncryptedPassword = EncryptedPassword;
    }
    
}
