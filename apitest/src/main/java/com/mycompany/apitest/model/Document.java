/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.apitest.model;

/**
 *
 * @author krumpli
 */
public class Document {
    private int doc_id;
    private int owner_id;
    private String doc_name;
    private boolean isPublic_doc;
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    ///public Document(int id, String name,int owner, boolean ispub)
   // {
       // this.doc_id=id;
       // this.doc_name=name;
       //this.owner_id=owner;
        //this.isPublic_doc=ispub;
    //}
    /**
     * @return the doc_id
     */
    public int getDoc_id() {
        return doc_id;
    }

    /**
     * @param doc_id the doc_id to set
     */
    public void setDoc_id(int doc_id) {
        this.doc_id = doc_id;
    }

    /**
     * @return the owner_id
     */
    public int getOwner_id() {
        return owner_id;
    }

    /**
     * @param owner_id the owner_id to set
     */
    public void setOwner_id(int owner_id) {
        this.owner_id = owner_id;
    }

    /**
     * @return the doc_name
     */
    public String getDoc_name() {
        return doc_name;
    }

    /**
     * @param doc_name the doc_name to set
     */
    public void setDoc_name(String doc_name) {
        this.doc_name = doc_name;
    }

    /**
     * @return the isPublic_doc
     */
    public boolean isIsPublic_doc() {
        return isPublic_doc;
    }

    /**
     * @param isPublic_doc the isPublic_doc to set
     */
    public void setIsPublic_doc(boolean isPublic_doc) {
        this.isPublic_doc = isPublic_doc;
    }
}
