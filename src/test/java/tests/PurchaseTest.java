package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ecomm.framework.pages.CartPage;
import com.ecomm.framework.pages.CheckoutCompletePage;
import com.ecomm.framework.pages.CheckoutStepOnePage;
import com.ecomm.framework.pages.CheckoutStepTwoPage;
import com.ecomm.framework.pages.InventoryPage;
import com.ecomm.framework.pages.LoginPage;

@Test
public class PurchaseTest extends BaseTest {

	public void endToEndPurchaseTest() {
		String productName = "Sauce Labs Backpack";

		LoginPage loginPage = new LoginPage(driver);
		InventoryPage inventoryPage = loginPage.doLogin("standard_user", "secret_sauce");

		Assert.assertTrue(inventoryPage.getInventoryCount() > 0, "Inventory page didn't load properly");

		inventoryPage.addProductToCart(productName);
		CartPage cartPage = inventoryPage.goToCart();

		Assert.assertTrue(cartPage.isProductInCart(productName), "Product is not present in cart");

		CheckoutStepOnePage checkoutStepOnePage = cartPage.goToCheckout();
		checkoutStepOnePage.enterCheckoutInformation("Aman", "Sharma", "400001");

		CheckoutStepTwoPage checkoutStepTwoPage = checkoutStepOnePage.submitCheckoutForm();
		Assert.assertTrue(checkoutStepTwoPage.isProductPresent(productName),
				"Product is not present in checkout step two page");

		CheckoutCompletePage checkoutCompletePage = checkoutStepTwoPage.clickFinish();
		Assert.assertEquals(checkoutCompletePage.getSuccessMsg(), "Thank you for your order!",
				"Mismatch is success message");
	}
}
