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
    private String inputPseudo;
    private String inputPassword;
    private String inputFirstName;
    private String inputSecondName;
    private String inputBirthDate;
    private String inputPostalCode;
    private String inputEmail;
    private String inputStreetNumber;
    private String inputStreetName;
    private String EncryptedPassword;
    
    public String connexion() throws NoSuchAlgorithmException {
        encryptPassword();
        if (comparePassword()) {
            currentUser = findUserByPseudo();
            return "protected/userPages.xhtml";
        }
        return "connexionError";
    }
    
    private void encryptPassword() throws NoSuchAlgorithmException {
        String tmpPassword = getInputPassword();
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        byte[] encodeHash = messageDigest.digest(tmpPassword.getBytes(StandardCharsets.UTF_8));
        tmpPassword = Base64.getEncoder().encodeToString(encodeHash);
        EncryptedPassword = tmpPassword;
    }
    
    private boolean comparePassword() {
        return EncryptedPassword.equals(getUserPassword());
    }
    
    private String getUserPassword() {
        return daoUtillisateur.findByPseudo(inputPseudo).getMotPasse();
    }
    
    private Utilisateur findUserByPseudo() {
        return daoUtillisateur.findByPseudo(inputPseudo);
    }
    
    public void insertUser() {
        
    }
    
    public Utilisateur getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(Utilisateur currentUser) {
        this.currentUser = currentUser;
    }

    public String getInputPseudo() {
        return inputPseudo;
    }

    public void setInputPseudo(String inputPseudo) {
        this.inputPseudo = inputPseudo;
    }

    public String getInputPassword() {
        return inputPassword;
    }

    public void setInputPassword(String inputPassword) {
        this.inputPassword = inputPassword;
    }

    public String getInputFirstName() {
        return inputFirstName;
    }

    public void setInputFirstName(String inputFirstName) {
        this.inputFirstName = inputFirstName;
    }

    public String getInputSecondName() {
        return inputSecondName;
    }

    public void setInputSecondName(String inputSecondName) {
        this.inputSecondName = inputSecondName;
    }

    public String getInputBirthDate() {
        return inputBirthDate;
    }

    public void setInputBirthDate(String inputBirthDate) {
        this.inputBirthDate = inputBirthDate;
    }

    public String getInputPostalCode() {
        return inputPostalCode;
    }

    public void setInputPostalCode(String inputPostalCode) {
        this.inputPostalCode = inputPostalCode;
    }

    public String getInputEmail() {
        return inputEmail;
    }

    public void setInputEmail(String inputEmail) {
        this.inputEmail = inputEmail;
    }

    public String getInputStreetNumber() {
        return inputStreetNumber;
    }

    public void setInputStreetNumber(String inputStreetNumber) {
        this.inputStreetNumber = inputStreetNumber;
    }

    public String getInputStreetName() {
        return inputStreetName;
    }

    public void setInputStreetName(String inputStreetName) {
        this.inputStreetName = inputStreetName;
    }

}
