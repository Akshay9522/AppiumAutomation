package com.utils;

import java.awt.Dimension;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class Utility {
	
public static void clickOnElement (WebElement element) {
	element.click();
}
public static void sendText (WebElement element, String text) {
	element.clear();
	element.sendKeys(text);
}
public static String DisplayedText (WebElement element) {
	return element.getText();
}
public static void scroll(Dimension size) {
	
}
public static void swipeByElement(AndroidDriver driver,WebElement element,String direction) {
	((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
			  "elementId", ((RemoteWebElement) element).getId(),
			    "direction", direction,
			    "percent", 0.75
			));
}
public static void scrollToElement(AndroidDriver driver,String Uitext) {
	driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"Uitext\"))"));
}
public static void scrollToLast(AndroidDriver driver,String direction) {
	 boolean canScrollMore;
	 do {
		  canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
				    "left", 100, "top", 100, "width", 200, "height", 200,
				    "direction", direction,
				    "percent", 3.0
				));
	 }while(canScrollMore);

}
public static void longClick(AndroidDriver driver,WebElement element,String timeInms) {
	((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
	    "elementId", ((RemoteWebElement) element).getId(),"duration",timeInms
	));
}
}