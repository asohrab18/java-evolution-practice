package com.learning.model;

import java.util.List;

public class EmployeeDto {

	public static List<Employee> findEmployees() {
		Employee e1 = new Employee(1, "Adam", 48, "Finance", 38000, true);
		Employee e2 = new Employee(2, "Baby", 20, "Finance", 20000, false);
		Employee e3 = new Employee(3, "Celina", 16, "Human Resource", 12000, true);
		Employee e4 = new Employee(4, "Denis", 15, "Human Resource", 13000, false);
		Employee e5 = new Employee(5, "Eliza", 13, "Human Resource", 11000, true);
		Employee e6 = new Employee(6, "Ferry", 15, "Information Technology", 15000, false);
		Employee e7 = new Employee(7, "Gagan", 16, "Information Technology", 13000, true);
		Employee e8 = new Employee(8, "Herry", 20, "Information Technology", 17000, false);
		Employee e9 = new Employee(9, "Ilyas", 17, "Science", 40000, true);
		Employee e10 = new Employee(10, "Jack", 38, "Science", 30000, false);

		return List.of(e1, e2, e3, e4, e5, e6, e7, e8, e9, e10);
	}

	public static void printEmployees() {
		List<Employee> employees = findEmployees();
		System.out.println(employees);
	}
}
