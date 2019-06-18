package com.shree.shoppingbackend.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Product {
	
	//private fields
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String code;
	
	@NotBlank
	private String name;
	
	@NotBlank
	private String brand;
	
	@NotBlank
	private String description;
	
	@Column(name="unit_price")
	@Min(value=1)
	private double unitPrice;
	
	private int quantity;
	
	@JsonIgnore
	@Column(name="is_active")
	private boolean active;
	
	@JsonIgnore
	@Column(name="category_id")
	private int categoryId;
	
	@JsonIgnore
	@Column(name="supplier_id")
	private int supplierId;
	
	private int purchases;
	
	private int views;
	
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	@JsonManagedReference
	private List<ProductImage> productImages = new ArrayList<ProductImage>();
	
	
	@Transient
	private List<MultipartFile> imgFiles = new ArrayList<MultipartFile>();
	
	
	//default constructor
	public Product() {
		this.code = "IMG"+UUID.randomUUID().toString().substring(33).toUpperCase();
	}
	
	//setters and getters methods 

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public int getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}

	public int getPurchases() {
		return purchases;
	}

	public void setPurchases(int purchases) {
		this.purchases = purchases;
	}

	public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
	}

	
	public List<MultipartFile> getImgFiles() {
		return imgFiles;
	}

	public void setProductImages(List<ProductImage> productImages) {
		this.productImages = productImages;
	}

	public List<ProductImage> getProductImages() {
		return productImages;
	}
	
	public void setImgFiles(List<MultipartFile> imgFiles) {
		this.imgFiles = imgFiles;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", code=" + code + ", name=" + name + ", brand=" + brand + ", description="
				+ description + ", unitPrice=" + unitPrice + ", quantity=" + quantity + ", active=" + active
				+ ", categoryId=" + categoryId + ", supplierId=" + supplierId + ", purchases=" + purchases + ", views="
				+ views + ", imgFiles=" + imgFiles + "]";
	}


	
	
	

}
