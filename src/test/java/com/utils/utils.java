package com.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class utils extends BaseTest implements ITestListener{

	public void onTestFailure(ITestResult result) {

		try {
			captureScreen(result.getMethod().getMethodName());
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

}