package TestCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest {
	
	@Test(dataProvider="getdata")
	public void doLoginTest(String username,
			String password,
			String result,
			String browser,
			int phone){
		System.out.println("Username = " + username + "password = "+ password);
	}
	@AfterMethod
	public void afterm(){
		System.out.println("XXXXXX");
	}
	@DataProvider//(parallel=true)
	public Object[][] getdata(){
		
		Object[][] data= new Object[3][5];
		//1st Row
		data[0][0]= "U1";
		data[0][1]= "P1";
		data[0][2]= "Pass";
		data[0][3]= "Mozilla";
		data[0][4]= 12345678;
		
		//2nd Row
		data[1][0]= "U2";
		data[1][1]= "P2";
		data[1][2]= "Pass";
		data[1][3]= "Chrome";
		data[1][4]= 14835678;
		
		//3rd Row
		data[2][0]= "U3";
		data[2][1]= "P3";
		data[2][2]= "Fail";
		data[2][3]= "IE";
		data[2][4]= 54875678;
		
		return data;
		
				
				
	}
}
