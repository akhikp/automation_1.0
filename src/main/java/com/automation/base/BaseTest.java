package com.automation.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automation.utils.WaitTimeUtils;

public class BaseTest {
	protected static WebDriver driver;
	public WebDriverWait wait;
	static Properties prop;

	// Constructor
	public BaseTest() {

		prop = new Properties();
		FileInputStream fip;
		try {
			fip = new FileInputStream("src\\main\\java\\com\\automation\\config\\config.properties");
			prop.load(fip);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void initialization() {
		String browserType = prop.getProperty("browser");
		if (browserType.equalsIgnoreCase("chrome")) 
		{
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\sarpoova\\Downloads\\softwares\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(WaitTimeUtils.LONG_WAIT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(WaitTimeUtils.LONG_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));

	}

	public void scrolltoview(WebElement ele) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)", ele);
	}

	// Click Method
	public void click(By elementLocation) {
		waitVisibility(elementLocation);
		driver.findElement(elementLocation).click();
	}

	// Write Text
	public void writeText(By elementLocation, String text) {
		waitVisibility(elementLocation);
		driver.findElement(elementLocation).sendKeys(text);
	}

	// Read Text
	public String readText(By elementLocation) {
		waitVisibility(elementLocation);
		return driver.findElement(elementLocation).getText();
	}

	// Wait
	public void waitVisibility(By by) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}
}