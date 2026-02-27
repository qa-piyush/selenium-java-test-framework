package driver;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {

	public static ThreadLocal<WebDriver> tldriver = new ThreadLocal<>();

	public static void initDriver(Properties prop) {

		String browser = prop.getProperty("browser").trim();
		if (browser.equalsIgnoreCase("chrome")) {

			ChromeOptions options = new ChromeOptions();

			Map<String, Object> prefs = new HashMap<>();
			prefs.put("credentials_enable_service", false);
			prefs.put("profile.password_manager_enabled", false);
			prefs.put("profile.password_manager_leak_detection", false);

			options.setExperimentalOption("prefs", prefs);

			try {
				tldriver.set(new org.openqa.selenium.remote.RemoteWebDriver(
						new java.net.URL("http://host.docker.internal:4444"), options));
			} catch (Exception e) {
				throw new RuntimeException("Failed to connect to Selenium Grid", e);
			}

			getDriver().manage().window().maximize();
		}

		else {
			throw new RuntimeException("Unsupported browser: " + browser);
		}
	}

	public static WebDriver getDriver() {
		return tldriver.get();
	}

	public static void quitDriver() {
		if (getDriver() != null) {
			getDriver().quit();
			tldriver.remove();
		}
	}
}
