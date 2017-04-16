
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Q1 {
public static void main(String args[]){
	String browser= "Chrome";
	WebDriver driver=null;
	System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
	System.setProperty("webdriver.ie.driver","C:\\IEDriverServer.exe");
	if (browser.equals("Chrome")){
		ChromeOptions options = new ChromeOptions();
		Map<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("credentials_enable_service", false);
		options.setExperimentalOption("prefs", chromePrefs);
		options.addArguments("disable-infobars");
		driver = new ChromeDriver(options);
	}
	else if (browser.equals("IE")){
		driver= new InternetExplorerDriver();
	}
	
	driver.get("https://www.irctc.co.in/eticketing/loginHome.jsf");
	
}
}
