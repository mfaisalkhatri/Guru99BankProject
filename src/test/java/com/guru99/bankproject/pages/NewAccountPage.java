package com.guru99.bankproject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author Faisal Khatri
 *
 */
public class NewAccountPage {

	private WebDriver driver;

	/**
	 * @param driver
	 */
	public NewAccountPage(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * @return customerId Field
	 */
	public WebElement customerIdField() {
		return driver.findElement(By.name("cusid"));
	}

	/**
	 * @return account type field
	 */
	public WebElement accountTypeField() {
		return driver.findElement(By.name("selaccount"));
	}

	/**
	 * @return initial deposit field
	 */
	public WebElement initialDeposit() {
		return driver.findElement(By.name("inideposit"));
	}
	
	/**
	 * @return submit button
	 */
	public WebElement submitButton () {
		return driver.findElement(By.name("button2"));
	}

	
}
