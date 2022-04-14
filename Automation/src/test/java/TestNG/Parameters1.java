package TestNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;


public class Parameters1 
{
WebDriver driver;
	
	@BeforeSuite
	@Parameters("Browser")
	public void OpenBrowser(String browser)
	{
		if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\vitka\\Downloads\\chromedriver_win32\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\vitka\\Downloads\\geckodriver-v0.30.0-win32\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		
		System.out.println("OpenBrowser");
	}
	
	@BeforeTest
	public void geturl()
	{
		driver.get("https://www.flipkart.com/");
	}
	
	@BeforeClass
	public void Maximize_Browser() throws InterruptedException
	{
		driver.manage().window().maximize();
		Thread.sleep(1000);
	}
	
	@BeforeMethod
	public void getcookies()
	{
		System.out.println("getCookies");
	}
	
	@Parameters({"emailid","password"})
	
	@Test
	public void Login(String email, String Pass) throws Exception
	{
		String parent=driver.getWindowHandle();
		
		String elements=driver.getPageSource();
		System.out.println(elements);
		
		String title=driver.getTitle();
		System.out.println(title);
		
		driver.findElement(By.xpath("//input[@type='text' and @class='_2IX_2- VJZDxU']")).sendKeys(email);
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//input[@class='_2IX_2- _3mctLh VJZDxU']")).sendKeys(Pass);
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2HKlqd _3AWRsL']")).click();
		Thread.sleep(5000);
		
		
	}
	
	@AfterMethod
	public void getscreenshot()
	{
		System.out.println("SS");
	}
	
	@AfterClass
	public void deletcookies()
	{
		System.out.println("deletcookies");
	}
	
	@AfterTest
	public void dbconnectionclosed()
	{
		System.out.println("dbconnectionclosed");
	}
	
	@AfterSuite
	public void closed_browser()
	{
		driver.close();
	}

}
