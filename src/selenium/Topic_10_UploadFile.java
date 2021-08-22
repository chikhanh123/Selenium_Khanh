package selenium;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Topic_10_UploadFile {
	WebDriver driver;
	@Test
	public void Testcase_01() throws Exception {
		driver.get("https://blueimp.github.io/jQuery-File-Upload/");
		String image = "test.png";
		String image1 = "test.png";
		String image2 = "test.png";
		String filepath1 = "/Users/dxcv/Desktop/capture/" + image;
		String filepath2 = "/Users/dxcv/Desktop/capture/" + image1;
		String filepath3 = "/Users/dxcv/Desktop/capture/" + image2;
		String[] strFile = { filepath1, filepath2, filepath3 };
//		Cach 1:
//		for(String file : strFile) {
//			WebElement addFile = driver.findElement(By.xpath("//input[@type='file']"));
//			addFile.sendKeys(file);
//			Thread.sleep(1000);
//		}
//		Cach 2:
			WebElement addFile = driver.findElement(By.xpath("//input[@type='file']"));
			addFile.sendKeys(filepath1 + "\n" + filepath2 + "\n" + filepath3);
			
			
			Thread.sleep(5000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//a[text()='"+ image + "']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//a[text()='"+ image1 + "']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//a[text()='"+ image2 + "']")).isDisplayed());
	}

	@Test
	public void Testcase_02() {

	}

	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver", "/Users/dxcv/git/Selenium_Khanh/chromedriver");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@AfterTest
	public void afterTest() {
		driver.quit();

	}

}
