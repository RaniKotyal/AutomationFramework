package lord.taylor.screens;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PaymentPage

{
	WebDriver driver;
	
	@FindBy(id="payCC")
	private WebElement paymentMode;
	
	@FindBy(id="payCCNum")
	private WebElement enterCCnumber;
	
	@FindBy(id="payCCName")
	private WebElement nameOnTheCard;
	
	@FindBy(id="ccMonth")
	private WebElement mth;
	
	@FindBy(id="ccYear")
	private WebElement yr;
		
	@FindBy(id="payCCV")
	private WebElement cvv;
		
	@FindBy(id="jsCompletePayment")
	private WebElement continueCheckout;
	
	public PaymentPage(WebDriver driver)
	{
	this.driver=driver;

	PageFactory.initElements(driver, this);
	}
	
	public void verifyingPaymentPage(String paymentType,String cardNumber,String cardName,String month,String year,String cVV)
	{
		Select dropdown= new Select(paymentMode);
		dropdown.selectByVisibleText(paymentType);
		
		enterCCnumber.sendKeys(cardNumber);
		nameOnTheCard.sendKeys(cardName);
		
		Select dropdown1 = new Select(mth);
		dropdown1.selectByVisibleText(month);
		
		Select dropdown2 = new Select(yr);
		dropdown2.selectByVisibleText(year);
		
		cvv.sendKeys(cVV);
		continueCheckout.click();
		
		
	}
	
}
