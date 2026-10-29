package googleWeather;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import java.util.List;

public class DropdownTest {

	public static void main(String[] ags)
	{
		System.setProperty("webdriver.gecko.driver", "C:\\selenium\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://the-internet.herokuapp.com/dropdown");
		WebElement dropdownElement = driver.findElement(By.id("dropdown"));
        Select dropdown = new Select(dropdownElement);
		dropdown.selectByValue("1");
		System.out.println("selected option " + dropdown.getFirstSelectedOption().getText());
		Select dropdown1 = new Select(driver.findElement(By.id("dropdown")));
		dropdown1.selectByValue("2");
		System.out.println("selected option " + dropdown1.getFirstSelectedOption().getText());
		System.out.println("boleen "+ dropdown.isMultiple());
		List <WebElement> options = dropdown.getOptions();
		for(WebElement option : options)
		{
			System.out.println("list "+ option.getText());
		}
		
		driver.quit();
	}
}
