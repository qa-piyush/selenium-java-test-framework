package com.ecomm.framework.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;

import exeptions.FrameworkException;

public class ElementUtil {

	private WebDriver driver;

	public ElementUtil(WebDriver driver) {
		this.driver = driver;
	}

	public void doClick(By locator) {
		try {
			WaitUtil.waitForClickable(locator);
			driver.findElement(locator).click();
		} catch (Exception e) {
			throw new FrameworkException("Unable to click element " + locator, e);
		}
	}

	public String doGetText(By locator) {
		try {
			WaitUtil.waitForVisibility(locator);
			return driver.findElement(locator).getText();
		} catch (Exception e) {
			throw new FrameworkException("Unable to get text from element " + locator, e);
		}
	}

	public void doSendKeys(By locator, String text) {
		try {
			WaitUtil.waitForVisibility(locator);
			driver.findElement(locator).clear();
			driver.findElement(locator).sendKeys(text);
		} catch (Exception e) {
			throw new FrameworkException
			("Unable to send keys to the element " + locator + "and send keys" + text, e);
		}
	}

	public void doClickRetry(By locator, int retry) {
		int attempts = 0;
		while (attempts < retry) {
			try {
				WaitUtil.waitForVisibility(locator);
				driver.findElement(locator).click();
				return;
			} catch (StaleElementReferenceException | ElementClickInterceptedException e) {
				attempts++;
			}
		}
		throw new FrameworkException
		("Failed to click element after retries: " + locator + "after" + retry + "retries");
	}

	public Boolean isElementDisplayed(By locator) {
		try {
			WaitUtil.waitForPresence(locator);
			return driver.findElement(locator).isDisplayed();
		} catch (Exception e) {
			throw new FrameworkException("Elment is not visible within timeout: " + locator, e);
		}
	}
}
