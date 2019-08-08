package com.shree.shoppingbackend.dao;

import java.util.List;

import com.shree.shoppingbackend.dto.Address;
import com.shree.shoppingbackend.dto.Cart;
import com.shree.shoppingbackend.dto.User;

/*
 * Interface - UserDAO -> all CURD operation declaration
 * 
 */
public interface UserDAO {

	//Add an User
	public boolean addUser(User objUser);
	
	public User findUserByEmail(String email);
	
	
	//Add an Address
	public boolean addAddress(Address objAddress);
	
	public Address getBillingAddress(User user);
	
	public List<Address> listShippingAddress(User user);
	
	public boolean updateCart(Cart objCart);
	
	public boolean addCart(Cart objCart);
	
}
