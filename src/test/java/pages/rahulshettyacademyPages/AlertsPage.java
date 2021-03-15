package pages.rahulshettyacademyPages;

import com.BaseClassWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class AlertsPage extends BaseClassWebDriver {
    WebElement AlertTextBox = driver.findElement(By.id("name"));
    WebElement AlertBtn = driver.findElement(By.id("alertbtn"));
    WebElement AlertConfirmBtn = driver.findElement(By.id("confirmbtn"));
    String text = "Johnny Deep";

    public void AlertsPage() {
    AlertTextBox.sendKeys(text);
    test.pass("passing text value into alert textbox"+ "<br />"+text);

    AlertBtn.click();
    test.pass("click on alert button");

    String AlertText = driver.switchTo().alert().getText();
    Assert.assertEquals(AlertText,"Hello "+text+", share this practice page and share your knowledge");
    test.pass("validate alert text "+ "<br />" +AlertText);


    driver.switchTo().alert().accept();
    test.pass("click on ok from alert popup window");

    test.info("Confirm Alert popup window");
    AlertConfirmBtn.click();
    test.pass("click on alert confirm button");
    String AlertConfirmText = driver.switchTo().alert().getText();
    Assert.assertEquals(AlertConfirmText,"Hello , Are you sure you want to confirm?");
    test.pass("validate alert confirm text "+ "<br />" +AlertConfirmText);

    driver.switchTo().alert().dismiss();
    test.pass("click on Cancel from alert popup window");





    }






}