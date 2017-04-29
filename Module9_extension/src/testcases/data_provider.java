package testcases;

import java.lang.reflect.Method;
import org.testng.annotations.DataProvider;

public class data_provider {

	@DataProvider(name = "Reg_test_dataprovider")
	public static Object[][] data() {
		Object data[][] = new Object[2][3];

		data[0][0] = "U1";
		data[0][1] = "P1";
		data[0][2] = "xyz@gmail.com";

		data[1][0] = "U2";
		data[1][1] = "P2";
		data[1][2] = "abc@gmail.com";

		return data;
	}

	// we can add more data providers for other class

	@DataProvider(name = "testlogin_dataprovider")
	public static Object[][] data1() {
		Object data1[][] = new Object[2][2];

		data1[0][0] = "U1";
		data1[0][1] = "P1";

		data1[1][0] = "U2";
		data1[1][1] = "P2";

		return data1;
	}

	@DataProvider(name = "Sampledata")
	public static Object data2() {
		Object data[][] = new Object[2][3];
		data[0][0] = "U1";
		data[0][1] = "P1";
		data[0][2] = "123@gmail.com";

		data[1][0] = "U2";
		data[1][1] = "P2";
		data[1][2] = "456@gmail.com";

		return data;
	}

	@DataProvider(name = "Sampleielsedata")
	public static Object[][] data3(Method md) {
		Object data[][] = null;
		if (md.getName().equals("testA")) {
			data = new Object[2][3];
			data[0][0] = "U11";
			data[0][1] = "P11";
			data[0][2] = "11@gmail.com";

			data[1][0] = "U22";
			data[1][1] = "P22";
			data[1][2] = "22@gmail.com";

		} else if (md.getName().equals("testB")) {
			data = new Object[2][3];
			data[0][0] = "U33";
			data[0][1] = "P33";
			data[0][2] = "33@gmail.com";

			data[1][0] = "U44";
			data[1][1] = "P44";
			data[1][2] = "44@gmail.com";

		}
		return data;
	}
}