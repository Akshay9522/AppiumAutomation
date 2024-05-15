package com.utils;

import java.awt.Dimension;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

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
public static void rotateScreen(AndroidDriver driver) {
	DeviceRotation rotate = new DeviceRotation(0, 0, 90);
	driver.rotate(rotate);
}
public static void hideKeyboard(AndroidDriver driver) {
	driver.hideKeyboard();
}
public static String validateCopiedText(AndroidDriver driver, String text) {
	driver.setClipboardText(text);
	return driver.getClipboardText();
}
public static void pressBackKey(AndroidDriver driver) {
	driver.pressKey(new KeyEvent(AndroidKey.BACK));
}
public static void pressHomeKey(AndroidDriver driver) {
	driver.pressKey(new KeyEvent(AndroidKey.BACK));
}
public static void openActivity(AndroidDriver driver,String packageName,String appActivity ) {
	((JavascriptExecutor) driver).executeScript("mobile: startActivity", ImmutableMap.of(
			  "intent",packageName+"/"+appActivity));
}
public static void switchToWebView(AndroidDriver driver, String appPackage) {
	Set<String> handles = driver.getContextHandles();
	Iterator<String> iterator = handles.iterator();
	while(iterator.hasNext()) {
		String view = iterator.next();
		if(view.equalsIgnoreCase("WEBVIEW"+appPackage)) {
			driver.context(view);
		}
	}
}
public static void switchToNativeView(AndroidDriver driver, String appPackage) {
	Set<String> handles = driver.getContextHandles();
	Iterator<String> iterator = handles.iterator();
	while(iterator.hasNext()) {
		String view = iterator.next();
		if(view.equalsIgnoreCase("NATIVE_VIEW"+appPackage)) {
			driver.context(view);
		}
	}
}
public static String toastMsgXpath(String text) {
	return "//android.widget.Toast[text()="+text+"]";
}
}