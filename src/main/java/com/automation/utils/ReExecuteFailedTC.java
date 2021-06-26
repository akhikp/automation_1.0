package com.automation.utils;

import org.testng.Assert;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.annotations.Test;

public class ReExecuteFailedTC implements IRetryAnalyzer {
	private int retryCount = 0;
	private int maxRetryCount = 1;

	public boolean retry(ITestResult result) {

		if (retryCount < maxRetryCount) {
			retryCount++;
			return true;
		}
		return false;
	}


}