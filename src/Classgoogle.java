import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Classgoogle
{
	public static void main(String[] args) throws InterruptedException 
	{
		// TODO Auto-generated method stub
 System.setProperty("webdriver.chrome.driver","C:\\selenium\\chromedriver.exe");
 WebDriver driver = new ChromeDriver();
 driver.get("https://google.com");
 Thread.sleep(3000);
 String title = driver.getTitle();
 if(title.equals("google.com"))
 {
	 System.out.println("success");
	 }
 else
 {
	 System.out.println("failure");
 }
 driver.quit();
	}

}
