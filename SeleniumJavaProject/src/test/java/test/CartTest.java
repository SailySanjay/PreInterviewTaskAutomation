package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import pages.CartPage;

public class CartTest {	
	WebDriver driver;
	CartPage page;
	@BeforeTest
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
		driver.manage().window().maximize();
		page = new CartPage(driver);
	}
	
	@Test
	public void validateShopCart() {
		Assert.assertTrue(page.validateCart(driver));
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
		driver.quit();
	}

}
