package com.learning.model;

public class Student {

	private String name;
	private int age;

	public Student() {
		System.out.println("Called no-argument constructor of Student class.");
	}

	public Student(String name, int age) {
		System.out.println("Called arguments constructor of Student class.");
		this.name = name;
		this.age = age;
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

	@Override
	public String toString() {
		return "name: " + name + ", age = " + age + "\n";
	}
}
