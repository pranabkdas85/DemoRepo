package functionalities;

public class twodarray {

	public static void main(String[] args) {
		String[][] table1 = new String[3][3];

		for (int i = 0; i < table1.length; i++) {
			for (int j = 0; j < table1[0].length; j++) {
				table1[i][j] = "das";
			}

		}

		for (int i = 0; i < table1.length; i++) {
			for (int j = 0; j < table1[0].length; j++) {
				System.out.println(table1.toString());
			}

		}

	}
}
