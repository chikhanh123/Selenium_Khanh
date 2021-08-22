package selenium;

import java.sql.Timestamp;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.el.ConditionalExpression;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.Assert;

public class Topic_11_wait {
	By btnStart = By.xpath("//button[text()='Start']");
	By lblHelloworld = By.xpath("//div[@id='finish']//h4");
	By lblLoading = By.xpath("//div[@id='loading']");
	WebDriver driver;
	WebDriverWait explicitWait;
	
//@Test
//  public void Testcase_01_implicit_wait() {
//	  driver.get("https://the-internet.herokuapp.com/dynamic_loading/2");
//	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//	  driver.findElement(btnStart).click();
//	  Assert.assertTrue(driver.findElement(lblHelloworld).isDisplayed());
//  }
  @Test
  public void Testcase_02() {
	  driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
	  explicitWait = new WebDriverWait(driver, 5);
	  driver.get("https://the-internet.herokuapp.com/dynamic_loading/2");
	  
//	  invisible + khong co trong Dom
	  System.out.println("start time"+ funcgetDateTime());
	  explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(lblHelloworld));
	  System.out.println("End time"+ funcgetDateTime());
	  
//	  invisible + khong co trong Dom
	  System.out.println("start time"+ funcgetDateTime());
	  explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(lblLoading));
	  System.out.println("End time"+ funcgetDateTime());
	  
	  driver.findElement(btnStart).click();
	  
	  
//	  invisible + co trong Dom
	  System.out.println("start time"+ funcgetDateTime());
	  explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(lblLoading));
	  System.out.println("End time"+ funcgetDateTime());
	  
//	  invisible + co trong Dom
	  System.out.println("start time"+ funcgetDateTime());
	  explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(btnStart));
	  System.out.println("End time"+ funcgetDateTime());
  }
  
  
  public Date funcgetDateTime() {
	  Date date = new Date();
	  date = new Timestamp(date.getTime());
	  return date;
  }
  
@BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver","/Users/dxcv/git/Selenium_Khanh/chromedriver");
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
	  
  }

}
