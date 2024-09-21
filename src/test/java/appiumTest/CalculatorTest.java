package appiumTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class CalculatorTest {

	
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		UiAutomator2Options options = new UiAutomator2Options()
		        .setAutomationName("UiAutomator2")
		        .setPlatformName("Android")
		        .setPlatformVersion("13")
		        .setDeviceName("ca827b46")
		        .setAppPackage("com.coloros.calculator")
		        .setAppActivity("com.android.calculator2.Calculator")
		        .setAndroidInstallTimeout(Duration.ofMillis(300000)); // 5 minutes

	        URL serverUrl = new URL("http://localhost:4723/wd/hub");
	        AndroidDriver driver = new AndroidDriver(serverUrl, options);

	        
	       WebElement seven = driver.findElement(By.id("com.coloros.calculator:id/digit_7"));
	       seven.click();
	       
	       driver.findElement(By.id("com.coloros.calculator:id/op_add")).click();
	       
	       WebElement three = driver.findElement(By.id("com.coloros.calculator:id/digit_3"));
	       three.click();
	       
	       WebElement eqTo = driver.findElement(By.id("com.coloros.calculator:id/eq"));
	       
	       eqTo.click();
	       
	       String result = driver.findElement(By.id("com.coloros.calculator:id/result")).getText().toString();
	       
	       if(result.equals("10")) {
	    	   System.out.println("Test passed");
	       }else {
	    	   System.out.println("Result failed");
	       }
	       Thread.sleep(5000);
	        
	        // Use the driver
	        driver.quit();  

	}
}
