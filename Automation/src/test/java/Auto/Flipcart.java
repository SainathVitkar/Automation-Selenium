package Auto;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Flipcart 
{

	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\vitka\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		
		String parent=driver.getWindowHandle();
		
		String elements=driver.getPageSource();
		System.out.println(elements);
		
		String title=driver.getTitle();
		System.out.println(title);
		
		driver.findElement(By.xpath("//input[@type='text' and @class='_2IX_2- VJZDxU']")).sendKeys("vitkarsai@gmail.com");
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//input[@class='_2IX_2- _3mctLh VJZDxU']")).sendKeys("9130093695");
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2HKlqd _3AWRsL']")).click();
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//input[@title='Search for products, brands and more']")).sendKeys("iphone 13");
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//input[@title='Search for products, brands and more']")).sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//div[contains(text(),'APPLE iPhone 13 (Blue, 128 GB)')]")).click();
		Thread.sleep(5000);
		
		Set<String> s=driver.getWindowHandles();
		
		for(String x:s)
		{
			driver.switchTo().window(x);
		}
		
		String text=driver.findElement(By.xpath("//div[@class='_30jeq3 _16Jk6d']")).getText();
		System.out.println(text);
		Thread.sleep(5000);
		
		List<WebElement>ss=driver.findElements(By.xpath("//div[@class='_2418kt']/ul/li"));
		
		for(WebElement a: ss)
		{
			String b=a.getAttribute("Class");
			System.out.println(b);
			String c=a.getText();
			System.out.println(c);
		}
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//button[@type='button']")).click();
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//button[@class='_2KpZ6l RLM7ES _3AWRsL']")).click();
		Thread.sleep(5000);
		
		JavascriptExecutor jb=(JavascriptExecutor) driver;
		jb.executeScript("window,scrollBy(0,250)", "");
		
		driver.findElement(By.xpath("//span[@id='to-payment']/button")).click();
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//button[contains(text(),'Accept & Continue')]")).click();
		Thread.sleep(5000);
		
		driver.switchTo().window(parent);
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//div[@class='KK-o3G']")).click();
		Thread.sleep(5000);
		
		JavascriptExecutor js=(JavascriptExecutor) driver;
		jb.executeScript("window,scrollBy(0,550)", "");
		
		driver.findElement(By.xpath("//div[contains(text(),'Remove')]")).click();
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("(//div[contains(text(),'Remove')])[2]")).click();
		Thread.sleep(5000);
		

	}

}
