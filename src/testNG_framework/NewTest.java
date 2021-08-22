package testNG_framework;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class NewTest {
	WebDriver driver;
	
	
	
	@Parameters({"username", "password"})
  @Test
  public void Login(String userName, String passWord) {
		  driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
		  driver.findElement(By.xpath("//input[@id='email']")).sendKeys(userName);
		  driver.findElement(By.xpath("//input[@id='pass']")).sendKeys(passWord);
		  driver.findElement(By.xpath("//button[@id='send2']")).click();
		  String Pass_lessthan_6 = driver.findElement(By.xpath("//div[@id='advice-validate-password-pass']")).getText();
		  Assert.assertEquals(Pass_lessthan_6, "Please enter 6 or more characters without leading or trailing spaces.");
  }
  
  
  @Parameters("browser")
  @BeforeTest
  public void beforeTest(String browsername) {
	  if(browsername.toLowerCase().trim().equals("chrome")) {
	  System.setProperty("webdriver.chrome.driver","/Users/dxcv/git/Selenium_Khanh/chromedriver");
	  driver = new ChromeDriver();
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  driver.manage().window().maximize();
	  driver.get("http://live.demoguru99.com/");
	  }
	   else if(browsername.toLowerCase().trim().equals("firefox")) {
		  System.setProperty("webdriver.chrome.driver","/Users/dxcv/git/Selenium_Khanh/firefoxdriver");
		  WebDriver driver = new FirefoxDriver();
		  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		  driver.manage().window().maximize();
		  driver.get("http://demo.guru99.com/v4/"); 
	  }
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
