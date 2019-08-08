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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.shree.onlineshopping.util.FileUploadUtility;
import com.shree.onlineshopping.validator.ProductValidator;
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
			
			//After saving product
			if(operation.equals("product")) {
				mav.addObject("msg", "Product Added Successfully...");
			}
			else
			//After saving Category
			if(operation.equals("category")) {
				mav.addObject("msg","Category Added Successfully...");
			}
			
		}
	
		return mav;
	}
	
	
	//save product
	@RequestMapping(value="/products", method=RequestMethod.POST) 
	public String saveProduct(@Valid @ModelAttribute("newProduct") Product objProduct, BindingResult result, Model model,HttpServletRequest request) {
		
		List<ProductImage> productImages = new ArrayList<ProductImage>();
		
		
		//handle image validation for new product
		if(objProduct.getId() == 0) {
			new ProductValidator().validate(objProduct, result);
		}else {
			for(MultipartFile imgFile : objProduct.getImgFiles()) {
				if(!imgFile.getOriginalFilename().equals("")) {
					new ProductValidator().validate(objProduct, result);
				}
			}
			
		}
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
		
		//perform saving and updating the product
		if(objProduct.getId() ==  0) {
			//create or save new product if id is 0
			objProductDAO.add(objProduct,productImages);
		}else {
			//update the existing product is id is not 0
			objProductDAO.update(objProduct);
		}
		
		logger.info("Product going to Submit : "+objProduct.toString());
		
		
		return "redirect:/manage/products?operation=product";
	}
	
	
	
	/*
	 * Activate and Deactivate the Products
	 * 
	 */
	
	
	@RequestMapping(value="/product/{id}/activation",method=RequestMethod.POST)
	@ResponseBody
	public String handleProductActivation(@PathVariable("id") int productId) {
		
		String resultMsg = "";
		
		//fetch the product by using their id
		Product objProduct = objProductDAO.get(productId);
		
		//get product activation status
		boolean isActive = objProduct.isActive();
		
		//activating or deactivating the product
		objProduct.setActive(!objProduct.isActive());
		
		//updating the product
		objProductDAO.update(objProduct);
		
		return (isActive) ? "You have Successfully Deactivate the Product with Id : "+objProduct.getId() :
							"You have Successfully Activate the Product with Id : "+objProduct.getId();
	}
	
	/*
	 * 
	 * Edit the single Product
	 * 
	 */
	
	
	@RequestMapping(value="/{id}/product", method=RequestMethod.GET)
	public ModelAndView showEditProduct(@PathVariable("id") int productId) {
		
		logger.info("showEditProduct(){} - "+ productId);
		ModelAndView mav = new ModelAndView("page");
		mav.addObject("userClickmanageProducts", true);
		mav.addObject("title", "Manage Products");
		
		Product editProduct = objProductDAO.get(productId);
		
		//set the product that is fetch from the database
		mav.addObject("newProduct", editProduct);
	
		return mav;
	}
	
	/*
	 * Method return the list of Categories
	 * 
	 */
	
	@ModelAttribute("categories")
	public List<Category> getCategories(){
		return objCategoryDAO.listCategory();
	}
	
	
	
	/*
	 * Method return the category
	 * 
	 */
	
	@ModelAttribute("category")
	public Category getCategry(){
		return new Category();
	}
	

	/*
	 * 
	 * Save new Category 
	 * 
	 */
	
	
	@RequestMapping(value="/category", method=RequestMethod.POST)
	public String saveNewCategory(@ModelAttribute("category") Category objCategory) {
		
		logger.info("saveCategory(){} - To save new category");
		
		//save operation
		
		objCategoryDAO.addCategory(objCategory);
		logger.info("Category going to Submit : "+objCategory.toString());
		
		return "redirect:/manage/products?operation=category";
	}

}
