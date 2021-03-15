package test.rahulshettyacademyWebsiteTest;

import com.BaseClassWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.rahulshettyacademyPages.FramesPage;


public class FrameTest extends BaseClassWebDriver {
    @DataProvider(name = "testdata")
    public Object[][] getData() {
        String excelPath = projectPath + "/excel/login.xlsx";
        Object data[][] = testData(excelPath, "Sheet9");
        return data;
    }

    @Test(dataProvider = "testdata")
    public void Nested_frames_test(String frameWebsite) {

        driver.navigate().to(frameWebsite);

        FramesPage frame = new FramesPage();

        frame.Nested_frames_page();


    }
}