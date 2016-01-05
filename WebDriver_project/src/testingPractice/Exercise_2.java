package testingPractice;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class Exercise_2 {
	private WebDriver driver;
	private String baseUrl;
	
	
	@BeforeMethod
	public void setUp(){
		driver = new FirefoxDriver();
		baseUrl = "http://www.newegg.com/";
		/*title = driver.getTitle();*/
	}
	
	@Test
	public void testExercise_2(){
		driver.get(baseUrl);
		driver.manage().window().maximize();
		String titleOne = driver.getTitle();
		String urlOne = driver.getCurrentUrl();
		boolean check;
		
		//Display the first URL and Title
		System.out.println(urlOne);
		System.out.println(titleOne + "\n");
		
		//Locate the search box
		WebElement searchBox = driver.findElement(By.id("haQuickSearchBox"));
		searchBox.click();
		searchBox.sendKeys("Computer Cases");
		
		//Locate the Search Category Box
		WebElement categoryBox = driver.findElement(By.cssSelector("select[id='haQuickSearchStore']"));
		categoryBox.click();
		
		//Select one of the elements in the list
		WebElement selectedItem = driver.findElement(By.cssSelector("option[value='100006519']"));
		//If xpath was used here the syntax would be
		//driver.findElement(By.xpath("//option[@value = '100006519']"));
		selectedItem.click();
		
		//Locate search button and click
		WebElement searchButton = driver.findElement(By.cssSelector("button[class = 'btn btn-primary btn-mini search-bar-btn']"));
		searchButton.click();
		
		//Grab the second URL and Title
		String urlTwo = driver.getCurrentUrl();
		//Verify search was successful
		if(urlTwo.contains("newegg.com/Product")){
			check = true;
		}else{check = false;}
		Assert.assertTrue(check);
		
		//If search was successful get the new title and URL
		String titleTwo = driver.getTitle();
		//Display both URL and Title
		System.out.println(urlTwo);
		System.out.println(titleTwo + "\n");
		System.out.println("THE TEST WAS SUCCESSFUL!!!!");
		
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
