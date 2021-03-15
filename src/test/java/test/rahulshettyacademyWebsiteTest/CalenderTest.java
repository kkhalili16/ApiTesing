package test.rahulshettyacademyWebsiteTest;

import com.BaseClassWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.rahulshettyacademyPages.CalenderPage;

public class CalenderTest extends BaseClassWebDriver {

    @DataProvider(name = "testdata")
    public Object[][] getData() {
        String excelPath = projectPath + "/excel/login.xlsx";
        Object data[][] = testData(excelPath, "Sheet11");
        return data;
    }

    @Test(dataProvider = "testdata")
    public void CalenderTesting(String CalenderWebsite, String newFlightWebsite) throws InterruptedException {
       // driver.navigate().to(CalenderWebsite);
        driver.navigate().to(newFlightWebsite);
        CalenderPage calender = new CalenderPage();
       // calender.CalenderHandling();
        calender.newFlight();


    }

}
