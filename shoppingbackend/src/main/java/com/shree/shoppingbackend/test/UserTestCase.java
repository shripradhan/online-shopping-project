package com.shree.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.shree.shoppingbackend.dao.UserDAO;
import com.shree.shoppingbackend.dto.Address;
import com.shree.shoppingbackend.dto.Cart;
import com.shree.shoppingbackend.dto.User;

public class UserTestCase {
	
	//JUNIT Unit testing
	
	private static AnnotationConfigApplicationContext applicationContext;
	
	private static UserDAO objUserDAO;
	
	private User objUser;
	
	private Address address;
	
	private Address objAddress;
	
	private Cart objCart;
	
	@BeforeClass
	public static void init() {
		
		applicationContext = new AnnotationConfigApplicationContext();
		
		applicationContext.scan("com.shree.shoppingbackend");
		
		applicationContext.refresh();
		
		objUserDAO = (UserDAO)applicationContext.getBean("userDAO");
	}
	
	@Test
	public void testAdd() {
		
		objUser = new User();
		objUser.setFirstName("Shrikant");
		objUser.setLastName("Pradhan");
		objUser.setEmail("shripradhan.94@gmail.com");
		objUser.setContactNumber("7769896344");
		objUser.setRole("USER");
		objUser.setPassword("123456");
		
		
		assertEquals("Failed to add user!",true,objUserDAO.addUser(objUser));
		
		//we are going to add the address
		
		objAddress = new Address();
		objAddress.setAddressLineOne("202 shivkrupa house");
		objAddress.setAddressLineTwo("Dhantoli , nagpur");
		objAddress.setCity("Nagpur");
		objAddress.setState("Maharastra");
		objAddress.setCountry("India");
		objAddress.setPostalCode("441910");
		objAddress.setBilling(true);
		
		
		//attached the user to the address
		
		objAddress.setUser(objUser);
		
		assertEquals("Failed to add Address",true,objUserDAO.addAddress(objAddress));
	
		
		
		if(objUser.getRole().equals("USER")) {
			//create a cart for this user
			objCart = new Cart();
			objCart.setUser(objUser);
			
			objUser.setCart(objCart);
			
			//add cart
			assertEquals("Failed to add Cart",true,objUserDAO.addCart(objCart));
			
			//add shipping address for these user
			objAddress = new Address();
			objAddress.setAddressLineOne("plot no. 23 telephone Nagar");
			objAddress.setAddressLineTwo("dighori road , nagpur");
			objAddress.setCity("Nagpur");
			objAddress.setState("Maharastra");
			objAddress.setCountry("India");
			objAddress.setPostalCode("441910");
			objAddress.setShipping(true);
			
			//add shipping address
			assertEquals("Failed to add shipping address",true,objUserDAO.addAddress(objAddress));
			
		}
		
	}
	/*	*/
	/*
	@Test
	public void testAdd() {
		objUser = new User();
		objUser.setId(1);
		assertEquals("Failed to add User",true,objUserDAO.deleteUser(objUser));
	}*/
	
	/*@Test
	public void testUpdateCart() {
		
		User user = objUserDAO.findUserByEmail("shripradhan.94@gmail.com");
		System.out.println(user.toString());
		Cart cart= user.getCart();
		
		cart.setCartLines(12);
		cart.setGrandTotal(5000);
		
		assertEquals("Failed to update cart", true, objUserDAO.updateCart(cart));
		
	}*/
	
	//adding an address
	
	/*@Test
	public void testAddAddress() {
		
		// we need to add an user
		objUser = new User();
		objUser.setFirstName("Shrikant");
		objUser.setLastName("Pradhan");
		objUser.setEmail("shripradhan.94@gmail.com");
		objUser.setContactNumber("7769896344");
		objUser.setRole("USER");
		objUser.setPassword("123456");
		
		assertEquals("Failed to add User",true,objUserDAO.addUser(objUser));
		
		//we are going to add the address
		
		objAddress = new Address();
		objAddress.setAddressLineOne("202 shivkrupa house");
		objAddress.setAddressLineTwo("Dhantoli , nagpur");
		objAddress.setCity("Nagpur");
		objAddress.setState("Maharastra");
		objAddress.setCountry("India");
		objAddress.setPostalCode("441910");
		objAddress.setBilling(true);
		
		
		//attached the user to the address
		
		objAddress.setUser(objUser);
		
		assertEquals("Failed to add Address",true,objUserDAO.addAddress(objAddress));
		
		//we are also going to add the shipping address
		

		objAddress = new Address();
		objAddress.setAddressLineOne("susgaon, pune");
		objAddress.setAddressLineTwo("pune");
		objAddress.setCity("pune");
		objAddress.setState("Maharastra");
		objAddress.setCountry("India");
		objAddress.setPostalCode("441560");
		objAddress.setShipping(true);
		
		//attached the user to the address
		
		objAddress.setUser(objUser);
				
		assertEquals("Failed to add Address",true,objUserDAO.addAddress(objAddress));
	}*/
	
	/*@Test
	public void testAddAddress() {
		
		objUser = objUserDAO.findUserByEmail("shripradhan.94@gmail.com");
		objAddress = new Address();
		objAddress.setAddressLineOne(" Reddy Guda Area, Hyderabad");
		objAddress.setAddressLineTwo("near Law College, Hyderabad");
		objAddress.setCity("hyderabad");
		objAddress.setState("Telangana");
		objAddress.setCountry("India");
		objAddress.setPostalCode("446960");
		objAddress.setShipping(true);
		
		//attached the user to the address
		
		objAddress.setUser(objUser);
				
		assertEquals("Failed to add Address",true,objUserDAO.addAddress(objAddress));
		
	}
	*/
	/*@Test
	public void testGetAddrss() {
		
		objUser = objUserDAO.findUserByEmail("shripradhan.94@gmail.com");
		
		assertEquals("Failed to fetch the list of address and size dows not match!",4,objUserDAO.listShippingAddress(objUser).size());
		
		assertEquals("Failed to fetch the list of address and size dows not match!","Nagpur",objUserDAO.getBillingAddress(objUser).getCity());
		
		
	}*/
	
	
}
