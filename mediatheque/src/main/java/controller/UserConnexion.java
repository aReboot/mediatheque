/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 *
 * @author Adrien
 */
public class UserConnexion {

    private String user;
    private String password;
    
    private void encryptPassword() throws NoSuchAlgorithmException {
        String tmpPassword = getPassword();
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        byte[] encodeHash = messageDigest.digest(tmpPassword.getBytes(StandardCharsets.UTF_8));
        tmpPassword = Base64.getEncoder().encodeToString(encodeHash);
        setPassword(tmpPassword);
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    
    
}
