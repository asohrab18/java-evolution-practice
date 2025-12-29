package com.learning.streamsApi;

import java.util.List;

import com.learning.model.Employee;
import com.learning.model.EmployeeDto;

public class FilteringDemo {

	public static void main(String[] args) {
		List<Employee> employees = EmployeeDto.findEmployees();

		//1. Print all employees
		employees.stream().forEach(e -> System.out.println(e));
		
		//2. Print employees with salary > 50000 and isActive = true

	}

}
