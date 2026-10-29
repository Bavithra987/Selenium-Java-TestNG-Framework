package googleWeather;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

public class Waittest {
	public static void main(String[] args)
	{
		System.setProperty("webdriver.gecko.driver", "C:\\selenium\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		driver.get("https://the-internet.herokuapp.com/login");
		WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
		username.sendKeys("tomsmith");
		WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
		password.sendKeys("SuperSecretPassword!");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("flash")));
		String actualmessage = message.getText();
		System.out.println("displays : "+actualmessage);
		if(actualmessage.contains("You logged into a secure area!"))
		{
			System.out.println("Login Successful");
		}
		else 
			{
			System.out.println("Login Failed");
			
			}
		driver.quit();
		
	}

}
