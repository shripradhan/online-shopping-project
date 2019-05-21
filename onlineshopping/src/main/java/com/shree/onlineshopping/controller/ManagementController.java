package com.shree.onlineshopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.shree.shoppingbackend.dao.CategoryDAO;
import com.shree.shoppingbackend.dto.Category;
import com.shree.shoppingbackend.dto.Product;

@Controller
@RequestMapping(value="/manage")
public class ManagementController {
	
	@Autowired
	private CategoryDAO objCategoryDAO;
	
	
	@RequestMapping(value="/products", method=RequestMethod.GET)
	public ModelAndView showManageProduct() {
		
		ModelAndView mav = new ModelAndView("page");
		mav.addObject("userClickmanageProducts", true);
		mav.addObject("title", "Manage Products");
		
		Product newProduct = new Product();
		newProduct.setSupplierId(3000);
		newProduct.setActive(true);
		mav.addObject("newProduct", newProduct);
	
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

}
