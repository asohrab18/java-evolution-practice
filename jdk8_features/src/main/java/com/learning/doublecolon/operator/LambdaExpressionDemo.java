package com.learning.doublecolon.operator;

import com.learning.utils.AppConstants;

public class LambdaExpressionDemo {

	static Runnable r = () -> {
		for (int i = AppConstants.ONE; i <= AppConstants.FIFTEEN; i++) {
			System.out.println(AppConstants.CHILD_THREAD);
		}
	};

	public static void main(String[] args) {
		Thread t = new Thread(r);
		t.start();

		for (int i = AppConstants.ONE; i <= AppConstants.FIFTEEN; i++) {
			System.out.println(AppConstants.MAIN_THREAD);
		}
	}
}
