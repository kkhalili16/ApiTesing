package pages.rahulshettyacademyPages;

import com.BaseClassWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;
import java.awt.event.KeyEvent;

public class ActionsPage extends BaseClassWebDriver {
    WebElement AccountList = driver.findElement(By.xpath("//a[@id='nav-link-accountList']"));
    WebElement searchTextBox = driver.findElement(By.id("twotabsearchtextbox"));

    public void MouseActionHover(){

      Actions a =new Actions(driver);
      a.moveToElement(AccountList).build().perform();

    }

    public void MouseClickWriteCapitalAndSelectText() throws InterruptedException, AWTException {

        Actions a =new Actions(driver);
        a.moveToElement(searchTextBox).click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().build().perform();
        a.moveToElement(AccountList).contextClick().build().perform();

        //Calling different class to close contextClick
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_ESCAPE);
        robot.keyRelease(KeyEvent.VK_ESCAPE);


    }






}
