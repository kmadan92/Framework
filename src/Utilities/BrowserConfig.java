package Utilities;

import java.net.URL;
import java.security.InvalidParameterException;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;

//import com.Compass.WebUI.MobileEngine;
//
//import io.appium.java_client.android.AndroidDriver;
//import io.appium.java_client.remote.MobileCapabilityType;

public class BrowserConfig {
	
	public static WebDriver getBrowser(String Browser)
	{
		
	
	int b=0;
	
	
	if(Browser.trim().equalsIgnoreCase("firefox"))
		b=1;
	else if(Browser.trim().equalsIgnoreCase("IE"))
		b=2;
	else if(Browser.trim().equalsIgnoreCase("CHROME"))
		b=3;
//	else if(Browser.trim().equalsIgnoreCase("Mobile"))
//		b=4;
	
	switch (b) 
	{
		case 1:
			//updated to work with selenium 3.0.1 jars (these are triggered through Gecko driver, post setting the capabilities)
			//System.setProperty("webdriver.firefox.marionette","C:\\NewFramework_ISD-SIT_Project\\Browser\\GeckoDriver\\geckodriver.exe");
			System.setProperty("webdriver.gecko.driver","C:\\NewFramework_ISD-SIT_Project\\Browser\\GeckoDriver\\geckodriver.exe");
			DesiredCapabilities capabilities=DesiredCapabilities.firefox();
			capabilities.setCapability("marionette", true);
//			
			//FirefoxOptions options = new FirefoxOptions();
			//options.setBinary("C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe"); //Location where Firefox is installed
	 
			//DesiredCapabilities capabilities = DesiredCapabilities.firefox();
			//capabilities.setCapability("moz:firefoxOptions", options);
			
			
//			
//			//FirefoxProfile f1 = new FirefoxProfile();
//	        //boolean acceptUntrustedSs = false;
//	        //f1.setAssumeUntrustedCertificateIssuer(acceptUntrustedSs);
//			//return new FirefoxDriver(f1);
			//return new FirefoxDriver(); 
			return new FirefoxDriver(capabilities); 
//			FirefoxOptions firefoxOptions = new FirefoxOptions();
//			firefoxOptions.setLogLevel(FirefoxDriverLogLevel.TRACE);
//			firefoxOptions.setCapability("marionette", true);
//			return new FirefoxDriver(firefoxOptions); 
//			
			
	
		case 2:
			System.setProperty("webdriver.ie.driver", "C:\\NewFramework_ISD-SIT_Project\\Browser\\IE\\IEDriverServer.exe");
		DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
			ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			//ieCapabilities.setCapability("EnableNativeEvents", false);
				ieCapabilities.setCapability("ensureCleanSession", true);
          //  ieCapabilities.setCapability("browserName", "internet explorer");
           //  ieCapabilities.setCapability("VERSION", "11.0");
            // ieCapabilities.setCapability("platform", "WINDOWS");
               ieCapabilities.setCapability("ignoreZoomSetting", true);
            // ieCapabilities.setCapability("ignoreProtectedModeSettings", true); 

			return new InternetExplorerDriver(ieCapabilities);
			//return new InternetExplorerDriver();
		
		case 3:
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\kamadan\\Documents\\SOM\\Regression\\Script Backup for Laptop Change\\POA_Workspace\\Framework\\Browser\\Chrome\\chromedriver.exe");
//			DesiredCapabilities chromeCapabilities = DesiredCapabilities.chrome();
//			chromeCapabilities.setCapability("headless", true);
//			final ChromeOptions chromeOptions = new ChromeOptions();
//			chromeOptions.setBinary("C:\\Users\\kamadan\\AppData\\Local\\Google\\Chrome SxS\\Application\\chrome.exe");
//			chromeOptions.addArguments("--headless");
//			chromeCapabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);


			//if (null==System.getProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY))
			//{
				//System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY,"chromedriver");
			//}
				//return new ChromeDriver(chromeCapabilities);
				return  new ChromeDriver();
				
//		case 4:
//			DesiredCapabilities mobilecapabilities = new DesiredCapabilities();
//			mobilecapabilities.setCapability(MobileCapabilityType.BROWSER_NAME, BrowserType.CHROME);
//			mobilecapabilities.setCapability(MobileCapabilityType.PLATFORM, Platform.ANDROID);
//			mobilecapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "OnePlus5T");
//			mobilecapabilities.setCapability(MobileCapabilityType.VERSION, MobileEngine.version);
//			mobilecapabilities.setCapability(MobileCapabilityType.UDID, MobileEngine.deviceid);
//			mobilecapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
//			
//		 driver = new AndroidDriver(new URL("http://127.0.0.1:"+MobileEngine.port+"/wd/hub"), mobilecapabilities);
//		 return driver;
		 
		default:
			throw new InvalidParameterException("You must choose one of the defined driver types");

	}
	
	}
}
