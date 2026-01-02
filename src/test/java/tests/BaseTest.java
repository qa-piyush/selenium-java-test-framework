package tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.ecomm.framework.utils.ConfigReader;

import driver.DriverFactory;

public class BaseTest {

	protected WebDriver driver;
	protected Properties prop;

	@BeforeMethod
	public void setup() {
		ConfigReader configReader = new ConfigReader();
		prop = configReader.initProp();
		DriverFactory.initDriver(prop);
		driver = DriverFactory.getDriver();
		driver.get(prop.getProperty("url"));
	}

	@AfterMethod
	public void tearDown() {
		DriverFactory.quitDriver();
	}

}
