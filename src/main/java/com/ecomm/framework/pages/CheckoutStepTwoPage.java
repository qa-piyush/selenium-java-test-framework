package com.ecomm.framework.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ecomm.framework.utils.ElementUtil;

public class CheckoutStepTwoPage {

	private WebDriver driver;
	private ElementUtil elementUtil;

	private By finishBtn = By.id("finish");
	private By totalPrice = By.className("summary_total_label");

	public CheckoutStepTwoPage(WebDriver driver) {
		this.driver = driver;
		this.elementUtil = new ElementUtil(driver);
	}

	public boolean isProductPresent(String productName) {
		By productNamePresent = By
				.xpath("//div[@class='inventory_item_name' and normalize-space(.)='" + productName + "']");
		return elementUtil.isElementDisplayed(productNamePresent);
	}
	
	public boolean areProductsPresent(List<String> productNames) {
		for(String productName : productNames )
			if(!isProductPresent(productName)) {
				return false;
			}
		return true;
	}

	public String geTotalPrice() {
		return elementUtil.doGetText(totalPrice);
	}

	public CheckoutCompletePage clickFinish() {
		elementUtil.doClick(finishBtn);
		return new CheckoutCompletePage(driver);
	}
}
