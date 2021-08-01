package selenium;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class Topic_05_Dropdown {
	WebDriver driver;

  @Test
public void Testcase_01_Default_Dropdown() throws Exception {
//	  step 2: kiễm tra xem dropdown có multi hay không
//	  step 3: chọn giá trị trong dropdown bằng SelectVisible
//	  Step 4: kiễm tra giá trị đã được chọn thành công
//	  step 5: chọn giá trị trong dropdown bằng SelectValue
//	  Step 6: kiễm tra giá trị đã được chọn thành công
//	  step 7: chọn giá trị trong dropdown bằng SeleIntdex
//	  Step 8: kiễm tra giá trị đã được chọn thành công
//	  Step 9: kiễm tra dropdown co tao bao nhieu gia tri
	  By btnMobile = By.xpath("//a[text()='Mobile']");
	  By xpathdpdSortBy = By.xpath("(//select[@title='Sort By'])[1]");
	  
	  driver.findElement(btnMobile).click();
//	  truong hop chon dropdown trang khong load lai
//	  WebElement dpdSortBy = driver.findElement(xpathdpdSortBy);
//	  Select DropDown = new Select(dpdSortBy);
//	  Assert.assertFalse(DropDown.isMultiple());// step 2
//	  DropDown.selectByVisibleText("Price");//  thuong dung nhat.Price la gi tri thuc hien thi tren man hinh
//	  Thread.sleep(5000);
//	  Assert.assertEquals(DropDown.getFirstSelectedOption().getText(), "Price");// step 4: lay gia tri duoc chon va so sanh
//	  DropDown.selectByValue("http://live.demoguru99.com/index.php/mobile.html?dir=asc&order=name");
//	  Thread.sleep(5000);
//	  Assert.assertEquals(DropDown.getFirstSelectedOption().getText(), "Name");
//	  DropDown.selectByIndex(2);
//	  Thread.sleep(5000);
//	  Assert.assertEquals(DropDown.getFirstSelectedOption().getText(), "Position");
//	  Assert.assertEquals(DropDown.getOptions().size(), "3");
	  
	  
//	  cho truong hop khi chon gia tri trong dropdown thi page load lai
	  for(int i=0;i<8;i++ ) {
		  WebElement dpdSortBy = driver.findElement(xpathdpdSortBy); 
		  Select DropDown = new Select(dpdSortBy);
		switch(i) {
		case 0:
			Assert.assertFalse(DropDown.isMultiple());
			break;
		case 1:
			DropDown.selectByVisibleText("Price");
			break;
		case 2:
			Assert.assertEquals(DropDown.getFirstSelectedOption().getText(), "Price");
			break;
		case 3:
			DropDown.selectByValue("http://live.demoguru99.com/index.php/mobile.html?dir=asc&order=name");
			break;
		case 4:
			Assert.assertEquals(DropDown.getFirstSelectedOption().getText(), "Name");
			break;
		case 5:
			DropDown.selectByIndex(0);
			break;
		case 6:
			Assert.assertEquals(DropDown.getFirstSelectedOption().getText(), "Position");
			break;
		case 7:
			 Assert.assertEquals(DropDown.getOptions().size(), "3");
			break;
		}
	  }
	  
  }
  
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver","/Users/dxcv/git/Selenium_Khanh/chromedriver");
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
