package appiumTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Example1TestClassInstallAppOnEmulator {

	public static void main(String[] args) throws MalformedURLException {
		 UiAutomator2Options options = new UiAutomator2Options()
	                .setAutomationName("Appium")
	                .setPlatformName("Android")
	                .setPlatformVersion("13")
	                .setDeviceName("ca827b46")
	                .setApp("C:\\SDKtools\\indiamart.apk")
	                .setAndroidInstallTimeout(Duration.ofMillis(300000)); // 5 minutes (300000 ms);

	        URL serverUrl = new URL("http://localhost:4723/wd/hub");
	        AndroidDriver driver = new AndroidDriver(serverUrl, options);

	        // Use the driver
	        driver.quit();  
	        
	        //Enable  - Adavance Settings - Developer Options - Disable permission monitoring;
	}
}
