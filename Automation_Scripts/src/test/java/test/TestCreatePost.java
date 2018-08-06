package test;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageFactory.Data;
import pageFactory.Gmail;
import pageFactory.SalesForceLogin;
import pageFactory.SalesforceChatter;

public class TestCreatePost {

    WebDriver driver;
    SalesForceLogin objLogin;
    SalesforceChatter objChatterPage;
    Data objData;
    Gmail objGmail;

    @BeforeTest
    public void setup(){
        driver = new FirefoxDriver();
        objData = new Data(driver);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get(objData.getChatterUrl());
    }

    /**
     * precondition: have the rule set up
     * 
     * This test go to http://login.salesforce.com
     * Login to application
     * create a chatter post
     * verify that the post got to the email		
     */

    @Test(priority=0)
    public void test_Create_Chatter_Post(){    	
    	objGmail = new Gmail(driver);
	    String message = objData.createARandomTweet("post");
	    String salesforceUser = objData.getSalesforceUser();
	    String salesforcePass = objData.getSalesforcePass();
	    String gmailUrl = objData.getGmailURL();
    	String gmailEmail = objData.getGmailUserField();
    	String gmailPass = objData.getGmailPassField();
	    
	    
	    //Create Login Page object
	    objLogin = new SalesForceLogin(driver);
	    //login to application
	    objLogin.loginToSalesforce(salesforceUser,salesforcePass);
	    objChatterPage = new SalesforceChatter(driver);
	    //create a chatter post
	    objChatterPage.createChatterPost(message);
	    //verify if text is present
	    Assert.assertTrue(objChatterPage.verifyTextPresent(message));
	    
	    //verification that the post is no the email
	    driver.get(gmailUrl);
		objGmail.loginGmail(gmailEmail, gmailPass);
		//step 11 Click on connect button from the email
		Assert.assertEquals(objGmail.clickFirstEmailAndGetMessage(), message);
    }
}