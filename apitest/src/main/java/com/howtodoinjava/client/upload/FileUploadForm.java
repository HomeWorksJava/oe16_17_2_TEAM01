package com.howtodoinjava.client.upload;

import javax.ws.rs.FormParam;
import org.jboss.resteasy.annotations.providers.multipart.PartType;

public class FileUploadForm {

	public FileUploadForm() {
	}

	private byte[] fileData;
	private String fileName;
        private String owner;
        private String isPublic_doc;

    public String isIsPublic_doc() {
        return isPublic_doc;
    }
@FormParam("isPublic_doc")
    public void setIsPublic_doc(String isPublic_doc) {
        this.isPublic_doc = isPublic_doc;
    }

    public String getOwner() {
        return owner;
    }
@FormParam("owner")
    public void setOwner(String owner) {
        this.owner = owner;
    }

	public String getFileName() {
		return fileName;
	}

	@FormParam("fileName")
	public void setFileName(String fileName) {
		this.fileName = fileName;
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