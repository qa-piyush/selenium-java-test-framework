package flows;

import org.openqa.selenium.WebDriver;

import com.ecomm.framework.pages.CartPage;
import com.ecomm.framework.pages.CheckoutStepOnePage;
import com.ecomm.framework.pages.InventoryPage;
import com.ecomm.framework.pages.LoginPage;

public class CheckoutFlow {

	private WebDriver driver;

	public CheckoutFlow(WebDriver driver) {
		this.driver = driver;
	}

	public CheckoutStepOnePage loginAndGoToCheckoutStepOnePage(String productName) {
		LoginPage loginPage = new LoginPage(driver);

		InventoryPage inventoryPage = loginPage.doLogin("standard_user", "secret_sauce");
		inventoryPage.addProductToCart(productName);
		CartPage cartPage = inventoryPage.goToCart();

		return cartPage.goToCheckout();
	}
}
