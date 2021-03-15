package pages.rahulshettyacademyPages;

import com.BaseClassWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class ClearTripPage extends BaseClassWebDriver {

WebElement AdultsDropdown = driver.findElement(By.id("Adults"));
WebElement ChildrensDropdown = driver.findElement(By.id("Childrens"));
WebElement infantsDropdown = driver.findElement(By.xpath("//select[@id='Infants']"));
WebElement MoreOptionsLink = driver.findElement(By.id("MoreOptionsLink"));
WebElement ClassOfTravel = driver.findElement(By.xpath("//select[@id='Class']"));
WebElement AirlineName = driver.findElement(By.xpath("//input[@id='AirlineAutocomplete']"));
WebElement DepartOnCalender = driver.findElement(By.xpath("//input[@id='DepartDate']"));
WebElement SearchButton = driver.findElement(By.id("SearchBtn"));
WebElement ErrorMessage = driver.findElement(By.id("homeErrorMessage"));

    public void Assignment2() throws InterruptedException { //UI(Dropdowns,EditBoxes,Error Valdia…)

        //Adults Dropdown Menu.
        Select AdultsOption = new Select(AdultsDropdown);
        AdultsOption.selectByIndex(1);
        test.pass("Select option 2 from Adults dropdown menu.");
        String AdultDropDownText = AdultsOption .getFirstSelectedOption().getText();
        Assert.assertEquals(AdultDropDownText , "2");
        test.info("Validate actual value: "+ "<br />"+ AdultDropDownText
                +"<br /> with expected value: " + "<br /> 2" );

        //Childrens Dropdown Menu.
        Select ChildrensOption = new Select(ChildrensDropdown);
        ChildrensOption.selectByIndex(4);
        test.pass("Select option 4 from Childrens dropdown menu.");
        String ChildrensDropDownText = ChildrensOption.getFirstSelectedOption().getText();
        Assert.assertEquals(ChildrensDropDownText , "4");
        test.info("Validate actual value of ChildrensDropDown: "+ "<br />"+ ChildrensDropDownText
                +"<br /> with expected value: " + "<br /> 4" );

        //Infants Dropdown Menu.
        Select  InfantsOption = new Select(infantsDropdown);
        InfantsOption.selectByIndex(1);
        test.pass("Select option 1 from Infants dropdown menu.");
        String InfantsDropDownText = InfantsOption.getFirstSelectedOption().getText();
        Assert.assertEquals(InfantsDropDownText , "1");
        test.info("Validate actual value of ChildrensDropDown: "+ "<br />"+ InfantsDropDownText
                +"<br /> with expected value: " + "<br /> 1" );

        for(int i = 0; i<3; i++){
            Thread.sleep(1000);
            MoreOptionsLink.click();
        }
        test.pass("Click on more option.");

        //Class od travel dropdown menu.
        Select TravelClass = new Select(ClassOfTravel);
           TravelClass.selectByVisibleText("Business");

        String TravelClassFirstOption = TravelClass.getFirstSelectedOption().getText();
        test.pass("Select "+ TravelClassFirstOption +" from Infants dropdown menu.");

        Assert.assertEquals(TravelClassFirstOption, "Business");

        test.info("Validate actual value of Travel Class DropDown: "
        + "<br />"+ TravelClassFirstOption +"<br /> with expected value: " + "<br /> Business");


        //Airline Name Text box.
         AirlineName.sendKeys("American Airlines");
         test.pass("Typing Airline name in text box.");


        //Depart on Calender.
        DepartOnCalender.click();
        test.pass(" Depart on calender.");
        //WebElement CalenderCurrentDate = driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active"));
        //or
        WebElement CalenderCurrentDate = driver.findElement(By.cssSelector("[class*='ui-state-active']"));
        CalenderCurrentDate.click();
        test.pass("Click on calender current date.");


        SearchButton.click();
        Thread.sleep(1000);
        test.pass("Click on Search flights button");

        if(ErrorMessage.isDisplayed()){
            System.out.println(ErrorMessage.getText());
            test.pass("Error message:"+"<br />"+ErrorMessage.getText());
        }






    }





}
