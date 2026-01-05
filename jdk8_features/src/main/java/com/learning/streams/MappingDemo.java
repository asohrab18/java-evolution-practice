package com.learning.streams;

import java.util.List;
import com.learning.model.Employee;
import com.learning.model.EmployeeDto;

public class MappingDemo {
	private static List<Employee> employees = EmployeeDto.findEmployees();

	static void printEmployeeNames() {
		List<String> names = employees.stream().map(e -> e.getName()).toList();
		System.out.println(names);
	}

	public static void main(String[] args) {
		printEmployeeNames();
	}
}
