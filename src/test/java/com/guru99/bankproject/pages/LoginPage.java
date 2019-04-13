package com.guru99.bankproject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author Faisal
 *
 */
public class LoginPage {

	private WebDriver driver;

	/**
	 * @param driver
	 */
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	/**
	 * @return loginForm
	 */
	public WebElement loginForm() {
		WebElement mainloginForm = driver.findElement(By.name("frmLogin"));
		return mainloginForm;
	}

	/**
	 * @return userId
	 */
	public WebElement userId() {
		
		WebElement userIdField = loginForm().findElement(By.name("uid"));
		return userIdField;
	}

	/**
	 * @return password
	 */
	public WebElement password() {
		WebElement passwordField = loginForm().findElement(By.name("password"));
		return passwordField;
	}

	/**
	 * @return
	 */
	public WebElement loginButton() {
		WebElement loginBtn = loginForm().findElement(By.name("btnLogin"));
		return loginBtn;
	}

	/**
	 * @return resetButton
	 */
	public WebElement resetButton() {
		WebElement resetBtn = loginForm().findElement(By.name("btnReset"));
		return resetBtn;

	}
	
	
}
