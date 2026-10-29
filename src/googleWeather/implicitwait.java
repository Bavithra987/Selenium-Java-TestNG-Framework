package googleWeather;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

public class implicitwait {
	public static void main(String[] args)
	{
		System.setProperty("webdriver.gecko.driver", "C://Selenium//geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://the-internet.herokuapp.com/login");
		driver.findElement(By.id("username")).sendKeys("tomsmith");
		driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		WebElement message = driver.findElement(By.id("flash"));
		String actualmessage = message.getText();
		System.out.println("display message :"+ actualmessage);
		if(actualmessage.contains("You logged into a secure area!"))
		{
			System.out.println("Login Successful");
		}
		else
		{
			System.out.println("Login Failed");
		}
		driver.findElement(By.xpath("//a[@href='/logout']")).click();
		driver.quit();
	}
}
