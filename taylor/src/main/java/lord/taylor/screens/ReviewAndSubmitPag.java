package lord.taylor.screens;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReviewAndSubmitPag

{
	WebDriver driver;
	
	@FindBy(xpath="//div[@class=\"billing-address-summary\"]")
	private WebElement  billingAddress;
	
	@FindBy(xpath="//div[@class=\"email-address-summary\"]")
	private WebElement  emailAddress;
	
	@FindBy(xpath="//div[@class=\"payment-method-summary\"]")
	private WebElement  paymentSummary;
	
	@FindBy(xpath="//div[@class=\"promotion-summary\"]")
	private WebElement  promotionSummary;
	
	@FindBy(xpath="//div[@id=\"jsVal-shippingAddress\"]")
	private WebElement  shippingAddress;
	
	@FindBy(xpath="//a[@class='widebag-heading items']")
	private WebElement  itemCount;
	
	@FindBy(xpath="//p[@class=\"widebag-item-inventory-status\"]")
	private WebElement status;
	
	@FindBy(xpath="//p[@class=\"widebag-item-unit-price\"]")
	private WebElement unitPrice;
	
	@FindBy(xpath="//div[@class=\"order-summary\"]")
	private WebElement orderSummary;
	
	
	/*@FindBy(xpath="//button[contains(text(),'Place order')]")
	private WebElement placeOrder;*/

	
	@FindBy(id="jsReviewSubmit")
	private WebElement placeOrder;
	
	public ReviewAndSubmitPag(WebDriver driver)
	{
		this.driver=driver;
	PageFactory.initElements(driver, this);
	
	}
	
	public void verifyReviewSubmit() throws Exception
	{
		System.out.println("BillingAddress " +billingAddress.getText());
		System.out.println("EmailAddress " +emailAddress.getText());
		System.out.println("PaymentSummary " +paymentSummary.getText());
		System.out.println("PromotionSummary " +promotionSummary.getText());
		System.out.println("ShippingAddress " +shippingAddress.getText());
		System.out.println("ItemCount " +itemCount.getText());
		System.out.println("Status " +status.getText());
		System.out.println("UnitPrice " +unitPrice.getText());
		System.out.println("OrderSummary " +orderSummary.getText());
		Thread.sleep(8000);
		placeOrder.click();


	}
	
	
	
	

}
