package Auto;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Firfox {

	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\vitka\\Downloads\\geckodriver-v0.30.0-win32\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		
		driver.get("https://www.youtube.com/");
		
		Thread.sleep(3000);
	

	}

}
