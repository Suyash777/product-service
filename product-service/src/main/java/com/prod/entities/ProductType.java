package com.prod.entities;

import java.util.Map;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapKeyColumn;


@Entity
public class ProductType {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(unique = true,nullable = false)
	private String productTypeName;
	@Column(unique = true,nullable = false)
	private String productTypeKey;

	@ElementCollection
	@CollectionTable(name = "AttributeDefination", joinColumns = {@JoinColumn(name = "product_Type_id", referencedColumnName = "id") })
	@MapKeyColumn(name = "DefinationName")
	@Column(name = "DefinationType")
	private Map<String, String> attributeDefination;

	
	public ProductType() {
		super();
	}
	
	public ProductType(String productTypeName, String productTypeKey, Map<String, String> attributeDefination) {
		super();
		this.productTypeName = productTypeName;
		this.productTypeKey = productTypeKey;
		this.attributeDefination = attributeDefination;
	}

	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getProductTypeName() {
		return productTypeName;
	}


	public void setProductTypeName(String productTypeName) {
		this.productTypeName = productTypeName;
	}


	public String getProductTypeKey() {
		return productTypeKey;
	}


	public void setProductTypeKey(String productTypeKey) {
		this.productTypeKey = productTypeKey;
	}


	public Map<String, String> getAttributeDefination() {
		return attributeDefination;
	}

	public void setAttributeDefination(Map<String, String> attributeDefination) {
		this.attributeDefination = attributeDefination;
	}

}
