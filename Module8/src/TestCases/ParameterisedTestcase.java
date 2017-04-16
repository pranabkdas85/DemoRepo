package TestCases;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
//import org.junit.runners.Parameterized.Parameter;

@RunWith(Parameterized.class)
public class ParameterisedTestcase {
	public String username;
	public String password;
	public int pin;
	
	public ParameterisedTestcase(String username, String password, int pin)
	{
		this.username= username;
		this.password = password;
		this.pin= pin;
	}
	
@Parameters
public static Collection<Object[]>  getdata()
{
	Object[][] data= new Object[2][3];
	//rows= no of times you want to repeat the test.
	// cols= no of parameters you want to pass
	data[0][0]="testuser1";
	data[0][1]="pass1";
	data[0][2]=1234;
		
	data[1][0]="testuser2";
	data[1][1]="pass2";
	data[1][2]=12345;
	
	return Arrays.asList(data);
		
}
@Test
public void testRegister()
{
	System.out.println("Testing registration--"+ username + "---" + password + "---" + pin);
}
}

