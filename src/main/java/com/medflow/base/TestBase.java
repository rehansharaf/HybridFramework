package com.medflow.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.medflow.utils.ExtentManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	public static Properties prop;

	@BeforeSuite
	public void loadConfig() throws IOException {

		ExtentManager.setExtent();
		DOMConfigurator.configure("log4j.xml");

		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "/configuration/config.properties");
			prop.load(ip);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void browserIntialization() {

		String browser = prop.getProperty("browser");
		setDriver(browser);
		// driver = BrowserFactory.instance.getDriver();
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		getDriver().manage().window().maximize();
		getDriver().get(prop.getProperty("url"));

	}

	public void setDriver(String browserName) {

		if (browserName.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			// Set Browser to ThreadLocalMap
			driver.set(new ChromeDriver());
		} else if (browserName.equalsIgnoreCase("FireFox")) {
			WebDriverManager.firefoxdriver().setup();
			driver.set(new FirefoxDriver());
		} else if (browserName.equalsIgnoreCase("IE")) {
			WebDriverManager.iedriver().setup();
			driver.set(new InternetExplorerDriver());
		}

	}

	public static WebDriver getDriver() {
		// Get Driver from threadLocalmap
		return driver.get();
	}

	public void removeDriver() {

		getDriver().quit();
		driver.remove();
	}

	@AfterSuite
	public void afterSuite() {
		ExtentManager.endReport();
	}

}
