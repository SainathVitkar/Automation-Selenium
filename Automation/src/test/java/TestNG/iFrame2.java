package TestNG;

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

public class iFrame2 
{
	WebDriver driver;
	@BeforeSuite
	public void openbrowser()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\vitka\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		System.out.println("OpenBrowser");
		
	}
	
	@BeforeTest
	public void geturl() throws InterruptedException
	{
		driver.get("https://www.globalsqa.com/demo-site/frames-and-windows/#iFrame");
		Thread.sleep(3000);
	}
	
	@BeforeClass
	public void maximizebrowser() throws InterruptedException
	{
		driver.manage().window().maximize();
		Thread.sleep(3000);
	}
	
	@BeforeMethod
	public void getcookies()
	{
		System.out.println("Get_Cookies");
	}
	
	@Test
	public void login() throws InterruptedException
	{
		WebElement iframe3=driver.findElement(By.id("wrapper"));
		driver.switchTo().frame(iframe3);
		Thread.sleep(3000);
		
		WebElement iframe2=driver.findElement(By.xpath("(//div[@style='margin-top: 0px; margin-bottom: 0px;'])"));
		driver.switchTo().frame(iframe2);
		Thread.sleep(3000);
		
		WebElement iframe1=driver.findElement(By.xpath("(//div[@style='margin-top: 0px; margin-bottom: 0px;']/div[1])"));
		driver.switchTo().frame(iframe1);
		Thread.sleep(3000);
		
		WebElement Filter=driver.findElement(By.id("current_filter"));
		Select s=new Select(Filter);
		s.selectByVisibleText("AUTOMATION");
		Thread.sleep(3000);
		
	}
	
	@AfterMethod
	public void screenshot() throws IOException
	{
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyToDirectory(src,new File("C:\\Users\\vitka\\git\\repository\\Automation\\Sai"));
		
	}
	
	@AfterClass
	public void deletcookies()
	{
		System.out.println("Deletcookies");
	}
	
	@AfterTest
	public void dbconnectionclosed()
	{
		System.out.println("Dbconnection closed");
	}
	
	@AfterSuite
	public void closebrowser()
	{
		driver.close();
		System.out.println("Close Browser");
	}

	

}
