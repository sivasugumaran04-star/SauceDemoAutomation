package Utilities;

import org.testng.Reporter;
import org.testng.internal.ReporterConfig;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportUtility {

	public static ExtentReports getReport() {
		
		ExtentSparkReporter spark = new ExtentSparkReporter("./src/test/resources/reports/DWS_Report_"+Java_utilities.getName()+".html");
        spark.config().setReportName("Demo Web Shop");
        ExtentReports extent= new ExtentReports();
        extent.attachReporter(spark);
		return extent;
		
	}
}
