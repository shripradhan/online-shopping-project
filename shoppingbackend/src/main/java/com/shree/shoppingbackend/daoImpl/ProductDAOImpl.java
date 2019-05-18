package com.shree.shoppingbackend.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shree.shoppingbackend.dao.ProductDAO;
import com.shree.shoppingbackend.dto.Product;

@Repository("productDAO")
@Transactional
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	/*
	 * Get Single Product
	 * 
	 * */
	@Override
	public Product get(int productId) {
		try {
			
			return sessionFactory
						.getCurrentSession()
							.get(Product.class, Integer.valueOf(productId));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	/*
	 * Get List of Products
	 * 
	 * */

	@Override
	public List<Product> list() {
		
		return sessionFactory.getCurrentSession().createQuery("FROM Product",Product.class).getResultList();
	}
	
	/*
	 * Save the Product
	 * 
	 * */

	@Override
	public boolean add(Product product) {
		try {
			
			 sessionFactory
					.getCurrentSession()
							.persist(product);
			
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/*
	 * Update the Product
	 * 
	 * */

	@Override
	public boolean update(Product product) {
		try {
			
			sessionFactory
						.getCurrentSession()
									.update(product);
			
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	/*
	 * Delete the Product
	 * 
	 * */


	@Override
	public boolean delete(Product product) {
		try {
			//set product active false
			product.setActive(false);
			
			//call the update method
			return this.update(product);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/*
	 *@Get the list of All Active Products
	 * 
	 * */

	@Override
	public List<Product> listActiveProducts() {

		String selectActiveProducts = "FROM Product WHERE active = :activeProduct";
		return sessionFactory
					.getCurrentSession()
							.createQuery(selectActiveProducts,Product.class)
									.setParameter("activeProduct", true)
												.getResultList();
	}
	

	/*
	 *@Get the list of All Active Products By Category
	 * 
	 * */


	@Override
	public List<Product> listActiveProductByCategory(int categoryId) {
		String selectActiveProductsByCategory = "FROM Product WHERE active = :activeProduct AND categoryId = :categoryId";
		return sessionFactory
					.getCurrentSession()
							.createQuery(selectActiveProductsByCategory,Product.class)
									.setParameter("activeProduct", true)
												.setParameter("categoryId", categoryId)
														.getResultList();
	}
	
	/*
	 *@Get the list of All Latest (Count) number of product
	 * 
	 * */

	@Override
	public List<Product> getLatestActiveProduct(int count) {
		return sessionFactory
					.getCurrentSession()
							.createQuery("FROM Product WHERE active= :activeProduct ORDER BY id",Product.class)
									.setParameter("activeProduct", true)
											.setMaxResults(count)
														.getResultList();
	}

}
