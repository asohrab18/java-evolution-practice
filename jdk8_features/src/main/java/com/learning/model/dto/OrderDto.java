package com.learning.model.dto;

import java.time.LocalDate;
import java.util.List;
import com.learning.model.Order;

public class OrderDto {

	public static List<Order> findOrders() {
		Order o1 = new Order(111, LocalDate.of(2023, 1, 18));
		Order o2 = new Order(222, LocalDate.of(2025, 3, 8));
		Order o3 = new Order(333, LocalDate.of(2021, 6, 9));
		Order o4 = new Order(444, LocalDate.of(2026, 1, 12));
		Order o5 = new Order(555, LocalDate.of(2020, 8, 10));
		Order o6 = new Order(666, LocalDate.of(2024, 9, 16));
		Order o7 = new Order(777, LocalDate.of(2025, 10, 11));
		Order o8 = new Order(888, LocalDate.of(2024, 11, 21));

		return List.of(o1, o2, o3, o4, o5, o6, o7, o8);
	}

	public static void printOrders() {
		System.out.println(findOrders());
	}
}
