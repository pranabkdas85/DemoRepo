package practice;

public class FabonaciSeriesWithOutRecursion {
	static int a1 = 1;
	static int a2 = 1;
	static int number = 10;

	public static void main(String[] args) {
		System.out.println(a1);
		System.out.println(a2);
		while (number > 2) {
			fabonaci();
			number--;
		}
	}

	public static void fabonaci() {
		int no;
		no = a1 + a2;
		a1 = a2;
		a2 = no;
		System.out.println(no);
	}
}
