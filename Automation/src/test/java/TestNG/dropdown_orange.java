package TestNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class dropdown_orange 
{
	WebDriver driver;
	@BeforeSuite
	public void OpenBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\vitka\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		System.out.println("OpenBrowser");
	}
	
	@BeforeTest
	public void geturl() throws InterruptedException
	{
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/admin/viewSystemUsers");
		Thread.sleep(10000);
	}
	
	@BeforeClass
	public void maximize_browser() throws InterruptedException
	{
		driver.manage().window().maximize();
		Thread.sleep(2000);
		System.out.println("maximize_browser");
	}
	
	@BeforeMethod
	public void getcookies()
	{
		System.out.println("getcookies");
	}
	
	@Test
	public void Login() throws InterruptedException
	{
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		Thread.sleep(3000);
		
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		Thread.sleep(3000);
		
		WebElement Select=driver.findElement(By.id("btnLogin"));
		Select.click();
		Thread.sleep(2000);
		
		driver.findElement(By.linkText("PIM")).click();
		Thread.sleep(2000);
		
		
		WebElement User_Role=driver.findElement(By.id("empsearch_employee_status"));
		Select s1=new Select(User_Role);
		s1.selectByVisibleText("Full-Time Permanent");
		Thread.sleep(2000);
		
		WebElement Status=driver.findElement(By.id("empsearch_sub_unit"));
		Select s2=new Select(Status);
		s2.selectByVisibleText("Engineering");
		Thread.sleep(2000);
		
	}
	
	@AfterMethod
	public void getscreenshot()
	{
		System.out.println("Screenshot");
	}
	
	@AfterClass
	public void deletcookies()
	{
		System.out.println("Delet cookies");
	}
	
	@AfterTest
	public void dbconnectionclosed()
	{
		System.out.println("dbconnectionclosed");
	}
	
	@AfterSuite
	public void closebrowser()
	{
		driver.close();
		System.out.println("Closed the browser");
	}

}
