package com.learning.functionalInterfaces.functions;

import java.util.ArrayList;
import java.util.List;
import java.util.function.DoubleFunction;
import java.util.function.DoubleToIntFunction;
import java.util.function.DoubleToLongFunction;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.IntToDoubleFunction;
import java.util.function.IntToLongFunction;
import java.util.function.LongFunction;
import java.util.function.LongToDoubleFunction;
import java.util.function.LongToIntFunction;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;
import com.learning.utils.AppConstants;

public class FunctionDemo {

	static Function<String, Integer> strLengthFunction = s -> {
		if (s == null) {
			return AppConstants.ZERO;
		}
		return s.length();
	};

	static Function<String, String> stringWithLengthFunction = s -> {
		if (s == null) {
			return "Length of " + s + " = 0";
		}
		return "Length of '" + s + "' = " + s.length();
	};

	static Function<String, String> trimFunction = s -> {
		if (s == null) {
			return AppConstants.EMPTY;
		}
		return s.trim();
	};

	static Function<Integer, Integer> squareFunction = i -> {
		if (i == null) {
			return AppConstants.ZERO;
		}
		return i * i;
	};

	static Function<Integer, Integer> cubeFunction = i -> {
		if (i == null) {
			return AppConstants.ZERO;
		}
		return i * i * i;
	};

	static Function<Integer, Integer> multiplyBy2 = i -> {
		if (i == null) {
			return AppConstants.ZERO;
		}
		return i * AppConstants.TWO;
	};

	static Function<Integer, Integer> add10 = i -> {
		if (i == null) {
			return AppConstants.ZERO;
		}
		return i + AppConstants.TEN;
	};

	// Function.identity() – Returns the Input as-is. Useful in Streams.
	static Function<String, String> identityFunction = Function.identity();

	static DoubleFunction<String> designationFunction = salary -> {
		if (salary <= AppConstants.DOUBLE_0) {
			return "NONE";
		} else if (salary >= AppConstants.DOUBLE_5000 && salary <= AppConstants.DOUBLE_30000) {
			return "Software Engineer Trainee";
		} else if (salary > AppConstants.DOUBLE_30000 && salary <= AppConstants.DOUBLE_40000) {
			return "Software Engineer";
		} else if (salary > AppConstants.DOUBLE_40000 && salary <= AppConstants.DOUBLE_50000) {
			return "Senior Software Engineer";
		} else if (salary > AppConstants.DOUBLE_50000 && salary <= AppConstants.DOUBLE_100000) {
			return "Team Lead";
		} else if (salary > AppConstants.DOUBLE_100000 && salary <= AppConstants.DOUBLE_300000) {
			return "Manager";
		}
		return "OTHERS";
	};

	static DoubleToIntFunction cgpaFunction = marks -> {
		int cgpa = AppConstants.ZERO;
		if (marks > AppConstants.DOUBLE_0 && marks <= AppConstants.DOUBLE_30) {
			cgpa = AppConstants.ONE;
		} else if (marks > AppConstants.DOUBLE_30 && marks <= AppConstants.DOUBLE_50) {
			cgpa = AppConstants.TWO;
		} else if (marks > AppConstants.DOUBLE_50 && marks <= AppConstants.DOUBLE_70) {
			cgpa = AppConstants.THREE;
		} else if (marks > AppConstants.DOUBLE_70 && marks <= AppConstants.DOUBLE_80) {
			cgpa = AppConstants.FOUR;
		} else if (marks > AppConstants.DOUBLE_80 && marks <= AppConstants.DOUBLE_100) {
			cgpa = AppConstants.FIVE;
		}
		return cgpa;
	};

	static DoubleToLongFunction roundFunction = value -> Math.round(value);

	static IntFunction<String> remarksFunction = rank -> {
		String remarks = "POOR PERFORMANCE!";
		if (rank <= AppConstants.ZERO) {
			remarks = "FAILED";
		} else if (rank == AppConstants.ONE) {
			remarks = "EXCELLENT PERFORMANCE!";
		} else if (rank == AppConstants.TWO) {
			remarks = "BETTER PERFORMANCE!";
		} else if (rank == AppConstants.THREE) {
			remarks = "GOOD PERFORMANCE!";
		} else if (rank == AppConstants.FOUR) {
			remarks = "PERFORMANCE IS FINE.";
		} else if (rank == AppConstants.FIVE) {
			remarks = "WORK HARD";
		}
		return remarks;
	};

