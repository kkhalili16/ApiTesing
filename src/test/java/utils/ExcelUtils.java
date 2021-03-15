package utils;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

    static String projectpath;
    static XSSFWorkbook workbook;
    static XSSFSheet sheet;

    //no return types for constructor
    public ExcelUtils(String excelPath, String sheetName){
        try{
            projectpath = System.getProperty("user.dir");
            workbook = new XSSFWorkbook(excelPath);
            sheet = workbook.getSheet(sheetName);
        }catch (Exception exp){
           exp.getMessage();
           exp.getCause();
           exp.printStackTrace();
        }
    }
/*
    public static void main(String[] args) {
        //getRowCount();
        getCellDataString(0,0);
        getCellDataNumber(1,2);
    }
*/
    public static int getRowCount(){
        int rowCount = 0;
        try {
            rowCount = sheet.getPhysicalNumberOfRows();
            System.out.println("No of rows : "+rowCount);
        }catch (Exception exp){
            exp.printStackTrace();
            exp.getMessage();
            exp.getCause();
        }
        return rowCount;
    }

    public static int getColCount(){
        int colCount=0;
        try {
            colCount = sheet.getRow(0).getPhysicalNumberOfCells();
            System.out.println("No of column : "+colCount);
        }catch (Exception exp){
            exp.printStackTrace();
            exp.getMessage();
            exp.getCause();
        }
        return colCount;
    }
    public String getCellDataString(int rowNum, int colNum){
        String cellData = null;
        try {
            cellData = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
            //System.out.println("value of the selected cell : "+cellData);

        }catch (Exception exp){
            exp.getMessage();
            exp.getCause();
            exp.printStackTrace();
        }
        return cellData;
    }

    public double getCellDataNumber(int rowNum, int colNum){
        double cellData = 0;
        try {
            cellData = sheet.getRow(rowNum).getCell(colNum).getNumericCellValue();
           // System.out.println(cellData);
        }catch (Exception exp){
            exp.getMessage();
            exp.getCause();
            exp.printStackTrace();
        }
        return cellData;
    }

} // end of class
