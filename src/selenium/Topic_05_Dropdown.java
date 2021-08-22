package selenium;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class Topic_05_Dropdown {
	WebDriver driver;
	WebDriverWait waitExplicit;
	JavascriptExecutor javascriptExecutor;

  @Test(enabled=false)
public void Testcase_01_Default_Dropdown() throws Exception {
//	  step 2: kiễm tra xem dropdown có multi hay không
//	  step 3: chọn giá trị trong dropdown bằng SelectVisible
//	  Step 4: kiễm tra giá trị đã được chọn thành công
//	  step 5: chọn giá trị trong dropdown bằng SelectValue
//	  Step 6: kiễm tra giá trị đã được chọn thành công
//	  step 7: chọn giá trị trong dropdown bằng SeleIntdex
//	  Step 8: kiễm tra giá trị đã được chọn thành công
//	  Step 9: kiễm tra dropdown co tao bao nhieu gia tri
	  driver.get("http://live.demoguru99.com/");
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
			 Assert.assertEquals(DropDown.getOptions().size(), 3);
			break;
		}
	  }
	  
  }
  
  @Test
  public void Testcase_02_handle_Dropdownlist() throws Exception {
	  driver.get("https://jqueryui.com/resources/demos/selectmenu/default.html");
	Select_Item_Dropdownlist("(//span[@role='combobox'])[3]", "//ul[@id='number-menu']//li[@class='ui-menu-item']/div", "15");  
	Assert.assertEquals(driver.findElement(By.xpath("//span[@id='number-button']//span[@class='ui-selectmenu-text']")).getText(), "15");
	
  }
// sử dụng cho mọi dropdown Còn Select chỉ sử dụng cho default 
  public void Select_Item_Dropdownlist(String parentXpath, String allItemXpath, String ItemValue) throws Exception {
//	  click vao dropdown de show ra item
	  javascriptExecutor = (JavascriptExecutor) driver;
//	  sử dụng khi nút cần click không hiển thị trên màn hình phải kéo xuống mới thấy
	  javascriptExecutor.executeScript("arguments[0].click();", By.xpath(parentXpath));
//	  driver.findElement(By.xpath(parentXpath)).click();
	  
//	  đợi all webelement LstAllItem is load trong 30
	  waitExplicit = new WebDriverWait(driver, 30);
	  waitExplicit.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(allItemXpath)));
	  List <WebElement> LstAllItem = driver.findElements(By.xpath(allItemXpath));
//	  đợi cho 1 element xuất 
//	  waitExplicit.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ItemXpathValue)));
//		Tạo Webelement Item cho chạy hết tuần tự trong cái List Webelement LstAllItem.
	  for(WebElement Item : LstAllItem) {
		  if(Item.getText().equals(ItemValue)) {
//			  scroll đến cái xpath chưá value là: ItemValue
			  javascriptExecutor = (JavascriptExecutor) driver;
			  javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", Item);
			  Thread.sleep(1500);
//			  click vao item can chon
			  Item.click();
//			  neu xpath Item khong visibal thi su dung ham click javascrips
			  break;
		  }
	  }
  }
// lưu ý:element bat the input
 public void funcCheckToCheckBox(WebElement element) {
	 if(!element.isSelected()) {
		 if(element.isDisplayed()) {
			 element.click();
		 }else {
			 javascriptExecutor.executeScript("arguments[0].click();", element); 
		 }
	 }
 }
 
@Test
public void funcExcuteWithAlert() {
//	 Alert là do trình duyệt sinh ra, pop-up là app sinh ra.
	Alert alert = driver.switchTo().alert();
	alert.accept(); //	click ok, confirm
	alert.dismiss();// click cancel
	alert.getText(); // lay text dung verify
	alert.sendKeys("ad"); // dung de senkeys vao alert
//	đối với Alert Authen truyền trên url username pass vào.
	 driver.get("https://jqueryui.com/resources/demos/selectmenu/default.html");
	 driver.get("https://admin:admin1@jqueryui.com/resources/demos/selectmenu/default.html");
//	 with admin là user, admin1 là password
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
