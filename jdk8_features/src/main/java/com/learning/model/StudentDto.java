package com.learning.model;

import java.util.List;

public class StudentDto {

	public static List<Student> findStudents() {
		Student s1 = new Student("Adam", 48);
		Student s2 = new Student("Baby", 20);
		Student s3 = new Student("Celina", 36);
		Student s4 = new Student("Denis", 55);
		Student s5 = new Student("Eliza", 13);

		return List.of(s1, s2, s3, s4, s5);
	}

	public static List<Student> findStudentsWithMarks() {
		Student s1 = new Student("Adam", 48, new double[] { 58.35d, 97.45d, 40.85d });
		Student s2 = new Student("Baby", 20, new double[] { 68.55d, 87.65d, 50.75d });
		Student s3 = new Student("Celina", 36, new double[] { 78.35d, 77.45d, 60.85d });
		Student s4 = new Student("Denis", 55, new double[] { 88.35d, 67.45d, 70.85d });
		Student s5 = new Student("Eliza", 13, new double[] { 98.35d, 57.45d, 80.85d });

		return List.of(s1, s2, s3, s4, s5);
	}

	public static void printStudents() {
		List<Student> students = findStudents();
		System.out.println(students);
	}
}
