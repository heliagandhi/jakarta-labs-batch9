package qaautomation.pert4;

import org.testng.Assert;
import org.testng.annotations.Test;

import qaautomation.pert4.pages.LoginPageFactory;
import qaautomation.pert4.pages.ProfilePageFactory;

public class WebTestPagesFactory extends BaseWebTest {
	
	@Test
	public void testLogin() {
		// cara mendapatkan username dengan xpath

		LoginPageFactory loginPage = new LoginPageFactory(driver, explicitWait);
		ProfilePageFactory profilePage = new ProfilePageFactory(driver, explicitWait);
		String username = "tomsmith";
		String password = "SuperSecretPassword!";

		loginPage.inputUsername(username);
		loginPage.inputPassword(password);
		loginPage.clickLoginButton();
		String actualText = profilePage.getProfileText();
		String expectedText = "You logged into a secure area!";

		Assert.assertTrue(actualText.contains(expectedText));
	}
}

