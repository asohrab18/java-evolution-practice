package com.learning.streamsApi;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import com.learning.model.Employee;
import com.learning.model.EmployeeDto;

public class CollectorsDemo {

	private static List<Employee> employees = EmployeeDto.findEmployees();

	static void printEmployeesByDepartment() {
		Map<String, List<Employee>> byDept = employees.stream().collect(Collectors.groupingBy(Employee::getDept));

		System.out.println(byDept);
	}

	public static void main(String[] args) {
		printEmployeesByDepartment();
	}

}
