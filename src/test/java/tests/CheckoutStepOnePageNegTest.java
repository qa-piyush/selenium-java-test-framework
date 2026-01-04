package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ecomm.framework.pages.CheckoutStepOnePage;

import flows.CheckoutFlow;

public class CheckoutStepOnePageNegTest extends BaseTest {

	@Test(dataProvider = "negativeCheckoutData")
	public void checkoutFlowErrorMsgValidation(
			String firstName,
			String lastName,
			String postalCode,
			String errorMessage) {
		CheckoutFlow checkoutFlow = new CheckoutFlow(driver);
		CheckoutStepOnePage checkoutStepOnePage = checkoutFlow.loginAndGoToCheckoutStepOnePage("Sauce Labs Backpack");

		checkoutStepOnePage.enterCheckoutInformation(firstName, lastName, postalCode);
		checkoutStepOnePage.submitCheckoutForm();

		Assert.assertTrue(checkoutStepOnePage.getErrorMsg().contains(errorMessage),
				"Expected First Name is not displayed");
	}

	@DataProvider
	public Object[][] negativeCheckoutData() {
		return new Object[][] { 
			    { "", "Sharma", "400002", "First Name is required" },
				{ "Manish", "", "400012", "Last Name is required" },
				{ "Manish", "Sharma", "", "Postal Code is required" } };
	}
}
