package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utils.Utility;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import junit.framework.Assert;

public class AndroidBrowserPage {


	public AndroidDriver driver;
	@FindBy (id="email")
	WebElement emailField;
	
	@FindBy (id="pass")
	WebElement passwdField;
	
	@FindBy (name="login")
	WebElement loginButton;
	
	@FindBy (xpath = "(//div[@id='email_container']//child::div)[2]")
	WebElement errorMsg;

	public AndroidBrowserPage(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	public void enterUsername(String text ){
		Utility.sendText(emailField, text);
	}
	public void enterPassword(String text ){
		Utility.sendText(passwdField, text);
	}
	public void clickOnLogin() {
		Utility.clickOnElement(loginButton);
	}
	public String displayErrorMsg() {
		return Utility.DisplayedText(errorMsg);
	}
}
