package com.shree.onlineshopping.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shree.shoppingbackend.dao.ProductDAO;
import com.shree.shoppingbackend.dto.Product;

@Controller
@RequestMapping("/json/data")
public class JsonDataController {

	@Autowired
	private ProductDAO productDAO;

	@RequestMapping("/all/products")
	@ResponseBody
	public List<Product> getAllProducts() {
		
		List<Product> listProduct = new ArrayList<Product>();
		Product p = new Product();
		p.setName("Mobile");
		p.setBrand("Asus");
		p.setUnitPrice(12000);
		p.setQuantity(4555);
		listProduct.add(p);
		
		Product p1 = new Product();
		p1.setName("Mobile");
		p1.setBrand("Asus");
		p1.setUnitPrice(12000);
		p1.setQuantity(4555);
		
		listProduct.add(p1);

		//return listProduct;
		
		List<Product> objListProducts =  productDAO.listActiveProducts();
		
		return objListProducts;

	}
	
	@RequestMapping("/category/{id}/products")
	@ResponseBody
	public List<Product> getProductByCategory(@PathVariable("id") Integer id) {

		return productDAO.listActiveProductByCategory(id);

	}
}
