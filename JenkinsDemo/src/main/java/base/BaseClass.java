package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClass {
	public WebDriver driver;

	@BeforeMethod
	public void setup() {
		String browser = System.getProperty("browser");
	    if (browser != null) {
	        if (browser.equalsIgnoreCase("Chrome")) {
	            driver = new ChromeDriver();
	        } else if (browser.equalsIgnoreCase("Firefox")) {
	            driver = new FirefoxDriver();
	        } else if (browser.equalsIgnoreCase("Edge")) {
	            driver = new EdgeDriver();
	        } 
	    }
		driver.manage().window().maximize();
		driver.get(System.getProperty("url"));
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
	}

	@AfterMethod
	public void tearDown() {
		if(driver != null) {
			driver.quit();	
		}
		
	}

}
