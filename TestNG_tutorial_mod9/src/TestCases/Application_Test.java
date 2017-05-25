 package TestCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Application_Test {
	
	SoftAssert softassert;
	
	@BeforeTest
	public void beforetest(){
		System.out.println("Before Test");
	}
	@AfterTest
	public void aftertest(){
		System.out.println("After Test");
	}
	@BeforeMethod
	public void beforemethod(){
		System.out.println("Before Method");
		}
	@AfterMethod
	public void aftermethod(){
		System.out.println("After Method");
	}
	@BeforeSuite
	public void BeforeSuite(){
		System.out.println("Before Suite");
		}
	@AfterSuite
	public void AfterSuite(){
		System.out.println("After Suite");
		}
	@Test(priority=1)
	public void doLogin(){
		System.out.println("Login Test Execution");
		//throw new SkipException("Any Error");
		/*softassert = new SoftAssert();
		softassert.fail("Error message ");
		softassert.assertAll();*/
		}
	@Test(priority=2,dependsOnMethods={"doLogin"})
	public void doPasswordchange(){
		System.out.println("Changing Password");
		}
	@Test(priority=3,dependsOnMethods={"doLogin"})
	public void doLogout(){
		System.out.println("Logging Out");
		}
	}