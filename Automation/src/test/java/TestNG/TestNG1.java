package TestNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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

public class TestNG1 
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
		driver.get("https://demoqa.com/automation-practice-form");
		Thread.sleep(2000);
		System.out.println("geturl");
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
		String text=driver.findElement(By.xpath("//div[@class='practice-form-wrapper']/h5")).getText();
		System.out.println(text);
		
		driver.findElement(By.id("firstName")).sendKeys("Sainath");
		driver.findElement(By.id("lastName")).sendKeys("Vitkar");
		Thread.sleep(2000);
		
		driver.findElement(By.id("userEmail")).sendKeys("vitkarsai@gmail.com");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//label[@for='gender-radio-1']")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("userNumber")).sendKeys("9130093695");
		Thread.sleep(2000);
		driver.findElement(By.id("dateOfBirthInput")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//select[@class='react-datepicker__year-select']/option[96]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//select[@class='react-datepicker__month-select']/option[5]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@aria-label='Choose Saturday, June 3rd, 1995']")).click();
		Thread.sleep(2000);
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window,scrollBy(0,250)", "");
		
		driver.findElement(By.xpath("//div[@class='subjects-auto-complete__value-container subjects-auto-complete__value-container--is-multi css-1hwfws3']")).sendKeys("English");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='subjects-auto-complete__value-container subjects-auto-complete__value-container--is-multi css-1hwfws3']")).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//label [@for='hobbies-checkbox-1']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//label [@for='hobbies-checkbox-2']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//label [@for='hobbies-checkbox-3']")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("uploadPicture")).sendKeys("C:\\Users\\vitka\\Downloads\\Sainath Vitkar.docx");
		Thread.sleep(2000);
		driver.findElement(By.id("currentAddress")).sendKeys("Shivajinagar,Pune");
		Thread.sleep(2000);
		
		js.executeScript("window,scrollBy(0,250)", "");
		
		driver.findElement(By.xpath("//div[contains(text(),'Select State')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[contains(text(),'Uttar Pradesh')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[contains(text(),'Select City')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[contains(text(),'Agra')]")).click();
		
		System.out.println("Coding");
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
