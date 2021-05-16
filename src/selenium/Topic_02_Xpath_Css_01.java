package selenium;

import org.testng.annotations.Test;
import org.testng.Assert;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


public class Topic_02_Xpath_Css_01 {
	WebDriver driver;
  @Test
  public void Testcase_01() {
	  driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
	  driver.findElement(By.xpath("//input[@id='email']")).sendKeys();
	  driver.findElement(By.xpath("//input[@id='pass']")).sendKeys();
	  driver.findElement(By.xpath("//button[@id='send2']")).click();
	  String errorEmail = driver.findElement(By.xpath("//div[@id='advice-required-entry-email']")).getText();
	  Assert.assertEquals(errorEmail, "This is a required field.");
	  String errorPass = driver.findElement(By.xpath("//div[@id='advice-required-entry-pass']")).getText();
	  Assert.assertEquals(errorPass, "This is a required field.");

  }
  //@Test
  //public void Testcase_02() {

  //}
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver","D:\\Selenium\\Windows OS\\chromedriver_win32\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  driver.manage().window().maximize();
	  driver.get("http://live.demoguru99.com/");
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
