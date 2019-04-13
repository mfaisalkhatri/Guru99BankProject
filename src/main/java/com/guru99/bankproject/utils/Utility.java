package com.guru99.bankproject.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author ADMIN
 *
 */
public class Utility {

	private WebDriver driver;
	private static WebElement element;
	
	/**
	 * @param driver
	 */
	public Utility(WebDriver driver) {
		this.driver = driver;
	}
	 
	
	/**
	 * @return 
	 * @return 
	 * 
	 */
	public Utility enterText (String text) {		
		element.click();
		element.clear();
		element.sendKeys(text);
		return this;
	}
}
