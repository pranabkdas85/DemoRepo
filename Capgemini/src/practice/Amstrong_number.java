package practice;

public class Amstrong_number {

	public static void main(String[] args) {
		int onedigit, twodigit, thirddigit, fourdigit, rem = 0;
		double number;
		int ip_number= 407;
			fourdigit = ip_number / 1000;
			rem = ip_number % 1000;
			thirddigit = rem / 100;
			rem = ip_number % 100;
			twodigit = rem / 10;
			rem = ip_number % 10;
			onedigit = rem;
			number = Math.pow(fourdigit, 3) + Math.pow(thirddigit, 3)
					+ Math.pow(twodigit, 3) + Math.pow(onedigit, 3);
			if (ip_number == number)
				System.out.println(ip_number + ": is a Amstrong number");
			else
				System.out.println(ip_number + ": is not a Amstrong number");
		}

	}


