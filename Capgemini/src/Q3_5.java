import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Q3_5 {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");

		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		FirefoxOptions options = new FirefoxOptions();
		options.setLogLevel(Level.SEVERE);
		capabilities.setCapability("moz:firefoxOptions", options);
		WebDriver driver = new FirefoxDriver(capabilities);

		driver.get("https://paytm.com/");

		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//*[@id='app']/div/div[2]/div[2]/div[3]/div[3]/div")));
		element.click();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		//driver.findElement(By.xpath("//*[@id='app']/div/div[2]/div[2]/div[3]/div[3]/div")).click();

		// findout how many frames are there in the page
		List<WebElement> frames = driver.findElements(By.tagName("iframe"));
		System.out.println(frames.size());
		for (int i = 0; i < frames.size(); i++) {
			driver.switchTo().frame(i);
			int s = driver.findElements(By.id("input_0")).size();
			if (s > 0) {
				driver.findElement(By.xpath("//*[@id='input_0']")).sendKeys("9177240265");
				driver.findElement(By.xpath("//*[@id='input_1']")).sendKeys("parmeshwarA1!");
				driver.findElement(By.xpath("//*[@id='loginForm']/div/md-content/button[1]")).click();
				Thread.sleep(2000);
			}
			driver.switchTo().defaultContent();
		}

	}

}
