package practice;

public class GenerateRandomNumberUpto4Digit {
	public static void main(String args[]) {
		double d = Math.random();

		d = d * 9999;
		System.out.println((int) d);

	}
}
