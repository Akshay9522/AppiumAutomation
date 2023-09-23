package com.utils;

import org.openqa.selenium.WebElement;

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
}
