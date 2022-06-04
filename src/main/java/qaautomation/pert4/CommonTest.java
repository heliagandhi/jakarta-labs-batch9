package qaautomation.pert4;

import org.testng.annotations.Test;

import qaautomation.pert4.pages.CommonPage;
import qaautomation.pert4.utils.TestUtility;

public class CommonTest extends BaseWebTest {
	
	CommonPage commonPage = new CommonPage(driver, explicitWait);

	@Test
	public void testSwitching() {
		commonPage.openNewTab();
		commonPage.switchWindow(1);
		commonPage.openUrl("https://facebook.com");
		commonPage.openNewWindow();
		commonPage.switchWindow(2);
		commonPage.openUrl("https://twitter.com");
		TestUtility.hardWait(3);
	}
}
