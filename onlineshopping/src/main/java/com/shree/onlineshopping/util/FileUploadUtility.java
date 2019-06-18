package com.shree.onlineshopping.util;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.jboss.logging.Logger;
import org.springframework.web.multipart.MultipartFile;

public class FileUploadUtility {
	
	private static final Logger logger = Logger.getLogger(FileUploadUtility.class);
	
	private static final String ABS_PATH = "E:\\Real Time Project Dev\\Projects\\online-shopping-project\\onlineshopping\\src\\main\\webapp\\assets\\images\\";
	
	private static String REAL_PATH = "";
	
	//method for file uploading
	public static void uploadFile(HttpServletRequest request, MultipartFile file, String imgCode) {
		
		//get REAL_PATH
		REAL_PATH = request.getSession().getServletContext().getRealPath("/assets/images/");
		logger.info("uploadFile() {} - REAL_PATH : "+REAL_PATH);
		
		logger.info("uploadFile() {} - ABS_PATH : "+ABS_PATH);
		/*
		 * to make sure that all directories exists or not 
		 * if not
		 * then create the Directories for storing the image file
		 * 
		 */
		
		//for Absulate Path
		if(!new File(ABS_PATH).exists()) {
			//create the Directories
			new File(ABS_PATH).mkdirs();
		}
		
		//for Real Path
		if(!new File(REAL_PATH).exists()) {
			//create the Directories
			new File(REAL_PATH).mkdirs();
		}
		
		try {
			
			//store file to Absulate Path
			file.transferTo(new File(ABS_PATH + imgCode + ".jpg"));
			
			//store file to Real Path
			file.transferTo(new File(REAL_PATH + imgCode + ".jpg"));
			
			
		} catch (IOException ioex) {
			
			
		}
		
	}

}
