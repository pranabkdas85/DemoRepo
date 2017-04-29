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

	/*	int onedigit, twodigit, thirddigit, fourdigit, rem = 0;
		double number;
		int ip_number = 407;
		fourdigit = ip_number / 1000;
		rem = ip_number % 1000;
		thirddigit = rem / 100;
		rem = ip_number % 100;
		twodigit = rem / 10;
		rem = ip_number % 10;
		onedigit = rem;
		number = Math.pow(fourdigit, 3) + Math.pow(thirddigit, 3) + Math.pow(twodigit, 3) + Math.pow(onedigit, 3);
		if (ip_number == number)
			System.out.println(ip_number + ": is a Amstrong number");
		else
			System.out.println(ip_number + ": is not a Amstrong number");*/

	}

}
