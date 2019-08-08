package com.shree.onlineshopping.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.stereotype.Component;

import com.shree.onlineshopping.model.RegisterModel;
import com.shree.shoppingbackend.dao.UserDAO;
import com.shree.shoppingbackend.dto.Address;
import com.shree.shoppingbackend.dto.Cart;
import com.shree.shoppingbackend.dto.User;

@Component
public class RegisterHandler {
	
	@Autowired
	private UserDAO userDAO;
	
	public RegisterHandler() {
		System.out.println("RegisterHandler.RegisterHandler()");
	}

	
	public RegisterModel init() {
		System.out.println("RegisterHandler.init()");
		return new RegisterModel();
	}
	
	//Add User to RegistrationModel in flow Scope
	public void addUser(RegisterModel registerModel, User user) {
		System.out.println("RegisterHandler.addUser() : "+user);
		registerModel.setUser(user);
		
	}
	
	
	//Add Billing Address to RegistrationModel in flow Scope
	
	public void addAddress(RegisterModel registerModel, Address address) {
		System.out.println("RegisterHandler.addAddress() : "+address);
		registerModel.setAddress(address);
	}
	
	
	/*
	 * 
	 * Validate User with email uniqness and confirm password
	 *
	 */
	
	public String validateUser(User user, MessageContext error) {
		
		String transitionValue = "success";
		
		//checking if password matches the confirm password
		if(!(user.getPassword().equalsIgnoreCase(user.getConfirmPassword()))) {
			
			error.addMessage(new MessageBuilder()
					.error()
					.source("confirmPassword")
					.defaultText("Password does not match the cofirm password")
					.build());
		
			transitionValue = "failure";
		}
		
		//check the uniqness of the email id
		if(userDAO.findUserByEmail(user.getEmail()) != null) {
			
			error.addMessage(new MessageBuilder()
					.error()
					.source("email")
					.defaultText("User already Exist with these email")
					.build());
			
			transitionValue = "failure";
		}
		
		
		return transitionValue;
	}
	
	//
	
	public String saveAll(RegisterModel model) {
		String transitionValue = "success";
		
		//fetch the user
		User user = model.getUser();
		
		if(user.getRole().equals("USER")) {
			
			Cart cart = new Cart();
			
			cart.setUser(user);
			
			user.setCart(cart);
			
		}
		
		//save the user
		userDAO.addUser(user);
		
		
		//fetch the Address
		Address address = model.getAddress();
		address.setUser(user);
		address.setBilling(true);
		
		//save the address
		userDAO.addAddress(address);
		
		return transitionValue;
	}
	
	
	
	
}
