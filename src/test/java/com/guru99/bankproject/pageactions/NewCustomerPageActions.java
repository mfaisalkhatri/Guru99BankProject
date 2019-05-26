package com.guru99.bankproject.pageactions;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.guru99.bankproject.pages.MainPage;
import com.guru99.bankproject.pages.NewCustomerPage;
import com.guru99.bankproject.pages.NewCustomerPageDetails;

/**
 * @author Faisal Khatri
 *
 */
public class NewCustomerPageActions {

	private WebDriver driver;
	private MainPage mainPage;
	private NewCustomerPage newCustomer;
	private NewCustomerPageDetails newCustomerPageDetails;
	private String customerid;

	/**
	 * @param driver
	 */
	public NewCustomerPageActions(WebDriver driver) {
		this.driver = driver;
		this.mainPage = new MainPage(driver);
		this.newCustomer = new NewCustomerPage(driver);
		this.newCustomerPageDetails = new NewCustomerPageDetails(driver);
	}

	private void clickNewCustomerMenu() {
		mainPage.menu("New Customer").click();
		
	}

	private void addCustomerName(String customerName) {
		newCustomer.customerNameField().click();
		newCustomer.customerNameField().clear();
		newCustomer.customerNameField().sendKeys(customerName);
	}

	private void selectGender(String gender) {
		newCustomer.genderField(gender).click();

	}

	private void selectDob(String dd, String mmm, String year) {
		newCustomer.dateOfBirthField().sendKeys(dd);
		newCustomer.dateOfBirthField().sendKeys(mmm);
		newCustomer.dateOfBirthField().sendKeys(Keys.TAB);
		newCustomer.dateOfBirthField().sendKeys(year);

	}

	private void enterAddress(String address) {
		newCustomer.addressField().clear();
		newCustomer.addressField().sendKeys(address);
	}

	private void enterCity(String city) {
		newCustomer.cityField().clear();
		newCustomer.cityField().sendKeys(city);
	}

	private void enterState(String state) {
		newCustomer.stateField().clear();
		newCustomer.stateField().sendKeys(state);
	}

	private void enterPin(String pinNo) {
		newCustomer.pinNoField().clear();
		newCustomer.pinNoField().sendKeys(pinNo);
	}

	private void enterMobileNumber(String mobNo) {
		newCustomer.mobNoField().clear();
		newCustomer.mobNoField().sendKeys(mobNo);
	}

	private void enterEmail(String emailId) {
		newCustomer.emailIdField().clear();
		newCustomer.emailIdField().sendKeys(emailId);
	}

	private void enterPassword(String password) {
		newCustomer.passwordField().clear();
		newCustomer.passwordField().sendKeys(password);
	}

	private void clickSubmit() {
		newCustomer.submitButton().click();
	}

	/**
	 * @return customer id
	 */
	public String customerId() {
		return this.customerid;
	}

	private void saveCustomerId() {
		this.customerid = newCustomerPageDetails.getcustomerIdRow().getText();
	}

	private void verifyCustomerCreatedSuccessfully() {
		String successMessage = newCustomerPageDetails.getCustomerPageHeading().getText();
		Assert.assertEquals(successMessage,"Customer Registered Successfully!!!");
	
	}

	/**
	 * @param customerName
	 * @param gender
	 * @param dd
	 * @param mm
	 * @param year
	 * @param address
	 * @param city
	 * @param state
	 * @param pinNo
	 * @param mobNo
	 * @param emailId
	 * @param password
	 */
	public void addNewCustomer(String customerName, String gender, String dd, String mm, String year, String address,
			String city, String state, String pinNo, String mobNo, String emailId, String password) {
		clickNewCustomerMenu();
		addCustomerName(customerName);
		selectGender(gender);
		selectDob(dd, mm, year);
		enterAddress(address);
		enterCity(city);
		enterState(state);
		enterPin(pinNo);
		enterMobileNumber(mobNo);
		enterEmail(emailId);
		enterPassword(password);
		clickSubmit();
		verifyCustomerCreatedSuccessfully();
		saveCustomerId();

	}

}
