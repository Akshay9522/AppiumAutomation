package com.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.pages.LoginPage;
import com.utils.BaseTest;

public class LoginTest extends BaseTest{
	
@Test
public void loginTestPositive() throws Throwable {
	LoginPage lgpge = new LoginPage(driver);
	lgpge.clickOnLogin();
	lgpge.enterloginDetails();
	lgpge.clickOnsignin();
	Assert.assertEquals(lgpge.displayMsg(), "Success");
	Thread.sleep(4000);
}
}
