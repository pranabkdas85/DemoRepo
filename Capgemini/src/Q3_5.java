import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Q3_5 {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		Map<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("credentials_enable_service", false);
		options.setExperimentalOption("prefs", chromePrefs);
		options.addArguments("disable-infobars");
		WebDriver driver = new ChromeDriver(options);

		driver.get("https://paytm.com/");

		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//*[@id='app']/div/div[2]/div[2]/div[3]/div[3]/div")));
		element.click();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		// driver.findElement(By.xpath("//*[@id='app']/div/div[2]/div[2]/div[3]/div[3]/div")).click();

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
