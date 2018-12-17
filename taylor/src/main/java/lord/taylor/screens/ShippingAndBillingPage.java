package lord.taylor.screens;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ShippingAndBillingPage 

{
WebDriver driver;
	
	@FindBy(id="shipFirst")
	private WebElement fName;
	
	@FindBy(id="shipLast")
	private WebElement lName;
	
	@FindBy(id="shipAddress1")
	private WebElement addLine1;
	
	@FindBy(id="shipCity")
	private WebElement cty;
	
	@FindBy(id="shipState")
	private WebElement stat;
	
	@FindBy(id="shipZip")
	private WebElement zip;
	
	@FindBy(id="shipEmail")
	private WebElement email;
	
	@FindBy(id="shipPhone")
	private WebElement phoneNo;
	
	@FindBy(xpath="//button[contains(text(),'Continue Checkout')]")
	private WebElement checkoutButton;
	
	@FindBy(xpath="//button[contains(text(),'Use Address As Entered')]")
	private WebElement addressAsEntered;

	public ShippingAndBillingPage(WebDriver driver)
	{
	this.driver=driver;

	PageFactory.initElements(driver, this);
	}
	
	/*Validating Shippin And Billing Page */
	
	public void verifyShippingAndBillingPage(String firstName ,String lastName,String addressLine1,String addressLine2,String city,String state,String zipCode,String emailID ,String phoneNumber) throws Exception
	{
		fName.sendKeys(firstName);
		lName.sendKeys(lastName);
		addLine1.sendKeys(addressLine1);
		cty.sendKeys(city);
		Select dropdown= new Select(stat);
		dropdown.selectByVisibleText(state);
		zip.sendKeys(zipCode);
		email.sendKeys(emailID);
		phoneNo.sendKeys(phoneNumber);
		checkoutButton.click();
		Thread.sleep(7000);	
	    addressAsEntered.click();
		
		
	}
			

}
