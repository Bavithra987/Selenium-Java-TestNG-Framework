package Tests;
import Pages.loginpage;
import Pages.securepage;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class loginTestNG {
	
      WebDriver driver;
      loginpage loginpage;
      
      @BeforeMethod
      public void setUP()
      {
    	  System.setProperty("webdriver.gecko.driver", "C:\\selenium\\geckodriver.exe");
    	  driver = new FirefoxDriver();
    	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	  driver.get("https://the-internet.herokuapp.com/login");
    	  loginpage = new loginpage(driver);
    	  System.out.println("Browser Opened");
      }
      
      @Test(priority=0)
      public void titleTest()
      {
    	  String actualTitle = driver.getTitle();
    	  System.out.println("Actual title is: " + actualTitle); 
    	  String expectedTitle = "The Internet";
    	  Assert.assertEquals(actualTitle, expectedTitle, "Title Mismatch! Got :"+ actualTitle);
    	  System.out.println("Title test passed");
      }
      
      @Test (priority =1)
      public void validloginTest()
      {
    	  loginpage.login("tomsmith", "SuperSecretPassword!");
    	  String message = loginpage.getResultMessage();
    	  Assert.assertTrue(message.contains("You logged into a secure area!"), "Login failed - message was:" + message);
    	  System.out.println("valid login test passed");
      }
      
      @Test (priority = 2)
      public void invalidloginTest()
      {
    	  loginpage.login("tomsmith1", "SuperSecretPassword");
    	  String message = loginpage.getResultMessage();
    	  Assert.assertTrue(message.contains("Your username is invalid"), "Expected invalid login message but got : " + message);
    	  System.out.println("Invalid login test passed");
      }
      @AfterMethod
      public void tearDown()
      {
          driver.quit();
          System.out.println("Browser Closed");
      }
}
