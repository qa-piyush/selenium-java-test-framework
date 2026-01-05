package listeners;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.ecomm.framework.utils.ExtentManager;
import com.ecomm.framework.utils.ScreenshotUtil;

import driver.DriverFactory;

public class TestListener implements ITestListener {

	private ExtentReports extent;
	private ExtentTest test;

	@Override
	public void onStart(ITestContext context) {
		extent = ExtentManager.getExtent();
	}

	@Override
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.pass("Test passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		WebDriver driver = DriverFactory.getDriver();
		String screenshotPath =
				ScreenshotUtil.takeScreenshot(driver, result.getMethod().getMethodName());
		test.fail(result.getThrowable());
		test.addScreenCaptureFromPath(screenshotPath);
	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}
}
