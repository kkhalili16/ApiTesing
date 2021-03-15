package test.rahulshettyacademyWebsiteTest;

import com.BaseClassWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.rahulshettyacademyPages.LimitingWebDriverPage;

public class LimitingWebDriverTest extends BaseClassWebDriver {
    @DataProvider(name = "testdata")
    public Object[][] getData() {
        String excelPath = projectPath + "/excel/login.xlsx";
        Object data[][] = testData(excelPath, "Sheet10");
        return data;
    }

    @Test(dataProvider = "testdata")
    public void LimitingDriver_openTabs(String tabsWebsite) {

       driver.navigate().to(tabsWebsite);

        LimitingWebDriverPage limited = new LimitingWebDriverPage();

        //limited.LimitingDriverScope();
        limited.Assignment6();


    }
}
