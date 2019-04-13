package com.guru99.bankproject.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author Faisal Khatri
 *
 */
public class NewCustomerPage {

	private WebDriver driver;
	private MainPage mainPage;

	/**
	 * @param driver
	 */
	public NewCustomerPage(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * @return customerPage
	 */
	public WebElement customerPage() {
		return driver.findElement(By.cssSelector(".layout"));
	}

	/**
	 * @return customer name
	 */
	public WebElement customerNameField() {
		return customerPage().findElement(By.name("name"));
	}

	/**
	 * @param gender 
	 * @param index 
	 * @return gender field
	 */
	public WebElement genderField(String gender) {
		List<WebElement> genderFieldElements = customerPage().findElements(By.name("rad1"));
		
		if(gender.equals("male")) {
		return genderFieldElements.get(0);
		}
		
		return genderFieldElements.get(1);
	}

	/**
	 * @return date of birth field
	 */
	public WebElement dateOfBirthField() {
		return customerPage().findElement(By.id("dob"));
	}

	/**
	 * @return address field
	 */
	public WebElement addressField() {
		return customerPage().findElement(By.name("addr"));

	}

	/**
	 * @return city field
	 */
	public WebElement cityField() {
		return customerPage().findElement(By.name("city"));
	}
	
	
	/**
	 * @return state field
	 */
	public WebElement stateField() {
		return customerPage().findElement(By.name("state"));
	}
	
	/**
	 * @return state field
	 */
	public WebElement pinNoField() {
		return customerPage().findElement(By.name("pinno"));
	}

	/**
	 * @return mobile number field
	 */
	public WebElement mobNoField() {
		return customerPage().findElement(By.name("telephoneno"));
	}
	
	/**
	 * @return email field
	 */
	public WebElement emailIdField() {
		return customerPage().findElement(By.name("emailid"));
	}
	
	/**
	 * @return email field
	 */
	public WebElement passwordField() {
		return customerPage().findElement(By.name("password"));
	}
	
	/**
	 * @return submit button
	 */
	public WebElement submitButton() {
		return customerPage().findElement(By.name("sub"));
	}
	
		
}
