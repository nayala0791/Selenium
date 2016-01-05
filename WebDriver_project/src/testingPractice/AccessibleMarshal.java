package testingPractice;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AccessibleMarshal {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeMethod
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://www.newegg.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testAccessibleMarshal() throws Exception {
	  driver.get(baseUrl);
    String subtotal = driver.findElement(By.cssSelector("span.amount")).getText();
    System.out.println("subtotal");
    driver.get(baseUrl + "/Computer-Cases/SubCategory/ID-7");
    driver.findElement(By.id("baBreadcrumbTop")).click();
    try {
      Assert.assertEquals("ATX Computer Cases & Chassis - Newegg.com", driver.getTitle());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    driver.findElement(By.id("titleDescriptionID2")).click();
    driver.findElement(By.xpath("(//a[@name='&lid=AddCartN82E16811119260'])[2]")).click();
    driver.findElement(By.xpath("//div[@id='intermediary']/div/div/ul/li[2]/div/a/span[3]")).click();
    driver.findElement(By.xpath("(//img[@alt='View Detail'])[2]")).click();
    driver.findElement(By.linkText("Add to Cart ►")).click();
    Assert.assertTrue(isElementPresent(By.linkText("SAMSUNG 850 PRO 2.5\" 2 TB SATA III 3-D Vertical Internal Solid State Drive (SSD) MZ-7KE2T0BW")));
    driver.findElement(By.id("ITEM.35-181-060.1.0.0")).click();
    driver.findElement(By.id("ITEM.35-181-060.1.0.0")).clear();
    driver.findElement(By.id("ITEM.35-181-060.1.0.0")).sendKeys("");
    driver.findElement(By.id("35-181-060.1.0.0")).click();
    driver.findElement(By.id("removeFromCart")).click();
    boolean element = isElementPresent(By.cssSelector("li.price-current. > strong"));
    String price = driver.findElement(By.cssSelector("li.price-current. > strong")).getText();
    System.out.println(price);
  }

  @AfterMethod
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      Assert.assertNotEquals(verificationErrorString, "");
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}

