package testSuite;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
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


public class Testcase1 {
	private static WebDriver driver;

	@BeforeClass
	void setupClass(){
		//
	}
	
	@Test
	public static void method() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\sarpoova\\Downloads\\softwares\\chromedriver_win32\\chromedriver.exe");

		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");

		// driver.navigate().to("http://automationpractice.com/index.php?id_category=3&controller=category");

		WebElement ele = driver.findElement(By.xpath("//*[@id=\"newsletter-input\"]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)", ele);

		WebElement email = driver.findElement(By.id("email_create"));
		email.click();

		Random rand = new Random();
		int rand_int1 = rand.nextInt(10009);
		email.sendKeys("tester" + rand_int1 + "@gmail.com");

		/*
		 * WebElement pwd = driver.findElement(By.xpath("//*[@id='passwd']"));
		 * pwd.click(); pwd.sendKeys("qwery123");
		 */

		/*
		 * Actions act = new Actions(driver); act.moveByOffset(10, 100);
		 * act.moveToElement(email);
		 */
		((JavascriptExecutor) driver).executeScript("document.body.style.zoom='80%';");

		WebDriverWait wait = new WebDriverWait(driver, 8);
		WebElement submitbtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("SubmitCreate")));
		submitbtn.submit();

		WebElement element = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"noSlide\"]/h1")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)", element);
		wait.until(ExpectedConditions.stalenessOf(element));

		String title = driver.findElement(By.xpath("//*[@id=\"noSlide\"]/h1")).getText().toString();
		System.out.println("Title: " + title);

		File fileDummy = new File(title);

		try {

			if (!fileDummy.exists())
				fileDummy.createNewFile();

			if (fileDummy.exists())
				System.out.println("File is existing");

		} catch (IOException e) {

			e.printStackTrace();
		}

		driver.quit();

	}

}