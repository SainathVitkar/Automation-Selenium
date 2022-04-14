package TestNG;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class PriyaTest 
{
	WebDriver driver;
	@BeforeSuite
	public void openbrowser()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\vitka\\\\Downloads\\\\chromedriver_win32\\\\chromedriver.exe");
		driver=new ChromeDriver();
		System.out.println("Open Chrome");
		
	}
	
	@BeforeTest
	public void geturl()
	{
		driver.get("https://www.flipkart.com/");
		System.out.println("Get URL");
	}
	
	@BeforeClass
	public void maximize()
	{
		driver.manage().window().maximize();
		System.out.println("Maximize Screen");
	}
	
	@BeforeMethod
	public void get_cookies()
	{
		System.out.println("Get Cookies");
	}
	
	@Parameters({"mobilenumber","password"})
	
	@Test
	public void Flipcartlogin(String Number, String Pass) throws InterruptedException
	{
		driver.findElement(By.xpath("//input[@type='text' and @class='_2IX_2- VJZDxU']")).sendKeys(Number);
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//input[@class='_2IX_2- _3mctLh VJZDxU']")).sendKeys(Pass);
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2HKlqd _3AWRsL']")).click();
		Thread.sleep(5000);
	}
	
	@AfterMethod
	public void takescreenshot() throws IOException
	{
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyToDirectory(src, new File("C:\\Users\\vitka\\git\\repository\\Automation\\Sai"));
	}
	
	@AfterClass
	public void deletcookies()
	{
		System.out.println("Delet Cookies");
	}
	
	@AfterTest
	public void dbconnectionclosed()
	{
		System.out.println("DBCC");
	}
	
	@AfterSuite
	public void closebrowser()
	{
		//driver.close();
		System.out.println("Close Chrome");
	}

}
