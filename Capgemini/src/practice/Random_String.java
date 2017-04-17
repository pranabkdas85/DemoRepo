package practice;

import java.util.Random;

public class Random_String {

	public static void main(String[] args) {
		
		int n = 4;
		
		// This will provide a String with n-characters
		char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < n; i++) {
			char c = chars[random.nextInt(chars.length)];
			sb.append(c);
		}
		String output = sb.toString();
		System.out.println(output);
	}
}
