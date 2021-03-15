package pages.rahulshettyacademyPages;

import com.BaseClassWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Function;

public class GreenMarketPage extends BaseClassWebDriver {

    String[] itemsNeeded = {"Brocolli", "Cucumber", "Carrot", "Brinjal"};
    public void AddToCart() throws InterruptedException {

        int  j=0;

        List <WebElement> elements =  driver.findElements(By.cssSelector("h4.product-name"));

        for(int i =0; i<elements.size(); i++){



                String[] name = elements.get(i).getText().split("-");
                String formattedName = name[0].trim();



                List itemsNeededList = Arrays.asList(itemsNeeded);

                if(itemsNeededList.contains(formattedName))  {


                driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
                test.pass("the item added to cart successfully<br />" + formattedName );

                    if(j == itemsNeeded.length){
                        break;
                    }
                }
        }
    }

    public void CheckItemsAddedToCart() throws InterruptedException {
        int k=0;
        //(//ul[@class='cart-items'])[1]/li/div[@class='product-info']/p[@class='product-name']
        WebElement cartIcon = driver.findElement(By.xpath("//a[@class='cart-icon']"));
        cartIcon.click();


        List<WebElement> itemsInCart = driver.findElements(By.xpath("(//ul[@class='cart-items'])[1]/li/div[@class='product-info']/p[@class='product-name']"));
        for (int i =0; i<itemsInCart.size(); i++){

            String[] cartList = itemsInCart.get(i).getText().split("-");
            String formatedName = cartList[0].trim();

            Assert.assertEquals(formatedName, itemsNeeded[i]);

            if(k==itemsNeeded.length){
                break;
            }

        }


    }


    public void ProcedToCheckoutPageResults() throws InterruptedException {
        driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
        test.pass("clicking on PROCEED TO CHECKOUT ");
/* explicit wait
        WebDriverWait w = new WebDriverWait(driver,5);
        w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));
*/
        driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
        test.info("typing promo code <br >"+"rahulshettyacademy");

        driver.findElement(By.cssSelector("button.promoBtn")).click();
        test.pass("clicking on promo button");
/* explicit wait
        w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
*/
        String promoCodeMessage = driver.findElement(By.cssSelector("span.promoInfo")).getText();
        Assert.assertEquals(promoCodeMessage,"Code applied ..!");
        test.pass("promo code applied");



    }

    public void Assignment3(){

        WebDriverWait w = new WebDriverWait(driver, 5);
        driver.navigate().to("https://www.itgeared.com/demo/1506-ajax-loading.html");
        driver.findElement(By.xpath("//a[contains(text(),'Click to load get data via Ajax!')]")).click();

        w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='results']")));
        String messageData = driver.findElement(By.xpath("//div[@id='results']")).getText();
        System.out.println(messageData);


    }

    public void FluentWait(){
        driver.navigate().to("https://the-internet.herokuapp.com/dynamic_loading/1");

        driver.findElement(By.cssSelector("[id='start'] button")).click();

        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(3)).ignoring(NoSuchElementException.class);

        wait.until(driver -> {
            if (driver.findElement(By.cssSelector("[id='finish'] h4")).isDisplayed()) {
                return driver.findElement(By.cssSelector("[id='finish'] h4"));
            } else
                return null;
        });

        System.out.printf(driver.findElement(By.cssSelector("[id='finish'] h4")).getText());

    }
//or
    public void FluentWait2(){
        driver.navigate().to("https://the-internet.herokuapp.com/dynamic_loading/1");

        driver.findElement(By.cssSelector("[id='start'] button")).click();

        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(3)).ignoring(NoSuchElementException.class);


       WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
           @Override
           public WebElement apply(WebDriver driver) {
               if (driver.findElement(By.cssSelector("[id='finish'] h4")).isDisplayed()) {
                   return driver.findElement(By.cssSelector("[id='finish'] h4"));
               } else

               return null;
           }
       });

        System.out.printf(driver.findElement(By.cssSelector("[id='finish'] h4")).getText());

    }









}






