package com.GenericUtilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplementation implements ITestListener {
	private ExtentReports reports;
	private ExtentTest test;
	public static ExtentTest stest;

	public void onStart(ITestContext arg0) {
		
		String date = new SimpleDateFormat("-yyyy_MM_dd_hh_mm_ss").format(new Date());
		ExtentSparkReporter spark = new ExtentSparkReporter("./extentReport/extentreport"+date+".html");
		spark.config().setDocumentTitle("Assesment");
		spark.config().setReportName("Automation Testing Reportt");
		spark.config().setTheme(Theme.DARK);
		reports = new ExtentReports();
		reports.attachReporter(spark);
		reports.setSystemInfo("Author", "Bavana");
		reports.setSystemInfo("OS", "win 11");
		reports.setSystemInfo("Browser", "chrome");
	}

	public void onTestStart(ITestResult result) {
		test = reports.createTest(result.getMethod().getMethodName());
		stest = test;
	}

	public void onTestSuccess(ITestResult result) {
		test.pass(result.getMethod().getMethodName() + " Passed");
	}

	public void onTestFailure(ITestResult result) {
		test.fail(result.getMethod().getMethodName() + " Failed");
		test.fail(result.getThrowable());
		System.out.println(Thread.currentThread().getId());
		String path = new WebdriverUtilties().screenShot(Baseclass.sdriver);
		test.addScreenCaptureFromBase64String(path);
	}

	public void onTestSkipped(ITestResult result) {
		test.pass(result.getMethod().getMethodName() + " Skipped");
	}

	public void onFinish(ITestContext context) {
		reports.flush();
	}

}
