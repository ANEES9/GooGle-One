package tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;
import pageobjects.AboutPage;

public class AboutPageTest extends Base {

	public WebDriver driver;

	@BeforeMethod
	public void setup() throws IOException {

		driver = initializeBrowser();
		driver.get(prop.getProperty("url"));
	}

	@AfterMethod
	public void tearDown() {

		driver.quit();
	}

	  @Test(priority = 1)
	public void Verify_About_landingPage() throws InterruptedException {

		// Get the actual page title
		String actualTitle = driver.getTitle();

		// Specify the expected page title
		String expectedTitle = "Google On - Cloud Storage, Automatic Phone Backup, VPN and more";

		// Assert the page title
		Assert.assertEquals(actualTitle, expectedTitle, "Page title mismatch");

	}

	@Test(priority = 2)
	public void Verify_About_MakelifetimeOfMemories_Section() throws InterruptedException {

		executor = (JavascriptExecutor) driver;
		
		Thread.sleep(2000);
		scrollDown(driver, "about");
		
	//- click on the learnMore_Storage_Backupp button
		WebElement learnMore_Storage_Backupp = driver
				.findElement(By.xpath("(//a[@aria-label='Learn more in storage back up page'])[1]"));
		executor.executeScript("arguments[0].click();", learnMore_Storage_Backupp);
		Thread.sleep(2000);

		driver.navigate().back();
		scrollDown(driver, "about");
		Thread.sleep(2000);
		
		//- click on the learnMore_Online_safety button
		WebElement learnMore_Online_safety = driver
				.findElement(By.xpath("(//a[@aria-label='Learn more in about security page'])[1]"));
		executor.executeScript("arguments[0].click();", learnMore_Online_safety);
		Thread.sleep(2000);

		driver.navigate().back();
		scrollDown(driver, "about");
		Thread.sleep(2000);

		//- click on the learnMore_Extra_benefits buton
		WebElement learnMore_Extra_benefits = driver
				.findElement(By.xpath("(//a[@aria-label='Learn more in extra benefits page'])[1]"));
		executor.executeScript("arguments[0].click();", learnMore_Extra_benefits);
		Thread.sleep(2000);

	driver.navigate().back();
		Thread.sleep(2000);

	}
	
	
}
