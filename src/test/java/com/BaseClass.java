package com;

import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;
//import config.PropertiesFile;
import utils.ExcelUtils;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import org.testng.annotations.Parameters;
import com.aventstack.extentreports.ExtentTest;

//import static com.BaseClassWebDriver.spark;

public class BaseClass {
    //public static Logger logger = LogManager.getLogger(OrangeHRM.class);
    public static RemoteWebDriver chrome = null;
    public static RemoteWebDriver firefox = null;
    public static String browserName = null;

    public String projectPath = System.getProperty("user.dir");
    public ExcelUtils excel = new ExcelUtils(projectPath+"/excel/data.xlsx", "Sheet1");
    //public String Baseurl = "https://opensource-demo.orangehrmlive.com/";
    //public String Baseurl = "http://www.tinyupload.com";
    public String Environment = "Prod";
    //public static ExtentSparkReporter spark;
    public static ExtentReports extent;
    public static ExtentTest test;
    // Base constroctor if we want to exceute any code first before running the test
    public BaseClass(){
        // System.out.println("Hello World");
    }

    @Parameters({"baseurl"})
    @BeforeSuite
        public void start(String baseurl) {
/*
        extent = new ExtentReports();
        spark = new ExtentSparkReporter("target/Spark/Spark.html");
        spark.config().setTheme(Theme.STANDARD);
        spark.config().setDocumentTitle("tinyupload.com");
        spark.config().setEncoding("utf-10");
        spark.config().setReportName("Automation Report");
        spark.config().setTimelineEnabled(true);
        extent.attachReporter(spark);
        extent.setSystemInfo("Host", baseurl);
        extent.setSystemInfo("Environment", Environment);
        extent.setSystemInfo("User Name", "Adam Salem");
        System.out.println("Test Started");
        */
    }

    @Parameters({"browser","baseurl", "gridurl"})
    @BeforeClass
    public void setUpTest(String browser, String baseurl, String gridurl){
       // PropertiesFile.getProperties();
        System.out.println("Browser name is : "+browser);
        System.out.println("Thread id is : "+Thread.currentThread().getId());
        ChromeOptions options = new ChromeOptions();
        FirefoxOptions options2 = new FirefoxOptions();
        if(browser.equalsIgnoreCase("chrome")){

            try {
                chrome = new RemoteWebDriver(new URL(gridurl), options);
                chrome.get(baseurl);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
        else if(browser.equalsIgnoreCase("FireFox")){
            //WebDriverManager.firefoxdriver().setup();
            try {
                firefox = new RemoteWebDriver(new URL(gridurl), options2);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            chrome.get(baseurl);
                firefox = new FirefoxDriver();
                firefox.get(baseurl);
        }
        //driver.manage().window().maximize();
        //driver.manage().deleteAllCookies();
        //driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        //What is explicit wait
        // Explicit waits can be set for specific elements / can be set for specific condition / E.g. wait until element is clickable

        ///What is implicit wait
        // Is used to define a time (period) untill when wbdriver should wait before throwing No Such Element exception
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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
    }

    @AfterSuite
    public void teardown() throws IOException {
        System.out.println("**********End of Suite");
    }
}



