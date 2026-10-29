package googleWeather;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class FirstTest {
    public static void main(String[] args) throws InterruptedException
    {
    	System.setProperty("webdriver.gecko.driver", "C:\\selenium\\geckodriver.exe");
    	WebDriver driver = new FirefoxDriver();
    	driver.get("https://www.google.com");
    	WebElement searchbox = driver.findElement(By.name("q"));
    	searchbox.sendKeys("selenium automation testing");
    	searchbox.submit();
    	Thread.sleep(3000);
    	System.out.println("Page title is: "+ driver.getTitle());
    	driver.quit();
    	
    }
}
