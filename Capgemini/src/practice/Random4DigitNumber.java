package practice;

public class Random4DigitNumber {

	public static void main(String[] args) {

		int n = 4;
		// This will always give a n-digit number
		int max = 1;
		for (int i = 0; i < n; i++)
			max *= 10;// ---0/10---1/100---2/1000---3/10000

		double d = Math.random() * max + max / 10;
		d = d < max ? d : d - max / 10;

		System.out.println((int) d);

	}

}
