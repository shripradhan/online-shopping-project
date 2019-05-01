package com.shree.shoppingbackend.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.shree.shoppingbackend.dao.CategoryDAO;
import com.shree.shoppingbackend.dto.Category;

@Repository("objCategory")
public class CategoryDAOImpl implements CategoryDAO{

	private static List<Category> categories = new ArrayList<Category>();
	
	static {
		Category category = new Category();
		category.setId(0);
		category.setName("Television");
		categories.add(category);
		
		category = new Category();
		category.setId(2);
		category.setName("Mobile");
		categories.add(category);
		
		category = new Category();
		category.setId(3);
		category.setName("Laptop");
		categories.add(category);
		
		category = new Category();
		category.setId(4);
		category.setName("Desktop");
		categories.add(category);
	}
	
	@Override
	public List<Category> listCategory() {
		// TODO Auto-generated method stub
		return categories;
	}

	@Override
	public Category get(int id) {
		// TODO Auto-generated method stub
		for(Category category : categories) {
			if(category.getId() == id) 
				return category;
		}
		return null;
	}

}
