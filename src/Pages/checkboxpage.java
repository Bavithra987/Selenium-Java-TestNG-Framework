package Pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;
import org.openqa.selenium.support.FindBys;

public class checkboxpage {
	
	WebDriver driver;
	
	@FindBys({@FindBy(xpath = "//input[@type='checkbox']")})
	List<WebElement>  checkboxElement;
	
	public checkboxpage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickAll()
	{
	    int c= checkboxElement.size();
		for(int i=0; i<c; i++)
		if(checkboxElement.get(i).isSelected() == false)
		{
			checkboxElement.get(i).click();
		}
		
	}
	public int getCheckBoxCount()
	{
		return checkboxElement.size();
	}
	public boolean isCheckBoxSelected(int index)
	{
		return checkboxElement.get(index).isSelected();
	}

}
