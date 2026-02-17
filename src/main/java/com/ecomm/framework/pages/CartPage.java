package com.ecomm.framework.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ecomm.framework.utils.ElementUtil;

public class CartPage {

	private WebDriver driver;
	private ElementUtil elementUtil;

	private By cartItems = By.className("cart_item");
	private By checkoutBtn = By.id("checkout");
	private By continueShoppingBtn = By.id("continue-shopping");

	public CartPage(WebDriver driver) {
		this.driver = driver;
		this.elementUtil = new ElementUtil(driver);
	}

	public int getCartItemCount() {
		return driver.findElements(cartItems).size();
	}

	public boolean isProductInCart(String productName) {
		By producInCart = By.xpath("//div[@class='inventory_item_name' and normalize-space(.)='" + productName + "']");
		return elementUtil.isElementDisplayed(producInCart);
	}

	public boolean areProductsInCart(List<String> productNames) {
		for (String productName : productNames)
			if (!isProductInCart(productName)) {
				return false;
			}
		return true;
	}

	public void removeItemFromCart(String productName) {
		By removeProductFromCart = By
				.xpath("//div[normalize-space(.)='" + productName + "']/ancestor::div[@class='cart_item']//button");
		elementUtil.doClick(removeProductFromCart);
	}

	public boolean isCartEmpty() {
		return getCartItemCount() == 0;
	}

	public CheckoutStepOnePage goToCheckout() {
		elementUtil.doClick(checkoutBtn);
		return new CheckoutStepOnePage(driver);
	}

	public InventoryPage clickContineShopping() {
		elementUtil.doClick(continueShoppingBtn);
		return new InventoryPage(driver);
	}
}
