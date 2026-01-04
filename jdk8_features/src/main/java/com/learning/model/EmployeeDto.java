package com.learning.model;

import java.util.List;

public class EmployeeDto {

	public static List<Employee> findEmployees() {
		Employee e1 = new Employee(1, "Adam", 48, "AI", 10000, true);
		Employee e2 = new Employee(2, "Baby", 20, "BBA", 20000, false);
		Employee e3 = new Employee(3, "Celina", 16, "AI", 30000, true);
		Employee e4 = new Employee(4, "Denis", 15, "AI", 40000, false);
		Employee e5 = new Employee(5, "Eliza", 13, "AI", 45000, true);
		Employee e6 = new Employee(6, "Ferry", 15, "FI", 60000, false);
		Employee e7 = new Employee(7, "Gagan", 16, "GI", 70000, true);
		Employee e8 = new Employee(8, "Herry", 20, "HI", 80000, false);
		Employee e9 = new Employee(9, "Ilyas", 17, "AI", 90000, true);
		Employee e10 = new Employee(10, "Jack", 38, "AI", 140000, false);
		Employee e11 = new Employee(11, "Kim", 40, "LI", 150000, true);
		Employee e12 = new Employee(12, "Lina", 15, "AI", 200000, false);
		Employee e13 = new Employee(13, "Maddy", 14, "NI", 130000, false);
		Employee e14 = new Employee(14, "Nick", 17, "AI", 110000, true);
		Employee e15 = new Employee(15, "Oberoi", 16, "PI", 34000, false);

		return List.of(e1, e2, e3, e4, e5, e6, e7, e8, e9, e10, e11, e12, e13, e14, e15);
	}

	public static void printEmployees() {
		List<Employee> employees = findEmployees();
		System.out.println(employees);
	}
}
