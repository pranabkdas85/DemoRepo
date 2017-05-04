package practice;

public class Amstrong_number {

	public static void main(String[] args) {

		int number, rem, sum = 0;
		for (int i = 0; i <= 9999; i++) {
			number = i;
			while (number > 0) {
				rem = number % 10;
				sum = sum + (int) Math.pow(rem, 3);
				number = number / 10;
			}
			if (sum == i) {
				System.out.println("Ams no" + i);
			}
			sum = 0;
		}

	}

}
