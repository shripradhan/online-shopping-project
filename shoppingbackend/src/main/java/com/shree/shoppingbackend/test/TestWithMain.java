package com.shree.shoppingbackend.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.shree.shoppingbackend.dao.CategoryDAO;
import com.shree.shoppingbackend.dto.Category;

public class TestWithMain {

	//JUNIT Test Case
		private static AnnotationConfigApplicationContext context;
		
		private static CategoryDAO categoryDAO;
		
		//private  Category category;
		
		
	public static void main(String[] args) {
		//create AnnotationConfigApplicationContext container
		context = new AnnotationConfigApplicationContext();
		context.scan("com.shree.shoppingbackend");
		context.refresh();
		//get CategoryDAO bean object
		categoryDAO = (CategoryDAO) context.getBean("objCategory");
		System.out.println(categoryDAO.getClass());
		Category category = new Category();
		category.setName("Television");
		category.setDescription("All Branded Television");
		category.setImageUrl("tel_02.jpg");
		category.setActive(true);
		categoryDAO.addCategory(category);
	}

}
