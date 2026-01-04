package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ecomm.framework.pages.InventoryPage;
import com.ecomm.framework.pages.LoginPage;

public class LoginTest extends BaseTest {
	
	@Test
	public void validLoginTest() {
		LoginPage loginPage = new LoginPage(driver);
		InventoryPage inventoryPage = loginPage.doLogin(
				prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertTrue(inventoryPage.isHomePageLoaded(),
				"Home Page not loaded after login");
	}

	@Test(dataProvider = "invalidLoginData")
	public void invalidLoginTest(
		String username, String password, String expectedErrorMessage) {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.clickLogin();
		
		Assert.assertTrue(loginPage.getErrorMsg().contains(expectedErrorMessage),
				"expectedErrorMessage");
	}

	@DataProvider
	public Object[][] invalidLoginData(){
		return new Object[][]{
		{"standard_user","wrong_password","Epic sadface"},
		{"locked_out_user","secret_sauce","Epic sadface"},
		{"wrong_user","secret_sauce","Epic sadface"}
	};
	}
}

