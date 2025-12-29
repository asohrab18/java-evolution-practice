package com.learning.model;

public class Employee {
	private int id;
	private String name;
	private String dept;
	private double salary;
	private boolean active;

	public Employee() {
	}

	public Employee(int id, String name, String dept, double salary, boolean active) {
		super();
		this.id = id;
		this.name = name;
		this.dept = dept;
		this.salary = salary;
		this.active = active;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDept() {
		return dept;
	}

	public double getSalary() {
		return salary;
	}

	public boolean isActive() {
		return active;
	}

	@Override
	public String toString() {
		return "id = " + id + ", name = " + name + ", dept = " + dept + ", salary = " + salary + ", active = " + active
				+ "\n";
	}

}
