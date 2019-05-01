package com.shree.shoppingbackend.dao;

import java.util.List;

import com.shree.shoppingbackend.dto.Category;

public interface CategoryDAO {

	public List<Category> listCategory();
	
	public Category get(int id);
}
