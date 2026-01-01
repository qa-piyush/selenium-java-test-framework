package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ecomm.framework.pages.LoginPage;

import driver.DriverFactory;

public class LoginTest extends BaseTest {

	@Test
	public void validLoginTest() {
		WebDriver driver = DriverFactory.getDriver();
		driver.get("https://www.saucedemo.com/");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.Login("standard_user", "secret_sauce");
		String currentUrl = driver.getCurrentUrl();
		Assert.assertTrue(currentUrl.contains("inventory.html"), "Login Failed");
	}

	@Test
	public void invalidLoginTest() {
		WebDriver driver = DriverFactory.getDriver();
		driver.get("https://www.saucedemo.com/");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.Login("wrong_user", "wrong_password");
		String actualError = loginPage.getErrorMsg();
		Assert.assertTrue(actualError.contains("sername and password do not match"),
				"Expected error message not displayed");
	}
}
