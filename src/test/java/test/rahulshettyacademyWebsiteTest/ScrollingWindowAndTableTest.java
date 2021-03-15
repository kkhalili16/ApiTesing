package test.rahulshettyacademyWebsiteTest;

import com.BaseClassWebDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.rahulshettyacademyPages.CalenderPage;
import pages.rahulshettyacademyPages.ScrollingWindowAndTablePage;



public class ScrollingWindowAndTableTest extends BaseClassWebDriver {




    @DataProvider(name = "testdata")
    public Object[][] getData() {
        String excelPath = projectPath + "/excel/login.xlsx";
        Object data[][] = testData(excelPath, "Sheet4");
        return data;
    }

    @Test(dataProvider = "testdata")
    public void CalenderTesting(String AlertWebsite) throws InterruptedException {
        driver.navigate().to(AlertWebsite);

        ScrollingWindowAndTablePage scroll = new ScrollingWindowAndTablePage();

       // scroll.ScrollingWindow();
       // scroll.ScrollingTable();
       // scroll.TableGridsHandling();
       // scroll.Assignment7();
        scroll.Assignment8();

        /*DesiredCapabilities ch = DesiredCapabilities.chrome();
        ch.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
        ch.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

        ChromeOptions c = new ChromeOptions();
        c.merge(ch);

        System.getProperty("webdriver.chrome.driver", " ");
        WebDriver driver = new ChromeDriver(c);*/




    }







}
