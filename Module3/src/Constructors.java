
public class Constructors {
	public static void main(String[] args) {
	Car a = new Car();
	a.mod="BMW";
	a.price=123;
	System.out.println("a car Model is "+a.mod + " and price is " + a.price);
	Car b= new Car ("audi", 456);
	System.out.println("b car Model is "+b.mod + " and price is " + b.price);

	} 

}
