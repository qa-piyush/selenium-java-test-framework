package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ecomm.framework.pages.CartPage;
import com.ecomm.framework.pages.InventoryPage;
import com.ecomm.framework.pages.LoginPage;

public class CartTest extends BaseTest {

	@Test
	public void shouldAddAndRemoveItemFromCart() {
		String productName = "Sauce Labs Backpack";
		LoginPage loginPage = new LoginPage(driver);
		InventoryPage inventoryPage = loginPage.doLogin(
				prop.getProperty("username"), prop.getProperty("password"));
		inventoryPage.addProductToCart(productName);
		Assert.assertEquals(inventoryPage.getCartItemCount(), "1");
		CartPage cartPage = inventoryPage.goToCart();

		Assert.assertTrue(cartPage.isProductInCart(productName), " " + productName + " is not present in cart");
		cartPage.removeItemFromCart(productName);
		Assert.assertTrue(cartPage.isCartEmpty(), "Cart is not empty");
	}
}
