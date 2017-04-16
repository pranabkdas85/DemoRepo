import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;



public class Certificate_error {
public static void main(String args[]) throws Exception{
	
	
	/* for Firefox
	FirefoxProfile prof = new FirefoxProfile();
	prof.setAcceptUntrustedCertificates(true);
	prof.setAssumeUntrustedCertificateIssuer(true);
	WebDriver driver = new FirefoxDriver(prof);
	*/
	/* for chrome
	System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
	*/
	
	System.setProperty("webdriver.ie.driver","C:\\IEDriverServer.exe");
	
	WebDriver driver = new InternetExplorerDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	driver.get("https://onlineservices.tin.nsdl.com/etaxnew/tdsnontds.jsp");
	Thread.sleep(15000);
	driver.get("javascript:document.getElementById('overridelink').click();");
	driver.findElement(By.id("continueToSiteAlign")).click();
	driver.get("javascript:document.getElementById('overridelink').click();");
	driver.navigate().to("javascript:document.getElementById('overridelink').click()");
	
}
}
