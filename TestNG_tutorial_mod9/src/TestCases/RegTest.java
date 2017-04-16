package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class RegTest {
	SoftAssert softassert = new SoftAssert();
	
	@Test
	public void doRegisTest(){
		String ExpectedTitle= "xxxx";
		String ActualTitle="yyyy";
		System.out.println("A");
		//Assert.assertEquals(ActualTitle, ExpectedTitle);
		softassert.assertEquals(ActualTitle, ExpectedTitle);
		System.out.println("B");
		Assert.fail("Error Message");
		//Assert.assertTrue(2>1,"Error Message");
		//Assert.assertTrue(isElementPresent("XXX"),"Element not present");
		softassert.assertAll();
		
		}
	} 

