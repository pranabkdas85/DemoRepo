package functionalities;

public class Mathclass {
	public static void main(String args[]) {

		System.out.println("************absolute values************");

		int c = Math.abs(-543);
		System.out.println(c);

		double a = Math.abs(-98.545);
		System.out.println(a);

		float b = Math.abs(-34.654f);
		System.out.println(b);

		long d = Math.abs(-487878634);
		System.out.println(d);
		System.out.println("**********cube root***************");
		double e = Math.cbrt(27);
		System.out.println(e);

		System.out.println(Math.ceil(927.6));
		System.out.println(Math.ceil(927.5));
		System.out.println(Math.ceil(927.4));

		System.out.println(Math.copySign(7, -87));
		System.out.println(Math.copySign(7, 87));
		System.out.println(Math.copySign(-7, -87));
		System.out.println(Math.copySign(-7, 87));

		System.out.println("**********max function***************");
		System.out.println(Math.max(2345.45, 3456.23));
		System.out.println(Math.max(2345f, 3456f));
		System.out.println(Math.max(2345, 3456));
		System.out.println(Math.max(23432456785l, 345234567896l));

		System.out.println("**********min function***************");
		System.out.println(Math.min(2345.45, 3456.23));
		System.out.println(Math.min(2345f, 3456f));
		System.out.println(Math.min(2345, 3456));
		System.out.println(Math.min(23432456785l, 345234567896l));

		System.out.println("**********power function***************");
		System.out.println(Math.pow(4, -2));
		System.out.println(Math.pow(4, 2));

		System.out.println("**********Random function***************");
		System.out.println(Math.random());

		System.out.println("**********Round function***************");
		System.out.println(Math.round(3456.5432));
		System.out.println(Math.round(-3456.5432));
	}
}