package Auto;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test {

	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\vitka\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://demoqa.com/automation-practice-form");
		Thread.sleep(2000);
		driver.manage().window().maximize();
		
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
		
		driver.findElement(By.xpath("//label [@for=\'hobbies-checkbox-1\']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//label [@for='hobbies-checkbox-2']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//label [@for='hobbies-checkbox-3']")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("uploadPicture")).sendKeys("C:\\Users\\vitka\\Downloads\\Sainath Vitkar.docx");
		Thread.sleep(1000);
		driver.findElement(By.id("currentAddress")).sendKeys("Shivajinagar,Pune");
		Thread.sleep(1000);
		
		js.executeScript("window,scrollBy(0,250)", "");
		
		driver.findElement(By.xpath("//div[contains(text(),'Select State')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[contains(text(),'Uttar Pradesh')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[contains(text(),'Select City')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[contains(text(),'Agra')]")).click();
		
		Thread.sleep(2000);
		

	}

}
