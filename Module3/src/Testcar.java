
public class Testcar {
	public static void main(String[] args) {
		// Note= Here a,b,c is the reference to the object which is created
		Car a = new Car();// Car() is the new object created
		Car b = new Car();
		Car c = new Car();
		a.mod = "A";
		b.mod = "B";
		c.mod = "C";
		
		System.out.println(a.mod);
		System.out.println(b.mod);
		System.out.println(c.mod);
		
		a=b;// Here the reference gets changed.
		b=c;
		c=a;
		
		System.out.println(a.mod);
		System.out.println(b.mod);
		System.out.println(c.mod);
	}

}
