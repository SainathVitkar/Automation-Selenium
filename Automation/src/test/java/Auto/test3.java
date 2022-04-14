package Auto;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class test3 
{
	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\vitka\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/admin/viewSystemUsers");
		driver.manage().window().maximize();
		Thread.sleep(10000);
		
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		Thread.sleep(3000);
		
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		Thread.sleep(3000);
		
		WebElement Select=driver.findElement(By.id("btnLogin"));
		Select.click();
		Thread.sleep(2000);
		
		driver.findElement(By.linkText("PIM")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.id("searchSystemUser_userName")).sendKeys("Admin");
		Thread.sleep(2000);
		
		WebElement User_Role=driver.findElement(By.id("searchSystemUser_userType"));
		Select s1=new Select(User_Role);
		s1.selectByVisibleText("Admin");
		Thread.sleep(2000);
		
		driver.findElement(By.id("searchSystemUser_employeeName_empName")).sendKeys("Royal King");
		Thread.sleep(2000);
		
		WebElement Status=driver.findElement(By.id("searchSystemUser_status"));
		Select s2=new Select(Status);
		s2.selectByVisibleText("Enabled");
		Thread.sleep(2000);
		
		WebElement sainath=driver.findElement(By.id("searchBtn"));
		sainath.click();
		Thread.sleep(5000);

	}

}
