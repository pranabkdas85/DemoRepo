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
			System.out.println("error1");
			ErrorUtil.addVerificationFailure(t);
		}
		try {
			Assert.assertEquals("A", "C");

		} catch (Throwable t) {
			System.out.println("error2");
			ErrorUtil.addVerificationFailure(t);
		}
		try {
			Assert.assertEquals("A", "D");

		} catch (Throwable t) {
			System.out.println("error3");
			ErrorUtil.addVerificationFailure(t);
		}
		System.out.println("ends");
	}

}
