package com.recapp.action;

import java.io.File;
import java.io.RandomAccessFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;

import com.recapp.beans.FileUpLoad;

public class UploadFileAction extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		FileUpLoad attachmentForm = (FileUpLoad) form;
		if (attachmentForm != null) {
			String description = attachmentForm.getDescription();
			System.out.println("Description:" + description);
			FormFile formFile = attachmentForm.getFormFile();
			if (formFile != null) {
				byte[] bytes = formFile.getFileData();
				ServletContext servletContext = getServlet()
						.getServletContext();
				String savePath = servletContext.getRealPath("/WEB-INF");
				String fileName = formFile.getFileName();
				File uploadedFile = new File(savePath, fileName);
				RandomAccessFile raf = new RandomAccessFile(uploadedFile, "rw");
				raf.write(bytes);
				raf.close();
			}
		}
		return (mapping.findForward("success"));
	}
}