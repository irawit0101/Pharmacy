package com.pharmacy.model;

import java.math.BigDecimal;

public class Medicine {
	int id;
	String name;
	BigDecimal price;
	int quantity;
	
	public Medicine(int id, String name, BigDecimal price, int quantity) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Medicine [id=" + id + ", name=" + name + ", price=" + price + ", quantity=" + quantity + "]";
	}

	

	
	
}
