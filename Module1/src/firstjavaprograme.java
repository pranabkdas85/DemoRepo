
public class firstjavaprograme {

	public static void main(String[] args) {
		System.out.println("Hello World");
		System.out.println("first line");
		System.out.print("second line");
		System.out.println("Third Line");
		
			//byte, char, short, int, long,float, double, boolean----- String
		long x1 = -92233823934l;
		System.out.println(x1);
		
		
		
		int a= 100;
		System.out.println(a);
		a=2147483647;
		/*range of int is –2,147,483,648 to 2,147,483,647.
		*  its is of 32 bits */
		System.out.println(a);
		long b= 922337203;
		/* Range of Long is –9,223,372,036,854,775,808 to
		 * 9 ,223,372,036,854,775,807 it is of 64 bytes ,
		 * but now its not working */
		System.out.println(b);
		double c= 12.55555555555;
		System.out.println(c);
		/* Double if of 8 bytes	approximately ±1.79769313486231570E+308
		 *  (15 significant decimal digits) */
		byte d=127;
		System.out.println(d);
		/*	Byte is of 8 Byte	 and Range is from – 128 to 127 */
		char pd ='p';
		System.out.println(pd);
		/* char accepts only single character and should be inside
		 *  single quotation mark.
		 */
		boolean e=true;
		System.out.println(e);
		/* Boolean accepts only true or false */
		System.out.println(100>200);
		System.out.println(100<200);
		System.out.println(100==100);
		/* Program to find out greatest of two integer */			
		int i=100;
		int j=200;
		int k=50;
		if (i>j)
			System.out.println("i is greatest "+i);
		else
			System.out.println("j is greatest " + j);
		/* Program to find out greatest of three integer */	
		if (i>j & i>k)
			System.out.println("i is  the greatest of three");
		else if(j>k)
			System.out.println("j is greatest of three");
		else
			System.out.println("k is greatest of three");
		
		float f=-8;
		
		}// ends the main function
	}// ends the class