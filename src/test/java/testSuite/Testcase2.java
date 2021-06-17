package testSuite;

import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Testcase2 {
	private static WebDriver driver;

	@Test
	public static void method() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\sarpoova\\Downloads\\softwares\\chromedriver_win32\\chromedriver.exe");

		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");

		driver.navigate().to("http://www.google.com");

		
		driver.quit();
		
		//Assert.assertFalse(true);

	}

}