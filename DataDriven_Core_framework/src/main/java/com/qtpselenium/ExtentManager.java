package com.qtpselenium;

import java.io.File;
import java.util.Date;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager {
	private static ExtentReports extent;

	public static ExtentReports getInstance() {
		if (extent == null) {
			Date d = new Date();
			String filename = d.toString().replace(" ", "_").replace(":", "_")
					+ ".html";

			extent = new ExtentReports("D:\\" + filename);
			extent.loadConfig(new File(System.getProperty("user.dir")
					+ "\\ReportsConfig.xml"));
			// optional
			extent.addSystemInfo("Selenium Version", "2.53.0").addSystemInfo(
					"Environment", "QA");

		}
		return extent;
	}
}
