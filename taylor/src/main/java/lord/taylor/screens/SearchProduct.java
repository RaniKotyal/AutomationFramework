package lord.taylor.screens;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lord.taylor.testBase.TestBase;

public class SearchProduct extends TestBase
{
	
	@FindBy(xpath="//input[@value='Search']")
	private WebElement search;
	
	
	
	public SearchProduct(WebDriver driver)
	{
		//this.driver=driver;
		
		
	    PageFactory.initElements(driver, this);
	    System.out.println("driver"+driver);
	
	}
	
	public void search(String productID) throws Exception 
	{
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(7000);
		search.click();
		search.sendKeys(productID);
		search.submit();
   }
	
	
 public static void main (String args[]) throws Exception 
	
	{


		
		TestBase tb=new TestBase();
		tb.init();
		
	
		SearchProduct se = new SearchProduct(driver);
		se.search();
		
	}
	

}
