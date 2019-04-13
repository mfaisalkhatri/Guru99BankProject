package com.guru99.bankproject.pageactions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.guru99.bankproject.pages.LoginPage;
import com.guru99.bankproject.pages.MainPage;

/**
 * @author ADMIN
 *
 */
public class LoginPageActions {

	private WebDriver driver;
	private LoginPage loginPage;

	/**
	 * @param driver
	 */
	public LoginPageActions(WebDriver driver) {
		this.driver = driver;
		this.loginPage = new LoginPage(driver);

	}

	/**
	 * @param userName
	 * @param password
	 * @param isValid
	 */

	private void enterUserName(String userName) {
		loginPage.userId().clear();
		loginPage.userId().sendKeys(userName);
	}

	private void enterPassword(String password) {
		loginPage.password().clear();
		loginPage.password().sendKeys(password);
	}

	/**
	 * @param userName
	 * @param password
	 * @param isValid
	 */
	public void loginWebsite(String userName, String password, boolean isValid) {
		enterUserName(userName);
		enterPassword(password);
		loginPage.loginButton().click();

		if (isValid) {
			MainPage mainPage = new MainPage(driver);
			mainPage.marquee().isDisplayed();
			
		} else {
			String actualAlertText = driver.switchTo().alert().getText();
			String expectedAlertText = "User or Password is not valid";
			Assert.assertEquals(actualAlertText, expectedAlertText);

			driver.switchTo().alert().accept();

		}

	}

}
