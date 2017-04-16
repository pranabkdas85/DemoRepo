import java.util.logging.Level;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Q10 {
	public static void main(String args[]) {

		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");

		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		FirefoxOptions options = new FirefoxOptions();
		options.setLogLevel(Level.SEVERE);
		capabilities.setCapability("moz:firefoxOptions", options);
		WebDriver driver = new FirefoxDriver(capabilities);

		driver.get("https://www.irctc.co.in/eticketing/loginHome.jsf");
		driver.manage().window().maximize();

		// 1st type
		driver.navigate().refresh();

		// 2nd Type
		driver.findElement(By.id("usernameId")).sendKeys(Keys.F5);

		// 3rd Type
		driver.get(driver.getCurrentUrl());

		// 4th Type
		driver.navigate().to(driver.getCurrentUrl());

		// 5th type
		driver.findElement(By.name("s")).sendKeys("\uE035");

	}
}