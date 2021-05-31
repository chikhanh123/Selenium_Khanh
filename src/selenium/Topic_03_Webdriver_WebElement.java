package selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Topic_03_Webdriver_WebElement {
	WebDriver driver;
	By search = By.xpath("//input[@id='search']");
	By Newsletter = By.xpath("//input[@id='newsletter']");

	@Test
	public void Check_field_display_on_page() {
		driver.get("http://live.demoguru99.com/");
		if (isDisplay(search)) {
			driver.findElement(search).sendKeys("Automation");
		}
		if (isDisplay(Newsletter)) {
			driver.findElement(Newsletter).sendKeys("Automation");
		}
	}

	@Test
	public void check_enable() {
		driver.get("http://live.demoguru99.com/");
		if (isEnable(search)) {
			driver.findElement(search).sendKeys("isEnable");
		}
		if (isEnable(Newsletter)) {
			driver.findElement(Newsletter).sendKeys("isEnable");
		}
	}

	public boolean isDisplay(By byvalue) {
		if (driver.findElement(byvalue).isDisplayed()) {
			return true;
		}
		return false;
	}

	public boolean isEnable(By byvalue) {
		if (driver.findElement(byvalue).isEnabled()) {
			return true;
		}
		return false;
	}

	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\Windows OS\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	@AfterTest
	public void afterTest() {
		driver.quit();

	}

}
