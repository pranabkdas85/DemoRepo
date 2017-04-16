package practice;

import java.util.Random;

public class Random_name {

	public static void main(String[] args) {
	String strn[]= {"pranab","Chandana","Deblina"};
	Random random=new Random();
	System.out.println(strn[random.nextInt(strn.length)]);
		
		
		
		

	}

}
