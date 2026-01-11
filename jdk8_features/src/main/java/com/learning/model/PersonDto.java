package com.learning.model;

import java.util.List;

public class PersonDto {

	public static List<Person> findPersons() {
		Person p1 = new Person("Adam", 43, "New York City", "NY", "USA");
		Person p2 = new Person("Benjim", 20, "Washington", "WDC", "USA");
		Person p3 = new Person("Celina", 17, "Lahore", "PAK", "PAKISTAN");
		Person p4 = new Person("Denis", 15, "Aligarh", "UP", "INDIA");
		Person p5 = new Person("Elizabeth", 65, "London", "LN", "UK");
		Person p6 = new Person("Ferry", 35, "Meerut", "UP", "INDIA");
		Person p7 = new Person("Georgia", 25, "England", "EN", "UK");
		Person p8 = new Person("Haseeb", 27, "Rawalpindi", "PAK", "PAKISTAN");
		Person p9 = new Person("Sunny", 23, "Noida", "UP", "INDIA");
		Person p10 = new Person("Venilla", 45, "London", "LN", "UK");
		Person p11 = new Person("Tariq", 54, "Rawalpindi", "PAK", "PAKISTAN");
		Person p12 = new Person("Waseem", 50, "Rawalpindi", "PAK", "PAKISTAN");
		Person p13 = new Person("Abhijeet", 23, "Hyderabad", "Telangana", "INDIA");
		Person p14 = new Person("Tanya", 76, "New Delhi", "Delhi", "INDIA");
		Person p15 = new Person("Shekhar", 54, "Chennai", "TN", "INDIA");

		return List.of(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15);
	}

	public static void printPersons() {
		List<Person> persons = findPersons();
		System.out.println(persons);
	}
}
