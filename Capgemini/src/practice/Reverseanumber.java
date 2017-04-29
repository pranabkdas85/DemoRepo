package practice;

public class Reverseanumber {

	public static void main(String[] args) {
		int number = 98765;
		int rev_number = 0, buffer = number, rem = 0;

		while (buffer > 0) {
			rem = buffer % 10;
			rev_number = rev_number * 10 + rem;
			buffer = buffer / 10;
		}
		System.out.println(rev_number);
	}

}
