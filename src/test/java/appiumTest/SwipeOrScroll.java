package appiumTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Collections;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class SwipeOrScroll {

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
        
        Dimension size = driver.manage().window().getSize();
        
        //find the position where you want ot touch
        int startX = size.getWidth() / 2;
        int startY = size.getHeight()/2;
        
        //position till you want to move your finger to swipe
        int endX = startX;
        int endY = (int) (size.getHeight() * 0.25);
        
        //PointerInput class t ocreate a sequence of actions
        PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH,"finger1");
        
        //Sequence object, which is a list of actions that will be perofrmed
        Sequence sequence = new Sequence(finger1,1)
        		.addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(),startX,startY))
        		.addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
        		.addAction(new Pause(finger1, Duration.ofMillis(200)))
        		.addAction(finger1.createPointerMove(Duration.ofMillis(100), PointerInput.Origin.viewport(), endX,endY))
        		.addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        
        driver.perform(Collections.singletonList(sequence));
        
        Thread.sleep(2000);
        
	}

}
