package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pageFactory.Gmail;
import pageFactory.SalesForceLogin;
import pageFactory.SalesforceChatter;

public class TestCreateLotsOfPosts extends BaseClass{

    SalesForceLogin objLogin;
    SalesforceChatter objChatterPage;
    Gmail objGmail;

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
    	int nrOfpost = 2;
	    String message = objData.createARandomText("post");
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
	    for (int i=1;i<=nrOfpost;i++) {
	    	objChatterPage.createChatterPost(message+" post nr "+i);
	    }
	    
	    //verify if text is present
	    //Assert.assertTrue(objChatterPage.verifyTextPresent(message));
	    
	    //verification that the post is no the email
	    driver.get(gmailUrl);
		objGmail.loginGmail(gmailEmail, gmailPass);
		//step 11 Click on connect button from the email
		objGmail.clickFirstEmail();
		Assert.assertTrue(isTextPresent(message));
    }
}