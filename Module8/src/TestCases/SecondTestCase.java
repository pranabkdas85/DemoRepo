package TestCases;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assume;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class SecondTestCase {
	
	@BeforeClass // have to be static. this is executed before executing the class
	public static void begning()
	{
		System.out.println("**************Begning**************");
		Assume.assumeTrue(true);/* this function returning false
		will skip all tests.*/
	}
	
	@AfterClass
	public static void ending() // have to be static. this is executed before executing the class
	{
		System.out.println("***********ending**************");
	}
	
	@Before	public void Openbrowser()// called every time before executing the Test
{
	// Code to open browser
	System.out.println("Opening the browser");
	
	}
@Test
public void secondEmailTest()
{  
	System.out.println("Testing Send email");

}
@Test
public void secondMessageTest()
{
	System.out.println("Testing Send message");
}
//called every time after executing the Test
@After
public void Closebrowser()
{
	//Code to close the browser
	System.out.println("closing browser");
	}


}
