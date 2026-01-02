package com.ecomm.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ecomm.framework.utils.ElementUtil;

public class CheckoutStepOnePage {

	private WebDriver driver;
	private ElementUtil elementUtil;

	public CheckoutStepOnePage(WebDriver driver) {
		this.driver = driver;
		this.elementUtil = new ElementUtil(driver);
	}

	private By firstName = By.id("first-name");
	private By lastName = By.id("last-name");
	private By postalCode = By.id("postal-code");
	private By continueBtn = By.id("continue");
	private By cancelBtn = By.id("cancel");

	public void enterCheckoutInformation(String fName, String lName, String zip) {
		elementUtil.doSendKeys(firstName, fName);
		elementUtil.doSendKeys(lastName, lName);
		elementUtil.doSendKeys(postalCode, zip);
	}

	public CheckoutStepTwoPage clickContinue() {
		elementUtil.doClick(continueBtn);
		return new CheckoutStepTwoPage(driver);
	}

	public CartPage clickCancel() {
		elementUtil.doClick(cancelBtn);
		return new CartPage(driver);
	}
}
