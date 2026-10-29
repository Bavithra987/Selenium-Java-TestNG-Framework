package googleWeather;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;


public class Fluentwait {

	public static void main(String[] args)
	{
		System.setProperty("webdriver.gecko.driver", "c:\\selenium\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://the-internet.herokuapp.com/login");
		Wait<WebDriver> fluentWait = new FluentWait<>(driver)
		        .withTimeout(Duration.ofSeconds(20))
		        .pollingEvery(Duration.ofSeconds(3))
		        .ignoring(NoSuchElementException.class);
		
		WebElement username = fluentWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
		username.sendKeys("tomsmith");
		WebElement password = fluentWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
		password.sendKeys("SuperSecretPassword!");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		WebElement message= fluentWait.until(ExpectedConditions.visibilityOfElementLocated(By.className("flash")));
		String actualmessage= message.getText();
		System.out.println("message: "+ actualmessage);
		if(actualmessage.contains("You logged into a secure area!"))
		{
			System.out.println("login successful");
		}
		else 
		{
			System.out.println("login failed");
		}
		driver.quit();
	}
}
