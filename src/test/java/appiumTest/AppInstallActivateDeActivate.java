package appiumTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class AppInstallActivateDeActivate {

	public static void main(String[] args) throws InterruptedException, MalformedURLException {
		// TODO Auto-generated method stub

		// TODO Auto-generated method stub

		//Gather Desired capabilities
		//edited
		UiAutomator2Options options = new UiAutomator2Options()
				.setAutomationName("Appium")
				.setPlatformName("Android")
				.setPlatformVersion("13")
				.setDeviceName("ca827b46")
				.setApp("C:\\SDKtools\\ApiDemos-debug.apk")
				.setAndroidInstallTimeout(Duration.ofMillis(300000)); // 5 minutes (300000 ms);

		URL serverUrl = new URL("http://localhost:4723/wd/hub");
		AndroidDriver driver = new AndroidDriver(serverUrl, options);

		System.out.println("Application started");

		String packageName = "com.touchboarder.android.api.demos";
		driver.terminateApp(packageName);
/*		driver.removeApp(packageName);
		
		if(!driver.isAppInstalled(packageName)) {
			//Install application
			driver.installApp("C:\\\\SDKtools\\\\ApiDemos-debug.apk");
			System.out.println("App Installed");
		}else {
			System.out.println("App already installed");
			//Activate the appliation
			driver.activateApp(packageName);
		}*/
		Thread.sleep(5000);
		System.out.println("Application completed");
		driver.quit();//CLOSE SESSION
	}

}
