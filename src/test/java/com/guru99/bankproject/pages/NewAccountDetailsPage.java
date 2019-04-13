package com.guru99.bankproject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Faisal Khatri
 *
 */
public class NewAccountDetailsPage extends MainPage {


	/**
	 * @param driver
	 */
	public NewAccountDetailsPage(WebDriver driver) {
		super (driver);
	}
	
	/**
	 * @return Account Generated Table
	 */
	public WebElement accountTable () {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		return wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("#Accmsg"))));
	}
	
	/**
	 * @return Account Page Heading
	 */
	public WebElement getAccountPageHeading() {
		return accountTable().findElement(By.cssSelector("#account > tbody > tr:nth-child(1) > td > p"));
	}

	/**
	 * @return Account Id
	 * 
	 */
	public WebElement getAccountIdFromRow () {
		return accountTable().findElement(By.cssSelector("#account > tbody > tr:nth-child(4) > td:nth-child(2)"));
	}

		
}
