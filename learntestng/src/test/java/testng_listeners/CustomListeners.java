package testng_listeners;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class CustomListeners extends TestListenerAdapter{
	
	public void onTestSuccess(ITestResult tr){
		System.out.println("The test Case is Passed");
		
	}

}
