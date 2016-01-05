package testingPractice;

import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.*;

public class Exercise_4 {
	WebDriver driver;
	private String baseUrl;
	private String currentUrl, currentTitle, currentWindow;
	
	@BeforeMethod
	public void setUp(){
		driver = new FirefoxDriver();
		baseUrl = "http://www.alienware.com";
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	@Test
	public void testExercise_4(){
		//Get url and maximize the window
		driver.get(baseUrl);
		driver.manage().window().maximize();
		
		//Get the current window
		currentWindow = driver.getWindowHandle();
		
		//Create an action builder and perform actions on the first screen 
		Actions builder = new Actions(driver);
		Action moveAndClick = builder.moveToElement(driver.findElement(By.cssSelector("img[class = 'facebook_icon']")))
				.click()
				.build();
		moveAndClick.perform();
		
		//Create a set to hold all the windows and loop through to switch to the window
		Set<String> handles = driver.getWindowHandles();
		for(String hdn : handles){
			if(!hdn.equals(handles)){
				driver.switchTo().window(hdn);
			}
		}
		
		//perform actions on new window
		Action enterInfo = builder.moveToElement(driver.findElement(By.id("email")))
				.click()
				.sendKeys("none@any.com")
				.moveToElement(driver.findElement(By.id("pass")))
				.click()
				.sendKeys("test")
				.build();
		enterInfo.perform();
		
		//Switch back to the original window to complete process
		driver.switchTo().window(currentWindow);
		
		//Get both currentUrl and currentTitle
		currentUrl = driver.getCurrentUrl();
		currentTitle = driver.getTitle();
		
		//Verify that test is on the right window
		Assert.assertTrue(currentUrl.contains("www.alienware.com") && currentTitle.contains("Custom Gaming Computer"), 
				"FAILED: Did not switch back to original window!");
		
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
}
