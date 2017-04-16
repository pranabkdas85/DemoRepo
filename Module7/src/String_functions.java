public class String_functions {

		public static void main(String[] args)
	{
			System.out.println("hii"); 
			
		String str= " The rains have started here ";
		String str1=" The rains have not started here";
	
		System.out.println("Length of the String is " + str.length());
		System.out.println("The character at 5th index is "+ str.charAt(5));
		System.out.println("The character 's' is at " +str.indexOf('s'));
		System.out.println("The second occurance of 's' is at " + str.indexOf('s',9));
		System.out.println("Search the string -Negative scenario "+ str.indexOf("Hello"));
		System.out.println("Search the string -Positive scenario "+ str.indexOf("rains"));
		System.out.println("to check if both strings are same = " + str.equals(str1));
		System.out.println("Print the String from - to - character  = " + str.substring(0,10));
		System.out.println("Convert the String to Lower characters = " + str.toLowerCase());
		System.out.println("Convert the string to UPPER Characters = " + str.toUpperCase());
		System.out.println(" Trim space in the ends of the Strig = " + str.trim());
		System.out.println("Checks if the string starts with specified character = " + str.startsWith(" The"));
		System.out.println(" Checks if the string ends with specified chaacter = " + str.endsWith("here "));
		String str2= str.intern();// associated the string to another string
		System.out.println(str2);// prints the new string
		System.out.println("Replace the character ="+str.replace("rain","storm"));
				
		String temp[]= str.split(" ");
		for (int i=0; i<temp.length;i++)
		System.out.println(temp[i]);
		
		String temp1[]= str.split("have");
		for ( int i=0; i<temp1.length;i++)
		System.out.println(temp1[i]);
		
		
		
		
		String x="100";
		int k=Integer.parseInt(x);
		System.out.println("Value of k " + k);
				
		// to String
		String z= String.valueOf(k);
		System.out.println(z);
				
		}
	}
