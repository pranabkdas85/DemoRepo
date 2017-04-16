import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class Drivers_selenium {
	
	public static void main(String args[]){
		
		System.setProperty("webdriver.gecko.driver","C:\\geckodriver_v14.exe");
		FirefoxDriver fd= new FirefoxDriver();
		fd.get("https://www.google.co.in/?gws_rd=ssl");
		
		
		/*System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
		ChromeDriver cd = new ChromeDriver();
		cd.get("https://www.google.co.in/?gws_rd=ssl");
		*/
		
		/*System.setProperty("webdriver.ie.driver","C:\\IEDriverServer.exe");
		InternetExplorerDriver ie= new InternetExplorerDriver();
		ie.get("https://www.google.co.in/?gws_rd=ssl");*/
		
	}
		
}
