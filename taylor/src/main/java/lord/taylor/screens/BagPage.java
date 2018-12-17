package lord.taylor.screens;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lord.taylor.testBase.TestBase;

public class BagPage extends TestBase
{
	WebDriver driver;
	
	@FindBy(xpath="//a[@class='widebag-heading items']")
	private WebElement  itemCount;
	
	@FindBy(xpath="//input[@name=\"itemQuantity\"]")
	private WebElement  itemQuantity;
	
	@FindBy(xpath="//span[contains(text(),\"Edit\")]")
	private WebElement edit;
	
	@FindBy(xpath="//p[@class=\"widebag-item-inventory-status\"]")
	private WebElement status;
	
	@FindBy(xpath="//p[@class=\"widebag-item-unit-price\"]")
	private WebElement unitPrice;
	
	@FindBy(xpath="//p[@class=\"widebag-item-extended-price\"]")
	private WebElement subTotal;
	
	@FindBy(xpath="//input[@name=\"promoCode\"]")
	private WebElement enterPromoCode;
	
	@FindBy(xpath="//span[contains(text(),\"Apply\")]")
	private WebElement applyPromoCode;
	
	@FindBy(xpath="//h2[contains(text(),'Applied Promo Code(s)')]")
	private WebElement appliedPromoCode;
	
	
	@FindBy(xpath="//input[@name=\"zipCode\"]")
	private WebElement enterZipCode;
	
	@FindBy(xpath="//p[@class='widebag-item-discount-price']")
	private WebElement discount;
	
	
	@FindBy(xpath="//a[contains(text(),\"Checkout\")]")
	private WebElement checkout;
	
	
	

	
	/* WelCome Popup for Registered or Guest user*/
	
	@FindBy(id="loginEmail")
	private WebElement enterEmailAddress;
	
	@FindBy(id="loginPass")
	private WebElement pwd;
	
	@FindBy(xpath="//button[contains(text(),'Sign In & Checkout')]")
	private WebElement signInCheckout;
	
	@FindBy(xpath="//button[contains(text(),'Checkout as Guest ')]")
	private WebElement checkoutAsGuest;
	
	public BagPage(WebDriver driver)
	{
	this.driver=driver;

	PageFactory.initElements(driver, this);
	}
	
	public void bagPage(String itemquantity, String promoCode, String zipCode ) throws Exception
	{
		Thread.sleep(9000);
		System.out.println("Status " +status.getText());
		System.out.println("ItemCount " +itemCount.getText());
		System.out.println("ItemQuantity " +itemQuantity.getText());
		
		/* Modify Item Quantity */
		itemQuantity.click();
		itemQuantity.clear();
		itemQuantity.sendKeys(itemquantity);
		System.out.println("ItemQuantity" +itemQuantity.getText());
		//itemQuantity.submit();
		Thread.sleep(4000);

		System.out.println("UnitPrice " +unitPrice.getText());
		System.out.println("SubTotal " +subTotal.getText());
		
		/* Applying Promo Code */
		enterPromoCode.click();
		enterPromoCode.sendKeys(promoCode);
		applyPromoCode.click();
		System.out.println("PromoCode" +appliedPromoCode.getText());

		
		/* Enter Zip Code */
		Thread.sleep(9000);
		enterZipCode.click();
		enterZipCode.sendKeys(zipCode);
		Thread.sleep(9000);
		checkout.click();
		
	}
	
	/*Logging as Registered User */
	public void loginAsRegisteredUser(String emailID,String password)
	{
		
		enterEmailAddress.sendKeys(emailID);
		pwd.sendKeys(password);
		signInCheckout.click();
		
	}
	
	/*LogIn as Guest User */

	public void loginAsGuestUser()
	{
		
		checkoutAsGuest.click();
		
		
	}

	
	
}
	
	
	

