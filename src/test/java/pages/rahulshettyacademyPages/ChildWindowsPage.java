package pages.rahulshettyacademyPages;

import com.BaseClassWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Iterator;
import java.util.Set;


public class ChildWindowsPage extends BaseClassWebDriver {
WebElement blinkingText = driver.findElement(By.cssSelector(".blinkingText"));
WebElement userName = driver.findElement(By.cssSelector("#username"));

    public void ChildWindowHandle() throws InterruptedException {
        blinkingText.click();
//Calling window handles class
       Set<String> windows = driver.getWindowHandles();
//Get All tabs windows Ids and store it in String Array
       Iterator<String> it = windows.iterator();
//Moving to parent id window and save it in a variable
       String parentId = it.next();
//Moving to child id window and save it in a variable
       String childId  = it.next();
//Switch to specific window(child or parent)
       driver.switchTo().window(childId);


       driver.findElement(By.cssSelector(".im-para.red")).getText();
       String emailText = driver.findElement(By.cssSelector(".im-para.red")).getText()
               .split("at")[1].trim().split(" ")[0];

        /*Or  Interview Questions/Resume Preparation/ Material
        String emailText = driver.findElement(By.cssSelector(".im-para")).getText()
                .split("providing")[1].trim().split("to")[0].trim();
        System.out.println(emailText);
        */

        driver.switchTo().window(parentId);
        userName.sendKeys(emailText);

    }

public void windowHandling() throws InterruptedException {
        blinkingText.click();

        Set<String> window = driver.getWindowHandles();
        Iterator<String> it =   window.iterator();

        String parentId = it.next();
        String childId = it.next();

        driver.switchTo().window(childId);

        driver.findElement(By.xpath("//div[@class='navbar-collapse collapse clearfix']/ul/li[2]/a")).click();

       driver.switchTo().window(parentId);









}

}
