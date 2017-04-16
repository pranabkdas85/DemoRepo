package practice;



public class reverse_string {
	public static void main(String args[]){
		String name="Pranab";
		int len=name.length();
		char ch[]= new char[len];
		for (int i =0;i<len;i++)
			{
			ch[i]=name.charAt(len-i-1);
			}
		System.out.println("original string " + name);
		String str = String.valueOf(ch);
		System.out.println("Reverse string " + str);
	}
}