	static IntToDoubleFunction factorialFunction = num -> {
		double fact = AppConstants.DOUBLE_0;
		if (num < AppConstants.ZERO) {
			return AppConstants.DOUBLE_0;
		}
		if (num == AppConstants.ZERO) {
			return fact;
		}
		for (int i = num; i > AppConstants.ZERO; i--) {
			fact = fact * i;
		}
		return fact;
	};

	static IntToLongFunction squareLongFunction = num -> {
		return (long) num * num;
	};

	static LongFunction<String> nameOfIdFunction = id -> {
		String name = "ANONYMOUS";
		if (id == 1000000000l) {
			name = "ADAM GILCHRIST";
		} else if (id == 2000000000l) {
			name = "JESICA FERNANDEZ";
		} else if (id == 3000000000l) {
			name = "KELVIN SMITH";
		} else if (id == 4000000000l) {
			name = "MARCO POLO";
		} else if (id == 5000000000l) {
			name = "NICK JONAS";
		} else if (id == 6000000000l) {
			name = "PATRICK JOHNSON";
		}
		return name;
	};

	static LongToDoubleFunction marksOfIdFunction = id -> {
		double marks = 0d;
		if (id == 1000000000l) {
			marks = 90.50d;
		} else if (id == 2000000000l) {
			marks = 70.25d;
		} else if (id == 3000000000l) {
			marks = 60.75d;
		} else if (id == 4000000000l) {
			marks = 40.25d;
		} else if (id == 5000000000l) {
			marks = 66.50d;
		} else if (id == 6000000000l) {
			marks = 80.75d;
		}
		return marks;
	};

	static LongToIntFunction rankOfIdFunction = id -> {
		int rank = 0;
		if (id == 1000000000l) {
			rank = 1;
		} else if (id == 2000000000l) {
			rank = 2;
		} else if (id == 3000000000l) {
			rank = 3;
		} else if (id == 4000000000l) {
			rank = 4;
		} else if (id == 5000000000l) {
			rank = 5;
		} else if (id == 6000000000l) {
			rank = 6;
		}
		return rank;
	};

	static ToDoubleFunction<String> gradeSalaryFunction = grade -> {
		double salary = 0d;
		if (grade == null || grade.isEmpty() || grade.isBlank()) {
			return salary;
		}
		grade = grade.trim();
		if (grade.equalsIgnoreCase("A")) {
			salary = 300000.90d;
		} else if (grade.equalsIgnoreCase("B")) {
			salary = 200000.85d;
		} else if (grade.equalsIgnoreCase("C")) {
			salary = 150000.65d;
		} else if (grade.equalsIgnoreCase("D")) {
			salary = 100000.45d;
		}
		return salary;
	};

	static ToIntFunction<String> genderCodeFunction = gender -> {
		int code = 0;
		if (gender == null || gender.isEmpty() || gender.isBlank()) {
			return code;
		}
		gender = gender.trim();
		if (gender.equalsIgnoreCase("Female")) {
			code = 1;
		} else if (gender.equalsIgnoreCase("Male")) {
			code = 2;
		} else if (gender.equalsIgnoreCase("Transgender")) {
			code = 3;
		}
		return code;
	};

	static ToLongFunction<String> employeeIdFunction = name -> {
		long employeeId = 0l;
		if (name == null || name.isEmpty() || name.isBlank()) {
			return employeeId;
		}
		name = name.trim();
		if (name.equalsIgnoreCase("ADAM")) {
			employeeId = 1000000000l;
		} else if (name.equalsIgnoreCase("JESICA")) {
			employeeId = 2000000000l;
		} else if (name.equalsIgnoreCase("KELVIN")) {
			employeeId = 3000000000l;
		} else if (name.equalsIgnoreCase("MARCO")) {
			employeeId = 4000000000l;
		} else if (name.equalsIgnoreCase("NICK")) {
			employeeId = 5000000000l;
		} else if (name.equalsIgnoreCase("PATRICK")) {
			employeeId = 6000000000l;
		}
		return employeeId;
	};

