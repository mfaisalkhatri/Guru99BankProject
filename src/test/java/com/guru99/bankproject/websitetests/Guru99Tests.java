package com.guru99.bankproject.websitetests;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.configreader.configreader.main.PropertiesReader;
import com.guru99.bankproject.pageactions.LoginPageActions;
import com.guru99.bankproject.pageactions.NewAccountPageActions;
import com.guru99.bankproject.pageactions.NewCustomerPageActions;

/**
 * @author Faisal Khatri
 *
 */
public class Guru99Tests extends Setup {

	private String customerId;

	@Test(priority = 1, dataProvider = "logintestdata")
	private void loginValidationTests(String userName, String password, boolean isValid) {
		LoginPageActions loginPageAction = new LoginPageActions(driver);

		loginPageAction.loginWebsite(userName, password, isValid);

	}

	/**
	 * @return testData
	 * @throws IOException
	 */
	@DataProvider(name = "logintestdata")
	public Iterator<Object[]> testData() throws IOException {
		PropertiesReader prop = new PropertiesReader();
		List<Object[]> testData = new ArrayList<>();

		testData.add(new Object[] { "User1", "pass1", false });
		testData.add(new Object[] { prop.getKey("website.userid"), "pass1", false });
		testData.add(new Object[] { "user22", prop.getKey("website.password"), false });
		testData.add(new Object[] { " ", prop.getKey("website.password"), false });
		testData.add(new Object[] { "user2212", " ", false });

		testData.add(new Object[] { prop.getKey("website.userid"), prop.getKey("website.password"), true });
		return testData.iterator();
	}

	/**
	 * @return customerData
	 */
	@DataProvider(name = "addnewcustomer")
	public Iterator<Object[]> customerData() {
		List<Object[]> customerData = new ArrayList<>();
		customerData.add(new Object[] { "Johnny DOE", "male", "09", "02", "1988", "15 new villa street near Avenue park",
				"Mumbai", "Maharashtra", "400099", "9820098201", "test1670@gmail.com", "pass1234" });
		return customerData.iterator();
	}

	/**
	 * @param custName
	 * @param gender
	 * @param dd
	 * @param mmm
	 * @param year
	 * @param address
	 * @param city
	 * @param state
	 * @param pinNo
	 * @param mobNo
	 * @param emailId
	 * @param password
	 */
	@Test(priority = 2, dataProvider = "addnewcustomer", dependsOnMethods = "loginValidationTests")
	public void addnewCustomerTest(String custName, String gender, String dd, String mmm, String year, String address,
			String city, String state, String pinNo, String mobNo, String emailId, String password) {

		NewCustomerPageActions newcustomerpageActions = new NewCustomerPageActions(driver);
		newcustomerpageActions.addNewCustomer(custName, gender, dd, mmm, year, address, city, state, pinNo, mobNo,
				emailId, password);
		this.customerId = newcustomerpageActions.customerId();
	}

	/**
	 * @return account data
	 */
	@DataProvider(name = "addNewAccount")
	public Iterator<Object[]> newAccountData() {
		List<Object[]> accountData = new ArrayList<>();
		accountData.add(new Object[] { "Savings", "1000" });

		return accountData.iterator();

	}

	/**
	 * @param accType
	 * @param depositAmt
	 */
	@Test(priority = 3, dataProvider = "addNewAccount", dependsOnMethods = "addnewCustomerTest")
	public void addNewAccount(String accType, String depositAmt) {
		NewAccountPageActions newAccountPageActions = new NewAccountPageActions(driver);
		newAccountPageActions.createNewAccount(customerId, accType, depositAmt);
	}

}
