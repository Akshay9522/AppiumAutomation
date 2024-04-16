package com.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.remote.options.BaseOptions;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;

public class Base {

	public static Properties pro;
	public static AndroidDriver driver;
	public IOSDriver iosdriver;
	public static Properties loadProperties() throws Throwable {
		File file = new File(System.getProperty("user.dir")+"//config.properties");
		FileReader fr = new FileReader(file);
		pro = new Properties();
		pro.load(fr);
		return pro;		
	}
	public static XCUITestOptions iosCapabilities() throws Throwable {
		XCUITestOptions options = new XCUITestOptions();
		options.setPlatformName(loadProperties().getProperty("ios.platformName"));
		options.setCapability("platformVersion", loadProperties().getProperty("ios.platformVersion"));
		options.setCapability("deviceName", loadProperties().getProperty("deviceName"));
		options.setCapability("automationName", loadProperties().getProperty("ios.automationName"));
		options.setCapability("app", System.getProperty("user.dir")+"//App//"+loadProperties().getProperty("android.app2.name"));
		options.setCapability("appPackage", loadProperties().getProperty("ios.app2.packageName"));
		options.setCapability("appActivity", loadProperties().getProperty("ios.app2.activityName"));
		options.setCapability("fullReset", loadProperties().getProperty("ios.fullReset"));
		options.setCapability("noReset", loadProperties().getProperty("ios.noReset"));
		return options;		
	}
	
	public static UiAutomator2Options androidCapabilities() throws Throwable {
		UiAutomator2Options options = new UiAutomator2Options();
		options.setPlatformName(loadProperties().getProperty("android.platformName"));
		options.setCapability("platformVersion", loadProperties().getProperty("android.platformVersion"));
		options.setCapability("deviceName", loadProperties().getProperty("deviceName"));
		options.setCapability("automationName", loadProperties().getProperty("android.automationName"));
		options.setCapability("app", System.getProperty("user.dir")+"//App//"+loadProperties().getProperty("android.app2.name"));
		options.setCapability("appPackage", loadProperties().getProperty("android.app2.packageName"));
		options.setCapability("appActivity", loadProperties().getProperty("android.app2.activityName"));
		options.setCapability("fullReset", loadProperties().getProperty("android.fullReset"));
		options.setCapability("noReset", loadProperties().getProperty("android.noReset"));
		return options;		
	}
	public void captureScreen( String tcname) throws IOException {

		TakesScreenshot ts = (TakesScreenshot) driver;
		File sourse= ts.getScreenshotAs(OutputType.FILE);
		File target = new File (System.getProperty("user.dir")  +  "\\Screenshots\\" +tcname + ".png" );
		FileUtils.copyFile(sourse, target);
	}
	
	public void androidDriver(String url,BaseOptions options ) throws Throwable {
		driver = new AndroidDriver(new URL(url),options);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	public void iosDriver(String url,BaseOptions options ) throws Throwable {
		iosdriver = new IOSDriver(new URL(url),options);
		iosdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public void tearDown() {
		driver.quit();
	}
}
