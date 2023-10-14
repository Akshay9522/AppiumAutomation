package com.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class BaseTest {

	public static Properties pro;
	protected AndroidDriver driver;
	public static Properties loadProperties() throws Throwable {
		File file = new File(System.getProperty("user.dir")+"//config.properties");
		FileReader fr = new FileReader(file);
		pro = new Properties();
		pro.load(fr);
		return pro;		
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
	@BeforeTest
	public void androidDriver() throws Throwable {
		URL url = new URL(loadProperties().getProperty("appium.server.url"));
		driver = new AndroidDriver(url,androidCapabilities());
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@AfterTest
	public void tear() {
		driver.quit();
	}
}
