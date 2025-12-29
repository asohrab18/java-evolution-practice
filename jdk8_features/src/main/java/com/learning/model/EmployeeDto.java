package com.learning.model;

import java.util.List;

public class EmployeeDto {

	public static List<Employee> findEmployees() {
		Employee e1 = new Employee(1, "A", "AI", 10000, true);
		Employee e2 = new Employee(2, "B", "BBA", 20000, false);
		Employee e3 = new Employee(3, "C", "AI", 30000, true);
		Employee e4 = new Employee(4, "D", "AI", 40000, false);
		Employee e5 = new Employee(5, "E", "AI", 45000, true);
		Employee e6 = new Employee(6, "F", "FI", 60000, false);
		Employee e7 = new Employee(7, "G", "GI", 70000, true);
		Employee e8 = new Employee(8, "H", "HI", 80000, false);
		Employee e9 = new Employee(9, "I", "AI", 90000, true);
		Employee e10 = new Employee(10, "J", "AI", 140000, false);
		Employee e11 = new Employee(11, "K", "LI", 150000, true);
		Employee e12 = new Employee(12, "L", "AI", 200000, false);
		Employee e13 = new Employee(13, "M", "NI", 130000, false);
		Employee e14 = new Employee(14, "N", "AI", 110000, true);
		Employee e15 = new Employee(15, "O", "PI", 34000, false);

		return List.of(e1, e2, e3, e4, e5, e6, e7, e8, e9, e10, e11, e12, e13, e14, e15);
	}
}
