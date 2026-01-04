package com.learning.functionalInterfaces.customized;

import com.learning.model.Employee;

public interface EmployeeDataProvider {

	Employee get(int id, String name, int age, String dept, double salary, boolean active);
}
