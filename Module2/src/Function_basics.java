
public class Function_basics {

	public static void main(String[] args) {
		System.out.println("Main");
		testme();
		sumall(1, 2, 3);
		System.out.println("Multiple " + multiple(2,5,3));// the pass arguments should
		//have same data type defined in the function.
		
	}
	public static void testme(){
		System.out.println(" in testme");
		}
	/* All functions should be Parallel to each other.
	 *  That means the functions should be outside the main function
	 *   but inside the Class.
	 */
	public static void sumall(int a, int b,int c){
		int sum= a+b+c;
		/* The sum is Local Variable.
		The visibility of the field sum is limited to the same function. */
		System.out.println("Sum = "+ sum);
		}
	public static int multiple(int a,int b, int c)
	{
		int Mul= a*b*c;
		return Mul;
	}
	}
/* A function can accept any number of arguments
 *  but it returns only one value.
 *  void, is the returned type for an function.
 *  two function can share same name
 *   but should have different arguments passing to it.
 */