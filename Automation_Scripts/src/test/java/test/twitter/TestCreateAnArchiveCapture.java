package test.twitter;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageFactory.SocialMediaDashboard;
import pageFactory.SocialMediaCreateArchiveFrom;
import pageFactory.SocialMediaLogin;
import pageFactory.Data;
import pageFactory.Gmail;

public class TestCreateAnArchiveCapture {

    WebDriver driver;
    SocialMediaLogin objLogin;
    SocialMediaDashboard objDashboardPage;
    SocialMediaCreateArchiveFrom objCreateArchiveFrom;
    Gmail objGmail;
    Data objData;

    @BeforeClass
    public void setup(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        objData = new Data(driver);
        driver.get(objData.getSocialMediaLoginURL());
        
    }

    /**
     * Precondition to assure that the archive is not already created is necessary
     * 
     * "1. Click on Create Archive
		2. Select Twitter
		3. Write a twitter account
		4. check the get messages checkbox
		5. Write an admin email
		6. Click on Next
		7. Select __TESTGROUP on the group
		8. Select Manager on Archive Role
		9. Click on Save
		10. Check and click the email to connect the account
		11. Click on connect button from the email
		12. Click on Authorize
		13. Search for the archive recently created
		14. Verify Data collection on Social Media Dashboard"
     * 		
     */

    @Test
    public void test_Create_Archive_Capture(){
    
    	String twitterUser = objData.getTwitterUserField();
    	String twitterPass = objData.getTwitterPassField();
    	String gmailEmail = objData.getGmailUserField();
    	String gmailPass = objData.getGmailPassField();
    	String archive = objData.getArchiveField();
    	String URL = objData.getUrlField();
    	String email = objData.getEmailField();
    	String socialMediaUser = objData.getSocialMediaUserField();
    	String socialMediaPass = objData.getSocialMediaPassField();
    	String gmailUrl = objData.getGmailURL();
    	String archiveCreateSuccessMessage = objData.getSuccessArchiveCreationMessage();
    	String archiveSuccessAuthentication = objData.getSuccessAuthenticationMessage();
    	String socialMediaDashboardURL = objData.getSocialMediaDashboardURL();
    	String successArchiveDeleteMessage = objData.getSuccessArchiveDeleteMessage();
    	String dataCollectionLabel = objData.getDataCollectionLabel();
    	
    	objGmail = new Gmail(driver);
		//Create Login Page object
		objLogin = new SocialMediaLogin(driver);
		//login to application
		objLogin.loginToSocialMedia(socialMediaUser, socialMediaPass);
		//add assert about correct login
		
		objDashboardPage = new SocialMediaDashboard(driver);
		objCreateArchiveFrom  = new SocialMediaCreateArchiveFrom(driver);
		
		
		//precondition VERIFY IF ELEMENT ALREADY EXISTS
		//System.out.println(objDashboardPage.verifyIfArchiveExists(archive));
		
		
		// step 1 and 2 Click on Create Archive and Select Twitter
		objDashboardPage.clickCreateArchiveTwitter();
		// step 3 Write a twitter account
		objCreateArchiveFrom.writeURL(URL);
		//CHECK THE CHECKBOX
		objCreateArchiveFrom.checkGetMessages();
		// step 4 Write an admin email
		objCreateArchiveFrom.writeEmail(email);
		// step 5 Click on Next
		objCreateArchiveFrom.clickOnNext();
		//step 6 Select __TESTGROUP on the group
		objCreateArchiveFrom.selectGroup();
		// step 7 Select Manager on Archive Role
		objCreateArchiveFrom.selectRole();
		// step 8 Click on Save
		objCreateArchiveFrom.clickOnCreate();
		// add validation to the modal
		Assert.assertTrue(objCreateArchiveFrom.getToastMessage().equals(archiveCreateSuccessMessage));
		
		//Email section
		//go to gmail and open the email
		// step  10 Check and click the email to connect the account (BASIC HTML)
		driver.get(gmailUrl);
		objGmail.loginGmail(gmailEmail, gmailPass);
		//step 11 Click on connect button from the email
		objGmail.checkFirstEmailAndClickConnect();
		
		//step 12. Click on Authorize
		//it will ask for user and pass from twitter
		objGmail.completeTwDataOnEmail(twitterUser, twitterPass);
		objGmail.clickAuthorizeApp();
		
		//assert success lightbox and close it
		Assert.assertTrue(objDashboardPage.getSuccessModalAlert().equals(archiveSuccessAuthentication));
		//I should close the modal but since html is complicated is easier to reload the page
		driver.get(socialMediaDashboardURL);
		
		//step 13. Search for the archive recently created
		objDashboardPage.searchArchive(archive);
		//step 14. Verify Data collection on Social Media Dashboard"
		Assert.assertTrue(objDashboardPage.getArchiveDataCollectionStatus().equals(dataCollectionLabel));
		
		//add a final module to delete
		//after the validation the test must destroy the objects
		objDashboardPage.deleteArchive();
		Assert.assertTrue(objCreateArchiveFrom.getToastMessage().equals(successArchiveDeleteMessage));
    }
 
	@AfterClass
	public void exit () {
		driver.close();
	}
   
}