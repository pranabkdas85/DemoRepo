import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Q6 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.get("https://www.irctc.co.in/eticketing/loginHome.jsf");

		// CREDENTAILS
		driver.findElement(By.id("usernameId")).sendKeys("prandas");
		driver.findElement(By.className("loginPassword")).sendKeys("poz909");
		Thread.sleep(10000);
		driver.findElement(By.id("loginbutton")).click();
		// HOMEPAGE
		driver.findElement(By.id("jpform:fromStation")).sendKeys("New D");
		WebElement from = driver.findElement(By.id("ui-id-1"));
		List<WebElement> from_list = from.findElements(By.tagName("li"));
		System.out.println("total no of values in from is : " + from_list.size());
		System.out.println("The List of stations in from list are: ");
		for (int i = 0; i < from_list.size(); i++) {
			System.out.println(from_list.get(i).getText());
		}
		for (int i = 0; i < from_list.size(); i++) {
			if (from_list.get(i).getText().equals("NEW DELHI - NDLS")) {
				from_list.get(i).click();
				break;
			}
		}
		driver.findElement(By.id("jpform:toStation")).sendKeys("chennai");

		WebElement to = driver.findElement(By.id("ui-id-2"));
		List<WebElement> to_list = to.findElements(By.tagName("li"));
		System.out.println("LIST OF PLACES IN TO :" + to_list.size());
		for (int i = 0; i < to_list.size(); i++) {
			System.out.print(to_list.get(i).getText());
			System.out.print(", is displayed :");
			System.out.print(to_list.get(i).isDisplayed());
			System.out.println("");
		}

		for (int i = 0; i < to_list.size(); i++) {
			if (to_list.get(i).getText().equals("CHENNAI CENTRAL - MAS"))
				to_list.get(i).click();
		}

		// INPUT Journey Date AND SUUBMIT
		driver.findElement(By.xpath("//*[@id='jpform:journeyDateInputDate']")).sendKeys("07-04-2017");
		driver.findElement(By.id("jpform:flexiDateId")).click();
		driver.findElement(By.id("jpform:jpsubmit")).click();

		// count the number of check boxes= DOUBT
		WebElement box = driver.findElement(By.id("jpform:j_idt226_body"));
		List<WebElement> no_box = box.findElements(By.tagName("input"));
		System.out.println("The number of Checkbox :" + no_box.size());
		for (int i = 0; i < no_box.size(); i++) {// DOUBT
			WebElement span = no_box.get(i).findElement(By.xpath("./following-sibling::span[1]"));
			System.out.println(span.getText());
		}
		// COUNT THE RADIO BUTTONS
		WebElement quota = driver.findElement(By.className("captchatxt"));
		List<WebElement> catagory = quota.findElements(By.xpath("//div[@id='qcbd']/table/tbody/tr/td"));
		System.out.println("Number of Radio Buttons : " + catagory.size());
		System.out.println("The radio buttons are :");

		for (int i = 0; i < catagory.size(); i++) {
			System.out.println(catagory.get(i).getText());

		}
		for (int i = 0; i < catagory.size(); i++) {
			if (catagory.get(i).getAttribute("checked").equals("checked")) {
				System.out.println("The element checked is  : " + catagory.get(i).getText());
			}
		}
		// TABLE
		int no_columns = driver.findElements(By.xpath("//table[@id='avlAndFareForm:trainbtwnstns']/tbody/tr[1]/td"))
				.size();
		int no_rows = driver.findElements(By.xpath("//table[@id='avlAndFareForm:trainbtwnstns']/tbody/tr/td[1]"))
				.size();
		System.out.println("NO OF columns : " + no_columns);// DOUBT
		System.out.println("NO OF rows : " + no_rows);// DOUBT
		for (int c = 1; c < no_rows; c++) {
			for (int d = 1; d < no_columns; d++) {
				System.out.print(driver
						.findElement(By
								.xpath("//table[@id='avlAndFareForm:trainbtwnstns']/tbody/tr[" + c + "]/td[" + d + "]"))
						.getText() + "----");
			}
			System.out.println("");
		}
		driver.findElement(By.xpath("//*[@id='avlAndFareForm:trainbtwnstns:0:j_idt478']/a")).click();
		// *[@id='avlAndFareForm:trainbtwnstns:0:j_idt478']/a

		Thread.sleep(10000);
		driver.findElement(By.xpath("//*[@id='avlAndFareForm:trainSchedPanel_content']/div/input")).click();

	}
}
