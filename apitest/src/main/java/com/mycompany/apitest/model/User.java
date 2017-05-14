/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.apitest.model;

/**
 *
 * @author Peter
 */
public class User 
{
    private String username;
    private String passwd;
    private int id;
    private String titulus;
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulus() {
        return titulus;
    }

    public void setTitulus(String titulus) {
        this.titulus = titulus;
    }      
}
