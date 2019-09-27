package com.shree.shoppingbackend.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shree.shoppingbackend.dao.CartLineDAO;
import com.shree.shoppingbackend.dto.Cart;
import com.shree.shoppingbackend.dto.CartLine;

@Repository("cartLineDAO")
@Transactional
public class CartLineDAOImpl implements CartLineDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	/*
	 * Get Single CartLine
	 */

	
	@Override
	public CartLine get(int id) {
		try {

			return sessionFactory
					.getCurrentSession()
						.get(CartLine.class, Integer.valueOf(id));
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}

		return null;
	}
	
	/*
	 * Add New CartLine
	 *  
	 */

	@Override
	public boolean add(CartLine cartLine) {
		try {
			
			 Session session = sessionFactory.getCurrentSession();
			 session.persist(cartLine);
			
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/*
	 * Update Existing CartLine
	 * 	 
	 */

	@Override
	public boolean update(CartLine cartLine) {
		try {

			sessionFactory.getCurrentSession().update(cartLine);

			return true;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}
	
	/*
	 * Delete Existing CartLine
	 * 	 
	 */

	@Override
	public boolean delete(CartLine cartLine) {
		try {
			sessionFactory.getCurrentSession().delete(cartLine);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/*
	 *Get List of CartLines
	 * 	 
	 */

	@Override
	public List<CartLine> list(int cartId) {
		String selectCartLines = "FROM CartLine WHERE cartId = :cartId";
		return sessionFactory
					.getCurrentSession()
							.createQuery(selectCartLines,CartLine.class)
									.setParameter("cartId", cartId)
														.getResultList();
	}
	
	/*
	 * Get Available CartLine
	 * 	 
	 */

	@Override
	public List<CartLine> listAvailable(int cartId) {
		return sessionFactory
				.getCurrentSession()
						.createQuery("FROM CartLine WHERE available =:available",CartLine.class)
								.setParameter("available", true)
													.getResultList();
	}
	
	/*
	 * Get CartLine with Criteria CartId and ProductId
	 * 	 
	 */

	@Override
	public CartLine getByCartAndProduct(int cartId, int productId) {
		try {
			return sessionFactory
					.getCurrentSession()
							.createQuery("FROM CartLine WHERE cartId =:cartId AND  product.id =:productId",CartLine.class)
								.setParameter("cartId", cartId)
									.setParameter("productId", productId)
														.getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public boolean updateCart(Cart cart) {
		try {

			sessionFactory.getCurrentSession().update(cart);

			return true;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

}
