package com.shree.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.shree.shoppingbackend.dao.ProductDAO;
import com.shree.shoppingbackend.dto.Product;

public class ProductTestCase {
	
	private static AnnotationConfigApplicationContext context;
	
	private static ProductDAO productDAO;
	
	private Product product;
	
	@BeforeClass
	public static void init() {
		
		context = new AnnotationConfigApplicationContext();
		context.scan("com.shree.shoppingbackend");
		context.refresh();
		productDAO = (ProductDAO) context.getBean("productDAO");
		
	}
	
	@Test
	public void testAddProduct() {
		//add new Product operation
		product = new Product();
		//set properties
		product.setName("Lenovo V330(14)");
		product.setBrand("Lenovo");
		product.setDescription("Remarkable value, impressive results");
		product.setUnitPrice(76452);
		product.setActive(true);
		product.setCategoryId(103);
		product.setSupplierId(3000);
	
		assertEquals("Something went wrong while inserting a new Product ..! ", true, productDAO.add(product));
	}
	
	
	/*@Test
	public void testReadAndUpdate() {
		//get the product having id 1202
		product = productDAO.get(1202);
		//update the unit price of existing product
		product.setUnitPrice(24580);
		
		
		assertEquals("Something went wrong while updating  a existing Product ..! ", true, productDAO.update(product));
	}*/
	
	/*@Test
	public void testDeleteProduct() {
		//get the product having id 1202
		product = productDAO.get(1202);
		
		assertEquals("Something went wrong while deleting a existing Product...!", true, productDAO.delete(product));
	}*/
	
/*	@Test
	public void testListProduct() {
				assertEquals("Something went wrong while getting all  existing Product...!", 3, productDAO.list().size());
	}*/
	
	
	/*@Test
	public void testListOfActiveProducts() {
		
		assertEquals("Something went wrong while Fetching all active Product...!", 2, productDAO.listActiveProducts().size());
		
	}*/

	
	/*@Test
	public void testListOfProductsByCategory() {
		
		assertEquals("Something went wrong while Fetching Products by Category...!", 2, productDAO.listActiveProductByCategory(101).size());
		
	}*/
	
	
	
//	@Test
//	public void testListOfLatestActiveProduct() {
//		
//		assertEquals("Something went wrong while Fetching Latest Active Products ..!", 2, productDAO.getLatestActiveProduct(2).size());
//		
//	}
	
	
	/*@Test
	public void testCRUDProduct() {
		
		//add new Product operation
		product = new Product();
		//set properties
		product.setName("Oppo Selfie S53");
		product.setBrand("Oppo");
		product.setDescription("A New Oppo Phone for gread selfie");
		product.setUnitPrice(25000);
		product.setActive(true);
		product.setCategoryId(101);
		product.setSupplierId(3002);
	
		assertEquals("Something went wrong while inserting a new Product ..! ", true, productDAO.add(product));
		
	}
*/
}
