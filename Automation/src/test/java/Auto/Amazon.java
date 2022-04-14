package Auto;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Amazon {

	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\vitka\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.in/?&ext_vrnc=hi&tag=googhydrabk1-21&ref=pd_sl_5szpgfto9i_e&adgrpid=58075519359&hvpone=&hvptwo=&hvadid=486462777326&hvpos=&hvnetw=g&hvrand=5023588977990562738&hvqmt=e&hvdev=c&hvdvcmdl=&hvlocint=&hvlocphy=1007788&hvtargid=kwd-64107830&hydadcr=14452_2154371&gclid=Cj0KCQjw0PWRBhDKARIsAPKHFGi80hji6lfANXlbTta_8nhpX2aXYcyfVFDTveYKQYkmvCEeJMhwYTIaAmoHEALw_wcB");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		
		String title=driver.getTitle();
		System.out.println(title);
		
		String url=driver.getCurrentUrl();
		System.out.println(url);
		
		int count=driver.findElements(By.tagName("a")).size();
		System.out.println(count);
		
		String s=driver.findElement(By.xpath("//h2[contains(text(),'Amazon Pay | Book your travel tickets')]")).getText();
		System.out.println(s);
		
		driver.findElement(By.xpath("//span[contains(text(),'Hello, Sign in')]")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("vitkarsai@gmail.com");
		Thread.sleep(2000);

		driver.findElement(By.xpath("//input[@id='continue']")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("9130093695");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@id='signInSubmit']")).click();
		Thread.sleep(2000);
		
		//driver.findElement(By.xpath("(//a[contains(text(),'Amazon Pay')])[1]")).click();
		
		//driver.findElement(By.xpath("(//span[@class='image-footer-text-desktop'])[7]")).click();
		
		//driver.findElement(By.xpath("//a[contains(text(),'How to use Amazon Pay balance?')]")).click();
		
		//String a=driver.findElement(By.xpath("//img[@alt='hOW TO ADD']")).getText();
		//System.out.println(a);
	}

}
