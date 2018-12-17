package lord.taylor.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserActions 
{
	int thinkTime = 500;
    WebDriverWait wait;

    public void click(WebDriver driver, WebElement elememt) 
    {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", elememt);
        System.out.println("success");
    }

}
