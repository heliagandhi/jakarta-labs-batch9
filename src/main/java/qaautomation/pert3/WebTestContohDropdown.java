package qaautomation.pert3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTestContohDropdown {
	@Test
	public void testLogin() {
		WebDriver driver;

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://the-internet.herokuapp.com/dropdown");
		// cara mendapatkan username dengan xpath
		driver.findElement(By.id("dropdown")).click();
	}
}
