package com.ecomm.framework.utils;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import driver.DriverFactory;
import exeptions.FrameworkException;

public class WaitUtil {

	public static final int DEFAULT_TIMEOUT = 10;

	private static WebDriver getDriver() {
		return DriverFactory.getDriver();
	}

	private static WebDriverWait getWait() {
		return new WebDriverWait(getDriver(), Duration.ofSeconds(DEFAULT_TIMEOUT));
	}

	public static void waitForVisibility(By locator) {
		try {
			getWait().until(ExpectedConditions.visibilityOfElementLocated(locator));
		} catch (Exception e) {
			throw new FrameworkException("Unable to click element " + locator, e);
		}
	}

	public static void waitForClickable(By locator) {
		try {
			getWait().until(ExpectedConditions.elementToBeClickable(locator));
		} catch (Exception e) {
			throw new FrameworkException("Unable to click element " + locator, e);
		}
	}

	public static void waitForPresence(By locator) {
		try {
			getWait().until(ExpectedConditions.presenceOfElementLocated(locator));
		} catch (Exception e) {
			throw new FrameworkException("Unable to click element " + locator, e);
		}
	}

	public static void waitForInvisibility(By locator) {
		try {
			getWait().until(ExpectedConditions.invisibilityOfElementLocated(locator));
		} catch (Exception e) {
			throw new FrameworkException("Element not visible within timeout: " + locator, e);
		}
	}
}
