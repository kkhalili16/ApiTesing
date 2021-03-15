package pages.rahulshettyacademyPages;

import com.BaseClassWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;


public class CalenderPage extends BaseClassWebDriver {

    public void CalenderHandling() throws InterruptedException {
        Thread.sleep(4000L);
        driver.findElement(By.id("travel_date")).click();

        while (!driver.findElement(By.className("datepicker-switch")).getText().contains("August 2021")) {
            driver.findElement(By.className("next")).click();
        }


        List<WebElement> date = driver.findElements(By.cssSelector("[class='datepicker-days'] [class='day']"));
        for (int i = 0; i < date.size(); i++) {
            String day = driver.findElements(By.cssSelector
                    ("[class='datepicker-days'] [class='day']")).get(i).getText();
            if (day.equalsIgnoreCase("25")) {
                driver.findElements(By.cssSelector("[class='datepicker-days'] [class='day']")).get(i).click();
                break;
            }


        }

    }

    public void newFlight() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.xpath("//h1[@class='uitk-type-display-700']")).click();

        WebElement departureCalender = driver.findElement(By.xpath("//button[@id='d1-btn']"));
        departureCalender.click();


        String departureDate = "20 May 2021";

        String departureMonthAndYear = departureDate.split(" ")[1] + " " + departureDate.split(" ")[2];
        String departureDay = departureDate.split(" ")[0].trim();
        /*
        String returnDate = "15 December 2021";
        String returnMonthAndYear = returnDate.split(" ")[1]+" "+returnDate.split(" ")[2];
        String returnDay = returnDate.split(" ")[0].trim();  */

        while (!driver.findElement(By.xpath
                ("(//div[@class='uitk-new-date-picker-month'])/h2")).getText().contains(departureMonthAndYear)) {

            driver.findElement(By.xpath("//div[@class='uitk-calendar']/div[1]/button[2]")).click();
        }


        List<WebElement> dates = driver.findElements(By.xpath("(//table[@class='uitk-date-picker-weeks'])[1]/tbody/tr/td/button[1]"));
        for (int i = 0; i < dates.size(); i++) {
            String day = (driver.findElements(By.xpath("(//table[@class='uitk-date-picker-weeks'])[1]/tbody/tr/td/button[1]")).get(i).getAttribute("data-day"));
            System.out.println(day);

            if (day.equalsIgnoreCase(departureDay)) {
                driver.findElements(By.xpath("(//table[@class='uitk-date-picker-weeks'])[1]/tbody/tr/td/button[1]")).get(i).click();

            }

        }

    }

}




