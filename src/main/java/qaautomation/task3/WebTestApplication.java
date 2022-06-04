package qaautomation.task3;

import org.testng.Assert;
import org.testng.annotations.Test;

import qaautomation.pert4.utils.TestUtility;

public class WebTestApplication extends BaseWebTest{
	
	@Test
	public void Login() {
		LoginPage loginPage = new LoginPage(driver, explicitWait);
		CatalogPage catalogPage = new CatalogPage(driver, explicitWait);
		
		String username = "standard_user";
		String password = "secret_sauce";
		
		loginPage.inputUsername(username);
		loginPage.inputPassword(password);
		loginPage.clickLoginButton();
		
		String actualText = catalogPage.getCatalogText();
//		System.out.println("actualText "+actualText);
		String expectedText = "PRODUCTS";
		Assert.assertTrue(actualText.contains(expectedText));
//		TestUtility.hardWait(3);
	}
	
	
	@Test
	public void LoginFailed() {
		LoginPage loginPage = new LoginPage(driver, explicitWait);
		
		String username = "standard_user";
		String password = "xxxxxxxxxxxxx";
		
		loginPage.inputUsername(username);
		loginPage.inputPassword(password);
		loginPage.clickLoginButton();
		
		String actualMessageError = loginPage.getMessageError();
//		System.out.println("actualMessageError"+ actualMessageError);
		String expectedMessageText = "Username and password do not match any user in this service";
		Assert.assertTrue(actualMessageError.contains(expectedMessageText));
//		TestUtility.hardWait(3);
	}
	
	
	@Test
	public void FinishOrder() {
		LoginPage loginPage = new LoginPage(driver, explicitWait);
		CatalogPage catalogPage = new CatalogPage(driver, explicitWait);
		CartPage cartPage = new CartPage(driver, explicitWait);
		CheckoutPage checkoutPage = new CheckoutPage(driver, explicitWait);
		
		/******************** LOGIN ************************/
		String username = "standard_user";
		String password = "secret_sauce";
		loginPage.inputUsername(username);
		loginPage.inputPassword(password);
		loginPage.clickLoginButton();
		String actualText = catalogPage.getCatalogText();
		String expectedText = "PRODUCTS";
		Assert.assertTrue(actualText.contains(expectedText));
		
		/******************** CHOOSE & ADD CART ************************/
		catalogPage.clickAddCart();
		catalogPage.clickCart();
		String cartPageText = cartPage.getCartText();
		String expectedCartText = "YOUR CART";
		Assert.assertTrue(cartPageText.contains(expectedCartText));
		
		/******************** CHECKOUT & NEXT PAGE CHECKOUT ************************/
		cartPage.clickCheckout();
		String actualInformationText = checkoutPage.getInformationText();
//		System.out.println("actualInformationText "+actualInformationText);
		String expectedInformationText = "CHECKOUT: YOUR INFORMATION";
		Assert.assertTrue(actualInformationText.contains(expectedInformationText));
		
		/******************** CHECKOUT INFORMATION & OVERVIEW ************************/
		String firstName = "Athena";
		String lastName = "aile";
		String postalCode = "17426";
		checkoutPage.inputFirstName(firstName);
		checkoutPage.inputLastName(lastName);
		checkoutPage.inputPostalCode(postalCode);
		checkoutPage.clickContinueButton();
		String actualTextOverview = checkoutPage.getOverviewText();
//		System.out.println("actualTextOverview "+actualTextOverview);
		String expectedTextOverview = "CHECKOUT: OVERVIEW";
		Assert.assertTrue(actualTextOverview.contains(expectedTextOverview));
		
		/******************** DONE CHECKOUT ************************/		
		checkoutPage.clickFinishButton();
		String actualCompleteText = checkoutPage.getCompleteText();
//		System.out.println("actualCompleteText "+actualCompleteText);
		String expectedCompleteText = "THANK YOU FOR YOUR ORDER";
		Assert.assertTrue(actualCompleteText.contains(expectedCompleteText));
		
		TestUtility.hardWait(3);
	}

}
