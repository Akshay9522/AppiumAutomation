package com.pages;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SwipePage {

	public AndroidDriver driver;

	public SwipePage() {

		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);

	}
	
	public void scrollPage() {
		
	}
}
