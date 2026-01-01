package com.ecomm.framework.pages;

import org.openqa.selenium.WebDriver;

public class HomePage {

	private WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public boolean isHomePageLoaded()
	{
		return driver.getCurrentUrl().contains("inventory");
	}
	
}
