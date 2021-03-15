package test.rahulshettyacademyWebsiteTest;

import com.BaseClassWebDriver;
import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.rahulshettyacademyPages.AlertsPage;


import static com.BaseClass.extent;

public class AlertsTest extends BaseClassWebDriver {

    @DataProvider(name = "testdata")
    public Object[][] getData() {
        String excelPath = projectPath + "/excel/login.xlsx";
        Object data[][] = testData(excelPath, "Sheet4");
        return data;
    }


    @Test(dataProvider = "testdata")
    public void AlertsTest(String AlertWebsite) {
        test = extent.createTest("AlertWebsite1");
        test.log(Status.INFO, "Starting Test Cases");
        driver.navigate().to(AlertWebsite);
        String curUrl = driver.getCurrentUrl();
        Assert.assertEquals(curUrl, AlertWebsite);
        test.pass("Navigated to AlertWebsite"+ AlertWebsite);
        //..........

        AlertsPage alert = new AlertsPage();
        alert.AlertsPage();



    }












}
