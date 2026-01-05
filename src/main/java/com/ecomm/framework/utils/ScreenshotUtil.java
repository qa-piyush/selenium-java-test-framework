package com.ecomm.framework.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtil {

	public static String takeScreenshot(WebDriver driver, String testName) {
		String timeStamp = String.valueOf(System.currentTimeMillis());
		String screenshotPath = 
				"test-output/screenshots/" + testName + "_" + timeStamp + ".png";
		try {
			File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			File dest = new File(screenshotPath);
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return screenshotPath;
	}
}
