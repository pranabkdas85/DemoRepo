package TestCases;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/* this will execute both of the Class (java Files) */


	@RunWith(Suite.class)
	@SuiteClasses(
			{
		UnderstandingAssertions.class,
		FirstTestCase.class,
		SecondTestCase.class
		}
			)
	public class MytestSuiterunner {
}
