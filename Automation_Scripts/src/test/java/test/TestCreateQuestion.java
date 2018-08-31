package test;


import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pageFactory.Gmail;
import pageFactory.SalesForceLogin;
import pageFactory.SalesforceChatter;

public class TestCreateQuestion extends BaseClass{

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
	    String message = objData.createARandomText("question");
	    String description = objData.createARandomText("description");
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
	    objChatterPage.createChatterQuestion(message, description);
	    //verify if text is present
	    Assert.assertTrue(objChatterPage.verifyTextPresent(message));
	    
	    //verification on the email
	    driver.get(gmailUrl);
		objGmail.loginGmail(gmailEmail, gmailPass);
		objGmail.clickFirstEmail();
		Assert.assertTrue(isTextPresent(message));
		Assert.assertTrue(isTextPresent(description));
    }
}