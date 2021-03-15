package utils;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.BaseClassWebDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Utility extends BaseClassWebDriver
{
    public static String getScreenshot(WebDriver driver)
    {
        TakesScreenshot ts=(TakesScreenshot)driver;

        File src=ts.getScreenshotAs(OutputType.FILE);

        //time
        String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
        String path="Reports/screenshots/"+timeStamp+".jpg";
       // String path="Reports/screenshots/"+System.currentTimeMillis()+".jpg";

        File destination=new File(path);

        try
        {
            FileUtils.copyFile(src, destination);
        } catch (IOException e)
        {
            System.out.println("Capture Failed "+e.getMessage());
        }

        return path;
    }


    public static String takescreenShot(WebDriver driver) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File scrFile = ts.getScreenshotAs(OutputType.FILE);

        String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(DateFormat.FULL);
        //.format(new Date());

        String img = "image"+timeStamp+".png";

        FileUtils.copyFile(scrFile,new File("Reports/screenshots/"+img));

        return img;
    }
}
