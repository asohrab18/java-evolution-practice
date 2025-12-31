package com.learning.functionalInterfaces.consumers;

import java.util.function.BiConsumer;
import java.util.function.ObjDoubleConsumer;
import java.util.function.ObjIntConsumer;
import java.util.function.ObjLongConsumer;

public class BiConsumerDemo {

	static BiConsumer<String, String> biconsumer = (s1, s2) -> {
		if (s1 == null || s1.isEmpty() || s1.isBlank()) {
			System.out.println("No information exists.");
		} else {
			if (s2 == null || s2.isEmpty() || s2.isBlank()) {
				System.out.println(s1);
			} else {
				String[] infoArray = s1.split(s2);
				System.out.println("Name: " + infoArray[0]);
				System.out.println("Company: " + infoArray[1]);
				System.out.println("Department: " + infoArray[2]);
				System.out.println("City: " + infoArray[3]);
				System.out.println("Country: " + infoArray[4]);
			}
		}
	};

	static ObjDoubleConsumer<String> nameSalaryDisplayConsumer = (s, d) -> {
		System.out.println(s + " has Salary = INR " + d);
	};

	static ObjIntConsumer<String> nameAgeDisplayConsumer = (s, a) -> {
		System.out.println(s + " is " + a + " years old.");
	};

	static ObjLongConsumer<String> nameIdDisplayConsumer = (s, i) -> {
		System.out.println(s + " has Employee Id = " + i);
	};

	public static void displayEmployeeInfo() {
		ConsumerDemo.loggerConsumer.accept("In displayEmployeeInfo:");
		String name = "John Cena";
		nameSalaryDisplayConsumer.accept(name, 150410d);

		nameAgeDisplayConsumer.accept(name, 37);

		nameIdDisplayConsumer.accept(name, 123456789L);
	}

	public static void displayData() {
		ConsumerDemo.loggerConsumer.accept("Data Format is as: 'Name#Company#Department#City#Country'");

		biconsumer.accept("Herry#HTC Global Pvt. Ltd.#IT#Hyderabad#India", "#");
	}

	public static void main(String[] args) {
		displayData();
		displayEmployeeInfo();
	}
}
