import java.util.logging.Level;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Q10 {
	public static void main(String args[]) {

		System.setProperty("webdriver.gecko.driver","C:\\geckodriver.exe");

		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		FirefoxOptions options = new FirefoxOptions();
		options.setLogLevel(Level.SEVERE);
		capabilities.setCapability("moz:firefoxOptions", options);
		WebDriver driver = new FirefoxDriver(capabilities);

		driver.get("https://www.irctc.co.in/eticketing/loginHome.jsf");
		driver.manage().window().maximize();

		// 1st type
		driver.navigate().refresh();
		System.out.println("completed the first type");

		// 2nd Type
		driver.findElement(By.id("usernameId")).sendKeys(Keys.F5);
		System.out.println("completed the second type");

		// 3rd Type
		driver.get(driver.getCurrentUrl());
		System.out.println("completed the third type");

		// 4th Type
		driver.navigate().to(driver.getCurrentUrl());
		System.out.println("completed the forth type");

		// 5th type
		driver.findElement(By.name("j_captcha")).sendKeys("\uE035");
		System.out.println("completed the fifth type");

	}
}