package com.recapp.beans;

import org.apache.struts.action.ActionForm;
import org.apache.struts.upload.FormFile;

public final class FileUpLoad extends ActionForm {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private FormFile formFile;
	private String description;

	public FormFile getFormFile() {
		return formFile;
	}

	public void setFormFile(FormFile formFile) {
		this.formFile = formFile;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
