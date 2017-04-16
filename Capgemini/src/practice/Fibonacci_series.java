package practice;

public class Fibonacci_series {
	public static void main(String args[]){
		
	int a0=0;
	int a1=1;
	System.out.println(a0);
	System.out.println(a1);
	for(int i=2;i<10;i++)
	{ 
		int a2=a1+a0;
		System.out.println(a2);
		a0=a1;
		a1=a2;
		
	}
	}
}
