package com.learning.model;

public class Student {

	private String name;
	private int age;
	private double[] marks;

	public Student() {
	}

	public Student(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public Student(String name, int age, double[] marks) {
		this.name = name;
		this.age = age;
		this.marks = marks;
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

	public double[] getMarks() {
		return marks;
	}

	public void setMarks(double[] marks) {
		this.marks = marks;
	}

	@Override
	public String toString() {
		return "name: " + name + ", age = " + age + "\n";
	}
}