package practice;

public class Palindrome {

	public static void main(String[] args) {
		String ip_string = "Pranab";
		int len = ip_string.length();
		char[] ip_char = new char[len];
		ip_char = ip_string.toCharArray();
		System.out.println(ip_char);
		char rev_ch[] = new char[len];
		for (int i = 0; i < len; i++) {
			rev_ch[i] = ip_char[len - i - 1];
		}
		System.out.println("original string " + ip_string);
		String rev_str = String.valueOf(rev_ch);
		System.out.println("Reverse string " + rev_str);

		if (ip_string.equals(rev_str))
			System.out.println("Its a Palindrome String");
		else
			System.out.println("Its not a Palindrome String");
	}
}
