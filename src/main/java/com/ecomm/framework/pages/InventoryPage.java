package com.ecomm.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ecomm.framework.utils.ElementUtil;

public class InventoryPage {

	private WebDriver driver;
	private ElementUtil elementUtil;

	private By inventoryItems = By.className("inventory_item");
	private By cartIcon = By.className("shopping_cart_link");

	public InventoryPage(WebDriver driver) {
		this.driver = driver;
		this.elementUtil = new ElementUtil(driver);
	}

	public boolean isHomePageLoaded() {
		return driver.getCurrentUrl().contains("inventory");
	}

	public int getInventoryCount() {
		return driver.findElements(inventoryItems).size();
	}

	public void addProductToCart(String productName) {
		By addToCartBtn = By.xpath(
				"//div[normalize-space()='" + productName + "']" + "/ancestor::div[@class='inventory_item']//button");
		elementUtil.doClick(addToCartBtn);
	}

	public CartPage goToCart() {
		elementUtil.doClick(cartIcon);
		return new CartPage(driver);
	}

}
