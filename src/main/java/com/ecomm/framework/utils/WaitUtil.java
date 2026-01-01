package com.ecomm.framework.utils;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import driver.DriverFactory;

public class WaitUtil {

	public static final int DEFAULT_TIMEOUT = 10;

	private static WebDriver getDriver() {
		return DriverFactory.getDriver();
	}

	private static WebDriverWait getWait() {
		return new WebDriverWait(getDriver(), Duration.ofSeconds(DEFAULT_TIMEOUT));
	}

	public static void waitForVisibility(By Locator) {
		getWait().until(ExpectedConditions.visibilityOfElementLocated(Locator));
	}

	public static void waitForClickable(By Locator) {
		getWait().until(ExpectedConditions.elementToBeClickable(Locator));
	}

	public static void waitForPresence(By Locator) {
		getWait().until(ExpectedConditions.presenceOfElementLocated(Locator));
	}
}
