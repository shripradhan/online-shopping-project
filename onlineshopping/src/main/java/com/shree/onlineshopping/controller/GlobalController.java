package com.shree.onlineshopping.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.shree.onlineshopping.model.UserModel;
import com.shree.shoppingbackend.dao.UserDAO;
import com.shree.shoppingbackend.dto.User;

@ControllerAdvice
public class GlobalController {

	@Autowired
	private HttpSession session;
	
	@Autowired
	private UserDAO userDAO;
	
	private UserModel userModel = null;
	
	public GlobalController() {
		System.out.println("In GlobalController Constructor");
	}
	
	@ModelAttribute
	public UserModel getUserModel() {
		
		
		
		if(session.getAttribute("userModel") == null) {
			
			//add the user model
			Authentication authentication  = SecurityContextHolder.getContext().getAuthentication();
			
			User user = userDAO.findUserByEmail(authentication.getName());
			
			if(user != null) {
				
				//create a new userModel object to pass the user details
				userModel = new UserModel();
				
				userModel.setId(user.getId());
				userModel.setEmail(user.getEmail());
				userModel.setRole(user.getRole());
				userModel.setFullName(user.getFirstName()+" "+user.getLastName());
				
				if(userModel.getRole().equals("USER")) {
					//set the cart only if user is buyer
					userModel.setCart(user.getCart());
				}
				
				//set the userModel in session 
				session.setAttribute("userModel", userModel);
				
				return userModel;
			}
			
		}
		
		return (UserModel)session.getAttribute("userModel");
	}
	
}
