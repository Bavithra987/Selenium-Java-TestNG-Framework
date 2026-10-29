package Tests;
import Pages.checkboxpage;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;

public class checkboxtest {

	public static void main(String[] args)
	{
		System.setProperty("webdriver.gecko.driver", "C:\\selenium\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.get("https://the-internet.herokuapp.com/checkboxes");
		checkboxpage checkboxpage = new checkboxpage(driver);
		System.out.println("total checkbox count is : " + checkboxpage.getCheckBoxCount());
		System.out.println("status of checkbox 1 is : " + checkboxpage.isCheckBoxSelected(0));
		System.out.println("status of checkbox 2 is : " + checkboxpage.isCheckBoxSelected(1));
		checkboxpage.clickAll();
		System.out.println("After clickall status of checkbox 1 is : " + checkboxpage.isCheckBoxSelected(0));
		System.out.println("After clcikall status of checkbox 2 is : " + checkboxpage.isCheckBoxSelected(1));
		driver.quit();
	}
}
