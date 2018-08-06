package test;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageFactory.SalesForceLogin;
import pageFactory.SalesforceChatter;

public class TestCreateQuestion {

    WebDriver driver;
    SalesForceLogin objLogin;
    SalesforceChatter objChatterPage;

    @BeforeTest
    public void setup(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://na72.lightning.force.com/lightning/page/chatter");
    }

    /**
     * This test go to http://login.salesforce.com
     * Login to application
     * create a chatter post
     * 		
     */

    @Test(priority=0)
    public void test_Create_Chatter_Post(){
    String message = "automated question message from DiegoBot4";
    String description = "description for automated question";
    //Create Login Page object
    objLogin = new SalesForceLogin(driver);
    //login to application
    objLogin.loginToSalesforce("diegolatierro@pf.com", "latierro050985");
    objChatterPage = new SalesforceChatter(driver);
    //create a chatter post
    objChatterPage.createChatterQuestion(message, description);
    //verify if text is present
    Assert.assertTrue(objChatterPage.verifyTextPresent(message));
    }
}