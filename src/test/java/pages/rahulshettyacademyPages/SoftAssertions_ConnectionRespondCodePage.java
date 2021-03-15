package pages.rahulshettyacademyPages;

import com.BaseClassWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;


import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;


public class SoftAssertions_ConnectionRespondCodePage extends BaseClassWebDriver {


    public void SoftAssertions_ConnectionsRespondCode_Obj() throws IOException {
        SoftAssert a = new SoftAssert();
        List<WebElement> links = driver.findElements(By.cssSelector("li[class='gf-li'] a"));
        for (WebElement link : links) {

            String url = link.getAttribute("href");
            HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();

            conn.setRequestMethod("HEAD");
            conn.connect();
            int respondCode = conn.getResponseCode();
            System.out.println("\033[43m"+respondCode+"\033[0m\n");

            a.assertTrue(respondCode < 400, "\033[43m The link with text:( "+link.getText()+" ) is broken with respond code("+respondCode+")\033[0m\n");

        }

        a.assertAll();



















/*        SoftAssert a = new SoftAssert();
        List<WebElement> links = driver.findElements(By.cssSelector("li[class='gf-li'] a"));
        for (WebElement link : links) {
            String url = link.getAttribute("href");
            HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
            conn.setRequestMethod("HEAD");
            conn.connect();

            int respondCode = conn.getResponseCode();
            System.out.println(respondCode);


            a.assertTrue(respondCode < 400, "The link with Text" +
                    link.getText() + " is broken with code" + respondCode);
        }

        a.assertAll();*/

    }


}
