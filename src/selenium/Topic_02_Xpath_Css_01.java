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
  public void Login_Empty() {
	  driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
	  driver.findElement(By.xpath("//input[@id='email']")).sendKeys();
	  driver.findElement(By.xpath("//input[@id='pass']")).sendKeys();
	  driver.findElement(By.xpath("//button[@id='send2']")).click();
	  String errorEmail = driver.findElement(By.xpath("//div[@id='advice-required-entry-email']")).getText();
	  Assert.assertEquals(errorEmail, "This is a required field.");
	  String errorPass = driver.findElement(By.xpath("//div[@id='advice-required-entry-pass']")).getText();
	  Assert.assertEquals(errorPass, "This is a required field.");
  }
  @Test
  public void Login_with_Email_Invalid() {
	  driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
	  driver.findElement(By.xpath("//input[@id='email']")).sendKeys("12343434@123.12324");
	  driver.findElement(By.xpath("//button[@id='send2']")).click();
	  String EmailInvalid = driver.findElement(By.xpath("//div[@id='advice-validate-email-email']")).getText();
	  Assert.assertEquals(EmailInvalid, "Please enter a valid email address. For example johndoe@domain.com.");
	  

  }
  @Test
  public void Login_with_Pass_lessthan_6_Characters() {
	  driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
	  driver.findElement(By.xpath("//input[@id='email']")).sendKeys("automation@gmail.com");
	  driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("123");
	  driver.findElement(By.xpath("//button[@id='send2']")).click();
	  String Pass_lessthan_6 = driver.findElement(By.xpath("//div[@id='advice-validate-password-pass']")).getText();
	  Assert.assertEquals(Pass_lessthan_6, "Please enter 6 or more characters without leading or trailing spaces.");

  }
  @Test
  public void Login_with_Pass_Incorrect() {
	  driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
	  driver.findElement(By.xpath("//input[@id='email']")).sendKeys("automation@gmail.com");
	  driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("123123123");
	  driver.findElement(By.xpath("//button[@id='send2']")).click();
	  String Pass_Incorrect = driver.findElement(By.xpath("//span[text()='Invalid login or password.']")).getText();
	  Assert.assertEquals(Pass_Incorrect, "Invalid login or password.");
  }
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
