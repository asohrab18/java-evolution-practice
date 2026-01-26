package com.learning.model;

import java.time.LocalDate;
import java.util.Objects;

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

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof Order)) {
			return false;
		}
		Order e = (Order) o;
		return orderId == e.orderId; // distinct based on id
	}

	@Override
	public int hashCode() {
		return Objects.hash(orderId);
	}
}
