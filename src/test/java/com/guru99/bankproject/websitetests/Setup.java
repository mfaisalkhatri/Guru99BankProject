package com.guru99.bankproject.websitetests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.configreader.configreader.main.PropertiesReader;

/**
 * @author Faisal Khatri
 *
 */
public class Setup {

	/**
	 * 
	 */
	protected WebDriver driver;

	/**
	 * @throws IOException
	 */
	@BeforeTest(alwaysRun=true)
	public void mainSetup() throws IOException {

		String fileName = "chromedriver.exe";
		String filePath = getClass().getClassLoader().getResource(fileName).getPath();
		System.setProperty("webdriver.chrome.driver", filePath);

		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		PropertiesReader prop = new PropertiesReader();
		driver.get(prop.getKey("website"));
	}

	/**
	 * 
	 */
	@AfterTest(alwaysRun=true)
	public void tearDown() {
		driver.quit();
	}

}
