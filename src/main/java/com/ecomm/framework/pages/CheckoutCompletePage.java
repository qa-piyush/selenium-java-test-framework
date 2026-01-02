package com.ecomm.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ecomm.framework.utils.ElementUtil;

public class CheckoutCompletePage {

	private WebDriver driver;
	private ElementUtil elementUtil;

	private By confirmationMsg = By.className("complete-header");
	private By backToInventoryBtn = By.id("back-to-products");

	public CheckoutCompletePage(WebDriver driver) {
		this.driver = driver;
		this.elementUtil = new ElementUtil(driver);
	}

	public String getSuccessMsg() {
		return elementUtil.doGetText(confirmationMsg);
	}

	public InventoryPage goBackToInventory() {
		elementUtil.doClick(backToInventoryBtn);
		return new InventoryPage(driver);
	}
}
