package com.shree.shoppingbackend.dao;

import java.util.List;

import com.shree.shoppingbackend.dto.Product;
import com.shree.shoppingbackend.dto.ProductImage;

public interface ProductDAO {

	public Product get(int productId);
	public List<Product> list();
	public boolean add(Product product);
	public boolean add(Product product,List<ProductImage> productImages);
	public boolean update(Product product);
	public boolean delete(Product product);
	
	
	//business method
	public List<Product> listActiveProducts();
	public List<Product> listActiveProductByCategory(int categoryId);
	public List<Product> getLatestActiveProduct(int count);
	
}
