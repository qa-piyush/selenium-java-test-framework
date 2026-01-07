package com.ecomm.framework.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {

	private static ExtentReports extent;

	public static ExtentReports getExtent() {
		if (extent == null) {

			ExtentSparkReporter spark = new ExtentSparkReporter("test-output/ExtentReport.html");

			spark.config().setReportName("Swag Labs Automation Report");
			spark.config().setDocumentTitle("Swag Labs Results");
			spark.config().setTheme(Theme.DARK);

			extent = new ExtentReports();
			extent.attachReporter(spark);
		}
		return extent;
	}
}
