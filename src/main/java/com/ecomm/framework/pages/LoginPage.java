package com.ecomm.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ecomm.framework.utils.ElementUtil;

public class LoginPage {

	private WebDriver driver;
	private ElementUtil elementUtil;

	private By usernameInput = By.id("user-name");
	private By passwordInput = By.id("password");
	private By loginButton = By.id("login-button");
	private By errorMessage = By.cssSelector("h3[data-test='error']");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		this.elementUtil = new ElementUtil(driver);
	}

	public void enterUsername(String username) {
		elementUtil.doSendKeys(usernameInput, username);
	}

	public void enterPassword(String password) {
		elementUtil.doSendKeys(passwordInput, password);
	}

	public InventoryPage clickLogin() {
		elementUtil.doClick(loginButton);
		return new InventoryPage(driver);
	}
	
	public boolean isLoginButtonDisplayed() {
		return elementUtil.isElementDisplayed(loginButton);
	}

	public InventoryPage doLogin(String username, String password) {
		elementUtil.doSendKeys(usernameInput, username);
		elementUtil.doSendKeys(passwordInput, password);
		elementUtil.doClick(loginButton);
		return new InventoryPage(driver);
	}

	public String getErrorMsg() {
		return elementUtil.doGetText(errorMessage);
	}

}
