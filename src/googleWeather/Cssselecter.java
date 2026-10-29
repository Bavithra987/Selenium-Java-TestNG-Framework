package googleWeather;
import org.openqa.selenium.WebDriver;
import io.restassured.RestAssured;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Cssselecter {

	public static void main(String[] args) throws InterruptedException
	{
		System.setProperty("webdriver.gecko.driver", "c:\\selenium\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://the-internet.herokuapp.com/login");
		driver.findElement(By.cssSelector("#username")).sendKeys("tomsmith");
		driver.findElement(By.cssSelector("#password")).sendKeys("SuperSecretPassword");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(5000);
		WebElement message = driver.findElement(By.xpath("//div[contains(@class,'flash')]"));
		String actualmessage = message.getText();
		System.out.println("message is :" + actualmessage);
		if(actualmessage.contains("You logged into a secure area!"))
		{
			System.out.println("Login Succesful");
		}
		else
		{
			System.out.println("Login Failed");
		}
		driver.quit();
	}
}

