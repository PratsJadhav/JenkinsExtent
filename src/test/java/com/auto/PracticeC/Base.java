package com.auto.PracticeC;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import java.lang.reflect.Method;

public class Base {
	
	public static ExtentReports extent;
	public static ExtentTest test;
	public static SimpleDateFormat formater; 
	
	static
	{
		Calendar calendar = Calendar.getInstance();
	    formater	= new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		extent = new ExtentReports(System.getProperty("user.dir")+"\\Reports\\test"+".html", false);
	}

	public void getResult(ITestResult result)
	{
		if(result.getStatus()==result.SUCCESS)
		{
			test.log(LogStatus.PASS, result.getName()+" test is passed");
		}
		else
		{
			test.log(LogStatus.FAIL, result.getName()+" test is failed");
		}
	}
	
	@BeforeMethod()
	public void m33(Method method)
	{
		test = extent.startTest(method.getName());
		test.log(LogStatus.INFO, method.getName() + "method started...");
	}
	
	@AfterMethod()
	public void m21(ITestResult result){
		getResult(result);
	}
	
	@AfterClass(alwaysRun = true)
	public void m22()
	{
		extent.endTest(test);
		extent.flush();
	}
}
