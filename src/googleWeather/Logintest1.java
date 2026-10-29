package googleWeather;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class Logintest1 {

	public static void main (String[] args) throws InterruptedException
	{
		System.setProperty("webdriver.gecko.driver", "c:\\selenium\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://the-internet.herokuapp.com/login");
		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys("tomsmith");
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("SuperSecretPassword");
		driver.findElement(By.className("radius")).click();
		Thread.sleep(5000);
		WebElement message = driver.findElement(By.className("flash"));
		String actualmessage = message.getText();
		System.out.println("Actual message is :"+ actualmessage);
		if(actualmessage.contains("You logged into a secure area!"))
		{
			System.out.println("Login Successful");
		}
		else 
		{
			System.out.println("Login Failed");
		}
		
        System.out.println("page title is : "+ driver.getTitle());
		driver.quit();
	}
}
