package googleWeather;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class radiobutton {
 public static void main(String[] args)
 {
	 System.setProperty("webdriver.gecko.driver", "C:\\selenium\\geckodriver.exe");
	 WebDriver driver = new FirefoxDriver();
	 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 driver.get("https://demoqa.com/radio-button");
	 WebElement radio = driver.findElement(By.id("yesRadio"));
	 radio.click();
	 System.out.println("is yes radio button selected " + radio.isSelected());
	 driver.findElement(By.id("impressiveRadio")).click();
	 System.out.println("is impressive radio button selected " + driver.findElement(By.id("impressiveRadio")).isSelected());
	 System.out.println("After selection");
	 System.out.println("is yes radio button still selected " + driver.findElement(By.id("yesRadio")).isSelected());
	 System.out.println("is impressive radio button still selected " + driver.findElement(By.id("impressiveRadio")).isSelected());
	 driver.quit();
 }
}
