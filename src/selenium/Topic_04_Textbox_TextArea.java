package selenium;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class Topic_04_Textbox_TextArea {
	WebDriver driver;
	By customerName = By.xpath("//input[@type='text' and @name='name']");
	By gender = By.xpath("//input[@type='radio' and @value='m']");
	By dateOfBirth = By.xpath("//input[@type='date']");
	By address = By.xpath("//textarea[@name='addr']");
	By city = By.xpath("//input[@name='city']");
	By state = By.xpath("//input[@name='state']");
	By PIN = By.xpath("//input[@name='pinno']");
	By mobileNumber = By.xpath("//input[@name='telephoneno']");
	By email = By.xpath("//input[@name='emailid']");
	By passWord = By.xpath("//input[@name='password']");
	String customerName_value, dOb_value, address_value,city_value, state_value, Pin_value, moblieNumber_value, email_value, passWord_value;
	
  @Test
public void Testcase_01_login() {
	  driver.findElement(By.xpath("//input[@name='uid']")).sendKeys("mngr330604");
	  driver.findElement(By.xpath("//input[@name='password']")).sendKeys("yhesahE");
	  driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
	  //verify home page
	  Assert.assertTrue(driver.findElement(By.xpath("//marquee[@class='heading3' and text()=\"Welcome To Manager's Page of Guru99 Bank\"] ")).isDisplayed());
	  driver.findElement(By.xpath("//li//a[text()='New Customer']")).click();
	  

  }
  @Test
public void Testcase_02_create_customer() {
	  Assert.assertTrue(driver.findElement(By.xpath("//p[@class='heading3' and text()='Add New Customer']")).isDisplayed());
	  //map value
	  customerName_value = "Khanh";
	  dOb_value = "10/10/1993";
	  address_value = "123 nguyen huu tho Phuong 13 Quan 7";
	  city_value = "Ho Chi Minh";
	  state_value = "Quan";
	  Pin_value =  "123456";
	  moblieNumber_value = "0987612345";
	  email_value = "Khanh" + random() + "@gamail.com"; 
	  passWord_value = "123abc";
	  
	  //input data
	  driver.findElement(customerName).sendKeys(customerName_value);
	  driver.findElement(gender).click();
	  driver.findElement(dateOfBirth).sendKeys(dOb_value);
	  driver.findElement(address).sendKeys(address_value);
	  driver.findElement(city).sendKeys(city_value);
	  driver.findElement(state).sendKeys(state_value);
	  driver.findElement(PIN).sendKeys(Pin_value);
	  driver.findElement(mobileNumber).sendKeys(moblieNumber_value);
	  driver.findElement(email).sendKeys(email_value);
	  driver.findElement(passWord).sendKeys(passWord_value);
	  driver.findElement(By.xpath("//input[@type='submit' and @name='sub']")).click();
	  //verify data get
	  Assert.assertTrue(driver.findElement(By.xpath("//p[@class='heading3' and text()='Customer Registered Successfully!!!']")).isDisplayed());
	  Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Customer Name']//following-sibling::td")).getText(), customerName_value);
	  Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Gender']//following-sibling::td")).getText(), "male");
	  Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Birthdate']//following-sibling::td")).getText(), "1993-10-10");
	  Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Address']//following-sibling::td")).getText(), address_value);
	  Assert.assertEquals(driver.findElement(By.xpath("//td[text()='City']//following-sibling::td")).getText(), city_value);
	  Assert.assertEquals(driver.findElement(By.xpath("//td[text()='State']//following-sibling::td")).getText(), state_value);
	  Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Pin']//following-sibling::td")).getText(), Pin_value);
	  Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Mobile No.']//following-sibling::td")).getText(), moblieNumber_value);
	  Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Email']//following-sibling::td")).getText(), email_value);
	  
	  
			  

  }
  
  public int random() {
	  Random random = new Random();
	  int number_random = random.nextInt(9999);
	  System.out.println("gia tri so duoc random"+ number_random);
	return number_random;
  }
  
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver","D:\\Selenium\\Windows OS\\chromedriver_win32\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  driver.manage().window().maximize();
	  driver.get("http://demo.guru99.com/v4/");
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
	  
  }

}
