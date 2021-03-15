package utils;

import com.aventstack.extentreports.ExtentReports;
import config.PropertiesFile;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExcelDataProvider {
    WebDriver driver = null;
    @BeforeSuite
    public void setUpTest(){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
    }



    @Test(dataProvider = "test1data")
    public void test1(String username, String password){
        try {
            System.out.println(username + " | " + password);
            driver.get("https://opensource-demo.orangehrmlive.com/");
            driver.findElement(By.id("txtUsername")).sendKeys(username);
            driver.findElement(By.id("txtPassword")).sendKeys(password);
            driver.findElement(By.id("btnLogin")).click();
            Thread.sleep(2000);
        }catch (Exception exp){
            exp.getMessage();
            exp.getCause();
            exp.printStackTrace();
        }
    }

    @DataProvider(name = "test1data")
    public Object[][] getData(){
        String projectPath = System.getProperty("user.dir");
        String excelPath =  projectPath+"/excel/data.xlsx";
        Object data[][] = testData(excelPath, "Sheet1");
        return data;
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
}
