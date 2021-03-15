package test.rahulshettyacademyWebsiteTest;

import com.BaseClassWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.rahulshettyacademyPages.ActionsPage;

import java.awt.*;

public class ActionsTest extends BaseClassWebDriver {
    @DataProvider(name = "testdata")
    public Object[][] getData() {
        String excelPath = projectPath + "/excel/login.xlsx";
        Object data[][] = testData(excelPath, "Sheet7");
        return data;
    }

    @Test(dataProvider = "testdata")
    public void ActionTest(String Amazon) throws InterruptedException, AWTException {

        driver.navigate().to("https://www.amazon.com/");

        ActionsPage action = new ActionsPage();

        action.MouseClickWriteCapitalAndSelectText();
        action.MouseActionHover();



    }



}
