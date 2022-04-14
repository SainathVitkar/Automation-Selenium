package TestNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class iFrame 
{
	WebDriver driver;
	@BeforeSuite
	public void openbrwoser()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\vitka\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		System.out.println("OpenBrowser");
	}
		
	@BeforeTest
	public void geturl()
	{
		driver.get("http://demo.automationtesting.in/Frames.html");
	}
		
	@BeforeClass
	public void maximize()
	{
		driver.manage().window().maximize();
		System.out.println("maximize");
	}
	
	@BeforeMethod
	public void getcookies()
	{
		System.out.println("getcookies");
	}
		
	@Test
	public void login() throws InterruptedException
	{
		String title=driver.getTitle();
			
		System.out.println(title);
			
		driver.findElement(By.linkText("Iframe with in an Iframe")).click();	
		Thread.sleep(3000);
	
		int count=driver.findElements(By.tagName("iframe")).size();	
		System.out.println(count);
	
		WebElement iframe2=driver.findElement(By.xpath("(//iframe[@style='float: left;height: 300px;width:600px'])"));	
		driver.switchTo().frame(iframe2);
		Thread.sleep(3000);
			
		WebElement iframe1=driver.findElement(By.xpath("(//iframe[@style='float: left;height: 250px;width: 400px'])"));
			
		driver.switchTo().frame(iframe1);
		Thread.sleep(3000);
			
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Sainath");
		Thread.sleep(3000);
			
		driver.switchTo().defaultContent();
		Thread.sleep(3000);
			
		driver.findElement(By.xpath("//a[@href='#Single']")).click();
		Thread.sleep(3000);
			
	}
	
	@AfterMethod
	public void screenshot()
	{
		System.out.println("screenshot");
	}
		
	@AfterClass
	public void deletecookies()
	{
		System.out.println("deletecookies");
	}
		
	@AfterTest
	public void dbconnectionclosed()
	{
		System.out.println("dbconnectionclosed");
	}
		
	@AfterSuite
	public void closebroswer()
	{
		driver.close();
		System.out.println();
	}

}
