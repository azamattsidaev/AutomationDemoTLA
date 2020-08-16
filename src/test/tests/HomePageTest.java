package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;

import java.lang.reflect.Method;

public class HomePageTest extends BaseTest {

    HomePage homePage;

    @Test
    public void validatePageHeader(){

        Assert.assertEquals(homePage.headerText.getText(), "Products");
    }

}