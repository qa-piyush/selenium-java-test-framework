package driver;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverFactory {

	private static ThreadLocal<WebDriver> tldriver = new ThreadLocal<>();

	public static void initDriver(Properties prop) {

		String browser = prop.getProperty("browser").trim();

		if (browser.equalsIgnoreCase("chrome")) {

			ChromeOptions options = new ChromeOptions();

			// Required for Docker
			options.addArguments("--headless=new");
			options.addArguments("--no-sandbox");
			options.addArguments("--disable-dev-shm-usage");

			// Disable password popups
			Map<String, Object> prefs = new HashMap<>();
			prefs.put("credentials_enable_service", false);
			prefs.put("profile.password_manager_enabled", false);
			prefs.put("profile.password_manager_leak_detection", false);
			options.setExperimentalOption("prefs", prefs);

			try {
				tldriver.set(new RemoteWebDriver(new URL("http://host.docker.internal:4444"), options));
			} catch (Exception e) {
				throw new RuntimeException("Failed to connect to Selenium Grid", e);
			}

			getDriver().manage().window().maximize();

		} else {
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