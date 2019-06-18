package com.shree.onlineshopping.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.multipart.MultipartFile;

import com.shree.shoppingbackend.dto.Product;

public class ProductValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		//checking command class object
		return Product.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		//cast target to Product type
		Product objProduct =  (Product)target;
		
		//check whether file has been selected or not
		int count = 1;
		for (MultipartFile objMultipartFile : objProduct.getImgFiles()) {

			if (objMultipartFile == null || objMultipartFile.getOriginalFilename().equals("")) {
				errors.rejectValue("imgFiles", null, "Please Select an image file to Upload..!");
				return;
			}
			
			// check whether the selected files are in proper format or not
			
			if (!(objMultipartFile.getContentType().equals("image/jpeg")
					|| objMultipartFile.getContentType().equals("image/png")
					|| objMultipartFile.getContentType().equals("image/gif"))) 
			{
				errors.rejectValue("imgFiles", null, "Please select only image file to upload..!");
				return;
			}
			count++;
		}


	}

}
