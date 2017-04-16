package practice;

public class Firsttenprimenumbers {
	public static void main(String args[]) {
		int no_divisor;
		int i = 1;
		int count = 0;
		while (true) {
			no_divisor = 0;
			for (int j = 1; j <= i; j++) {
				int rem = i % j;
				if (rem == 0)
					no_divisor = no_divisor + 1;
			}
			if (no_divisor == 2) {
				System.out.println(i);
				count++;
			}
			i++;
			if(count==10)
				break;
		}
	}
}
