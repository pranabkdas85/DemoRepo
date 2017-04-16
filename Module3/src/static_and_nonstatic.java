
public class static_and_nonstatic {
// here global variable, can be access across all function
	String  name;
	static int age;
	public static void main(String[] args) {
		sum();// this function can be called as, static can access all static stuff
		//sendmail(); //This function cannot be called as it is non static
		age =100;
		//name="pranab";
	}
public static void sum()// static function
{
	int i=100;// local variable
}
public void sendmail()// non static function
{
	int y=200;// local variable
	sum();// a non static function can call both static and non static variable/function 
	sendmail();
	age =100;
	name="pranab";
	}
}
