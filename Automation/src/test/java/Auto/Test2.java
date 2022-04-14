package Auto;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Test2 
{
	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\vitka\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.mercurytravels.co.in/");
		driver.manage().window().maximize();
		
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

}
