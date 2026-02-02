package com.learning.functionalInterfaces.consumers;

import java.util.function.BiConsumer;
import java.util.function.ObjDoubleConsumer;
import java.util.function.ObjIntConsumer;
import java.util.function.ObjLongConsumer;
import com.learning.utils.AppConstants;

public class BiConsumerDemo {

	static BiConsumer<String, String> biconsumer = (s1, s2) -> {
		if (s1 == null || s1.isEmpty() || s1.isBlank()) {
			System.out.println("No information exists.");
		} else {
			if (s2 == null || s2.isEmpty() || s2.isBlank()) {
				System.out.println(s1);
			} else {
				String[] infoArray = s1.split(s2);
				System.out.println("Name: " + infoArray[AppConstants.ZERO]);
				System.out.println("Company: " + infoArray[AppConstants.ONE]);
				System.out.println("Department: " + infoArray[AppConstants.TWO]);
				System.out.println("City: " + infoArray[AppConstants.THREE]);
				System.out.println("Country: " + infoArray[AppConstants.FOUR]);
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
		
		nameSalaryDisplayConsumer.accept(AppConstants.JOHN, AppConstants.DOUBLE_150410);

		nameAgeDisplayConsumer.accept(AppConstants.TOM, AppConstants.THIRTY_SEVEN);

		nameIdDisplayConsumer.accept(AppConstants.JOHN, AppConstants.LONG_123456789);
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
