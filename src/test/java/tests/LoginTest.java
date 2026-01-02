package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ecomm.framework.pages.InventoryPage;
import com.ecomm.framework.pages.LoginPage;

public class LoginTest extends BaseTest {

	@Test
	public void validLoginTest() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsername("standard_user");
		loginPage.enterPassword("secret_sauce");
		InventoryPage inventoryPage = loginPage.clickLogin();
		Assert.assertTrue(inventoryPage.isHomePageLoaded(), "Home Page not loaded after login");
	}

	@Test
	public void invalidLoginTest() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsername("wrong_user");
		loginPage.enterPassword("wrong_password");
		loginPage.clickLogin();
		String actualError = loginPage.getErrorMsg();
		Assert.assertTrue(actualError.contains("Username and password do not match"),
				"Expected error message not displayed");
	}
}
