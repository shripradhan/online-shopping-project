package com.shree.shoppingbackend.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cart_line")
public class CartLine implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/*
	 * private fields
	 * 
	 */
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@OneToOne
	private Product product;
	
	@Column(name = "cart_id")
	private int cartId;
	
	@Column(name = "product_count")
	private int productCount;
	
	private Double total;
	
	@Column(name = "buying_price")
	private Double buyingPrice;
	
	@Column(name = "is_available")
	private Boolean available = true;

	
	/*
	 * getters and setters for above private fields
	 * 
	 * 
	 */
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public int getProductCount() {
		return productCount;
	}

	public void setProductCount(int productCount) {
		this.productCount = productCount;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public Double getBuyingPrice() {
		return buyingPrice;
	}

	public void setBuyingPrice(Double buyingPrice) {
		this.buyingPrice = buyingPrice;
	}

	public Boolean getAvailable() {
		return available;
	}

	public void setAvailable(Boolean available) {
		this.available = available;
	}

	@Override
	public String toString() {
		return "CartLine [id=" + id + ", product=" + product + ", cartId=" + cartId + ", productCount=" + productCount
				+ ", total=" + total + ", buyingPrice=" + buyingPrice + ", available=" + available + "]";
	}
	

}
