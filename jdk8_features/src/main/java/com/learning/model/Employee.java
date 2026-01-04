package com.learning.model;

public class Employee {
	private int id;
	private String name;
	private int age;
	private String dept;
	private double salary;
	private boolean active;

	public Employee() {
		System.out.println("Called no-argument constructor of Employee class.");
	}

	public Employee(int id, String name, int age, String dept, double salary, boolean active) {
		System.out.println("Called arguments constructor of Employee class.");
		this.id = id;
		this.name = name;
		this.age = age;
		this.dept = dept;
		this.salary = salary;
		this.active = active;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "id = " + id + ", name = " + name + ", age = " + age + ", dept = " + dept + ", salary = " + salary
				+ ", active = " + active + "\n";
	}

}
