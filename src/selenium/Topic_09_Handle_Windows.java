package selenium;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import org.testng.Assert;


public class Topic_09_Handle_Windows {
	WebDriver driver;
  @Test
  public void Testcase_01_SwitchtochildWindow() {
	  driver.get("https://demoqa.com/browser-windows");
	  driver.findElement(By.xpath("//button[@id='tabButton']")).click();
	  String parentID = driver.getWindowHandle();
//	  funcSwitchToChildWindowUseParentID(parentID);
	  String desTitle ="";
	  funSwitchToChildWindowUseTitle(desTitle);
	  Assert.assertEquals(driver.findElement(By.xpath("//h1")).getText(), "This is a sample page");
	  Boolean result = funCloseAllWindowsExceptParentWindow(parentID);
	  Assert.assertTrue(result);
	  }
  @Test
  public void Testcase_02() {

  }
//  switch to child window, khi co 2 windows
  public void funcSwitchToChildWindowUseParentID(String parentID) {
	  Set <String> allID = driver.getWindowHandles(); // lấy ra tất cả ID của windows
	  for(String childID : allID) {
		  if(!childID.equals(parentID)) {
			  driver.switchTo().window(childID);
			  break;
		  }
	  }
  }
//  switch to child window, when having more than 2 windows
  public void funSwitchToChildWindowUseTitle(String desTitle) {
	  Set<String> allID = driver.getWindowHandles();
	  for(String childID : allID) {
		  driver.switchTo().window(childID);
		  if(driver.getTitle().equals(desTitle)) {
			  break;
		  }
	  }
  }
  
//  close all windows except parent window
  public Boolean funCloseAllWindowsExceptParentWindow(String parentID) {
	  Set<String> allID = driver.getWindowHandles();
	  for(String childID : allID) {
		  if(!childID.equals(parentID)) {
			  driver.switchTo().window(childID);
			  driver.close();
		  }
	  }
	  driver.switchTo().window(parentID);
	  if(driver.getWindowHandles().size() ==  1) {
		  return true;
	  }else {
		  return false;
	  }
  }
  
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver","/Users/dxcv/git/Selenium_Khanh/chromedriver");
	  driver = new ChromeDriver();
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  driver.manage().window().maximize();
	  
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
	  
  }

}
