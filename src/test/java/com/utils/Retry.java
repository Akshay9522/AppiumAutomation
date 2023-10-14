package com.utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer{

	private int retryCount = 0;
	private static int maxTry = 3;


	public boolean retry(ITestResult result) {
		if (retryCount < maxTry ) {
			
			retryCount++;
			
		}
		return false;
	}

}