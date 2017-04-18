package practice;

public class Random4DigitNumber {

	public static void main(String[] args) {
	
		int n = 4;
		//This will always give a n-digit number
		int max=1;
		for(int i=0;i<n;i++)
			max*=10;
		
		double d= Math.random()*max +max/10 ;
		d = d<max?d:d-max/10;
		
		System.out.println((int)d);

	}

}
