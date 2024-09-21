package appiumTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.touch.LongPressOptions;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
public class DragAndDropDemo {

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
		Thread.sleep(2000);
		
		// Scroll to "Views" and click
        String elementToScroll = "Views";
        WebElement viewElement = driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"" + elementToScroll + "\"))"));
        viewElement.click();

        Thread.sleep(1500);
 
        WebElement dragAndDrop = driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Drag and Drop\"]"));
        dragAndDrop.click();
        
		WebElement source = driver.findElement(By.xpath("//android.view.View[@resource-id=\"com.touchboarder.android.api.demos:id/drag_dot_1\"]"));
		WebElement target = driver.findElement(By.xpath("//android.view.View[@resource-id=\"com.touchboarder.android.api.demos:id/drag_dot_2\"]"));
		
		TouchAction action  = new TouchAction(driver);
		
		Thread.sleep(2000);
		action.longPress(longPressOptions().withElement(element(source))).moveTo(element(target)).release().perform();
	}

}
