package Auto;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alert1 {

	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\vitka\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://demoqa.com/alerts");
		Thread.sleep(2000);
		driver.manage().window().maximize();
		
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

}
