package testingPractice;

import org.testng.Assert;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

public class Exercise_7 {
	WebDriver driver;
	String baseUrl;
	
	@BeforeMethod
	public void setUp(){
		driver = new FirefoxDriver();
		baseUrl ="www.newegg.com";
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	@Test
	public void testExercise_7(){
		driver.get(baseUrl);
		
		WebElement login = driver.findElement(By.cssSelector("a[class = 'top-nav-tab-name logout']"));
		login.click();
		
		WebElement create = driver.findElement(By.id("submit"));
		create.click();
		String currentUrl = driver.getCurrentUrl();
		Assert.assertTrue(currentUrl.contains("newegg.com/NewMyAccount"), "FAILED: NOT IN THE RIGHT PAGE");
		
		WebElement pwd = driver.findElement(By.id("Password"));
		pwd.click();
		pwd.sendKeys("A");
		
		WebElement confirmPwd = driver.findElement(By.id("Password1"));
		confirmPwd.click();
		confirmPwd.sendKeys("A");
		
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		WebElement button = driver.findElement(By.cssSelector("a[class = 'atnSecondary']"));
		button.click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement waitElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.className("alert")));
		
		Assert.assertEquals(waitElement.getText(), "Wrong Login information you entered");
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
