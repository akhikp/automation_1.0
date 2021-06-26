package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.automation.base.BaseTest;

public class LoginPage extends BaseTest {

	@FindBy(id = "newsletter-input")
	WebElement ele;

	@FindBy(id = "email_create")
	WebElement email;

	@FindBy(id = "SubmitCreate")
	WebElement submitbtn;

	@FindBy(xpath = "//*[@id='noSlide']/h1")
	@CacheLookup
	WebElement sectionHeaderLabel;

	// init
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	// getter setter

	public WebElement getEle() {
		return ele;
	}

	public WebElement getSectionHeaderLabel() {
		return sectionHeaderLabel;
	}

	public WebElement getEmail() {
		return email;
	}
	
	public WebElement getSubmitBtn() {
		return submitbtn;
	}

	// actions
	public String validatePageTitle() {
		return driver.getTitle();
	}

	public void enterEmail(String emailid) {
		email.sendKeys(emailid);
	}

	public HomePage clickSubmitBtn() {
		submitbtn.click();
		scrolltoview(sectionHeaderLabel);
		
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.stalenessOf(sectionHeaderLabel));
		
		return new HomePage();
	}

}