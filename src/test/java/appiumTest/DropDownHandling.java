package appiumTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class DropDownHandling {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub

		UiAutomator2Options options = new UiAutomator2Options()
				.setAutomationName("UiAutomator2")
				.setPlatformName("Android")
				.setPlatformVersion("13")
				.setDeviceName("ca827b46")
				.setAppPackage("com.touchboarder.android.api.demos")
				.setAppActivity("com.example.android.apis.ApiDemos").setAndroidInstallTimeout(Duration.ofMillis(300000)); // 5 minutes

		URL serverUrl = new URL("http://localhost:4723/wd/hub");
		AndroidDriver driver = new AndroidDriver(serverUrl, options);

		Thread.sleep(2000);
		
		System.out.println("Application started");
		driver.findElement(By.id("com.android.permissioncontroller:id/continue_button")).click();
		Thread.sleep(1500);
		driver.findElement(By.id("android:id/button1")).click();
		Thread.sleep(2500);
		
		// Scroll to "Views" and click
        String elementToScroll = "Views";
        WebElement viewElement = driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"" + elementToScroll + "\"))"));
        viewElement.click();

        Thread.sleep(1500);
        
        driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Controls\"]")).click();
        
        Thread.sleep(1500);
        
        
        driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"01. Light Theme\"]")).click();
        
        Thread.sleep(2500);
        
		// Scroll to "Views" and click
        String elementsToScroll = "Mercury";
        WebElement viewElements = driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"" + elementsToScroll + "\"))"));
        viewElements.click();
        
        //WebElement dropDown = driver.findElement(By.xpath("//android.widget.Spinner[@resource-id=\"com.touchboarder.android.api.demos:id/spinner1\"]"));
        //dropDown.click();
        
        Thread.sleep(1500);
        
        WebElement earthOption = driver.findElement(By.xpath("//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\"Earth\"]"));
        earthOption.click();
        
        System.out.println("Session closed");
        Thread.sleep(2000);
        
        driver.quit();
	}

}
