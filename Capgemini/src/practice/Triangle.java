package practice;

public class Triangle {

	public static void main(String[] args) {
		int no_lines = 4;
		int star = no_lines - 1;
		int l;
		for (int k = 1; k <= no_lines; k++) {
			for (int i = 1; i <= star; i++) {
				System.out.print("  ");
			}
			for (int j = 1; j <= k; j++) {
				System.out.print(j + " ");
			}
			l = k - 1;
			while (l >= 1) {
				System.out.print(l + " ");
				l--;
			}

			for (int i = 1; i <= star; i++) {
				System.out.print("  ");
			}
			System.out.println("");
			star--;
		}

	}

}
