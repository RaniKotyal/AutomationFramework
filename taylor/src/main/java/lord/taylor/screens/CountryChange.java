package lord.taylor.screens;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import lord.taylor.testBase.TestBase;
import lord.taylor.utils.UserActions;

public class CountryChange extends TestBase

{
    WebDriver Wb;
    UserActions action=new UserActions();

	@FindBy(xpath="//li[@class='menu-item shipping']")
	private WebElement shipTo;
	
	@FindBy(xpath="//span[contains(text(),'Back to U.S. Site')]")
	private WebElement backToUS;
	
	
	public CountryChange(WebDriver driver)
	{
	this.Wb=driver;
	PageFactory.initElements(Wb, this);
	}

	public void ShipToUS() throws Exception 
	{	
		System.out.println("inside country "+Wb);

		//driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		Thread.sleep(4000);
		shipTo.click();
		backToUS.click();
	}

	
}
