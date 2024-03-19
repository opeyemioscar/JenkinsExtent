package listener;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import base.BaseClass;


	public class ExtentManager extends BaseClass {

	    public static ExtentReports extent;
	    public static ExtentTest test;

	    //public static ExtentReports getInstance(String fileName) 
	    public static ExtentReports getInstance() throws IOException{
	        if (extent == null) {
	            ExtentSparkReporter htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"/test-output/ExtentReport/MyReport.html");
	            htmlReporter.loadXMLConfig(System.getProperty("user.dir") + "/extent-config.xml");
				/*
				 * htmlReporter.config().setTheme(Theme.STANDARD);
				 * htmlReporter.config().setDocumentTitle();
				 * htmlReporter.config().setEncoding("utf-8");
				 * htmlReporter.config().setReportName(fileName);
				 */

	            extent = new ExtentReports();
	            extent.attachReporter(htmlReporter);
	            extent.setSystemInfo("Automation Tester", "Opeyemi Oscar");
	            extent.setSystemInfo("Organization", "Way2Automation");
	            extent.setSystemInfo("Build no", "W2A-1234");
	            extent.setSystemInfo("OS", "Win11");
	            extent.setSystemInfo("Browser", "Chrome");
	        }
	        return extent;
	    }

	    public  String screenshotPath;
	    public  String screenshotName;

	    public  void captureScreenshot() {
	        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	        Date d = new Date();
	        screenshotName = d.toString().replace(":", "_").replace(" ", "_") + ".png";
	        try {
	            FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir") + "\\reports\\" + screenshotName));
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	}



