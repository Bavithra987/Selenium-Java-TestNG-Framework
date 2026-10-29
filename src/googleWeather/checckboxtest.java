package googleWeather;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class checckboxtest {

	public static void main(String[] args)
	{
		System.setProperty("webdriver.gecko.driver", "C:\\selenium\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://the-internet.herokuapp.com/checkboxes");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		List<WebElement> checkbox = driver.findElements(By.xpath("//input[@type='checkbox']"));
		System.out.println("Size of the checkbox "+ checkbox.size());
	    System.out.println("is checkbox1 selected " +checkbox.get(0).isSelected());
	    System.out.println("is checkbox1 selected " +checkbox.get(1).isSelected());
	    checkbox.get(0).click();
	    checkbox.get(1).click();
	    System.out.println("is checkbox1 selected " +checkbox.get(0).isSelected());
	    System.out.println("is checkbox1 selected " +checkbox.get(1).isSelected());
		driver.quit();
		}
}
