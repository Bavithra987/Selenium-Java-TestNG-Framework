package googleWeather;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Set;
import java.util.concurrent.*;
import org.openqa.selenium.support.ui.*;

public class Combinedboxes {

	public static void main(String[] args) throws InterruptedException
	{
		System.setProperty("webdriver.gecko.driver", "C:\\selenium\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://the-internet.herokuapp.com/");
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		System.out.println("Checking dropdown");
		driver.findElement(By.xpath("//a[@href='/dropdown']")).click();
		WebElement dropdownElement = driver.findElement(By.id("dropdown"));
		Select dropdown = new Select(dropdownElement);
		dropdown.selectByVisibleText("Option 2");
		System.out.println("Selected dropdown option "+ dropdown.getFirstSelectedOption().getText());
		driver.navigate().back();
		System.out.println("Checking checkbox");
		driver.findElement(By.xpath("//a[@href='/checkboxes']")).click();
		List <WebElement> checkbox = driver.findElements(By.xpath("//input[@type='checkbox']"));
	    checkbox.get(0).click();
	    checkbox.get(1).click();
		System.out.println("is Checkbox 1 selected "+ checkbox.get(0).isSelected());
		System.out.println("is Checkbox 2 selected "+ checkbox.get(1).isSelected());
		driver.navigate().back();
		System.out.println("Checking javscript alerts");
		driver.findElement(By.xpath("//a[@href='/javascript_alerts']")).click();
		driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		System.out.println("message is "+ driver.findElement(By.id("result")).getText());
		driver.navigate().back();
		System.out.println("Checking window handle");
		driver.findElement(By.xpath("//a[@href='/windows']")).click();
		String mainWindow = driver.getWindowHandle();
		System.out.println("first window handle is "+ mainWindow);
		driver.findElement(By.xpath("//a[@href='/windows/new']")).click();
		Set<String> allWindows = driver.getWindowHandles();
		for(String window: allWindows)
		{
			if(!window.equals(mainWindow))
			{
				driver.switchTo().window(window);
				System.out.println("new window handle is "+ driver.getWindowHandle());
				driver.close();
			}
		}
		
		driver.quit();
	}
}

