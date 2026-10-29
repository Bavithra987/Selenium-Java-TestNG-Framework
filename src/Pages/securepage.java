package Pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.*;


public class securepage {
     
	WebDriver driver;
	
	@FindBy (className ="subheader")
	WebElement pageHeader;
	@FindBy(xpath = "//a[@href='/logout']")
	WebElement logoutButton;
	
	public securepage (WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String headertext()
	{
		return pageHeader.getText();
	}
	public void clicklogout()
	{
		logoutButton.click();
	}
}
