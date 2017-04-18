import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Q2 {

	public static void main(String[] args) {
		int roomneeded = 2;
		System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");

		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		FirefoxOptions options = new FirefoxOptions();
		options.setLogLevel(Level.SEVERE);
		capabilities.setCapability("moz:firefoxOptions", options);
		WebDriver driver = new FirefoxDriver(capabilities);
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		driver.get("http://www.gingerhotels.com/");
		driver.findElement(
				By.xpath("//div[@class='form-group col-md-12']/select"))
				.sendKeys("Agartala");
		driver.findElement(By.id("checkin")).click();
		driver.findElement(
				By.xpath("html/body/div[2]/div[1]/table/tbody/tr[5]/td[7]"))
				.click();
		driver.findElement(
				By.xpath("html/body/div[3]/div[1]/table/tbody/tr[6]/td[1]"))
				.click();
		WebElement room = driver.findElement(By.id("rooms"));
		List<WebElement> list_room = room.findElements(By.tagName("option"));
		System.out.println(list_room.size());
		room.sendKeys("2");
		
	}
}
