package com.shree.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.shree.shoppingbackend.dao.CategoryDAO;
import com.shree.shoppingbackend.dto.Category;

public class CategoryTestCase {

	//JUNIT Test Case
	private static AnnotationConfigApplicationContext context;
	
	private static CategoryDAO categoryDAO;
	
	private  Category category;
	
	/*@BeforeClass
	public static void init() {
		
		//create AnnotationConfigApplicationContext container
		context = new AnnotationConfigApplicationContext();
		context.scan("com.shree.shoppingbackend");
		context.refresh();
		
		//get CategoryDAO bean object
		categoryDAO = (CategoryDAO) context.getBean("objCategory");
	
	}*/
	
	/*@Test
	public void testAddCategory() {
		
		//perform addCategory() operation
		category = new Category();
		category.setName("Laptop");
		category.setDescription("Latest and Branded Laptop");
		category.setImageUrl("laptop_05.jpg");
		category.setActive(true);
		
		assertEquals("Successfully Add Category into DB table",true,categoryDAO.addCategory(category));
	
	}*/
	
	/*@Test
	public void testGetCategory() {
		
		//perform get() operation
		Category category = categoryDAO.get(102);
		//System.out.println("Category Name : "+category.getName());
		assertEquals("Successfully fetched Category from DB table","Laptop",category.getName());
	
	}*/
	
	/*@Test
	public void testUpdateCategory() {
		
		//perform get() operation
		Category category = categoryDAO.get(100);
		//System.out.println(category.getName());
		category.setName("Television");
		//System.out.println("Category Name : "+category.getName());
		assertEquals("Successfully update Category from DB table",true,categoryDAO.updateCategory(category));
	
	}
	
	*/
	
	/*@Test
	public void testDeleteCategory() {
		
		//perform deleteCategory() operation
		Category category = categoryDAO.get(100);
		
		assertEquals("Successfully deleted Category from DB table",true,categoryDAO.deleteCategory(category));
	
	
	}*/
	
	@Test
	public void testListCategory() {
		
		//assertEquals("Successfully fetched list of  Category from DB table",1,categoryDAO.listCategory().size());
	
	
	}
	
}
