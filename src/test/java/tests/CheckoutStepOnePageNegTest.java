package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ecomm.framework.pages.CheckoutStepOnePage;

import flows.CheckoutFlow;

public class CheckoutStepOnePageNegTest extends BaseTest {

	@Test
	public void checkoutWithoutFirstName() {
		CheckoutFlow checkoutFlow = new CheckoutFlow(driver);
		CheckoutStepOnePage checkoutStepOnePage = checkoutFlow.loginAndGoToCheckoutStepOnePage("Sauce Labs Backpack");

		checkoutStepOnePage.enterCheckoutInformation("", "juhyg", "400002");
		checkoutStepOnePage.clickContinue();

		Assert.assertTrue(checkoutStepOnePage.getErrorMsg().contains("First Name is required"),
				"Expected First Name is not displayed");
	}

	@Test
	public void checkoutWithoutLastName() {
		CheckoutFlow checkoutFlow = new CheckoutFlow(driver);
		CheckoutStepOnePage checkoutStepOnePage = checkoutFlow.loginAndGoToCheckoutStepOnePage("Sauce Labs Backpack");

		checkoutStepOnePage.enterCheckoutInformation("hygf", "", "400002");
		checkoutStepOnePage.clickContinue();

		Assert.assertTrue(checkoutStepOnePage.getErrorMsg().contains("Last Name is required"),
				"Expected Last Name is not displayed");
	}

	@Test
	public void checkoutWithoutPostalCode() {
		CheckoutFlow checkoutFlow = new CheckoutFlow(driver);
		CheckoutStepOnePage checkoutStepOnePage = checkoutFlow.loginAndGoToCheckoutStepOnePage("Sauce Labs Backpack");

		checkoutStepOnePage.enterCheckoutInformation("hygf", "jhgug", "");
		checkoutStepOnePage.clickContinue();

		Assert.assertTrue(checkoutStepOnePage.getErrorMsg().contains("Postal Code is required"),
				"Expected Postal Code is not displayed");
	}
}
