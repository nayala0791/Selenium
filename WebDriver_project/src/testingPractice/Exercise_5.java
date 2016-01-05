package testingPractice;

import org.testng.Assert;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.*;

public class Exercise_5 {
	WebDriver driver;
	private String baseUrl;
	private String currentUrl, currentTitle;
	
	
	@BeforeMethod
	public void setup(){
		driver = new FirefoxDriver();
		baseUrl= "http://www.alienware.com";
		//Import my Firefox into the browser when testing
		FirefoxProfile profile = new FirefoxProfile
				(new File("C:\\Users\\Nick\\AppData\\Roaming\\Mozilla\\Firefox\\Profiles"));
	}
	
	@Test
	public void testExercis_5() throws IOException{
		driver.get(baseUrl);
		//initialize the screenshot driver
		TakesScreenshot ts = ((TakesScreenshot) driver);
		//Make it read or write the file
		File screenshot = ts.getScreenshotAs(OutputType.FILE);
		//Set the destination of the screenshot
		FileUtils.copyFile(screenshot, new File("testShot.png"));
	}
}
