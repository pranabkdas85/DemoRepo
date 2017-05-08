import org.apache.log4j.Logger;

public class Test_log4 {

	public static void main(String[] args) {
		Logger APPLICATION_LOGS = Logger.getLogger("devpinoyLogger");
		APPLICATION_LOGS.debug("hello");
		APPLICATION_LOGS.debug("We are wrinting in to a log file");
		APPLICATION_LOGS.debug("starting the test case xyz test");
		

	}

}
