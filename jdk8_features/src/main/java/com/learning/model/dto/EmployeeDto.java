package com.learning.model.dto;

import java.util.List;
import com.learning.model.Employee;

public class EmployeeDto {

	public static List<Employee> findEmployees() {
		Employee e1 = new Employee(1, "Jack", 48, "Finance", 38000, true);
		Employee e2 = new Employee(2, "Zeeshan", 20, "Finance", 20000, false);
		Employee e3 = new Employee(3, "Travis", 16, "Health", 12000, true);
		Employee e4 = new Employee(4, "Denis", 15, "Health", 73000, false);
		Employee e5 = new Employee(5, "Symonds", 13, "Health", 11000, true);
		Employee e6 = new Employee(6, "Ferry", 15, "Technology", 55000, false);
		Employee e7 = new Employee(7, "Gagan", 16, "Technology", 13000, true);
		Employee e8 = new Employee(8, "Herry", 20, "Technology", 17000, false);
		Employee e9 = new Employee(9, "Celina", 17, "Science", 40000, true);
		Employee e10 = new Employee(10, "Adam", 38, "Science", 30000, false);

		return List.of(e1, e2, e3, e4, e5, e6, e7, e8, e9, e10);
	}

	public static void printEmployees() {
		List<Employee> employees = findEmployees();
		System.out.println(employees);
	}
}
