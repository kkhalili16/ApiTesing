package test.rahulshettyacademyWebsiteTest;

import com.BaseClassWebDriver;
import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.rahulshettyacademyPages.ClearTripPage;

import static com.BaseClass.extent;

public class ClearTripTest extends BaseClassWebDriver {

    @DataProvider(name = "testdata")
    public Object[][] getData() {
        String excelPath = projectPath + "/excel/login.xlsx";
        Object data[][] = testData(excelPath, "Sheet5");
        return data;
    }

    @Test(dataProvider = "testdata")
    public void ClearTripTest1(String ClearTripWebsite) throws InterruptedException {
        test = extent.createTest("ClearTripWebsite1");
        test.log(Status.INFO, "Starting Test Cases");
        driver.navigate().to(ClearTripWebsite);
        String curUrl = driver.getCurrentUrl();
        Assert.assertEquals(curUrl, ClearTripWebsite);
        test.pass("Navigated to ClearTripWebsite   "+ ClearTripWebsite);
        //..........

        ClearTripPage clear = new ClearTripPage();
        clear.Assignment2();



    }


}
