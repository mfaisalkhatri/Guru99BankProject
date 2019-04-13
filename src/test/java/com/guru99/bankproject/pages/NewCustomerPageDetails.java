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
public class NewCustomerPageDetails extends MainPage {
	
	/**
	 * @param driver
	 */
	public NewCustomerPageDetails(WebDriver driver) {
		super(driver);
	}

	/**
	 * @return registeredCustomerTable
	 */
	public WebElement registeredCustomerTable () {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		return wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("#regmsg"))));
	}
	
	/**
	 * @return Customer Page Heading
	 */
	public WebElement getCustomerPageHeading() {
		return registeredCustomerTable().findElement(By.cssSelector("#customer > tbody > tr:nth-child(1) > td > p"));
	}

	/**
	 * @return CustomerID
	 * 
	 */
	public WebElement getcustomerIdRow () {
		return registeredCustomerTable().findElement(By.cssSelector("#customer > tbody > tr:nth-child(4) > td:nth-child(2)"));
	}

	/**
	 * @return Customer Name
	 */
	public WebElement getCustomerName() {
		return registeredCustomerTable().findElement(By.cssSelector("#customer > tbody > tr:nth-child(5) > td:nth-child(2)"));
	}
	

}
