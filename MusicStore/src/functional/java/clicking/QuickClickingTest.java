package clicking;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class QuickClickingTest {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://localhost:8080/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void test() throws Exception {
	  assertTrue(true);
    driver.get(baseUrl + "/MusicStore/pages/track/manage.xhtml");
    driver.findElement(By.linkText("MusicStore")).click();
    driver.findElement(By.id("drop1")).click();
    driver.findElement(By.linkText("User Registration")).click();
    driver.findElement(By.id("drop1")).click();
    driver.findElement(By.linkText("User Login")).click();
    driver.findElement(By.id("drop1")).click();
    driver.findElement(By.linkText("Show All Users")).click();
    driver.findElement(By.id("drop2")).click();
    driver.findElement(By.linkText("Add Artist")).click();
    driver.findElement(By.id("drop2")).click();
    driver.findElement(By.linkText("Edit / Delete Artist")).click();
    driver.findElement(By.linkText("Tracks")).click();
    driver.findElement(By.linkText("Add Track")).click();
    driver.findElement(By.linkText("Tracks")).click();
    driver.findElement(By.linkText("Edit / Delete Track")).click();
    driver.findElement(By.linkText("Albums")).click();
    driver.findElement(By.linkText("Add Album")).click();
    driver.findElement(By.xpath("(//a[@id='drop2']/b)[3]")).click();
    driver.findElement(By.linkText("Edit / Delete Album")).click();
    driver.findElement(By.linkText("Products")).click();
    driver.findElement(By.linkText("Add Product")).click();
    driver.findElement(By.linkText("Products")).click();
    driver.findElement(By.linkText("Edit / Delete Product")).click();
    driver.findElement(By.linkText("Other")).click();
    driver.findElement(By.linkText("Add Store")).click();
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
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
