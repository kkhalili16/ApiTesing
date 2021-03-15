package pages.rahulshettyacademyPages;

import com.BaseClassWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.Iterator;
import java.util.Set;

public class LimitingWebDriverPage extends BaseClassWebDriver {

    public void LimitingDriverScope() throws InterruptedException {
        System.out.println(driver.findElements(By.tagName("a")).size());
    //Limiting Driver scope to footer section
        WebElement footerSection = driver.findElement(By.xpath("//div[@id='gf-BIG']"));
        System.out.println(footerSection.findElements(By.tagName("a")).size());
    //Limiting Driver scope to first column in footer section
        WebElement footerColumn = footerSection.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
        System.out.println(footerColumn.findElements(By.tagName("a")).size());

    //click on each link in footer first column in separate tab

        for(int i=1; i<footerColumn.findElements(By.tagName("a")).size(); i++){

          String keyClick =  Keys.chord(Keys.COMMAND, Keys.ENTER);

          footerColumn.findElements(By.tagName("a")).get(i).sendKeys(keyClick);

        }

       Set<String> window = driver.getWindowHandles();
       Iterator<String> it = window.iterator();
       String Parent = it.next();

       while (it.hasNext()){
           driver.switchTo().window(it.next());
           System.out.println(driver.getTitle());
           driver.close();
       }
        driver.switchTo().window(Parent);
    }


    public void Assignment6() {
        WebElement Checkbox = driver.findElement(By.xpath("//div[@id='checkbox-example']/fieldset/label[2]"));
        String checkBoxLabel = Checkbox.getText();
        Checkbox.findElement(By.xpath("//input[@id='checkBoxOption2']")).click();

        Select select = new Select(driver.findElement(By.xpath("//select[@id='dropdown-class-example']")));
        select.selectByVisibleText(checkBoxLabel);

        driver.findElement(By.xpath("//input[@name='enter-name']")).sendKeys(checkBoxLabel);
        driver.findElement(By.xpath("//input[@id='alertbtn']")).click();
        String alertText = driver.switchTo().alert().getText();
        Assert.assertEquals(alertText.contains(checkBoxLabel),true);
    }



}
