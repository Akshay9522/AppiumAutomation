package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.utils.Utility;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import junit.framework.Assert;


public class GesturePage {

	public AndroidDriver driver;
	@AndroidFindBy (accessibility="Swipe")
	WebElement swipeButton;
	
	@AndroidFindBy (xpath="(//android.view.ViewGroup[@content-desc='slideTextContainer'])[1]")
	WebElement fullopnsrc;
	
	@AndroidFindBy (xpath="//android.widget.TextView[@text='You found me!!!']")
	WebElement youfndme;

	public GesturePage(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	public void scrollByVisualText(String text ){
		Utility.scrollToElement(driver, text);
	}
	public void swipeByfullopensrc(String direction ){
		Utility.swipeByElement(driver, fullopnsrc, direction);
	}
	public void swipeVarify( ){
		String check=fullopnsrc.getAttribute("focusable");
		Assert.assertEquals(check, "false");
	}
	public void clickswipe() {
		Utility.clickOnElement(swipeButton);
	}
	public void scrollVarify( ){
		Assert.assertTrue(youfndme.isDisplayed());
	}
	


}
