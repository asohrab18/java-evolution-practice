package com.learning.model;

import java.util.List;

public class StudentDto {

	public static List<Student> findStudents() {
		Student s1 = new Student("Adam", 48);
		Student s2 = new Student("Baby", 20);
		Student s3 = new Student("Celina", 36);
		Student s4 = new Student("Denis", 15);
		Student s5 = new Student("Eliza", 13);

		return List.of(s1, s2, s3, s4, s5);
	}

	public static void printStudents() {
		List<Student> students = findStudents();
		System.out.println(students);
	}
}
