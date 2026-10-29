package googleWeather;
import java.util.Set;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Alert;
import java.util.concurrent.*;

public class windowtest {

	public static void main(String[] args) throws InterruptedException
	{
		System.setProperty("webdriver.gecko.driver", "C:\\selenium\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://the-internet.herokuapp.com/windows");
		String mainwindow= driver.getWindowHandle();
		System.out.println("Mainwindow handle is "+ mainwindow);
		driver.findElement(By.xpath("//a[@href='/windows/new']")).click();
		Set<String> allwindows = driver.getWindowHandles();
		System.out.println("Size of window handles is "+ allwindows.size());
		 for (String window : allwindows)
		 {
	            if (!window.equals(mainwindow))
	            {
	                driver.switchTo().window(window);
	                Thread.sleep(2000);
	                System.out.println("new window handles is "+ driver.getWindowHandle());
	                System.out.println("Current url "+ driver.getCurrentUrl());
	                driver.close();
	                break;
	            }
	            
		 }
		 driver.switchTo().window(mainwindow);
		 System.out.println("Current url "+ driver.getCurrentUrl());
		driver.quit();
		
	}
}
