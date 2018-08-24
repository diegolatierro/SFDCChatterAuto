package test;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseClass;
import pageFactory.Data;
import pageFactory.Gmail;
import pageFactory.SalesForceLogin;
import pageFactory.SalesforceChatter;

public class TestCreatePoll extends BaseClass{

    SalesForceLogin objLogin;
    SalesforceChatter objChatterPage;
    Gmail objGmail;

    /**
     * This test go to http://login.salesforce.com
     * Login to application
     * create a chatter post
     * 		
     */

    @Test(priority=0)
    public void test_Create_Chatter_Post(){
    	objGmail = new Gmail(driver);
	    String message = objData.createARandomText("poll");
	    String choice1 = objData.createARandomText("choice 1");
	    String choice2 = objData.createARandomText("choice 2");
	    String gmailUrl = objData.getGmailURL();
    	String gmailEmail = objData.getGmailUserField();
    	String gmailPass = objData.getGmailPassField();
	    //Create Login Page object
	    objLogin = new SalesForceLogin(driver);
	    //login to application
	    objLogin.loginToSalesforce(objData.getSalesforceUser(),objData.getSalesforcePass());
	    objChatterPage = new SalesforceChatter(driver);
	    //create a chatter post
	    objChatterPage.createChatterPoll(message, choice1, choice2);
	    //verify if text is present
	    //Assert.assertTrue(objChatterPage.verifyTextPresent(message));
	    //verification that the post is no the email
	    driver.get(gmailUrl);
		objGmail.loginGmail(gmailEmail, gmailPass);
		//step 11 Click on connect button from the email
		System.out.println("text is: " + objGmail.clickFirstEmailAndGetPoll());
		Assert.assertTrue(objGmail.clickFirstEmailAndGetPoll().contains(message));
		Assert.assertTrue(objGmail.clickFirstEmailAndGetPoll().contains(choice1));
		Assert.assertTrue(objGmail.clickFirstEmailAndGetPoll().contains(choice2));
    }
}