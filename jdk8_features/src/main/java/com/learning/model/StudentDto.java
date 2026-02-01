package com.learning.model;

import java.util.List;

public class StudentDto {

	public static List<Student> findStudents() {
		Student s1 = new Student("Eliza", 48);
		Student s2 = new Student("Jesica", 20);
		Student s3 = new Student("Menis", 36);
		Student s4 = new Student("Denis", 55);
		Student s5 = new Student("Adam", 13);

		return List.of(s1, s2, s3, s4, s5);
	}

	public static List<Student> findStudentsWithMarks() {
		Student s1 = new Student("Adam", 48, new double[] { 58.35d, 97.45d, 40.85d });
		Student s2 = new Student("Baby", 20, new double[] { 68.55d, 87.65d, 50.75d });

		return List.of(s1, s2);
	}

	public static List<Student> findStudentsWithSubjectsCodes() {
		Student s1 = new Student("AB", 48, new int[] { 58, 97, 40 });
		Student s2 = new Student("CD", 20, new int[] { 68, 87, 50 });

		return List.of(s1, s2);
	}
	
	public static List<Student> findStudentsWithQuestionPapersCodes() {
		Student s1 = new Student("AB", 48, new long[] { 123458l, 563458l, 456458l });
		Student s2 = new Student("CD", 20, new long[] { 983458l, 763458l, 893458l });

		return List.of(s1, s2);
	}

	public static void printStudents() {
		List<Student> students = findStudents();
		System.out.println(students);
	}
}
