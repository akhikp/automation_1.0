package testSuite;

import org.testng.annotations.Test;

import com.automation.base.BaseTest;
import com.automation.pages.HomePage;
import com.automation.pages.LoginPage;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

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
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Testcase1 extends BaseTest {
	LoginPage lp;
	HomePage hp;

	public Testcase1() {
		super();
	}

	@BeforeMethod
	void setup() {
		initialization();
		lp = new LoginPage();
	}

	@AfterMethod
	void teardown() {
		driver.quit();
	}

	@Test
	public void method() throws InterruptedException {

		String actualTitle = lp.validatePageTitle();
		lp.scrolltoview(lp.getEle());

		lp.getEmail().click();

		Random rand = new Random();
		int rand_int1 = rand.nextInt(10009);
		lp.getEmail().sendKeys("mailme" + rand_int1 + "@gmail.com");

		// ((JavascriptExecutor)
		// driver).executeScript("document.body.style.zoom='80%';");

		WebDriverWait wait = new WebDriverWait(driver, 8);

		wait.until(ExpectedConditions.elementToBeClickable(lp.getSubmitBtn()));
		lp.clickSubmitBtn();

		/*
		 * WebElement element = wait
		 * .until(ExpectedConditions.presenceOfElementLocated(By.xpath(
		 * "//*[@id=\"noSlide\"]/h1"))); ((JavascriptExecutor)
		 * driver).executeScript("arguments[0].scrollIntoView(true)", element);
		 * wait.until(ExpectedConditions.stalenessOf(element));
		 * 
		 * String title =
		 * driver.findElement(By.xpath("//*[@id=\"noSlide\"]/h1")).getText().toString();
		 * System.out.println("Title: " + title);
		 * 
		 * File fileDummy = new File(title);
		 * 
		 * try {
		 * 
		 * if (!fileDummy.exists()) fileDummy.createNewFile();
		 * 
		 * if (fileDummy.exists()) System.out.println("File is existing");
		 * 
		 * } catch (IOException e) {
		 * 
		 * e.printStackTrace(); }
		 */

	}

}