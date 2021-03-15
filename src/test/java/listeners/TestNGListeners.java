package listeners;

import com.BaseClassWebDriver;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.BaseClass;

import java.io.IOException;

import static utils.Utility.getScreenshot;
import static utils.Utility.takescreenShot;

public class TestNGListeners extends BaseClassWebDriver implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("******Test Started : "+result.getName());

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("******Test is successful : "+result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("******Test failed : "+result.getName());
        test.fail(MarkupHelper.createLabel(result.getName()+" Test Case Failed", ExtentColor.RED));
        test.fail(result.getThrowable());
        test.fail("details",
                MediaEntityBuilder.createScreenCaptureFromPath("../" + getScreenshot(driver)).build());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("******Test Skipped : "+result.getName());
        test.skip(MarkupHelper.createLabel(result.getName()+ " Test Case Skipped", ExtentColor.YELLOW));
        test.skip(result.getThrowable());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("******Test completed : "+context.getName());
        driver.quit();
    }
}
