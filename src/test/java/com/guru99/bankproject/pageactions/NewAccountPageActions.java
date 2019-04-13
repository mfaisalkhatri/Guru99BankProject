package com.guru99.bankproject.pageactions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.guru99.bankproject.pages.MainPage;
import com.guru99.bankproject.pages.NewAccountDetailsPage;
import com.guru99.bankproject.pages.NewAccountPage;

/**
 * @author ADMIN
 *
 */
public class NewAccountPageActions {

	private WebDriver driver;
	private MainPage mainPage;
	private NewAccountPage newAccountPage;
	private NewAccountDetailsPage newAccountPageDetails;
	private String getAccountId;
	
	/**
	 * @param driver
	 */
	public NewAccountPageActions(WebDriver driver) {
		this.driver = driver;
		this.mainPage = new MainPage(driver);
		this.newAccountPage = new NewAccountPage(driver);
		this.newAccountPageDetails = new NewAccountDetailsPage(driver);
	}

	
	private void clickNewAccountMenu() {
		mainPage.menu("New Account").click();
	}

	private void entercustomerId(String customerId) {
		newAccountPage.customerIdField().sendKeys(customerId);
	}

	private void selectAccountType(String accType) {
		Select select = new Select(newAccountPage.accountTypeField());
		select.selectByValue(accType);
	}

	private void enterInitialDeposit(String depositAmt) {
		newAccountPage.initialDeposit().sendKeys(depositAmt);
	}

	private void clickSubmitButton() {
		newAccountPage.submitButton().click();
	}
	
	private void saveAccountId() { 
		this.getAccountId = newAccountPageDetails.getAccountIdFromRow().getText();
	}
	
	private void verifyAccountGeneratedSuccessfully() {
		String actualSuccessMsg = newAccountPageDetails.getAccountPageHeading().getText();
		Assert.assertEquals(actualSuccessMsg, "Account Generated Successfully!!!");
	}
	
	/**
	 * @return Account Id
	 */
	public String accountId() {
		return this.accountId();
	}
	/**
	 * @param customerId 
	 * @param accType
	 * @param depositAmt
	 */
	public void createNewAccount(String customerId, String accType, String depositAmt) {
		clickNewAccountMenu();
		entercustomerId(customerId);
		selectAccountType(accType);
		enterInitialDeposit(depositAmt);
		clickSubmitButton();
		verifyAccountGeneratedSuccessfully();
		saveAccountId();
	}
}