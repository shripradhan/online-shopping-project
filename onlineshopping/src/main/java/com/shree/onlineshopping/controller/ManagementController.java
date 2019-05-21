package com.shree.onlineshopping.controller;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.shree.shoppingbackend.dao.CategoryDAO;
import com.shree.shoppingbackend.dao.ProductDAO;
import com.shree.shoppingbackend.dto.Category;
import com.shree.shoppingbackend.dto.Product;

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
	public String saveProduct(@ModelAttribute("newProduct") Product objProduct) {
	
		objProductDAO.add(objProduct);
		
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
