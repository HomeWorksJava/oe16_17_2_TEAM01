/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.apitest.model;

import java.util.ArrayList;

/**
 *
 * @author krumpli
 */
public class Title {
    private int title_id;
    private String title_name;
    private ArrayList<Role> roles;

    
   // public Title(int id, String name)
    //{
    //    this.title_id=id;
     //   this.title_name=name;
        //this.roles=new List<Role>();..ez miért szar??? 
    //}
    
    /**
     * @return the title_id
     */
    public int getTitle_id() {
        return title_id;
    }

    /**
     * @param title_id the title_id to set
     */
    public void setTitle_id(int title_id) {
        this.title_id = title_id;
    }

    /**
     * @return the title_name
     */
    public String getTitle_name() {
        return title_name;
    }

    /**
     * @param title_name the title_name to set
     */
    public void setTitle_name(String title_name) {
        this.title_name = title_name;
    }

    /**
     * @return the roles
     */
    public ArrayList<Role> getRoles() {
        return roles;
    }

    /**
     * @param roles the roles to set
     */
    public void setRoles(ArrayList<Role> roles) {
        this.roles = roles;
    }
}
