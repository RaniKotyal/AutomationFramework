package lord.taylor.testBase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestBase 
{
	public static  WebDriver driver;

 public void init() throws Exception 
 {
	 try
	 {
			
		System.out.println(System.getProperty("user.dir"));
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//src//main//resources//drivers//chrome");	
		
		 driver = new ChromeDriver();
		 System.out.println("driver1"+driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.manage().window().fullscreen();
		driver.get("https://qa.lordandtaylor.com/Entry.jsp");
		
		/*Thread.sleep(1600);
		Actions actions = new Actions(driver);
		actions.click();
		WebElement element = driver.findElement(By.xpath("//div[@class='inner']")); 
		actions.moveToElement(element).click();
		Robot robot = new Robot();
		robot.mouseMove(50,50);
		actions.click().build().perform();
		robot.mouseMove(200,70);
		actions.click().build().perform();*/
		
		
		 
		/*driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"generic-modal\"]/iframe")));
	
		WebElement element = driver.findElement(By.xpath(".//*[@id=\"close-button\"]")); 
		WebDriverWait wait1 = new WebDriverWait(driver,5);
		wait1.until(ExpectedConditions.visibilityOf(element));
		element.click();	*/	 
		
		WebElement element = driver.findElement(By.xpath("//button[contains(text(),'Continue Shopping')]")); 
		WebDriverWait wait1 = new WebDriverWait(driver,5);
		wait1.until(ExpectedConditions.visibilityOf(element));
		element.click();
		
		
		
	 }
 
		catch(Exception e){
		System.out.println(e);
		}
 
 
	/*@AfterClass
	
	private void close()
	{
		driver.close();
	}*/
	 }
 
public static void main (String args[]) throws Exception {
	 TestBase tb=new TestBase();
	 tb.init();
	 System.out.println("Successfully launched");
	 
 }
 }
