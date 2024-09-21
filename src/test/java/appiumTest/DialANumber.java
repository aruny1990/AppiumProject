package appiumTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class DialANumber {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
        UiAutomator2Options options = new UiAutomator2Options()
                .setAutomationName("UiAutomator2")
                .setPlatformName("Android")
                .setPlatformVersion("13")
                .setDeviceName("ca827b46")
                .setAppPackage("com.google.android.dialer")
                .setAppActivity("com.google.android.dialer.extensions.GoogleDialtactsActivity").setAndroidInstallTimeout(Duration.ofMillis(300000)); // 5 minutes

		URL serverUrl = new URL("http://localhost:4723/wd/hub");
		AndroidDriver driver = new AndroidDriver(serverUrl, options);

		
		//command to find the dialer appPackage and app activity
		//C:\Users\User>adb shell
		//OP4F39L1:/ $ dumpsys window displays | grep -e 'mCurrentFocus'
		//  mCurrentFocus=Window{57fa581 u0 com.google.android.dialer/com.google.android.dialer.extensions.GoogleDialtactsActivity}
		
		//To start appium inspector
		//appium --allow-cors
		/*
		 * { "appium:automationName": "UiAutomator2", "appium:platformName": "Android",
		 * "appium:platformVersion": "13", "appium:deviceName": "ca827b46",
		 * "appium:appPackage": "com.google.android.dialer", "appium:appActivity":
		 * "com.google.android.dialer.extensions.GoogleDialtactsActivity" }
		 */
		
		WebElement dialer = driver.findElement(By.id("com.google.android.dialer:id/dialpad_fab"));
		dialer.click();
		
		//click on numbers
		driver.findElement(By.id("com.google.android.dialer:id/zero")).click();
		driver.findElement(By.id("com.google.android.dialer:id/nine")).click();
		driver.findElement(By.id("com.google.android.dialer:id/eight")).click();
		driver.findElement(By.id("com.google.android.dialer:id/one")).click();
		driver.findElement(By.id("com.google.android.dialer:id/zero")).click();
		driver.findElement(By.id("com.google.android.dialer:id/zero")).click();
		driver.findElement(By.id("com.google.android.dialer:id/one")).click();
		driver.findElement(By.id("com.google.android.dialer:id/two")).click();
		driver.findElement(By.id("com.google.android.dialer:id/three")).click();
		driver.findElement(By.id("com.google.android.dialer:id/four")).click();
		driver.findElement(By.id("com.google.android.dialer:id/five")).click();
		
		driver.findElement(By.id("com.google.android.dialer:id/dialpad_voice_call_button")).click();
	}

}
