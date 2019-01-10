package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pageFactory.Gmail;
import pageFactory.SalesForceLogin;
import pageFactory.SalesforceChatter;

public class TestCreateCommentOnPoll extends BaseClass{

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
    public void test_Create_Comment_Poll(){    	
    	objGmail = new Gmail(driver);
	    String message = objData.createARandomText("poll");
	    String choice1 = objData.createARandomText("choice 1");
	    String choice2 = objData.createARandomText("choice 2");
	    String comment = objData.createARandomText("comment");
	    String salesforceUser = objData.getSalesforceUser();
	    String salesforcePass = objData.getSalesforcePass();
	    String gmailUrl = objData.getGmailURL();
    	String gmailEmail = objData.getGmailUserField();
    	String gmailPass = objData.getGmailPassField();
	    
	    
	    //Create Login Page object
	    objLogin = new SalesForceLogin(driver);
	    //login to application
	    System.out.println(salesforceUser);
	    objLogin.loginToSalesforce(salesforceUser,salesforcePass);
	    objChatterPage = new SalesforceChatter(driver);
	    //create a chatter post
	    objChatterPage.createChatterPoll(message, choice1, choice2);
	    //verify if text is present
	    Assert.assertTrue(objChatterPage.verifyTextPresent(message));
	    //create a comment
	    
	    objChatterPage.createChatterCommentForPoll(comment);
	    
	    //verification that the post is no the email
	    driver.get(gmailUrl);
		objGmail.loginGmail(gmailEmail, gmailPass);
		//step 11 verify the comment created

		objGmail.clickFirstEmail();
		Assert.assertTrue(isTextPresent(comment));
	}
}