package Tests;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.WebDriver;
import Pages.dropdownpage;
import java.util.concurrent.TimeUnit;


public class dropdowntest {

	public static void main(String[] args)
	{
		System.setProperty("webdriver.gecko.driver", "C://selenium//geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.get("https://the-internet.herokuapp.com/dropdown");
		dropdownpage dropdownpage = new dropdownpage(driver);
		dropdownpage.selectByText("Option 1");
		System.out.println("Selcted option : " + dropdownpage.getSelectedOption());
		dropdownpage.selectByIndex(2);
		System.out.println("Selcted option : " + dropdownpage.getSelectedOption());
		driver.quit();
	}
}

