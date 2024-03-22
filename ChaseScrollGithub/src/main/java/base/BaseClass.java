package base;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import extentManager.ExtentManager;

public class BaseClass {
	public static WebDriver driver;
	

	@BeforeSuite
	public void BeforeSuite() throws IOException {
		ExtentManager.setExtent();
	}

	@AfterSuite
	public void AfterSuite() {
		ExtentManager.endReport();
	}

	
	@BeforeMethod
	public void build() {
		String browser = System.getProperty("browser");
		if (driver != null) {
		if (browser.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
		}else if (browser.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
		}else if(browser.equalsIgnoreCase("Edge")) {
			driver = new EdgeDriver();
		}
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get(System.getProperty("url"));
		}
	}
	
	@AfterMethod
	public void teardown() {
		if(driver != null) {
			driver.quit();
		}
	}

	public static String screenShot(WebDriver driver, String filename) {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\ScreenShot\\" + filename + "_" + dateName + ".png";

		try {
			FileUtils.copyFile(source, new File(destination));
		} catch (Exception e) {
			e.getMessage();
		}

		// This new path for jenkins
		String newImageString = "http://localhost:8080/job/JenkinExtentTest/ws/JenkinExtentTest/ScreenShot/" + filename + "_" + dateName
				+ ".png";
		return newImageString;

	}

	public static String getCurrentTime() {
		String currentDate = new SimpleDateFormat("yyyy-MM-dd-hhmmss").format(new Date());
		return currentDate;
	}
}
