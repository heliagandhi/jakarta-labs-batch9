package qaautomation.task3;//01:56:29

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseWebTest {
//	ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
//	ThreadLocal<WebDriverWait> explicitWait = new ThreadLocal<WebDriverWait>();
//
//	@BeforeMethod
//	public void openUrl() {
//
//		WebDriverManager.chromedriver().setup();
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--headless", "--disable-gpu", "--windows-size=1920,1200");
//		driver.set(new ChromeDriver(options));
//		explicitWait.set(new WebDriverWait(driver.get(), Duration.ofSeconds(60)));
//		driver.get().manage().window().maximize();
//		driver.get().get("https://www.saucedemo.com/");
//
//	}
//
//	@AfterMethod
//	public void close() {
//
//		driver.get().quit();
//
//	}
	
	ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	ThreadLocal<WebDriverWait> explicitWait = new ThreadLocal<WebDriverWait>();

	@BeforeMethod
	public void openUrl() {

		WebDriverManager.chromedriver().setup();
		driver.set(new ChromeDriver());
		explicitWait.set(new WebDriverWait(driver.get(), Duration.ofSeconds(60)));
		driver.get().manage().window().maximize();
		driver.get().get("https://www.saucedemo.com/");

	}

	@AfterMethod
	public void close() {

		driver.get().quit();

	}

}
