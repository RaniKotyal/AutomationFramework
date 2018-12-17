package lord.taylor.screens;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class MiniBag 


{
	WebDriver driver;

	@FindBy(xpath="//div[contains(text(),'Close')]")
	private WebElement closeMiniBag;
	
	@FindBy(xpath="//div/a[contains(text(),'View My Bag & Checkout')]")
	private WebElement checkoutMiniBag;
	
	@FindBy(xpath="//div[contains(text(),\"Item in your bag\")]")
	private WebElement saksBagItemTitle;

	@FindBy(xpath="//div[@id=\"status71680\"]")
	private WebElement itemStatus;
	
	@FindBy(xpath="//div[@class='copy estimated-total']")
	private WebElement estimatedTotal;
	
	@FindBy(xpath="//td[4][@class='saksBagItem']")
	private WebElement itemDetails;
	
	public MiniBag(WebDriver driver)
	{
	this.driver=driver;

	PageFactory.initElements(driver, this);
	}
	
	public void miniBag() throws Exception
	{
		//driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		Thread.sleep(6000);

		System.out.println("SaksBagItemTitle "+saksBagItemTitle.getText());
		 
		assertTrue(closeMiniBag.isDisplayed(), "Displayed");
		assertTrue(closeMiniBag.isDisplayed());
		
		/*itemDetails.getText();
		System.out.println("Printing2 "+itemDetails);*/
		
		System.out.println("ItemDetails "+itemDetails.getText());

		
		//estimatedTotal.getText();
		System.out.println("EstimatedTotal "+estimatedTotal.getText());

		Thread.sleep(7000);

		checkoutMiniBag.click();
		
		
		
		
	}
	
	
}

