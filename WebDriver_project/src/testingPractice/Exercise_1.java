package testingPractice;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Exercise_1 {
	private WebDriver driver;
	private String baseUrl;
	
	@BeforeMethod
	public void setUp() {
		driver = new FirefoxDriver();
		baseUrl = "http://www.newegg.com";
		//driver.manage().timeouts().implicitlyWait(30 , TimeUnit.SECONDS);
	}
	
	@Test
	public void testExercise_1() {
		driver.get(baseUrl);
		String title = driver.getTitle();
		String url = driver.getCurrentUrl();
		boolean check;
		
		//verify the URL
		/*Assert.assertEquals(url, "http://www.newegg.com/");
		System.out.println(url);
		System.out.println(title);*/
		if(url.contains("newegg.com")){
			check = true;
		}else {check = false;}
		
		Assert.assertTrue(check);
		System.out.println(url);
		System.out.println(title);
		
		
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
		
	}

}
