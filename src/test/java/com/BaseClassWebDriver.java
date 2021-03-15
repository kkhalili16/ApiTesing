package com;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import config.PropertiesFile;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import utils.ExcelUtils;
import utils.Utility;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static com.BaseClass.extent;

public class BaseClassWebDriver {
   // public static Logger logger = LogManager.getLogger(OrangeHRM.class);
    public static WebDriver driver = null;
    public static String browserName = null;
    public String projectPath = System.getProperty("user.dir");
    public ExcelUtils excel = new ExcelUtils(projectPath+"/excel/data.xlsx", "Sheet1");
  //  public String Environment = "Test";
   // public static ExtentSparkReporter spark;
    public static ExtentReports extent;
    public static ExtentTest test;
    // Base constroctor if we want to exceute any code first before running the test
    public BaseClassWebDriver(){
        // System.out.println("Hello World");
    }

    @Parameters({"baseurl"})
    @BeforeSuite
        public void start (String baseurl){
/*
            extent = new ExtentReports();
            spark = new ExtentSparkReporter("target/spark/Spark.html");
            spark.config().setTheme(Theme.STANDARD);
            spark.config().setDocumentTitle("https://login.yahoo.com/");
            spark.config().setEncoding("utf-10");
            spark.config().setReportName("Automation Report");
            spark.config().setTimelineEnabled(true);
            extent.attachReporter(spark);
            extent.setSystemInfo("Host", baseurl);
            extent.setSystemInfo("Environment", Environment);
            extent.setSystemInfo("User Name", "Anwar A");
            System.out.println("Test Started");
            */

//Step1
        ExtentSparkReporter reporter = new ExtentSparkReporter("Reports/report.html");
//optional...
        reporter.config().setDocumentTitle("My Project name");
        reporter.config().setReportName("All regression tests");

 //step2
        extent = new ExtentReports();
 //step3
        extent.attachReporter(reporter);
//optional...
        extent.setSystemInfo("Company Name","Yahoo");
        extent.setSystemInfo("Project Name","QA");
        extent.setSystemInfo("Testers Name","Ahmad");
        extent.setSystemInfo("Test Lead","xyz");





    }

    @Parameters({"browser","baseurl"})
    @BeforeClass
    public void setUpTest(String browser, String baseurl){
        PropertiesFile.getProperties();
        System.out.println("Browser name is : "+browser);
        System.out.println("Thread id is : "+Thread.currentThread().getId());

        if(browser.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        else if(browser.equalsIgnoreCase("FireFox")){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        //What is explicit wait
        // Explicit waits can be set for specific elements / can be set for specific condition / E.g. wait until element is clickable

        ///What is implicit wait
        // Is used to define a time (period) untill when wbdriver should wait before throwing No Such Element exception
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get(baseurl);
    }


    public Object[][] testData(String excelPath, String sheetName){
        ExcelUtils excel = new ExcelUtils(excelPath,sheetName);
        int rowCount = excel.getRowCount();
        int colCount = excel.getColCount();
        // rowCount-1 because the first row has the headers
        Object data[][] = new Object[rowCount-1][colCount];
        for(int i=1; i<rowCount; i++){
            for(int j=0; j<colCount; j++){
                String cellData = excel.getCellDataString(i,j);
                System.out.print(cellData+" | ");
                data[i-1][j] = cellData;
            }
            System.out.println();
        }
        return data;
    }



    @AfterClass
    public void end() throws IOException {
        System.out.println("Test Completed");
        // this step "flush" will create the extent report
        extent.flush();
        driver.close();
        driver.quit();
    }

    @AfterSuite
    public void teardown() throws IOException {
        System.out.println("**********End of Suite");
    }
}



