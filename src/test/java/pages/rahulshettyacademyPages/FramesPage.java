package pages.rahulshettyacademyPages;

import com.BaseClassWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FramesPage extends BaseClassWebDriver {

public void Nested_frames_page(){


    WebElement parentFrame = driver.findElement(By.xpath("//frame[@name='frame-top']"));


   // driver.switchTo().frame("frame-top");
   // driver.switchTo().frame("frame-middle");
//or
    driver.switchTo().frame(parentFrame);
    driver.switchTo().frame(1);
    System.out.println(driver.findElement(By.xpath("//div[@id='content']")).getText());


}


}
