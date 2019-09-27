package com.shree.shoppingbackend.dao;

import java.util.List;

import com.shree.shoppingbackend.dto.Cart;
import com.shree.shoppingbackend.dto.CartLine;

public interface CartLineDAO {

	//the common methods
	
	public CartLine get(int id);
	
	public boolean add(CartLine cartLine);
	
	public boolean update(CartLine cartLine);
	
	public boolean delete(CartLine cartLine);
	
	public List<CartLine> list(int cartId);

	
	//other bussiness methods
	public List<CartLine> listAvailable(int cartId);
	
	public CartLine getByCartAndProduct(int cartId, int productId);
	
	//update the cart
	public boolean updateCart(Cart cart);
	
	
}
