
public class Car {
	String mod;
	int price;
	static int wheels=4;
	/*Constructor=Java constructor is invoked at the time of
	 *  object creation. It constructs the values i.e.
	 *   provides data for the object that is why it is known as constructor.
	 *   There are basically two rules defined for the constructor.
	 *   Constructor name must be same as its class name
	 *    Constructor must have no explicit return type
	 */
	public Car(String mod, int price)
	{
		this.mod=mod;
		this.price = price;
	}
	public Car()
	{
		System.out.println("in Car constructor - no arg");
	}
	 public static void main(String[] args) {
		Car c1= new Car();/* Objects of the class. Object is an instance 
		of a class. In an object all of the non static variable 
		of the class will reside */
		c1.mod="maruthi";// Here C1 is the reference to the Object
		c1.price=123;/* here price is non static, so to call non static data,
		 it needs to be called with an reference */ 
		//c1.wheels=4;
		c1.start();
		c1.accel();
		
		Car c2= new Car();
		c2.mod="tata motors";
		c2.price=456;
		//c2.wheels=4;
		c2.start();
		c2.accel();
				
		System.out.println(c1.mod);
		System.out.println(c2.mod);
		System.out.println(wheels);
		System.out.println(Car.wheels);
		System.out.println(c1.wheels);
		wheels=5;
		System.out.println(wheels);
		System.out.println(Car.wheels);
		System.out.println(c1.wheels);
		c1.wheels=6;
		System.out.println(wheels);
		System.out.println(Car.wheels);
		System.out.println(c1.wheels);
		System.out.println(c2.wheels);
		}
public void start()
{
	System.out.println(mod + " is atarting");}
public void accel()
{
	System.out.println(mod +" is accelerating");
}
}
