package tests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;

public class PlansPageTest extends Base {

	public WebDriver driver;

	@BeforeMethod
	public void setup() throws IOException {

		driver = initializeBrowser();
		driver.get(prop.getProperty("url2"));
	}

	@AfterMethod
	public void tearDown() {

		driver.quit();
	}


@Test(priority =1)
public void Verify_Plans_landingPage() throws InterruptedException {

	// Get the actual page title
	String actualTitle = driver.getTitle();

	// Specify the expected page title
	String expectedTitle = "Plans & Pricing - Google One";

	// Assert the page title
	Assert.assertEquals(actualTitle, expectedTitle, "Page title mismatch");


}
@Test(priority = 2)
public void Verify_Plans_ManageYourPlan_Section() throws InterruptedException {
	executor = (JavascriptExecutor) driver;
	String mainwindow = driver.getWindowHandle();
	
	Thread.sleep(2000);
	scrollDown(driver, "plans");
	
	
	
	//- click on the learnMore_GooglePlay button
		WebElement button_GooglePlayy = driver
				.findElement(By.xpath("(//a[@aria-label='Google Play'])[1]"));
		executor.executeScript("arguments[0].click();", button_GooglePlayy);
		Thread.sleep(2000);
		
		driver.switchTo().window(mainwindow);
		scrollDown(driver, "plans");
		Thread.sleep(2000);
		
		//- click on the learnMore_GooglePlay button
		WebElement button_AppStore = driver
				.findElement(By.xpath("(//a[@aria-label='link to App Store'])[1]"));
		executor.executeScript("arguments[0].click();", button_AppStore);
		Thread.sleep(2000);
		
		driver.switchTo().window(mainwindow);
		Thread.sleep(2000);
	

}
}
