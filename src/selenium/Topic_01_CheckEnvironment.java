package selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class Topic_01_CheckEnvironment {
	WebDriver driver;
  @Test
  public void Testcase_01_CheckUrl() {
	  String homePageUrl = driver.getCurrentUrl();
	 Assert.assertEquals(homePageUrl, "http://live.demoguru99.com/");
  }
  @Test
  public void Testcase_01_Checktitle() {
	  String homePage = driver.getTitle();
	  Assert.assertEquals(homePage, "Home page");
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
