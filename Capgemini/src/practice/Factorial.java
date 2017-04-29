package practice;

import java.util.Random;

public class Factorial {

	public static void main(String[] args) {
		Random r = new Random();
		int number = r.nextInt(10);
		System.out.println("The Random number is :" + number);
		int factorial = 1;
		for (int i = 1; i <= number; i++) {
			factorial = factorial * i;
		}
		System.out.println(" The factorial of the " + number + ":" + factorial);
	}
}
