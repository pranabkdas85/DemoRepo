
public class Utility_functions {

	public static void main(String[] args) {
		double d=Math.random();
		System.out.println(d);
		d=d*10;
		int n=(int) d;
		System.out.println(n);
		// Enter any number//
		int no=35;
		randomnumber(no);
	}
	public static void randomnumber(int num)
	{
		double d=Math.random();
		/* Math is a class and Random is a function */
		d=d*num;
		int number=(int) d;
		System.out.println("the number between 0 to " + num +" is "+  number);
	}
}
