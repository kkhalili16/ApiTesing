package test.rahulshettyacademyWebsiteTest;

import com.BaseClassWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.rahulshettyacademyPages.ChildWindowsPage;


public class ChildWindowsTest extends BaseClassWebDriver {

    @DataProvider(name = "testdata")
    public Object[][] getData() {
        String excelPath = projectPath + "/excel/login.xlsx";
        Object data[][] = testData(excelPath, "Sheet8");
        return data;
    }

    @Test(dataProvider = "testdata")
    public void ChildWindowTest(String ChildWindowWebsite) throws InterruptedException {

        driver.navigate().to(ChildWindowWebsite);

        ChildWindowsPage win = new ChildWindowsPage();
       // win.ChildWindowHandle();
        win.windowHandling();



    }

}
