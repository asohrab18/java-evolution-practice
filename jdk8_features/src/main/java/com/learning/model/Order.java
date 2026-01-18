package com.learning.model;

import java.time.LocalDate;

public class Order {

	private int orderId;
	private LocalDate orderDate;

	public Order() {
	}

	public Order(int orderId, LocalDate orderDate) {
		this.orderId = orderId;
		this.orderDate = orderDate;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	@Override
	public String toString() {
		return "{orderId = " + orderId + " has orderDate = " + orderDate + "}";
	}

}
