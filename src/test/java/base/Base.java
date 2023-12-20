package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	
	public Properties prop;
	
	WebDriver driver;
	public WebDriverWait wait;
	
	public JavascriptExecutor executor;
	
	public WebDriver initializeBrowser() throws IOException {
		
		prop = new Properties();
		
		File file = new File("src\\main\\java\\resources\\data.properties");
		
		FileInputStream fis = new FileInputStream(file);
		
		prop.load(fis);
		
		String browser = prop.getProperty("browser");
		
		if(browser.equals("chrome")) {
			
			
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			
		}else if(browser.equals("firefox")) {
				
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			
		}else if(browser.equals("edge")) {
			
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 
		
		return driver;
		
	}
	
	public String generateNewEmailTimeStamp() {
		
		Date date = new Date();
		return date.toString().replace(" ","_").replace(":","_")+"@gmail.com";
		
	}
	
	public String takeScreenshot(String testName,WebDriver driver) throws IOException {
		
		File srcScreenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String screenshotFilePath = System.getProperty("user.dir")+"\\Screenshots\\"+testName+".png";
		FileUtils.copyFile(srcScreenshot, new File(screenshotFilePath));
		return screenshotFilePath;
	}
	
	public static void scrollDown(WebDriver driver, String s) throws InterruptedException
	{
		WebElement learnMore_Storage_Backup = null;
		WebElement google_Play = null;
		String p = "about" ;
		String g = "plans" ;
		if (s.equals(p)){
		 learnMore_Storage_Backup = driver
				.findElement(By.xpath("(//a[@aria-label='Learn more in storage back up page'])[1]"));
		
		Actions builder = new Actions(driver);
	      Action seriesOfActions = builder.moveToElement(learnMore_Storage_Backup).click().sendKeys(Keys.PAGE_DOWN).build();
	      seriesOfActions.perform();
	      Thread.sleep(2000);
		} else if(s.equals(g)) {
			 google_Play = driver
					.findElement(By.xpath("(//a[@aria-label='link to App Store'])[1]"));
			
			Actions builder = new Actions(driver);
		      Action seriesOfActions2 = builder.moveToElement(google_Play).click().sendKeys(Keys.PAGE_DOWN).build();
		      seriesOfActions2.perform();
		      Thread.sleep(2000);
	      }
	    	  
	      }
	      
	

}
