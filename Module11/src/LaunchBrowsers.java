import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class LaunchBrowsers {

	String Browser = "Chrome";
	  
	@Test( dataProvider= "getdata")
	public void launch(String Browser, String username){
		System.setProperty("webdriver.gecko.driver","C:\\geckodriver.exe");
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
		System.setProperty("webdriver.ie.driver","C:\\IEDriverServer.exe");
		
		WebDriver driver= null;
		if(Browser.equals("Morzilla"))
			driver = new FirefoxDriver();
		else if(Browser.equals("Chrome"))
			driver= new ChromeDriver();
		else if (Browser.equals("Internet Explorer"))
			driver= new InternetExplorerDriver();
		driver.get("http://gmail.com");
		driver.quit();
			
			}
	@DataProvider
	public Object[][] getdata()
	{
		Object[][] data=new Object[3][2];
		// 3 iterations and 2 number of data
		data[0][0]= "Chrome";
		data[0][1]= "user1";
		
		data[1][0]= "Morzilla";
		data[1][1]= "user2";
		
		data[2][0]= "Internet Explorer";
		data[2][1]= "user3";
		
		return data;		
		
	}
	
}
