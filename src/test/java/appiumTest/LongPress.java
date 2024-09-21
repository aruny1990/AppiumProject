package appiumTest;

import java.awt.Point;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Collections;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.interactions.Sequence;

public class LongPress {

	static AndroidDriver driver = null;
	
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub

		UiAutomator2Options options = new UiAutomator2Options()
				.setAutomationName("UiAutomator2")
				.setPlatformName("Android")
				.setPlatformVersion("13")
				.setDeviceName("ca827b46")
				.setAppPackage("com.google.android.dialer")
				.setAppActivity("com.google.android.dialer.extensions.GoogleDialtactsActivity").setAndroidInstallTimeout(Duration.ofMillis(300000)); // 5 minutes

		URL serverUrl = new URL("http://localhost:4723/wd/hub");
		driver = new AndroidDriver(serverUrl, options);


		System.out.println("Application started");
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
		//driver.findElement(By.id("com.google.android.dialer:id/zero")).click();
		driver.findElement(By.id("com.google.android.dialer:id/nine")).click();
		driver.findElement(By.id("com.google.android.dialer:id/eight")).click();
		driver.findElement(By.id("com.google.android.dialer:id/one")).click();
		driver.findElement(By.id("com.google.android.dialer:id/zero")).click();
//		driver.findElement(By.id("com.google.android.dialer:id/zero")).click();
//		driver.findElement(By.id("com.google.android.dialer:id/one")).click();
//		driver.findElement(By.id("com.google.android.dialer:id/two")).click();
//		driver.findElement(By.id("com.google.android.dialer:id/three")).click();
//		driver.findElement(By.id("com.google.android.dialer:id/four")).click();
//		driver.findElement(By.id("com.google.android.dialer:id/five")).click();

		Thread.sleep(2000);
		//Long press on backspace/ delete button
		WebElement cancelBtn = driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"backspace\"]"));
		
		
		//LongPress on backspace / delete button
		longPress(cancelBtn);
		
		System.out.println("Test passed");
		
		Thread.sleep(2000);
		
		driver.quit();
		
	}
	
	static void longPress(WebElement el) {
		org.openqa.selenium.Point location = el.getLocation();
		PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH,"finger");
		
		Sequence longPress = new Sequence(finger,1);
		longPress.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), location.x,location.y));
		longPress.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
		longPress.addAction(finger.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(), location.x,location.y));
		longPress.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
		((AppiumDriver)driver).perform(Collections.singletonList(longPress));
		
		
		
	}

}
