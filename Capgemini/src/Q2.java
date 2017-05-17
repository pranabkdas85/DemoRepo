import org.testng.Assert;
import org.testng.AssertJUnit;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Q2 {

	static WebDriver driver;
	
	public static void main(String[] args) {
		//System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
		/*System.setProperty("webdriver.gecko.driver", "D:/Coding/jars/geckodriver-v0.14.0-win32/geckodriver.exe");
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		FirefoxOptions options = new FirefoxOptions();
		options.setLogLevel(Level.SEVERE);
		capabilities.setCapability("moz:firefoxOptions", options);
		WebDriver driver = new FirefoxDriver(capabilities);*/
		
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		Map<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("credentials_enable_service", false);
		options.setExperimentalOption("prefs", chromePrefs);
		options.addArguments("disable-infobars");
		driver = new ChromeDriver(options);
		
		driver.manage().window().maximize();
		
		String startDate = "08/06/2021"; // 8th June 2021
		
		String endDate = "08/06/2021"; // 16th June 2021

		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		driver.get("http://www.gingerhotels.com/");
		driver.findElement(By.xpath("//div[@class='form-group col-md-12']/select")).sendKeys("Agartala");
		
		//Setting checkin date
		WebElement checkInEle = driver.findElement(By.id("checkin"));
		setDate(startDate, checkInEle);
		
		//Setting checkout date
		WebElement checkOutEle = driver.findElement(By.id("checkout"));
		setDate(endDate, checkOutEle);
		
		WebElement room = driver.findElement(By.id("rooms"));
		room.sendKeys("2");

	}
	
	public static Calendar getFormattedDate(String dateInString){
		Date formattedDate = null;
		Date dateNow = null;
		SimpleDateFormat newdateFormat = new SimpleDateFormat("dd/MM/yyyy");
		try {
			formattedDate = newdateFormat.parse(dateInString);
			dateNow  = newdateFormat.parse(newdateFormat.format(new Date()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Calendar fomattedCalc = Calendar.getInstance();
		fomattedCalc.setTime(formattedDate);
		Calendar calNow = Calendar.getInstance();
		calNow.setTime(dateNow);
		
		if(fomattedCalc.before(calNow))
			return null;
			
		return fomattedCalc;
	}
		
	public static void setDate(String dateInString,WebElement dateBox){
		Calendar cal =  getFormattedDate(dateInString);
		if(null==cal){
			System.out.println("Please provide current or future date");
			Assert.fail("Please provide current or future date");
			return;
		}
		
		//Date picker is to be clicked only for checkin
		if(dateBox.getAttribute("id").equals("checkin")){
			dateBox.click();
		}
			
		WebElement datePicker = driver.findElement(By.xpath("//div[@class='datepicker dropdown-menu' and not(contains(@style,'none'))]"));
		
		//Check for relationship between checkout and checkin date
		if(dateBox.getAttribute("id").equals("checkout")){
			String monthYear = datePicker.findElement(By.xpath("./div[contains(@class,'-days')]//th[@class='switch']")).getText();
			String activeDate = datePicker.findElement(By.xpath(".//td[@class='day  active']")).getText();
			String checkinString = monthYear+" "+activeDate;
			
			Calendar checkincal = Calendar.getInstance();
			try {
				checkincal.setTime(new SimpleDateFormat("MMMM yyyy d").parse(checkinString));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			checkincal.add(Calendar.DATE, -1);
			
			if(cal.before(checkincal)){
				System.out.println("Please provide checkout date as equal to or more than checkin date");
				Assert.fail("Please provide checkout date as equal to or more than checkin date");
				return;
			}
			
		}
		
		String year = String.valueOf(cal.get(Calendar.YEAR));
		String month = new SimpleDateFormat("MMM").format(cal.getTime());
		String date = String.valueOf(cal.get(Calendar.DATE));
		
		
		if(datePicker.findElement(By.xpath("./div[contains(@class,'-days')]//th[@class='switch']")).getText().contains(year)){
			//When we are booking in the same year
			if(datePicker.findElement(By.xpath("./div[contains(@class,'-days')]//th[@class='switch']")).getText().contains(month)){
				//When we are booking in the same month
				datePicker.findElement(By.xpath(".//td[not(contains(@class,'old')) or not(contains(@class,'disabled'))][text()='"+date+"']")).click();
			}else{
				//Selecting the target month and date
				datePicker.findElement(By.xpath("./div[contains(@class,'-days')]//th[@class='switch']")).click();
				datePicker.findElement(By.xpath(".//span[contains(@class,'month')][text()='"+month+"']")).click();
				dateBox.click();
				datePicker.findElement(By.xpath(".//td[not(contains(@class,'old')) or not(contains(@class,'disabled'))][text()='"+date+"']")).click();
			}
		}else{
			//When we are not booking in the same year
			datePicker.findElement(By.xpath("./div[contains(@class,'-days')]//th[@class='switch']")).click();
			datePicker.findElement(By.xpath("./div[contains(@class,'-month')]//th[@class='switch']")).click();
			
			//Searching for correct year to be found
			boolean isYearNotInRange = false;
			do{
				String yearRange = datePicker.findElement(By.xpath("./div[contains(@class,'-years')]//th[@class='switch']")).getText();
				isYearNotInRange = Integer.parseInt(yearRange.substring(5, 9))<Integer.parseInt(year);
				if(isYearNotInRange)
					datePicker.findElement(By.xpath("./div[contains(@class,'-years')]//th[@class='next']")).click();
			}while(isYearNotInRange);
			
			//Selecting correct year
			datePicker.findElement(By.xpath(".//span[contains(@class,'year')][text()='"+year+"']")).click();
			dateBox.click();
			
			//Searching for target month and date
			if(datePicker.findElement(By.xpath("./div[contains(@class,'-days')]//th[@class='switch']")).getText().contains(month)){
				datePicker.findElement(By.xpath(".//td[not(contains(@class,'old')) or not(contains(@class,'disabled'))][text()='"+date+"']")).click();
			}else{
				datePicker.findElement(By.xpath("./div[contains(@class,'-days')]//th[@class='switch']")).click();
				datePicker.findElement(By.xpath(".//span[contains(@class,'month')][text()='"+month+"']")).click();
				dateBox.click();
				datePicker.findElement(By.xpath(".//td[not(contains(@class,'old')) or not(contains(@class,'disabled'))][text()='"+date+"']")).click();
			}
		}
		
	}
}
