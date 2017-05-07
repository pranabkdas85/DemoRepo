import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Certificate_error {
	public static void main(String args[]) throws Exception {

		
		 //for Firefox 
			/*FirefoxProfile prof = new FirefoxProfile();
			prof.setAcceptUntrustedCertificates(true);
			prof.setAssumeUntrustedCertificateIssuer(true); 
			WebDriver driver = new FirefoxDriver(prof);*/
		
		/*
		 * for chrome
		 * System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
		 */

		System.setProperty("webdriver.ie.driver", "D:/Coding/jars/IEDriverServer_Win32_3.3.0/IEDriverServer.exe");

		DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
		/*
		 * capabilities.setCapability(InternetExplorerDriver.
		 * FORCE_CREATE_PROCESS, true);
		 * capabilities.setCapability(InternetExplorerDriver.IE_SWITCHES,
		 * "-private");
		 */
		WebDriver driver = new InternetExplorerDriver(capabilities);

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://onlineservices.tin.nsdl.com/etaxnew/tdsnontds.jsp");

		// Check for certificate
		if (driver.getTitle().contains("Certificate Error"))
			driver.get("javascript:document.getElementById('overridelink').click()");

	}
}
