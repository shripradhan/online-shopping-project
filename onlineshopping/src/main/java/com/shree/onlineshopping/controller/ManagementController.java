package com.shree.onlineshopping.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.shree.onlineshopping.util.FileUploadUtility;
import com.shree.shoppingbackend.dao.CategoryDAO;
import com.shree.shoppingbackend.dao.ProductDAO;
import com.shree.shoppingbackend.dto.Category;
import com.shree.shoppingbackend.dto.Product;
import com.shree.shoppingbackend.dto.ProductImage;

@Controller
@RequestMapping(value="/manage")
public class ManagementController {
	
	@Autowired
	private CategoryDAO objCategoryDAO;
	
	@Autowired
	private ProductDAO objProductDAO;
	
	private static final Logger logger = Logger.getLogger(ManagementController.class);
	
	
	@RequestMapping(value="/products", method=RequestMethod.GET)
	public ModelAndView showManageProduct(@RequestParam(name="operation", required=false) String operation) {
		
		logger.info("launch Manage Product Page");
		ModelAndView mav = new ModelAndView("page");
		mav.addObject("userClickmanageProducts", true);
		mav.addObject("title", "Manage Products");
		
		Product newProduct = new Product();
		newProduct.setSupplierId(3000);
		newProduct.setActive(true);
		mav.addObject("newProduct", newProduct);
		
		if(operation != null) {
			
			if(operation.equals("product")) {
				mav.addObject("msg", "Product Added Successfully...");
			}
			
		}
	
		return mav;
	}
	
	
	//save product
	@RequestMapping(value="/products", method=RequestMethod.POST) 
	public String saveProduct(@Valid @ModelAttribute("newProduct") Product objProduct, BindingResult result, Model model,HttpServletRequest request) {
		
		List<ProductImage> productImages = new ArrayList<ProductImage>();
		//perform validation if there is any form error
		if(result.hasErrors()) {
			
			model.addAttribute("userClickmanageProducts", true);
			model.addAttribute("title", "Manage Products");
			
			//return logical view name with model data 
			return "page";
		}
		
		
		List<MultipartFile> listImageFiles = objProduct.getImgFiles();
		
		for(MultipartFile file : listImageFiles) {
			
			ProductImage objProductImage = new ProductImage();
			
			String fileName = "PRD"+UUID.randomUUID().toString().substring(28).toUpperCase()+objProduct.getCode();
			
			objProductImage.setImgName(fileName);
			objProductImage.setProduct(objProduct);
			
			productImages.add(objProductImage);
			
			//check file are exist or empty
			if(!file.getOriginalFilename().equals("")) {
				
				//call fileUploading method
				FileUploadUtility.uploadFile(request, file, fileName);
				
			}
			
		}
		
		//perform saving product
		objProductDAO.add(objProduct,productImages);
		logger.info("Product going to Submit : "+objProduct.toString());
		
		
		return "redirect:/manage/products?operation=product";
	}
	
	/*
	 * Method return the list of Categories
	 * 
	 */
	
	@ModelAttribute("categories")
	public List<Category> getCategories(){
		return objCategoryDAO.listCategory();
	}

}
