
public class Concatination_Operator {

	public static void main(String[] args) {
		String x= "Hello";
		String y = "World";
		System.out.println(x + " " + y);
		/* + is the concatenation Operator */
		int a= 100;  
		int b= 200;
		System.out.println(a+b);
		System.out.println(x+y+a+b);
		System.out.println(a+b+x+y);
		System.out.println(x+y+a+b);
		System.out.println((a+b)+x+y);
		System.out.println(a+""+b+x+y);
		System.out.println(Integer.toString(a)+b+x+y);
		}// end of main function
	
	}// end of class

