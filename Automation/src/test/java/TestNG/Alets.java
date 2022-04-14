package TestNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
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
import org.testng.annotations.Test;

public class Alets 
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
	public void geturl()
	{
		driver.get("https://demoqa.com/alerts");
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
		driver.findElement(By.id("alertButton")).click();
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		
		driver.findElement(By.id("confirmButton")).click();
		driver.switchTo().alert().dismiss();
		Thread.sleep(5000);
		
		driver.findElement(By.id("promtButton")).click();
		driver.switchTo().alert().sendKeys("qwertyuiop");
		Thread.sleep(5000);
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
