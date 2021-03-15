package test.YahooWebsiteTest;

import com.BaseClassWebDriver;
import com.aventstack.extentreports.ExtentTest;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.BaseClass.extent;


public class Login extends BaseClassWebDriver {




    @DataProvider(name = "testdata")
    public Object[][] getData(){
        String excelPath =  projectPath+"/excel/login.xlsx";
        Object data[][] = testData(excelPath, "Sheet2");
        return data;
    }

    @Test(dataProvider = "testdata")

    public void login(String yahoo) {

        //test = extent.createTest("Login to Yahoo", "Login To Yahoo Site");
        test = extent.createTest("Test");
        try {
            driver.get(yahoo);
            Thread.sleep(2000);
            test.log(Status.INFO, "Starting Test Case");
            test.info("Navigated to " + yahoo);


            WebElement add = driver.findElement(By.xpath("//body/div[@id='Masterwrap']/div[@id='Page']/main[@id='Main']/div[@id='applet_p_50000314']/div[1]/ul[1]/li[38]/div[1]/div[1]/div[1]/div[1]/div[2]/a[1]/h3[1]"));


            Assert.assertEquals(add.getText(), "30 Celebrities Who Have Destroyed Their Looks");
           // WebElement header = driver.findElement(By.xpath("//header[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]"));
           // Assert.assertEquals(header.getText(), "Make Yahoo Your xxxxxx Homepage");

            test.pass("right site");
            driver.close();
        }catch (Exception exp){
            test.log(Status.FAIL, exp.getCause().getMessage());
        }
    }



}




