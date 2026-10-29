package Tests;
import org.openqa.selenium.firefox.FirefoxDriver;

import Pages.loginpage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import java.util.concurrent.TimeUnit;
import Pages.securepage;

public class loginTest {

	public static void main(String[] args)
	{
		System.setProperty("webdriver.gecko.driver", "C://selenium//geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://the-internet.herokuapp.com/login");
		loginpage loginpage  = new loginpage(driver);
		loginpage.login("tomsmith", "SuperSecretPassword!");
		String message = loginpage.getResultMessage();
		System.out.println("Message :" + message);
		if(message.contains("You logged into a secure area!"))
		{
			System.out.println("Test Passed");
		}
		else
		{
			System.out.println("Test Failed");
		}
		
		securepage securepage = new securepage(driver);
		securepage.headertext();
		securepage.clicklogout();
		driver.quit();
		
	}
}
