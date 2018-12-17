package lord.taylor.screens;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ThankYouPage

{
	WebDriver driver;
	
	@FindBy(xpath="//h1[contains(text(),'Thank You')]]")
	private WebElement thankYou;
	
	@FindBy(xpath="//li[contains(text(),'Order')]")
    private WebElement orderID;
	
	/*@FindBy(xpath="")
	private WebElement orderID;*/
	
	
	
	
	
	public ThankYouPage(WebDriver driver)
	{
		this.driver=driver;
	PageFactory.initElements(driver, this);
	
	}
	
	public void thankyouPage()
	{
		System.out.println("Order Number " +orderID.getText());

		
	}
	
	
}

