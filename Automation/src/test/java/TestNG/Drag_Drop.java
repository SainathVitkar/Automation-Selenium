package TestNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;


public class Drag_Drop 
{
	WebDriver driver;

	@BeforeSuite
	@Parameters("browser")
	public void OpenBrowser(String browser)throws Exception
	{
		if(browser.equalsIgnoreCase("gecko"))
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\vitka\\Downloads\\geckodriver-v0.30.0-win32\\geckodriver.exe");
			WebDriver driver=new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("chrome"))
		{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\vitka\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		System.out.println("OpenBrowser");
		}
	}
	
	@BeforeTest
	public void geturl() throws InterruptedException
	{
		driver.get("https://demoqa.com/droppable");
		Thread.sleep(3000);
	}
	
	@BeforeClass
	public void maximize_browser() throws InterruptedException
	{
		driver.manage().window().maximize();
		Thread.sleep(3000);
	}
	
	@BeforeMethod
	public void get_cookies()
	{
		System.out.println("get_cookies");
	}
	
	@Test 
	public void ZMY() throws InterruptedException
	{
		driver.findElement(By.id("droppableExample-tab-simple")).click();
		WebElement drag=driver.findElement(By.id("draggable"));
		WebElement drop=driver.findElement(By.id("droppable"));
		
		Actions a=new Actions(driver);
		a.dragAndDrop(drag, drop).build().perform();
		Thread.sleep(3000);
		
		driver.findElement(By.id("droppableExample-tab-accept")).click();
		Thread.sleep(2000);
		System.out.println("ZMY");
		
	}
	
	@Test 
	public void ABCD() throws InterruptedException
	{
		driver.findElement(By.id("droppableExample-tab-simple")).click();
		
		WebElement drag=driver.findElement(By.id("draggable"));
		WebElement drop=driver.findElement(By.id("droppable"));
		
		Actions a=new Actions(driver);
		a.dragAndDrop(drag, drop).build().perform();
		Thread.sleep(3000);
		
		driver.findElement(By.id("droppableExample-tab-accept")).click();
		Thread.sleep(2000);
		System.out.println("ABCD");
		
	}
	
	@Test 
	public void KKK() throws InterruptedException
	{
		driver.findElement(By.id("droppableExample-tab-simple")).click();
		
		WebElement drag=driver.findElement(By.id("draggable"));
		WebElement drop=driver.findElement(By.id("droppable"));
		
		Actions a=new Actions(driver);
		a.dragAndDrop(drag, drop).build().perform();
		Thread.sleep(3000);
		
		driver.findElement(By.id("droppableExample-tab-accept")).click();
		Thread.sleep(2000);
		System.out.println("KKK");
		
	}
		
	
	@AfterMethod
	public void get_screenshot() throws IOException
	{
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyToDirectory(src,new File("C:\\Users\\vitka\\git\\repository\\Automation\\Sai"));
	}
	
	@AfterClass
	public void delet_cookies()
	{
		System.out.println("Delet_cookies");
	}
	
	@AfterTest
	public void dbconnectionclosed()
	{
		System.out.println("dbconnection closed");
	}
	
	@AfterSuite
	public void close_browser()
	{
		driver.close();
		System.out.println("Close broser");
	}

}
