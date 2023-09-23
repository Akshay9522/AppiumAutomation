package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.utils.Utility;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginPage {
	
public AndroidDriver driver;

@AndroidFindBy (accessibility="Login")
WebElement login;
@AndroidFindBy (accessibility="input-email")
WebElement userName;
@AndroidFindBy (accessibility="input-password")
WebElement passwd;
@AndroidFindBy (accessibility="button-LOGIN")
WebElement buttonLogin;
@AndroidFindBy (id="android:id/alertTitle")
WebElement sucessMsg;

public LoginPage(AndroidDriver driver) {
	this.driver = driver;
	PageFactory.initElements(new AppiumFieldDecorator(driver), this);
}

public void clickOnLogin() {
	Utility.clickOnElement(login);
}
public void clickOnsignin() {
	Utility.clickOnElement(buttonLogin);
}
public void enterloginDetails() {
	Utility.sendText(userName, "abc@gmail.com");
	Utility.sendText(passwd, "abc@1234");
}
public String displayMsg() {
	return Utility.DisplayedText(sucessMsg);
}
}
