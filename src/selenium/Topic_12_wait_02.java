package selenium;

import java.sql.Timestamp;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.el.ConditionalExpression;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.Assert;

public class Topic_12_wait_02 {
	WebDriver driver;
	WebDriverWait explicitWait;
	By tableDayMonYear = By.xpath("//div[@class='rcMain']");
	By btnClearDateMonYear = By.xpath("//span[text()='Clear Selected Dates']");
	By txtResult = By.xpath("//span[@id='ctl00_ContentPlaceholder1_Label1']");
	By ajax = By.xpath("//div[@class='raDiv']");
	
	
@Test
  public void Testcase_01_Ajaxloading_WithExplicitwait() {
	driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	  driver.get("https://demos.telerik.com/aspnet-ajax/ajaxloadingpanel/functionality/explicit-show-hide/defaultcs.aspx");
//	  check table ngay thang nam visible
	  explicitWait.until(ExpectedConditions.visibilityOfElementLocated(tableDayMonYear));
//	  select date
	  funcSelectDate(15);
//	  wait load xong
	  explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(ajax));
//	  check result
	  Assert.assertEquals(driver.findElement(txtResult).getText().trim(), "Sunday, August 15, 2021");
  }





public void funcSelectDate (int Date) {
	String xpathDate = "//a[text()='"+ Date+ "']";
	By date = By.xpath(xpathDate);
	explicitWait.until(ExpectedConditions.visibilityOfElementLocated(date));
	driver.findElement(date).click();
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
	  explicitWait = new WebDriverWait(driver, 10);
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
	  
  }

}
