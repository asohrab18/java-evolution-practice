package com.learning.model;

public class Student {

	private String name;
	private int age;
	private double[] marks;
	private int[] subjectsCodes;
	private long[] questionPapersCodes;

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

	public Student(String name, int age, int[] subjectsCodes) {
		this.name = name;
		this.age = age;
		this.subjectsCodes = subjectsCodes;
	}

	public Student(String name, int age, long[] questionPapersCodes) {
		this.name = name;
		this.age = age;
		this.questionPapersCodes = questionPapersCodes;
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

	public int[] getSubjectsCodes() {
		return subjectsCodes;
	}

	public void setSubjectsCodes(int[] subjectsCodes) {
		this.subjectsCodes = subjectsCodes;
	}

	public long[] getQuestionPapersCodes() {
		return questionPapersCodes;
	}

	public void setQuestionPapersCodes(long[] questionPapersCodes) {
		this.questionPapersCodes = questionPapersCodes;
	}

	@Override
	public String toString() {
		return "name: " + name + ", age = " + age + "\n";
	}
}