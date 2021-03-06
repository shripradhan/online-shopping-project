package com.shree.onlineshopping.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.shree.onlineshopping.exception.ProductNotFoundException;
import com.shree.shoppingbackend.dao.CategoryDAO;
import com.shree.shoppingbackend.dao.ProductDAO;
import com.shree.shoppingbackend.dao.UserDAO;
import com.shree.shoppingbackend.dto.Category;
import com.shree.shoppingbackend.dto.Product;
import com.shree.shoppingbackend.dto.User;

@Controller
public class PageController {
	
	private static final Logger logger = LoggerFactory.getLogger(PageController.class);
	
	
	@Autowired
	private  CategoryDAO objCategory;
	
	@Autowired
	private ProductDAO objProduct;
	
	@Autowired
	private UserDAO userDAO;
	

	@RequestMapping(value= {"/","/home","/index"})
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Home");
		
		logger.info("Inside PageController index method - INFO");
		logger.debug("Inside PageController inde method - DEBUG");
		logger.error("Inside PageController Some Error");
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
	
	@RequestMapping(value= "/show/{id}/product")
	public ModelAndView showSingleProduct(@PathVariable("id") int id) throws ProductNotFoundException{
		Product product = null;
		
		ModelAndView mv = new ModelAndView("page");
		
		//objProduct for fetching one Product based on the id
		product = objProduct.get(id);
		
		if(product == null)
			throw new ProductNotFoundException();
		
		//update the product view count
		product.setViews(product.getViews() + 1);
		objProduct.update(product);
		
		mv.addObject("title", product.getName());
		
		//passing the Single Product Information
		mv.addObject("product", product);
		
		mv.addObject("userClickSingleProduct",true);
		
		return mv;
	}
	
	
	/*
	 * handler method for login page
	 */
	
	@RequestMapping(value= "/login")
	public ModelAndView launchLogin(@RequestParam(name="error", required=false) String error,
			@RequestParam(name="logout", required=false) String logout
			) {
		ModelAndView mv = new ModelAndView("login");
		
		if(error != null) {
			mv.addObject("errorMsg", "Invalid username or password");
		}
		
		if(logout != null) {
			
			mv.addObject("logoutMsg",logout+" You've Logout Seccessfully");
		}
		
		mv.addObject("title", "Login");
		return mv;
	}
	
	/*
	 * handler method for access denied page
	 * 
	 */
	@RequestMapping(value= "/accessFailed")
	public ModelAndView accessDenied() {
		ModelAndView mv = new ModelAndView("error");
		
		mv.addObject("title", "403 - Access Denied");
		mv.addObject("errorMsg", "Access Denied");
		mv.addObject("errorTitle", "Aha..!, You Cought.");
		mv.addObject("errorDescription","You don't have authority to access these page");
		return mv;
	}
	
	/**
	 * handler method for logout 
	 * 
	 */
	
	@RequestMapping(value = "/app-logout")
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		
		String loginUserName = null;
		//first we are going to fetch the authentication obj
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		loginUserName = ((User)userDAO.findUserByEmail(auth.getName())).getFirstName();
		
		if(auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		
		return "redirect:/login?logout="+loginUserName;
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
