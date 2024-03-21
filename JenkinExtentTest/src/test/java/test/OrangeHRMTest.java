package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseClass;
import extentManager.ExtentManager;

public class OrangeHRMTest extends BaseClass {
	
	@Test(priority = 1)
	public void loginPageTest() throws InterruptedException {
		WebElement imgElement=driver.findElement(By.xpath("//img[@alt='company-branding']"));
		wait.until(ExpectedConditions.visibilityOf(imgElement));
		Assert.assertTrue(imgElement.isDisplayed());
	}
	@Test(priority = 3)
	public void loginTest() throws InterruptedException {
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(2000);
        String actualTitle=driver.getTitle();
        String expectedTitle="OrangeHRM";
        Assert.assertEquals(actualTitle, expectedTitle);
	}
	@Test(priority = 2)
	public void verifyForgotPassword() {
	WebElement forgotPassword =	driver.findElement(By.xpath("//p[@class='oxd-text oxd-text--p orangehrm-login-forgot-header']"));
	wait.until(ExpectedConditions.visibilityOf(forgotPassword));
	// Assert if the element is present
	Assert.assertNotNull(forgotPassword, ("Forgot Password link is not found on the page."));
	}
	/*
	 * @Test public void sampleCase() {
	 * ExtentManager.test.createNode("Validation1"); Assert.assertTrue(true);
	 * ExtentManager.test.createNode("Validation2"); Assert.assertTrue(true);
	 * ExtentManager.test.createNode("Validation3"); Assert.assertTrue(true);
	 * ExtentManager.test.createNode("Validation4--changes--");
	 * Assert.assertTrue(true); }
	 */
}
