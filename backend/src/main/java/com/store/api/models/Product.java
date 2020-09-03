package com.store.api.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "products")
public class Product {

	@Id
	private String id;
	private String nameProduct;
	private Integer quantiteProduct;
	private Float priceProduct;

	public Product(String nameProduct, Integer quantiteProduct, Float priceProduct) {

		this.nameProduct = nameProduct;
		this.quantiteProduct = quantiteProduct;
		this.priceProduct = priceProduct;
	}
	
	public Product () {}
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNameProduct() {
		return nameProduct;
	}

	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}

	public Integer getQuantiteProduct() {
		return quantiteProduct;
	}

	public void setQuantiteProduct(Integer quantiteProduct) {
		this.quantiteProduct = quantiteProduct;
	}

	public Float getPriceProduct() {
		return priceProduct;
	}

	public void setPriceProduct(Float priceProduct) {
		this.priceProduct = priceProduct;
	}
}
