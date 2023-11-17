package com.prod.entities;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Product {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(unique = true,nullable = false)
	private String productKey;
	@Column(unique = true,nullable = false) 
	private String productName;
	@Column(unique = true,nullable = false)
	private String productDescription; 

	@OneToMany(cascade = CascadeType.ALL)
	private Set<Categories> categories;
	
	@OneToOne(cascade = CascadeType.ALL) 
	private ProductType productType;
	
	@OneToOne(cascade = CascadeType.ALL)
	private ProductVariant masterVariant;
	
	@OneToMany(cascade = CascadeType.ALL)
	private Set<ProductVariant> variants;

	public Product() {
		super();
	}


	public Product(String productKey, String productName, String productDescription, Set<Categories> categories,
			ProductType productType, ProductVariant masterVariant, Set<ProductVariant> variants) {
		super();
		this.productKey = productKey;
		this.productName = productName;
		this.productDescription = productDescription;
		this.categories = categories;
		this.productType = productType;
		this.masterVariant = masterVariant;
		this.variants = variants;
	}



	public ProductVariant getMasterVariant() {
		return masterVariant;
	}


	public void setMasterVariant(ProductVariant masterVariant) {
		this.masterVariant = masterVariant;
	}


	public Set<ProductVariant> getVariants() {
		return variants;
	}


	public void setVariants(Set<ProductVariant> variants) {
		this.variants = variants;
	}


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getProductKey() {
		return productKey;
	}

	public void setProductKey(String productKey) {
		this.productKey = productKey;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public Set<Categories> getCategories() {
		return categories;
	}

	public void setCategories(Set<Categories> categories) {
		this.categories = categories;
	}

	public ProductType getProductType() {
		return productType;
	}

	public void setProductType(ProductType productType) {
		this.productType = productType;
	}
	
	
	
	
}
