package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ecomm.framework.pages.InventoryPage;
import com.ecomm.framework.pages.LoginPage;

public class LogoutTest extends BaseTest {

	@Test
	public void doLogoutSuccessful() {
		LoginPage loginPage = new LoginPage(driver);
		InventoryPage inventoryPage = 
				loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		
		inventoryPage.doOpenMenu();
		LoginPage loggedOutPage = inventoryPage.doLogout();

		Assert.assertTrue(loggedOutPage.isLoginButtonDisplayed(),
				"Login button is not displayed");
	}
	@Test
	public void checkSessionGuard() {
		LoginPage loginPage = new LoginPage(driver);
		InventoryPage inventoryPage = 
				loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		
		inventoryPage.doOpenMenu();
		LoginPage loggedOutPage = inventoryPage.doLogout();
		driver.get(prop.getProperty("url")+"//inventory.html");
		Assert.assertTrue(loggedOutPage.isLoginButtonDisplayed(), "User is still on login page");
	}

}
