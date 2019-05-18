package com.shree.shoppingbackend.dao;

import java.util.List;

import com.shree.shoppingbackend.dto.Category;

public interface CategoryDAO {
	
	public boolean addCategory(Category category);
	
	public Category get(int id);
	
	public List<Category> listCategory();
	
	public boolean updateCategory(Category category);
	
	public boolean deleteCategory(Category category);
	
	
}
