package practice;

public class SumOfEachDigitInTheGivenNumberUsingRecursion {

	public static void main(String[] args) {
		int number = 2345670;
		int rem = 0;
		int sum = 0;
		while (number > 0) {
			rem = number % 10;
			sum = sum + rem;
			number = number / 10;
		}
		System.out.println(sum);

	}

}
