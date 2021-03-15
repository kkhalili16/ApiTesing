package test.rahulshettyacademyWebsiteTest;

import com.BaseClassWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.rahulshettyacademyPages.SoftAssertions_ConnectionRespondCodePage;

import java.io.IOException;
import java.net.MalformedURLException;

public class SoftAssertions_ConnectionRespondCodeTest extends BaseClassWebDriver {

    @DataProvider(name = "testdata")
    public Object[][] getData() {
        String excelPath = projectPath + "/excel/login.xlsx";
        Object data[][] = testData(excelPath, "Sheet4");
        return data;
    }

    @Test(dataProvider = "testdata")
    public void SoftAssertion_ConnectionRespondCode(String AlertWebsite) throws IOException {
        driver.navigate().to(AlertWebsite);
        SoftAssertions_ConnectionRespondCodePage sc = new SoftAssertions_ConnectionRespondCodePage();
        sc.SoftAssertions_ConnectionsRespondCode_Obj();



    }

}
