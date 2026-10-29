package googleWeather;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Alert;
import java.util.concurrent.*;

public class alerttest {

	public static void main(String[] args)
	{
		System.setProperty("webdriver.gecko.driver","C:\\selenium\\geckodriver.exe");
	    WebDriver driver = new FirefoxDriver();
	    driver.get("https://the-internet.herokuapp.com/javascript_alerts");
	    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	    driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
	    Alert alert = driver.switchTo().alert();
	    System.out.println("jsalert message pop up is " +alert.getText());
	    alert.accept();
	    System.out.println("Result: " + driver.findElement(By.id("result")).getText());
	    driver.findElement(By.xpath("//button[@onclick = 'jsConfirm()']")).click();
	    Alert alert1 = driver.switchTo().alert();
	    System.out.println("jsconfirm message pop up is " +alert1.getText());
	    alert1.accept();
	    System.out.println("Result: " + driver.findElement(By.id("result")).getText());
	    driver.findElement(By.xpath("//button[@onclick = 'jsConfirm()']")).click();
	    Alert alert2 = driver.switchTo().alert();
	    alert2.dismiss();
	    System.out.println("Result: " + driver.findElement(By.id("result")).getText());
	    driver.findElement(By.xpath("//button[@onclick = 'jsPrompt()']")).click();
	    Alert alert3 = driver.switchTo().alert();
	    alert3.sendKeys("I am bavithra");
	    System.out.println("jsconfirm message pop up is " +alert1.getText());
	    alert3.accept();
	    System.out.println("Result: " + driver.findElement(By.id("result")).getText());
	    driver.findElement(By.xpath("//button[@onclick = 'jsPrompt()']")).click();
	    Alert alert4 = driver.switchTo().alert();
	    alert4.sendKeys("I am bavithra");
	    System.out.println("jsconfirm message pop up is " +alert1.getText());
	    alert4.dismiss();
	    System.out.println("Result: " + driver.findElement(By.id("result")).getText());
	     driver.quit();
	    
	    
	}
}
