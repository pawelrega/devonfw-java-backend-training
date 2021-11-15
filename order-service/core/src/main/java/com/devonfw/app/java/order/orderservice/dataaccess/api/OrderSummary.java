package com.devonfw.app.java.order.orderservice.dataaccess.api;

import java.time.LocalDate;

public class OrderSummary {

	private Double price;

	private CustomerEntity owner;

	private LocalDate creationDate;

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public CustomerEntity getOwner() {
		return owner;
	}

	public void setOwner(CustomerEntity owner) {
		this.owner = owner;
	}

	public LocalDate getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;
	}


}
