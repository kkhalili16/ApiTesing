package pages.rahulshettyacademyPages;

import com.BaseClassWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.util.List;

public class ScrollingWindowAndTablePage extends BaseClassWebDriver {

    public void ScrollingWindow() throws InterruptedException {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
        Thread.sleep(3000);

    }

    public void ScrollingTable() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.querySelector('.tableFixHead').scrollTop = 5000");
        Thread.sleep(3000);
    }

    public void TableGridsHandling() {
        int sum = 0;
        List<WebElement> element = driver.findElements(By.xpath("//div[@class='tableFixHead']/table/tbody/tr/td[4]"));
        for (int i = 0; i < element.size(); i++) {
            sum = sum + Integer.parseInt(element.get(i).getText());


        }
        String totalString = driver.findElement(By.xpath("//div[@class='totalAmount']")).getText();
        int total = Integer.parseInt(totalString.split(":")[1].trim());
        Assert.assertEquals(total, sum);
    }

    public void Assignment7() {
        /*
        List<WebElement> numColumn = driver.findElements(By.xpath("//div[@class='left-align']/fieldset/table/tbody/tr"));
        System.out.println(numColumn.size());
        List<WebElement> numRow = driver.findElements(By.xpath("//div[@class='left-align']/fieldset/table/tbody/tr/th"));
        System.out.println(numRow.size());
        List<WebElement> thdRow = driver.findElements(By.xpath("//div[@class='left-align']/fieldset/table/tbody/tr[3]/td"));
        for (int i = 0; i < thdRow.size(); i++) {
            System.out.println(thdRow.get(i).getText());
        }
         */
        WebElement table = driver.findElement(By.xpath("//div[@class='left-align']/fieldset/table"));


        System.out.println(table.findElements(By.tagName("tr")).size());


        System.out.println(table.findElements(By.tagName("tr")).get(0).findElements(By.tagName("th")).size());


        List<WebElement> secondRow = table.findElements(By.tagName("tr")).get(2).findElements(By.tagName("td"));


        System.out.println(secondRow.get(0).getText());


        System.out.println(secondRow.get(1).getText());


        System.out.println(secondRow.get(2).getText());


    }

    public void Assignment8() throws InterruptedException {
        driver.findElement(By.id("autocomplete")).sendKeys("ind");
        WebElement loc = driver.findElement(By.id("autocomplete"));
        Thread.sleep(2000);
        Actions a = new Actions(driver);
        a.moveToElement(loc).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).build().perform();

        //System.out.println(driver.findElement(By.id("autocomplete")).getAttribute("value"));
        //or
        JavascriptExecutor js = (JavascriptExecutor)driver;
        String val = (String) js.executeScript("return document.querySelector('#autocomplete').value");
        System.out.println(val);

    }


}



