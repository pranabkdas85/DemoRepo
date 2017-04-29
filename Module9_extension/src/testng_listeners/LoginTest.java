package testng_listeners;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest {
	@Test
	public void Login() {
		// Code
		System.out.println("Start");
		try {
			Assert.assertEquals("A", "B");

		} catch (Throwable t) {
			System.out.println("error");
			ErrorUtil.addVerificationFailure(t);
		}
		System.out.println("ends");
	}

}
