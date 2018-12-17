package lord.taylor.screens;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
	
		
		
		@FindBy(xpath="//a[@class=\"account\"]")
		private WebElement welcomeSignin; 
		
		@FindBy(xpath="//input[@name=\"username\"]")
		private WebElement email;
		
		@FindBy(xpath="//input[@name=\"password\"]")
		private WebElement pwd;
		
		@FindBy(xpath="//button[@class=\"hbc-button hbc-button--full hbc-button--primary sign-into-account__submit-button\"]")
		private WebElement signIn;
		
		public Login(WebDriver driver)
		{
		PageFactory.initElements(driver, this);
		}

	
		
		/*Login with valid credentials*/
		
		public void login(String emailID, String password)
		{
		welcomeSignin.click();
		email.sendKeys(emailID) ;
		pwd.sendKeys(password) ;
		signIn.click() ;
		}	
		
		
	}

