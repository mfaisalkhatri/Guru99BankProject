package com.guru99.bankproject.pageactions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.guru99.bankproject.pages.MainPage;

/**
 * @author ADMIN
 *
 */
public class MainPageActions {

	private WebDriver driver;
	private MainPage mainPage;
	
	/**
	 * @param driver
	 */
	public MainPageActions(WebDriver driver) {
		this.driver = driver;
	}
	
	/**
	 * 
	 */
	public void getMainPageTitle() {
		String actualMainPageTitle = mainPage.mainPageTitle().getText();
		String expectedmainPageTitle = "Guru99 Bank";
		Assert.assertEquals(actualMainPageTitle, expectedmainPageTitle);
	}
}
