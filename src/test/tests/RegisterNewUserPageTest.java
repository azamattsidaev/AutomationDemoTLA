package tests;

import base.BaseTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CommonPage;
import pages.HomePage;
import pages.RegisterNewUserPage;

import java.lang.reflect.Method;

public class RegisterNewUserPageTest extends BaseTest {


    RegisterNewUserPage registerNewUserPage;
    CommonPage commonPage;
    @BeforeMethod
    public void setUp(Method method, ITestResult iTestResult){
        super.setUp(method, iTestResult);
        registerNewUserPage = new RegisterNewUserPage(getDriver());
        commonPage = new CommonPage(getDriver());
        commonPage.clickNavBtn("User-Mgt");
    }
    @Test(description = "Verifying title of User Management Page")
    public void verifyTitle(){
        Assert.assertEquals(getDriver().getTitle(), "Register New User");
        screenshot.takeScreenshotAndLog();
    }
    @Test(description = "Validating <Login> and <Access DB> buttons")
    public void verifyLoginAccessDB_buttons(){
        Assert.assertTrue(registerNewUserPage.accessDbBtn.isDisplayed());
        Assert.assertTrue(registerNewUserPage.loginBtn.isDisplayed());
        screenshot.takeScreenshotAndLog();
    }
    @Test(description = "Testing Registration Form fields")
    public void verifyRgtForm(){
        for (String field: registerNewUserPage.registrationFormFields){
            Assert.assertTrue(commonPage.findById(field).isDisplayed());
            extentTest.log(LogStatus.PASS, commonPage.findById(field).getAttribute("name") + " - was displayed");
        }
        screenshot.takeScreenshotAndLog();
    }
}
