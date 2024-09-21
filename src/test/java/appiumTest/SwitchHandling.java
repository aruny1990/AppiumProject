package appiumTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class SwitchHandling {

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

		driver.findElement(By.id("com.android.permissioncontroller:id/continue_button")).click();
		Thread.sleep(1500);
		driver.findElement(By.id("android:id/button1")).click();
		Thread.sleep(1000);
		
		// Scroll to "Views" and click
        String elementToScroll = "Views";
        WebElement viewElement = driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"" + elementToScroll + "\"))"));
        viewElement.click();

        Thread.sleep(2000);
        // Scroll to "Switches" and click
        String mobElementToScroll = "Switches";
        WebElement switchElement = driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"" + mobElementToScroll + "\"))"));
        switchElement.click();

        // Add a wait to observe the result before closing
        Thread.sleep(2000);

		WebElement monitoredSwitch = driver.findElement(By.id("com.touchboarder.android.api.demos:id/monitored_switch"));
		
		if(monitoredSwitch.isSelected()==true) {
			System.out.println("Monitored switch is ON");
		}else {
			System.out.println("Monitored switch is OFF");
			monitoredSwitch.click();
		}
		
	}

}
