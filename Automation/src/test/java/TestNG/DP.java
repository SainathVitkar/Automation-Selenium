package TestNG;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DP 
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
		driver.get("https://www.mercurytravels.co.in/");
		Thread.sleep(3000);
	}
	
	
	@BeforeClass
	public void maximize() throws InterruptedException
	{
		driver.manage().window().maximize();
		Thread.sleep(3000);
	}
	
	@BeforeMethod
	public void getcookies()
	{
		System.out.println("getcookies");
	}
	
	@Test(dataProvider = "datap")
	public void login(String email, String pass) throws InterruptedException
	{
		driver.findElement(By.xpath("(//a[@data-toggle='dropdown'])[4]")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("(//a[@data-target=\'#modalLogin\'])[2]")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.id("sign_user_email")).sendKeys(email);
		Thread.sleep(3000);
		
		driver.findElement(By.id("sign_user_password")).sendKeys(pass);
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//button[contains(text(),'Log in')]")).click();
		Thread.sleep(10000);
		
		String title=driver.getTitle();
		System.out.println(title);
		
		if(driver.getTitle().contentEquals("Invalid Details"))
		{
			driver.findElement(By.id("modalMsg")).click();
		}
		else
		{
		driver.findElement(By.xpath("(//a[@data-toggle='dropdown'])[6]")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("(//a[@href='https://www.mercurytravels.co.in/b2c/logout'])[2]")).click();
		Thread.sleep(5000);
		
		System.out.println("Logout Successfully");
		}
		
	}
	
	 @DataProvider
	  public Object[][] datap() 
	 {
	    return new Object[][] {
	      new Object[] { "vitkarsai@gmail.com", "Sai@1234567" },
	      new Object[] { "vitkarsai@gmail.com", "Sai@123456" },
	    };
	  }


	
	@AfterMethod
	public void getscreenshot() throws IOException
	{
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyToDirectory(src,new File("C:\\Users\\vitka\\git\\repository\\Automation\\Sai"));
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
	public void closebrowser() throws InterruptedException
	{
		driver.close();
		Thread.sleep(3000);
	}
	
	

}
