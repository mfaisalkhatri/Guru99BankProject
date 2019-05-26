package com.guru99.bankproject.websitetests;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

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
	 * @param browser
	 * @throws IOException
	 */
	@Parameters ("browser")
	@BeforeTest (alwaysRun = true)
	public void mainSetup (String browser) throws IOException {

		PropertiesReader prop = new PropertiesReader ();
		if (browser.equalsIgnoreCase ("chrome")) {
			String fileName = "chromedriver.exe";
			String filePath = getClass ().getClassLoader ()
				.getResource (fileName)
				.getPath ();
			System.setProperty ("webdriver.chrome.driver", filePath);

			driver = new ChromeDriver ();

		}
		if (browser.equalsIgnoreCase ("remotechrome")) {
			System.out.println ("Executing Tests on Docker");
			String node = prop.getKey ("remote.address") + "/wd/hub";
			DesiredCapabilities cap = DesiredCapabilities.chrome ();
			cap.setBrowserName ("chrome");
			driver = new RemoteWebDriver (new URL (node), cap);

		}

		driver.manage ()
			.timeouts ()
			.implicitlyWait (20, TimeUnit.SECONDS);
		driver.manage ()
			.window ()
			.maximize ();
		driver.get (prop.getKey ("website"));
	}

	/**
	 * 
	 */
	@AfterTest (alwaysRun = true)
	public void tearDown () {
		driver.quit ();
	}

}
