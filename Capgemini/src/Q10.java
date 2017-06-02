import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Q10 {
	public static void main(String args[]) {

		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		Map<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("credentials_enable_service", false);
		options.setExperimentalOption("prefs", chromePrefs);
		options.addArguments("disable-infobars");
		WebDriver driver = new ChromeDriver(options);

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