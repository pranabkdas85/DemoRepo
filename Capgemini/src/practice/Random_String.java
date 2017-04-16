package practice;

import java.util.Random;

public class Random_String {

	public static void main(String[] args) {
		char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		System.out.println(chars.length);
		
	StringBuilder sb = new StringBuilder();
	Random random = new Random();
	for (int i = 0; i < 5; i++) {
	    char c = chars[random.nextInt(chars.length)];
	    sb.append(c);
	}
	String output = sb.toString();
	System.out.println(sb);
	System.out.println(output);
	}
}

