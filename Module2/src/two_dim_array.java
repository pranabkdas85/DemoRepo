
public class two_dim_array {
	public static void main(String[] args) {
		String dim[][]= new String[3][4];// first is row and then column
		int row= dim.length;  // no of rows
		int col=dim[0].length; // no of columns
		System.out.println("Number of Rows in the array is " + row);
		System.out.println("Number of Columns in the array is " + col);
		//First Row
		dim[0][0]="a";
		dim[0][1]="b";
		dim[0][2]="c";
		dim[0][3]="d";
		// Second Row
		dim[1][0]="e";
		dim[1][1]="f";
		dim[1][2]="g";
		dim[1][3]="h";
		//Third Row
		dim[2][0]="i";
		dim[2][1]="j";
		dim[2][2]="k";
		dim[2][3]="l";
		
		for (int i=0; i<row; i++)// initializes the rows
			{
			for (int j=0;j<col; j++)// initializes the columns
				System.out.print(dim[i][j]);
				System.out.println("");
				}// End of for first Loop		
		/* Object is the predefined Class in Java.
		 * The advantages of Object Array Data-type class is that,
		 *  the user can store different data types in the Array 
		 */
		Object[] ar= new Object[5];
		ar[0]="Hello";
		ar[1]=123;
		ar[2]="123";
		ar[3]=true;
		ar[4]=12.4567;
		
		}// End of Function
	}// End of Class
/* Drawback of array is that the length of
 *  the array needs to be defined at the first. 
 */