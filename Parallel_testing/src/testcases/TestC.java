package testcases;

import org.testng.annotations.Test;

public class TestC {
	@Test
	public void testC() throws InterruptedException{
		System.out.println("Test C starts");
		Thread.sleep(2000);
		System.out.println("Test C ends");
}
}