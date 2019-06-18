package com.shree.shoppingbackend.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="productImages")
public class ProductImage {

	
	//private properties
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="img_id")
	private int id;
	
	@Column(name="img_name")
	private String imgName;
	
	@ManyToOne
	@JoinColumn(name="id")
	@JsonBackReference
	private Product product;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getImgName() {
		return imgName;
	}

	public void setImgName(String imgName) {
		this.imgName = imgName;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	
}
