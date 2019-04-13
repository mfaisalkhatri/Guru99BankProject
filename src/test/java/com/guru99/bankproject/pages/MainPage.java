package com.guru99.bankproject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author Faisal Khatri
 *
 */
public class MainPage {

	public WebDriver driver;
	
	
	/**
	 * @param driver
	 */
	public MainPage(WebDriver driver) {
		this.driver = driver;
	}
	
	/**
	 * @return mainPageTitle
	 */
	public WebElement mainPageTitle () {
		return driver.findElement(By.cssSelector("div > h2.barone"));
	}
	
	/**
	 * @param menuName
	 * @return action
	 */
	public WebElement menu(String menuName) {
		return driver.findElement(By.linkText(menuName));
	}
	
	
		/**
	 * @return marquee
	 */
	public WebElement marquee() {
		return driver.findElement(By.cssSelector("body > table > tbody > tr > td > table > tbody > tr:nth-child(2) > td > marquee"));
		
	}
	
	
	
}
