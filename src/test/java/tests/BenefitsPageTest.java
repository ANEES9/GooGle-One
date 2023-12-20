package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;

public class BenefitsPageTest extends Base {
	
	public WebDriver driver;

	@BeforeMethod
	public void setup() throws IOException {

		driver = initializeBrowser();
		driver.get(prop.getProperty("url3"));
	}

	@AfterMethod
	public void tearDown() {

		driver.quit();
	}


@Test(priority=1)
public void Verify_Benefits_landingPage() throws InterruptedException {

	// Get the actual page title
	String actualTitle = driver.getTitle();

	// Specify the expected page title
	String expectedTitle = "Google One - Member benefits that help you get more out of Google";

	// Assert the page title
	Assert.assertEquals(actualTitle, expectedTitle, "Page title mismatch");


}

}
