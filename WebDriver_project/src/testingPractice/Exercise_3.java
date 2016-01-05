package testingPractice;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Exercise_3 {
	
	private WebDriver driver;
	private String baseUrl, currentUrl, currentTitle;
	
	
	@BeforeMethod
	public void setUp(){
		driver = new FirefoxDriver();
		baseUrl = "http://www.newegg.com";
	}
	
	@Test
	public void actionOne(){
		driver.get(baseUrl);
		driver.manage().window().maximize();
		Actions builder = new Actions(driver);
		
		//Create my first action
		Action hoverAndClick = builder.moveToElement(driver.findElement(By.name("Electronics")))
				.pause(5000)
				.moveToElement(driver.findElement(By.xpath("//*[@id='main-nav-menu-list']/ul/li[3]/div/div[1]/dl[3]/dd[2]/div/a")))
				.click()
				.build();
		hoverAndClick.perform();
//		actionTwo();
//	}
//		
//		public void actionTwo(){
//			//Create second builder
//		Actions builder2 = new Actions(driver);
//		//Create second action to click on Digital cameras
//		Action clickDc = builder2.moveToElement(driver.findElement(By.xpath("//*[@id='main-nav-menu-list']/ul/li[3]/div/div[1]/dl[3]/dd[2]/div/a")))
//				.click()
//				.build();
//		clickDc.perform();
		
		//Verify successful navigation
		currentUrl = driver.getCurrentUrl();
		currentTitle = driver.getTitle();
		Assert.assertTrue(currentUrl.contains("newegg.com/Digital-Cameras") && currentTitle.contains("Digital & DSLR Cameras and Accessories"),
				"FAILURE: Not in expected page");
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	

}
