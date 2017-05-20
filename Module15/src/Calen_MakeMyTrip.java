import java.sql.Driver;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Sleeper;

public class Calen_MakeMyTrip {
	static WebDriver driver;

	public static void main(String[] args) throws ParseException, InterruptedException {
		System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
		driver = new FirefoxDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		// launch site
		driver.get("https://www.makemytrip.com/");
		// enter del in the from city
		driver.findElement(By.xpath("//*[@id='hp-widget__sfrom']")).sendKeys("Del");
		// select new delhi
		driver.findElement(
				By.xpath("//div[@class='locationFilter autocomplete_from']/ul/li[contains(@aria-label,'New Delhi')]"))
				.click();
		// enter hyderabad in to city
		driver.findElement(By.xpath("//*[@id='hp-widget__sTo']")).sendKeys("Hyderabad");
		Thread.sleep(5000);
		// click on hyderabad drop down
		driver.findElement(
				By.xpath("//div[@class='locationFilter autocomplete_to']/ul/li[contains(@aria-label,'Hyderabad')]"))
				.click();
		// click on from date

		driver.findElement(By.xpath("//*[@id='hp-widget__depart']")).click();
		// select the from date
		try {
			selectfromDate("19/08/2017");
		} catch (Throwable t) {
			t.printStackTrace();
		}
		// Click on to date
		driver.findElement(By.xpath("//input[@id='hp-widget__return']"));

	}

	public static void selectfromDate(String date) throws ParseException, InterruptedException {
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		Date dateToBeSelected = df.parse(date);

		String yeardisplayed;
		String monthdisplayed;

		String monthtobeselected = new SimpleDateFormat("MM").format(dateToBeSelected);
		String yeartobeselected = new SimpleDateFormat("yyyy").format(dateToBeSelected);
		String daytobeselected = new SimpleDateFormat("d").format(dateToBeSelected);
		System.out.println(monthtobeselected + yeartobeselected + daytobeselected);
		while (true) {// selecting year
			yeardisplayed = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']/span[2]")).getText();
			if (yeardisplayed.equals(yeartobeselected)) {
				break;

			} else if (Integer.parseInt(yeardisplayed) < Integer.parseInt(yeartobeselected)) {
				driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
			}
		}
		while (true) {// selecting month
			monthdisplayed = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']/span[1]")).getText();

			if (Integer.valueOf(monthStringtoint(monthdisplayed)).equals(Integer.valueOf(monthtobeselected)))
				break;
			else if (Integer.parseInt(monthStringtoint(monthdisplayed)) < Integer.parseInt(monthtobeselected)) {
				driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
			}
		}
		Thread.sleep(5000);
		// Selecting the date
		driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td[@data-month='7']/a[text()='"
				+ daytobeselected + "']")).click();

	}

	public static String monthStringtoint(String month) {
		String monthStringtoint = null;
		if (month.equals("JANUARY"))
			monthStringtoint = "01";
		else if (month.equals("FEBRUARY"))
			monthStringtoint = "02";
		else if (month.equals("MARCH"))
			monthStringtoint = "03";
		else if (month.equals("APRIL"))
			monthStringtoint = "04";
		else if (month.equals("MAY"))
			monthStringtoint = "05";
		else if (month.equals("JUNE"))
			monthStringtoint = "06";
		else if (month.equals("JULY"))
			monthStringtoint = "07";
		else if (month.equals("AUGUST"))
			monthStringtoint = "08";
		else if (month.equals("SEPTEMBER"))
			monthStringtoint = "09";
		else if (month.equals("OCTOBER"))
			monthStringtoint = "10";
		else if (month.equals("NOVEMBER"))
			monthStringtoint = "11";
		else if (month.equals("DECEMBER"))
			monthStringtoint = "12";

		return monthStringtoint;
	}

	public static void selecttodate(String date) throws ParseException {
		SimpleDateFormat dt = new SimpleDateFormat("dd/mm/yyyy");
		Date datetobeselected = dt.parse(date);

		String yeardisplayed = null;
		String monthdisplayed=null;

		String daytobeselected = new SimpleDateFormat("d").format(datetobeselected);
		String monthtobeselected = new SimpleDateFormat("MM").format(datetobeselected);
		String yeartobeselected = new SimpleDateFormat("yyyy").format(datetobeselected);

		while (true) {//Selecting Year
			yeardisplayed = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
if (yeardisplayed.equals(yeartobeselected)){
	break;
}
else if(Integer.parseInt(yeartobeselected)>Integer.parseInt(yeardisplayed))
{
	driver.findElement(By.id("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
}
		}
		while(true){
			monthdisplayed=driver.findElement(By.xpath("//*[@id='dp1495089349873']/div/div[2]/div/div/span[1]")).getText();
			
	}
}

	
}
