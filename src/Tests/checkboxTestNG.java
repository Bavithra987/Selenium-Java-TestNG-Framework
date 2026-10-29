package Tests;
import Pages.checkboxpage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class checkboxTestNG {
	
	  WebDriver driver;
	  checkboxpage checkboxPage;
	
@BeforeMethod
public void setUp()
{
	System.setProperty("webdriver.gecko.diver", "C://selenium//geckodriver.exe");
	WebDriver driver = new FirefoxDriver();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.get("https://the-internet.herokuapp.com/checkboxes");
	checkboxPage = new checkboxpage(driver);
	System.out.println("Browser opened");
	}

@Test(priority =1)
public void CheckboxCountTest()
{
	int count = checkboxPage.getCheckBoxCount();
    Assert.assertEquals(count, 2, "Checkbox count mismatch!");
    System.out.println("Checkbox count is: " + count);
}
@Test(priority =2)
public void checkboxStatusTest()
{
	Assert.assertFalse(checkboxPage.isCheckBoxSelected(0),
            "Checkbox 1 should be unchecked by default!");
        Assert.assertTrue(checkboxPage.isCheckBoxSelected(1),
            "Checkbox 2 should be checked by default!");
        System.out.println("Checkbox status verified");
	}

@Test(priority = 3)
public void checkAllTest() {
	
	 try {
	        Thread.sleep(2000);  // wait 2 seconds for page to stabilize
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }
    checkboxPage.clickAll();
    Assert.assertTrue(checkboxPage.isCheckBoxSelected(0),
        "Checkbox 1 should be checked after clickAll!");
    Assert.assertTrue(checkboxPage.isCheckBoxSelected(1),
        "Checkbox 2 should be checked after clickAll!");
    System.out.println("All checkboxes checked successfully");
}

@AfterMethod
public void tearDown() {
    if(driver!= null)
    	{
    	driver.quit();
    	}
    
    System.out.println("Browser Closed");
}
}
