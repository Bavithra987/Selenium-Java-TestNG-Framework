package Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginpage {

	WebDriver driver;
	@FindBy(id = "username")
	WebElement usernameField;
	@FindBy(id= "password")
	WebElement passwordField;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement loginButton;
	@FindBy(className = "flash")
	WebElement flashMessage;
	public loginpage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void enterUsername (String username)
	{
		usernameField.sendKeys(username);
	}
	public void enterPassword (String password)
	{
		passwordField.sendKeys(password);
		
	}
	public void clicklogin()
	{
		loginButton.click();
	}
	public void login(String username, String password)
	{
		enterUsername(username);
		enterPassword(password);
		clicklogin();
	}
	public String getResultMessage()
	{
		return flashMessage.getText();
	}
}
