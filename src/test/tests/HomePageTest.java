package tests;

import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;
import org.testng.annotations.BeforeMethod;
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import java.lang.reflect.Method;


public class HomePageTest extends BaseTest {

    HomePage homePage;
    @BeforeMethod(alwaysRun = true)
    public void setUp(ITestResult result, Method method){
        super.setUp(method, result);
        homePage = new HomePage(getDriver());
    }
    @Test
    public void verifyTitle(){
        extentTest.log(LogStatus.INFO, "Verify title of Home Page");
        Assert.assertEquals(getDriver().getTitle(), "TLA Automation");
    }

    @Test(description = "Testing all navigation buttons are present")
    public void verifyNavButtons(){
        screenshot.takeScreenshotAndLog();
        homePage.sleep(2000);
        for (String button: homePage.navButtons){
            Assert.assertTrue(getDriver().findElement(By.linkText(button)).isDisplayed());
            extentTest.log(LogStatus.PASS, "Tested button: " + button.toUpperCase() + " - with success");
        }
    }




}