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
import pageFactory.SocialMediaEditArchiveForm;
import pageFactory.SocialMediaCreateArchiveFrom;
import pageFactory.SocialMediaLogin;
import pageFactory.Data;
import pageFactory.Gmail;

public class TestCreateAnArchiveEdit {

    WebDriver driver;
    SocialMediaLogin objLogin;
    SocialMediaDashboard objDashboardPage;
    SocialMediaCreateArchiveFrom objCreateArchiveFrom;
    SocialMediaEditArchiveForm objEditArchive;
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
     * "1. Click on Create Archive
		2. Select Twitter
		3. Write a twitter account
		4. Check the get messages option
		5. Write an admin email
		6. Click on Next
		7. Select __TESTGROUP on the group
		8. Select Manager on Archive Role
		9. Click on Save
     * 		
     */

    @Test(priority=0)
    public void test_Create_Archive_Edit(){

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
		objDashboardPage = new SocialMediaDashboard(driver);
		objCreateArchiveFrom = new SocialMediaCreateArchiveFrom(driver);
		objEditArchive  = new SocialMediaEditArchiveForm(driver);
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
		Assert.assertTrue(objCreateArchiveFrom.getToastMessage().equals(archiveCreateSuccessMessage));
		
		//go back to the dashobard
		driver.get(socialMediaDashboardURL);
		
		//step 13. Search for the archive recently created
		objDashboardPage.searchArchive(archive);
		
		//step 15 open edit page
		//objDashboardPage.clickOnEditArchive();
		
		//step 16 edit email
		objEditArchive.editEmail("edit_"+email);
		//go to permisions and edit group and role
		objEditArchive.clickOnPermission();
		objEditArchive.selectGroup();
		objEditArchive.pauseToast();
		objEditArchive.selectRole();
		//save changes
		objEditArchive.saveChanges();
		objEditArchive.pause();
		objDashboardPage.clickDashboard();
		objDashboardPage.pause();
		//go back to edit page and verify changes
		objDashboardPage.clickOnEditArchive();
		objDashboardPage.pauseToast();
		if (!objEditArchive.emailValue().equals("edit_"+email)) {
			Assert.fail("email was not updated");
		}
		objEditArchive.clickOnPermission();
		if (!objEditArchive.groupValue().equals("asd1") && !objEditArchive.roleValue().equals("Owner")) {
			Assert.fail("permissions was not updated");
		}
		objDashboardPage.clickDashboard();
		objDashboardPage.pause();
		objDashboardPage.deleteArchive();
		Assert.assertTrue(objCreateArchiveFrom.getToastMessage().equals(successArchiveDeleteMessage));
    }
    
	@AfterClass
	public void exit () {
		driver.close();
	}
}