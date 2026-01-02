package com.ecomm.framework.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;

public class ElementUtil {

	private WebDriver driver;

	public ElementUtil(WebDriver driver) {
		this.driver = driver;
	}

	public void doClick(By locator) {
		WaitUtil.waitForClickable(locator);
		driver.findElement(locator).click();
	}

	public String doGetText(By locator) {
		WaitUtil.waitForVisibility(locator);
		return driver.findElement(locator).getText();
	}

	public void doSendKeys(By locator, String text) {
		WaitUtil.waitForVisibility(locator);
		driver.findElement(locator).clear();
		driver.findElement(locator).sendKeys(text);
	}

	public void doClickRetry(By locator, int retry) {
		int attempts = 0;
		while (attempts < retry) {
			try {
				WaitUtil.waitForVisibility(locator);
				driver.findElement(locator).click();
				//return;
			} catch(StaleElementReferenceException | ElementClickInterceptedException e) {
				attempts++;
			}
		}
		throw new RuntimeException("Failed to click element after retries: " + locator);
	}

	public Boolean isElementDisplayed(By locator) {
		WaitUtil.waitForPresence(locator);
		return driver.findElement(locator).isDisplayed();
	}

}
