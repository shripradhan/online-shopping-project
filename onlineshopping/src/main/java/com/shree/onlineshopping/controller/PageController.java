package com.shree.onlineshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.shree.shoppingbackend.dao.CategoryDAO;
import com.shree.shoppingbackend.dto.Category;

@Controller
public class PageController {
	
	@Autowired
	private  CategoryDAO objCategory;
	

	@RequestMapping(value= {"/","/home","/index"})
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Home");
		mv.addObject("userClickHome", true);
		mv.addObject("categories", objCategory.listCategory());
		return mv;
	}
	
	@RequestMapping(value= "about")
	public ModelAndView about() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "About Us");
		mv.addObject("userClickAbout", true);
		return mv;
	}
	
	@RequestMapping(value= "contact")
	public ModelAndView contact() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Contact Us");
		mv.addObject("userClickContact", true);
		return mv;
	}
	
	@RequestMapping(value= "/show/all/products")
	public ModelAndView showAllProducts() {
		
		ModelAndView mv = new ModelAndView("page");
		
		mv.addObject("title", "All Products");
		//passing the list of category
		mv.addObject("categories",objCategory.listCategory());
		
		mv.addObject("userClickAllProducts",true);
		
		return mv;
	}
	
	
	@RequestMapping(value= "/show/category/{id}/product")
	public ModelAndView showCategoryProduct(@PathVariable("id") int id) {
		Category category = null;
		
		ModelAndView mv = new ModelAndView("page");
		
		//objCategory for fetching one category based on the id
		category = objCategory.get(id);
		
		mv.addObject("title", category.getName());
		
		//passing the list of category
		mv.addObject("categories",objCategory.listCategory());
		
		//passing single category object
		mv.addObject("category", category);
		
		mv.addObject("userClickCategoryProduct",true);
		
		return mv;
	}
	
	/*@RequestMapping(value= "/test/{greeting}")
	public ModelAndView test(@PathVariable("greeting")String greeting) {
		if(greeting == null) {
			greeting = "Sorry No Msg";
		}
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("greeting", greeting);
		
		return mv;
	}*/
}
