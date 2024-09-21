package appiumTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class BrrowserAutomation {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub

		UiAutomator2Options options = new UiAutomator2Options()
				.setAutomationName("UiAutomator2")
				.setPlatformName("Android")
				.setPlatformVersion("13")
				.setDeviceName("ca827b46");
		
		options.setCapability("browserName", "chrome");
		options.setCapability("chromedriverExecutable", "C:\\Users\\User\\eclipse-workspace\\Appium_Mobile_Test_Project\\chromedriver.exe");
				
		URL serverUrl = new URL("http://localhost:4723/wd/hub");
		AndroidDriver driver = new AndroidDriver(serverUrl, options);

		driver.get("https://www.google.com/");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement name = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
		name.sendKeys("Taj Mahal");
		name.sendKeys(Keys.RETURN);
		
		//apium server should be up and running and open chrome in mobile and connect ot desktop and open chrome in desktop and enter chrome://inspect/#devices
		//click on inspect

	}

}
