import org.openqa.selenium.Platform;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;


public class DesiredCapabilities_Firefox {

	public static void main(String[] args) {
		DesiredCapabilities cap = new DesiredCapabilities();
		//cap.setBrowserName("Mozilla");
		cap.setJavascriptEnabled(true);
		cap.setCapability(CapabilityType.BROWSER_NAME,"Mozilla");
		cap.setCapability(CapabilityType.PLATFORM, Platform.WINDOWS);
		
		System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");

		FirefoxDriver dr = new FirefoxDriver(cap);
	}

}
