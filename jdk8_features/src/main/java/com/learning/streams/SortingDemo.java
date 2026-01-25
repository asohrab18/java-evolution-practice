package com.learning.streams;

import java.util.Comparator;
import com.learning.model.AppUtils;
import com.learning.model.Employee;

public class SortingDemo {

	static void sortEmployees(String field, String order) {
		Comparator<Employee> comparator = null;

		if (field.equals("id")) {
			if (order.equalsIgnoreCase("DESC")) {
				// DESCENDING ORDER
				comparator = (e1, e2) -> (e1.getId() > e2.getId()) ? -1 : (e1.getId() < e2.getId()) ? 1 : 0;
			} else {
				// ASCENDING ORDER
				comparator = (e1, e2) -> (e1.getId() > e2.getId()) ? 1 : (e1.getId() < e2.getId()) ? -1 : 0;
			}
		} else if (field.equals("name")) {
			if (order.equalsIgnoreCase("DESC")) {
				// DESCENDING ORDER
				comparator = (e1, e2) -> e2.getName().compareTo(e1.getName());
			} else {
				// ASCENDING ORDER
				comparator = (e1, e2) -> e1.getName().compareTo(e2.getName());
			}
		} else if (field.equals("age")) {
			if (order.equalsIgnoreCase("DESC")) {
				// DESCENDING ORDER
				comparator = (e1, e2) -> (e1.getAge() > e2.getAge()) ? -1 : (e1.getAge() < e2.getAge()) ? 1 : 0;
			} else {
				// ASCENDING ORDER
				comparator = (e1, e2) -> (e1.getAge() > e2.getAge()) ? 1 : (e1.getAge() < e2.getAge()) ? -1 : 0;
			}
		}

		else if (field.equals("dept")) {
			if (order.equalsIgnoreCase("DESC")) {
				// DESCENDING ORDER
				comparator = (e1, e2) -> e2.getDept().compareTo(e1.getDept());
			} else {
				// ASCENDING ORDER
				comparator = (e1, e2) -> e1.getDept().compareTo(e2.getDept());
			}
		} else if (field.equals("salary")) {
			if (order.equalsIgnoreCase("DESC")) {
				// DESCENDING ORDER
				comparator = (e1, e2) -> (e1.getSalary() > e2.getSalary()) ? -1
						: (e1.getSalary() < e2.getSalary()) ? 1 : 0;
			} else {
				// ASCENDING ORDER
				comparator = (e1, e2) -> (e1.getSalary() > e2.getSalary()) ? 1
						: (e1.getSalary() < e2.getSalary()) ? -1 : 0;
			}
		} else if (field.equals("active")) {
			if (order.equalsIgnoreCase("DESC")) {
				// DESCENDING ORDER (First display all true and then false)
				comparator = (e1, e2) -> Boolean.valueOf(e2.isActive()).compareTo(Boolean.valueOf(e1.isActive()));
				// Method-2: comparator = (e1, e2) -> Boolean.compare(e2.isActive(),
				// e1.isActive());

			} else {
				// ASCENDING ORDER (First display all false and then true)
				comparator = (e1, e2) -> Boolean.valueOf(e1.isActive()).compareTo(Boolean.valueOf(e2.isActive()));
				// Method-2: comparator = (e1, e2) -> Boolean.compare(e1.isActive(),
				// e2.isActive());
			}
		}

		AppUtils.EMPLOYEES.stream().sorted(comparator).forEach(e -> System.out.println(e));
	}

	public static void main(String[] args) {
		sortEmployees("age", "DESC");
	}
}
