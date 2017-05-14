/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.apitest.model;

import javax.ws.rs.FormParam;
import org.jboss.resteasy.annotations.providers.multipart.PartType;

/**
 *
 * @author Peter
 */
public class FormData {
    
    public FormData() {
    }
 
    private byte[] fileData;
    private String username;
 
    public String getUsername() {
        return username;
    }
 
    @FormParam("username")
    public void setUsername(String fileName) {
        this.username = fileName;
    }
 
    public byte[] getFileData() {
        return fileData;
    }
 
    @FormParam("selectedFile")
    @PartType("application/octet-stream")
    public void setFileData(byte[] fileData) {
        this.fileData = fileData;
    }
}
