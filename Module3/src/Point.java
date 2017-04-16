
public class Point {
	int x,y;
	public static void main(String[] args) {
	Point p=new Point ();
	p.x=10;
	p.y=20;
	System.out.println("before Swap");
	System.out.println(p.x+ "----"+p.y);
	Swap(p.x,p.y);
	System.out.println("After Reference Swap");
	System.out.println(p.x+ "----"+p.y);
	swapval(p);
	System.out.println("After swapval function");
	System.out.println(p.x+ "----"+p.y);
	}
public static void Swap( int a, int b)// pass by value
{
	int temp=a;
	a=b;
	b=temp;
	System.out.println("Inside swap function");
	System.out.println(a+ "----"+b );
	//* here we swaped the reference of the object but not the values.
}
public static void swapval(Point p) // pass by reference
{
	int temp =p.x;
	p.x=p.y;
	p.y=temp;
	System.out.println("Inside swapval function");
	System.out.println(p.x+ "----"+p.y);
}
}
