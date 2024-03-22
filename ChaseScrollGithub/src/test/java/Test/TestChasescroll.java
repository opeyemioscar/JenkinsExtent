package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;

public class TestChasescroll extends BaseClass {
	@Test(priority = 1)
	public void validateName() {
		WebElement chasescroll = driver.findElement(By.xpath("//p[@class='chakra-text css-zzsy7e']"));
		Assert.assertNotNull(chasescroll, "The Chasecroll name is not found");
	}

	@Test(priority = 2)
	public void ValidePageTitle() {
		String actual = "Creating Unforgetabble Memories";
		String expect = driver.getTitle();
		Assert.assertEquals(actual, expect);
	}

	@Test(priority = 3)
	public void loginTest() {
		driver.findElement(By.xpath("//input[@placeholder='Enter your Email or Username']")).sendKeys("Davido");
		driver.findElement(By.xpath("input[placeholder='Enter your password']")).sendKeys("Test1234");
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
	}

	@Test(priority = 4)
	public void verifyurl() {
		String actual = "https://chasescroll-next-app-test.vercel.app/dashboard/event";
		String expected = driver.getCurrentUrl();
		Assert.assertEquals(actual, expected);
	}

}
