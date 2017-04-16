package functionalities;

public class Mathclass {
	public static void main(String args[]) {
		double d = -8;
		d = Math.abs(d);
		System.out.println("After Absolute Value" + d);
		float f = -((float) d) / 3;
		System.out.println(f);
		double a = (double) f;
		System.out.println(a);

	}
}