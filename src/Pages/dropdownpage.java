package Pages;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.support.pagefactory.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebDriver;

public class dropdownpage {

	WebDriver driver;
	
	@FindBy(id="dropdown")
	WebElement dropdownElement;
	
	public dropdownpage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void selectByText(String text)
	{
		Select dropdown = new Select(dropdownElement);
		dropdown.selectByVisibleText(text);
	}
	public void selectByIndex(int index)
	{
		Select dropdown = new Select(dropdownElement);
		dropdown.selectByIndex(index);
	}
	public String getSelectedOption()
	{
		Select dropdown = new Select(dropdownElement);
		return dropdown.getFirstSelectedOption().getText();
	}
}

