package lord.taylor.screens;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import lord.taylor.testBase.TestBase;

public class ProductDetailsPage extends TestBase

{
	WebDriver driver;
	
	@FindBy(xpath="//li[1][contains(@class, 'product-variant-attribute-value--swatch')]")
	private WebElement productColor;
	
	@FindBy(xpath="//li[1][contains(@class, 'product-variant-attribute-value--text')]")
	private WebElement productSize;
	
	@FindBy(xpath="//span[contains(text(),'ADD TO BAG')]")
	private WebElement addToBag;
	
	@FindBy(id="zoom-in")
	private WebElement zoomIn;
	
	@FindBy(id="zoom-out")
	private WebElement zoomOut;	
	
	@FindBy(id="zoom-reset")
	private WebElement zoomReset;
	
	@FindBy(id="full-screen")
	private WebElement fullScreen ;
	
	@FindBy(xpath="//div[@class=\"product-quantity\"]")
	private WebElement productQty ;
	
	
	
	@FindBy(xpath="//div[@class=\"product-pricing\"]")
	private WebElement productPrice ;

	
	public ProductDetailsPage(WebDriver driver)
	{
	this.driver=driver;
	PageFactory.initElements(driver, this);
	
	}

	/*Verifying product Details Page*/
	
	public void pdpPage() throws Exception 
	{		
		//driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		Thread.sleep(8000);
		assertTrue(zoomIn.isDisplayed()&&zoomOut.isDisplayed()&&zoomReset.isDisplayed());
				//&&fullScreen.isDisplayed()
		productColor.click();
		productSize.click();
		
		/*productPrice.getText();
		System.out.println("Printing "+productPrice);*/
		
		System.out.println("ProductPrice "+productPrice.getText());

		
		if (addToBag.isDisplayed())
		{
		System.out.println("Add To Bag Option is available");
		}
		else
		{
		System.out.println("Add To Bag Option is not available");
		}
		addToBag.click();

	
	}
	
}
