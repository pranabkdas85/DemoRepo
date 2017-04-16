package practice;

public class Pyramid {

	public static void main(String[] args) {
		int Height = 3;
		int blank = 0;
		for (int i = 0; i < Height; i++) {
			blank = Height / (2+i);
			for (int j = 0; j < blank; j++) {
				System.out.print(" ");
			}

			System.out.print("*");
			for (int j = 0; j < blank; j++) {
				System.out.print(" ");
			}
			System.out.println("");
		}

	}

}
