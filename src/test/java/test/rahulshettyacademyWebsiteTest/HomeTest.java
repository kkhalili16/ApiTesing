package test.rahulshettyacademyWebsiteTest;

import com.BaseClassWebDriver;
import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.rahulshettyacademyPages.HomePage;

import static com.BaseClass.extent;

public class HomeTest extends BaseClassWebDriver {

    @DataProvider(name = "testdata")
    public Object[][] getData() {
        String excelPath = projectPath + "/excel/login.xlsx";
        Object data[][] = testData(excelPath, "Sheet3");
        return data;
    }


    @Test(dataProvider = "testdata")
    public void StaticDropdownTest(String QAClickJetUrl) {
        test = extent.createTest("QAClickJetTest1");
        test.log(Status.INFO, "Starting Test Cases");
        driver.navigate().to(QAClickJetUrl);
        String curUrl = driver.getCurrentUrl();
        Assert.assertEquals(curUrl, QAClickJetUrl);
        test.pass("Navigated to QAClickWebsite"+ QAClickJetUrl);
        //..........

        HomePage dropdown = new HomePage();
        dropdown.staticDropdown();
        test.pass("successfully" +"<br />"
                + "selected AED option from dropdown");

    }
    /*
    @Test(dataProvider = "testdata")
    public void DropdownLoopingTest(String QAClickJetUrl) throws InterruptedException {
        test = extent.createTest("QAClickJetTest2");
        test.log(Status.INFO, "Starting Test Cases");
        driver.navigate().to(QAClickJetUrl);
        test.pass("Navigated to QAClickWebsite"+ QAClickJetUrl);
        //..........
        HomePage dropdown = new HomePage();

            dropdown.dropDownlooping();
            test.pass("successfully added 5 passengers");


    }


    @Test(dataProvider = "testdata")
    public void DropdownAutoSuggestive(String QAClickJetUrl) throws InterruptedException {
        test = extent.createTest("QAClickJetTest3");
        test.log(Status.INFO, "Starting Test Cases");
        driver.navigate().to(QAClickJetUrl);
        test.pass("Navigated to QAClickWebsite"+ QAClickJetUrl);
        //..........
        HomePage dropdown = new HomePage();

        dropdown.dropDownAutoSuggestive();
        test.pass("India was successfully selected from the country text box");

    }


    @Test(dataProvider = "testdata")
    public void DropdownDynamics(String QAClickJetUrl) throws InterruptedException {
        test = extent.createTest("QAClickJetTest4");
        test.log(Status.INFO, "Starting Test Cases");
        driver.navigate().to(QAClickJetUrl);
        test.pass("Navigated to QAClickWebsite"+ QAClickJetUrl);
        //..........
        HomePage dropdown = new HomePage();

        dropdown.dropDownDynamic();
        test.pass("Bengaluru(BLR) and Chennai(MAA) were successfully selected in From/To dropdown");
    }



    @Test(dataProvider = "testdata")
    public void Checkboxes(String QAClickJetUrl) throws InterruptedException {
        test = extent.createTest("QAClickJetTest5");
        test.log(Status.INFO, "Starting Test Cases");
        driver.navigate().to(QAClickJetUrl);
        test.pass("Navigated to QAClickWebsite"+ QAClickJetUrl);
        //..........
        HomePage checkbox = new HomePage();
        checkbox.checkboxes();


    }


    @Test(dataProvider = "testdata")
    public void radio(String QAClickJetUrl) {
        test = extent.createTest("QAClickJetTest6");
        test.log(Status.INFO, "Starting Test Cases");
        driver.navigate().to(QAClickJetUrl);
        test.pass("Navigated to QAClickWebsite" + QAClickJetUrl);
        //..........
        HomePage RoundTripRadio = new HomePage();
        RoundTripRadio.radio();
    }

/*
    @Test(dataProvider = "testdata")
    public void EndtoEndSearch(String QAClickJetUrl) throws InterruptedException {
        test = extent.createTest("QAClickJetTest7");
        test.log(Status.INFO, "Starting Test Cases");
        driver.navigate().to(QAClickJetUrl);
        test.pass("Navigated to QAClickWebsite" + QAClickJetUrl);
        //..........
        HomePage obj = new HomePage();


        obj.staticDropdown();
        test.pass("staticDropdown success");
        obj.dropDownlooping();
        test.pass("dropDownlooping success");
        obj.dropDownAutoSuggestive();
        test.pass("dropDownAutoSuggestive success");
        obj.dropDownDynamic();
        test.pass("dropDownDynamic success");
        obj.checkboxes();
        test.pass("checkboxes success");
        obj.radio();
        test.pass("radio success");

        obj.Search();
        test.pass("Search success");

    }
*/
}