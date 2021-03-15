package test.rahulshettyacademyWebsiteTest;

import com.BaseClassWebDriver;
import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.rahulshettyacademyPages.GreenMarketPage;




public class GreenMarketTest extends BaseClassWebDriver {

    @DataProvider(name = "testdata")
    public Object[][] getData() {
        String excelPath = projectPath + "/excel/login.xlsx";
        Object data[][] = testData(excelPath, "Sheet6");
        return data;
    }


    @Test(dataProvider = "testdata")
    public void AlertsTest(String GreenMarketWebsite) throws InterruptedException {
        test = extent.createTest("GreenMarketWebsite1");
        test.log(Status.INFO, "Starting Test Cases");
        driver.navigate().to(GreenMarketWebsite);
        Thread.sleep(3000);
        String curUrl = driver.getCurrentUrl();
        Assert.assertEquals(curUrl, GreenMarketWebsite);
        test.pass("Navigated to GreenMarketWebsite"+ GreenMarketWebsite);
        //..........

        GreenMarketPage add = new GreenMarketPage();
      //  add.AddToCart();
      //  add.CheckItemsAddedToCart();
      //  add.ProcedToCheckoutPageResults();
      //  add.Assignment3();

        add.FluentWait();
    }












}
