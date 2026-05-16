package Utilities;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


import Utilities.File_Utility;
import Utilities.Java_utilities;

public class BaseClass {
	
	 public WebDriver driver;
     public ExtentReports extent;
     public static  ExtentTest test;
    


	@BeforeSuite
	public void startReport() {
		extent=ExtentReportUtility.getReport();
	}
	
	@BeforeMethod
	public void openBrowser(Method method) {
		
		    driver= new EdgeDriver();
		    driver.manage().window().maximize();
		    driver.get(File_Utility.getPropertyData("url"));
		    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		    test =extent.createTest(method.getName());
	}
	
	
	
	@AfterMethod

	public void LogoutFromDWS( ITestResult result) throws IOException {

	            if (result.getStatus()== ITestResult.FAILURE) {
	            	WebDriverUtility.takeScreenshot(driver);
	            	test.fail("Test Failed").addScreenCaptureFromPath("./screenshot/"+Utilities.Java_utilities.getName()+".png");
	            	
	            	String path=captureScreenshot(result.getName());
	            	test.fail("Test Failed").addScreenCaptureFromPath(path);
	            	
	            	test.fail("Test Failed");
	            	try {
	            	test.addScreenCaptureFromPath(path);
					} catch (Exception e) {
						e.printStackTrace();
					}
	                test.addScreenCaptureFromPath(path);
					}
	            else if (result.getStatus()==ITestResult.SUCCESS) {
					 test.pass("Test Passesd");
				}
                driver.quit();
	}

	@AfterSuite

	public void closeBrowser() {

	       extent.flush();
           driver.quit();
           test.log(Status.INFO, "Browser Closed Successfully");

	}
	public String captureScreenshot(String testName) {
	    TakesScreenshot ts = (TakesScreenshot) driver;
	    File src = ts.getScreenshotAs(OutputType.FILE);

	    String path = "./screenshots/" + testName + ".png";

	    try {
	        FileUtils.copyFile(src, new File(path));
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return path;
		
}
}