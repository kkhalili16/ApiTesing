package pages.rahulshettyacademyPages;

import com.BaseClassWebDriver;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;


public class HomePage extends BaseClassWebDriver {

    WebElement CurrencyDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
    WebElement PassengersDropdown = driver.findElement(By.id("divpaxinfo"));
    WebElement AddPassengers = driver.findElement(By.id("hrefIncAdt"));
    WebElement DonePassengersbutton = driver.findElement(By.id("btnclosepaxoption"));
    WebElement CountryAutoSuggest = driver.findElement(By.id("autosuggest"));
    WebElement FromDropdown = driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT"));

    public void staticDropdown() {
//CurrencyDropdown
        try {
            Select dropdown = new Select(CurrencyDropdown);
            dropdown.selectByIndex(2);
            String index2 = dropdown.getFirstSelectedOption().getText();
            Assert.assertEquals(index2, "AED");

        } catch (Exception e) {
            test.log(Status.FAIL, e.getCause().getMessage());
        }

    }


    public void dropDownlooping() throws InterruptedException {
//PassengersDropdown
        PassengersDropdown.click();
        test.info("click on Passengers dropdown");
        Thread.sleep(2000L);

        for (int i = 1; i < 5; i++) {
            AddPassengers.click();
        }
        test.info("click on + to add 5 passengers");

        DonePassengersbutton.click();
        test.info("click on Done button");
        String NumPassengers = PassengersDropdown.getText();
        Assert.assertEquals(NumPassengers, "5 Adult");

    }


    public void dropDownAutoSuggestive() throws InterruptedException {
        //Country AutoSuggestive

        CountryAutoSuggest.sendKeys("ind");
        test.info("Typing 'ind' to select, shortcut for suggestion.");

        Thread.sleep(3000);
        String indiaOption = driver.findElement(By.xpath("(//ul[@id='ui-id-1']/li/a)[2]")).getText();
        Assert.assertEquals(indiaOption, "India");

        List<WebElement> options = driver.findElements(By.xpath("//ul[@id='ui-id-1']/li/a"));

        for (WebElement option : options) {

            if (option.getText().equalsIgnoreCase("India")) {
                option.click();
                break;
            }
        }
        test.info("Select India from country Suggest text box.");
    }


    public void dropDownDynamic() throws InterruptedException {

        FromDropdown.click();
        //From Bengaluru(BLR)
        WebElement BengaluruBLR = driver.findElement(By.xpath("//a[@value='BLR']"));
        BengaluruBLR.click();
        test.info("click to select Bengaluru(BLR) country");

        Thread.sleep(2000);

        //To Chennai(MAA)
        WebElement ChennaiMMA = driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR']//a[@value='MAA']"));
        //or WebElement ChennaiMMA = driver.findElement(By.xpath("(//a[@value='MAA'])[2]");
        ChennaiMMA.click();
        test.info("click to select Chennai(MAA) country");
    }

    public void checkboxes() throws InterruptedException {
        WebElement FamilyAndFriendsCheckbox = driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily"));
        List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
        try {
            for (WebElement checkbox : checkboxes) {


                if (checkbox.isDisplayed()) {
                    checkbox.click();
                    Thread.sleep(1000);
                    Assert.assertTrue(checkbox.isSelected());
                    System.out.println(PassengersDropdown.getText());
                }

            }

        test.pass("all checkboxes was successfully selected");

        }catch (Exception e){
            test.log(Status.FAIL, e.getCause().getMessage());
        }

        Assert.assertEquals(PassengersDropdown.getText(),"1 Child");
        test.info("When Unaccompanied Minor checkbox is selected PassengersDropdown will display 1 Child");
        test.pass("Result: " + PassengersDropdown.getText());

        FamilyAndFriendsCheckbox.click();
        Assert.assertEquals(PassengersDropdown.getText(), "1 Adult, 1 Child");
        test.info("When  Family and Friends checkbox is selected PassengersDropdown will display 1 Adult, 1 Child");
        test.pass("Result: " + PassengersDropdown.getText());
    }

    public void radio() {
        WebElement RoundTripRadio = driver.findElement(By.xpath("//label[contains(text(),'Round Trip')]"));
        WebElement Calender = driver.findElement(By.id("Div1"));

        driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();

        if (RoundTripRadio.getAttribute("class").contains("select-label")){
            Assert.assertTrue(true);
            test.pass("RoundTrip radio selected");

        }else{
            Assert.assertTrue(false);
            test.info("RoundTrip radio not selected");
        }


        if (Calender.getAttribute("style").contains("1")){
            Assert.assertTrue(true);
            test.pass("calender is enabled");

        }else{
            Assert.assertTrue(false);
            test.info("calender is disabled");
        }

    }



    public void Search() {

        WebElement submitBtn = driver.findElement(By.xpath("//input[@id='ctl00_mainContent_btn_FindFlights']"));
        submitBtn.click();
        test.pass("pass");






    }

}












