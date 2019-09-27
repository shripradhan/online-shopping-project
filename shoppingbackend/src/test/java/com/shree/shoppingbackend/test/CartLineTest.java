package com.shree.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.shree.shoppingbackend.dao.CartLineDAO;
import com.shree.shoppingbackend.dao.ProductDAO;
import com.shree.shoppingbackend.dao.UserDAO;
import com.shree.shoppingbackend.dto.Cart;
import com.shree.shoppingbackend.dto.CartLine;
import com.shree.shoppingbackend.dto.Product;
import com.shree.shoppingbackend.dto.User;

public class CartLineTest {

	
	private static AnnotationConfigApplicationContext context;
	
	private static CartLineDAO cartLineDAO;
	
	private static UserDAO userDAO;
	
	private static ProductDAO productDAO;
	
	private CartLine cartLine;
	
	@BeforeClass
	public static void init() {
		
		context = new AnnotationConfigApplicationContext();
		context.scan("com.shree.shoppingbackend");
		context.refresh();
		
		userDAO = (UserDAO) context.getBean("userDAO");
		productDAO = (ProductDAO) context.getBean("productDAO");
		cartLineDAO = (CartLineDAO) context.getBean("cartLineDAO");
		
	}
	
	@Test
	public void addCartLineTest() {
		
		//1. get the user
		User user = userDAO.findUserByEmail("vishu@gmail.com");
		
		//2. get the cart
		Cart cart = user.getCart();
		
		//3. get the product
		Product product = productDAO.get(1209);
		
		//4. create a new cart line
		cartLine = new CartLine();
		
		cartLine.setBuyingPrice(product.getUnitPrice());
		cartLine.setProductCount(cartLine.getProductCount());
		cartLine.setTotal(cartLine.getProductCount() * product.getUnitPrice());
		cartLine.setAvailable(true);
		cartLine.setCartId(cart.getId());
		cartLine.setProduct(product);
		
		assertEquals("Failed to add the cartLine", true, cartLineDAO.add(cartLine));
		
		//update the cart
		cart.setGrandTotal(cart.getGrandTotal() + cartLine.getTotal());
		
		cart.setCartLines(cart.getCartLines() + 1);
		
		assertEquals("Failed to update the cart", true, cartLineDAO.updateCart(cart));
	}
}
