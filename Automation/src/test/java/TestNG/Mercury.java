package TestNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

public class Mercury 
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
		driver.get("https://www.mercurytravels.co.in/");
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
		driver.findElement(By.xpath("(//input[@class='form-control ui-autocomplete-input'])[3]")).sendKeys("India");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@class='form-control ui-autocomplete-input'])[3]")).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		
		driver.findElement(By.id("dphh1")).click();
		Thread.sleep(2000);
		
		List<WebElement>wb=driver.findElements(By.xpath("//div[@class='datepicker dropdown-menu' and @style='display: block; top: 335.688px; left: 379.953px;']/div/table/tbody/tr/td"));
		
		for(WebElement x: wb)
		{
			String d=x.getAttribute("class");
			System.out.println(d);
			String s=x.getText();
			System.out.println(s);
			//Thread.sleep(1000);
			if(d.equalsIgnoreCase("day  active"))
			{
				JavascriptExecutor jb=(JavascriptExecutor) driver;
				jb.executeScript("arguments[0].click();", x);
			}	
		}
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//select[@name='nights']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//select[@name='nights']/option[3]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//select[@name='theme']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//select[@name='theme']/option[6]")).click();
		Thread.sleep(2000);
		
		//WebElement Select_duration=driver.findElement(By.xpath("//select[@name='nights']"));
		//Select s=new Select(Select_duration);
		//s.selectByVisibleText("3Nights+4Days");
		//Thread.sleep(2000);
		
		WebElement Submit=driver.findElement(By.xpath("//button[contains(text(),'SEARCH HOLIDAYS')]"));
		Submit.click();
		Thread.sleep(3000);
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
