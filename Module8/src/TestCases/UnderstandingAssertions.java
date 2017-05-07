package TestCases;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

public class UnderstandingAssertions {
	@Rule
	public ErrorCollector errcoll = new ErrorCollector();

	@Test
	public void testfriendlistFacebook() {
		int actual_total_friends = 100;// this should be counted by selenium
		int expected_total_friends = 10;
		/*
		 * if(actual_total_friends==expected_total_friends) {
		 * System.out.println("Pass"); } else { System.out.println("Fail"); }
		 */
		System.out.println("A");
		try {
			Assert.assertEquals(expected_total_friends, actual_total_friends);
		} catch (Throwable t) {
			System.out.println("Error Encountered= MISMATCH IN FRIENDS COUNT");
			errcoll.addError(t);
		}
		System.out.println("B");/*
								 * this code gets skipped if the
								 * Assert.assertEquals gets failed
								 */

		try {
			Assert.assertEquals("A", "B");
		} catch (Throwable t) {
			System.out.println("Error Encountered = THE EXPECTED DIDN'T COME");
			errcoll.addError(t);
		}
		/*
		 * try{ Assert.assertEquals("A","A"); }catch(Throwable t) {
		 * System.out.println("Error Encountered = THE EXPECTED DIDN'T COME");
		 * errcoll.addError(t); }
		 */
		Assert.assertTrue(2 > 5);
		System.out.println("Above assert passed");

	}// ends the testfriendlistFacebook()
}// ends the class