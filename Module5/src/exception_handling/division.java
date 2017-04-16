package exception_handling;

public class division {
public static void main(String args[]){
	try{
	System.out.println("A");
	int i=2/0;
	System.out.println("B");
	System.out.println(i);
	}catch (Exception e)
	{ System.out.println("some error : " + e.getMessage());
	e.printStackTrace();
	}
	System.out.println("C");
}
}