	public static void testFunctions() {
		String input = "ABCD";
		Integer strLength = strLengthFunction.apply(input);
		System.out.println("String = " + input + "\nIt's Length = " + strLength + "\n");

		System.out.println("Identity Function O/P = " + identityFunction.apply(input) + "\n");

		Integer num = 3;
		Integer squareAndThenCube = squareFunction.andThen(cubeFunction).apply(num);
		System.out.println("Number = " + num + "\nIt's square and then cube = " + squareAndThenCube + "\n");

		Integer cubeAndThenSquare = squareFunction.compose(cubeFunction).apply(num);
		System.out.println("Number = " + num + "\nIt's cube and then square = " + cubeAndThenSquare + "\n");

		Integer multiplyBy2add10 = multiplyBy2.andThen(add10).apply(num);
		System.out.println("Number = " + num + "\n(Number * 2) + 10 = " + multiplyBy2add10 + "\n");

		Integer add10multiplyBy2 = multiplyBy2.compose(add10).apply(num);
		System.out.println("Number = " + num + "\n(Number + 10) * 2 = " + add10multiplyBy2 + "\n");

		String input2 = "     PQRS     ";
		Integer strLength2 = strLengthFunction.compose(trimFunction).apply(input2);
		System.out.println("String = " + input2 + "\nIt's Length = " + strLength2 + "\n");

		System.out.println("Identity Function O/P2 = " + identityFunction.apply(input2) + "\n");
		/**
		 * trimFunction.compose(strLengthFunction).apply(input2);
		 * 
		 * Error: The method compose(Function<? super V,? extends String>) in the type
		 * Function<String, String> is not applicable for the arguments
		 * (Function<String,Integer>)
		 * 
		 */

		double salary = 60000.50d;
		String designation = designationFunction.apply(salary);
		System.out.println("Salary: INR " + salary + "\nDesignation: " + designation + "\n");

		double marks = 78.5d;
		int cgpa = cgpaFunction.applyAsInt(marks);
		System.out.println("Marks = " + marks + "\nCGPA = " + cgpa + "\n");

		long roundedMarks = roundFunction.applyAsLong(marks);
		System.out.println("Marks = " + marks + "\nRounded Marks = " + roundedMarks + "\n");

		int rank = 2;
		String remarks = remarksFunction.apply(rank);
		System.out.println("rank = " + rank + "\nRemarks: " + remarks + "\n");

		double factorial = factorialFunction.applyAsDouble(num);
		System.out.println("num = " + num + "\nFactorial = " + factorial + "\n");

		int number = 1234567891;
		long square = squareLongFunction.applyAsLong(number);
		System.out.println("number = " + number + "\nSquare of number = " + square + "\n");

		long candidateId = 2000000000l;
		String candidateName = nameOfIdFunction.apply(candidateId);
		System.out.println("Candidate Id = " + candidateId + "\nName = " + candidateName);

		double marksOfId = marksOfIdFunction.applyAsDouble(candidateId);
		System.out.println("Marks = " + marksOfId);

		int rankOfId = rankOfIdFunction.applyAsInt(candidateId);
		System.out.println("Rank = " + rankOfId + "\n");

		String grade = "B";
		double gradeSalary = gradeSalaryFunction.applyAsDouble(grade);
		System.out.println("Grade = " + grade + "\nSalary = " + gradeSalary + "\n");

		String gender = "Male";
		int genderCode = genderCodeFunction.applyAsInt(gender);
		System.out.println("Gender: " + gender + "\nCode = " + genderCode + "\n");

		String name = "MARCO";
		long employeeId = employeeIdFunction.applyAsLong(name);
		System.out.println("Name: " + name + "\nEmployee Id: " + employeeId + "\n");
	}

	public static void testFunctionsUsingStream() {
		System.out.println("Tested Function using Stream:");
		List<String> data = new ArrayList<>();
		data.add(null);
		data.add("C");
		data.add("SQL");
		data.add("Java");
		data.add("Dotnet");

		data.stream().map(stringWithLengthFunction).forEach(s -> System.out.println(s));
	}

	public static void main(String[] args) {
		testFunctions();
		testFunctionsUsingStream();
	}

}
