package com.shree.onlineshopping.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shree.onlineshopping.model.UserModel;
import com.shree.shoppingbackend.dao.CartLineDAO;
import com.shree.shoppingbackend.dao.ProductDAO;
import com.shree.shoppingbackend.dto.Cart;
import com.shree.shoppingbackend.dto.CartLine;
import com.shree.shoppingbackend.dto.Product;

@Service("cartService")
public class CartService {

	@Autowired
	private CartLineDAO cartLineDAO;
	
	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private HttpSession session;
	
	/*
	 * method - getCart() -> method to get the cart obj from the current session
	 */
	private Cart getCart() {
		UserModel userModel = (UserModel)session.getAttribute("userModel");
		
		Cart cart = userModel.getCart();
		
		return cart;
	}
	
	/*
	 * method - getCartLine() -> method to get cartLine of given cart details
	 */
	public List<CartLine> getCartLine(){
		
		Cart cart = this.getCart();
		List<CartLine> listCartLine = cartLineDAO.list(cart.getId());
		return listCartLine;
		
	}
	
	public String manageCartLine(int cartLineId, int productCount) {
		
		CartLine cartLine = cartLineDAO.get(cartLineId);
		
		if(cartLine == null) {
			
			return "result=error";
			
		}else {
			
			Product product = cartLine.getProduct();
			
			Double oldTotal = cartLine.getTotal();
			
			//check if the product  is available
			if(product.getQuantity() < productCount) {
				return "result=unavailable";
			}
			
			cartLine.setProductCount(productCount);
			cartLine.setBuyingPrice(product.getUnitPrice());
			cartLine.setTotal(product.getUnitPrice() * productCount);
			cartLineDAO.update(cartLine);
			
			Cart cart = this.getCart();
			cart.setGrandTotal(cart.getGrandTotal() - oldTotal + cartLine.getTotal());
			cartLineDAO.updateCart(cart);
			
			return "result=updated";
			
		}
		
		/*cartLine.setId(cartLineId);
		cartLine.setProductCount(productCount);
		
		cartLineDAO.update(cartLine);*/
	}

	public String deleteCartLine(int cartLineId) {
		
		//fetch the CartLine
		CartLine cartLine =  cartLineDAO.get(cartLineId);
		
		if(cartLine == null) {
			return "result=error";
		}else {
			
			//update the cart
			Cart cart = this.getCart();
			
			cart.setGrandTotal(cart.getGrandTotal() - cartLine.getTotal());
			cart.setCartLines(cart.getCartLines() - 1);
			
			cartLineDAO.updateCart(cart);
			
			//remove the cartLine
			cartLineDAO.delete(cartLine);
			
			return "result=deleted";
			
		}
		
	}

	//adding the CartLine
	public String addCartLine(int productId) {
		
		String response = null;
		
		Cart cart = this.getCart();
		
		CartLine cartLine = cartLineDAO.getByCartAndProduct(cart.getId(), productId);
		
		if(cartLine == null) {
			//add a new cartLine
			cartLine = new CartLine();
			
			//fetch the product
			Product product = productDAO.get(productId);
			
			cartLine.setCartId(cart.getId());
			cartLine.setProduct(product);
			cartLine.setBuyingPrice(product.getUnitPrice());
			cartLine.setProductCount(1);
			cartLine.setTotal(product.getUnitPrice());
			cartLine.setAvailable(true);
			
			cartLineDAO.add(cartLine);
			
			cart.setCartLines(cart.getCartLines() + 1);
			cart.setGrandTotal(cart.getGrandTotal() + cartLine.getTotal());
			
			cartLineDAO.updateCart(cart);
			
			
			response = "result=added";
		}else {
			
			//check if the cartLine has reached the maximum count
			if(cartLine.getProductCount() < 3) {
				//update the productCount for that cartLine
				response = this.manageCartLine(cartLine.getId(), cartLine.getProductCount() + 1);
				
			}else {
				response = "result=maximum";
			}
			
		}
		
		return response;
		
	}
}
