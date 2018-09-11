package test;


import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pageFactory.Gmail;
import pageFactory.SalesForceLogin;
import pageFactory.SalesforceChatter;

public class TestEditCommentOnPost extends BaseClass{

    //WebDriver driver;
    SalesForceLogin objLogin;
    SalesforceChatter objChatterPage;
    //Data objData;
    Gmail objGmail;

    /**
     * precondition: have the rule set up
     * 
     * This test go to http://login.salesforce.com
     * Login to application
     * create a chatter post
     * verify that the post got to the email		
     */

    @Test
    public void test_Edit_Comment_Post(){    	
    	objGmail = new Gmail(driver);
	    String message = objData.createARandomText("post");
	    String comment = objData.createARandomText("comment");
	    String newComment = objData.createARandomText("edit comment");
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
	    //create a comment
	    objChatterPage.createChatterCommentForPost(comment);
	    //edit a comment
	    
	    //UNABLE TO CLICK EDIT ON COMMENT (EDIT AND DELETE COMMENTS WILL BE SUSPENDED)
	    //objChatterPage.editChatterCommentForPost(newComment);
	    
	    js.executeScript("arguments[0].click();", SalesforceChatter.postCommentPicklist);
	    objChatterPage.pause();
	    js.executeScript("arguments[0].click();", SalesforceChatter.postCommentEditButton);
	    objChatterPage.editChatterCommentForPost(newComment);
	    
	     
	    //verification that the post is no the email
	    driver.get(gmailUrl);
		objGmail.loginGmail(gmailEmail, gmailPass);
		//step 11 verify the comment created
		objGmail.clickFirstEmail();
		Assert.assertTrue(isTextPresent(newComment+comment));
    }
}