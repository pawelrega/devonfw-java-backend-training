package com.devonfw.app.java.order.orderservice.dataaccess.api;

import javax.persistence.Entity;

@Entity(name="Item")
public class ItemEntity {

	private String name;

	private String description;

	private Double price;

	private static final long serialVersionUID = 1L;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String lastname) {
		this.description = lastname;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
}
