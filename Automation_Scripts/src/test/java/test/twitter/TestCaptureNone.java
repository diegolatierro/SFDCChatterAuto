package test.twitter;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageFactory.Data;
import pageFactory.SocialMediaCreateArchiveFrom;
import pageFactory.SocialMediaDashboard;
import pageFactory.SocialMediaLogin;
import pageFactory.Twitter;
import pageFactory.TwitterArchive;

public class TestCaptureNone {

	WebDriver driver;
	SocialMediaLogin objLogin;
	SocialMediaDashboard objDashboardPage;
	SocialMediaCreateArchiveFrom objCreateArchiveFrom;
	Data objData;
	Twitter objTwitter;
	TwitterArchive objTwitterArchive;

	@BeforeClass
	public void setup(){
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		objData = new Data(driver);
		objTwitter = new Twitter(driver);
		objTwitterArchive = new TwitterArchive(driver);
		driver.get(objData.getSocialMediaLoginURL());   
	}

	@Test
	public void test_NoCapture() throws InterruptedException {
		String twitterUser = objData.getTwitterUserField();
		String twitterPass = objData.getTwitterPassField();
		String archive = objData.getArchiveField();
		String URL = objData.getUrlField();
		String email = objData.getEmailField();
		String socialMediaUser = objData.getSocialMediaUserField();
		String socialMediaPass = objData.getSocialMediaPassField();
		String archiveCreateSuccessMessage = objData.getSuccessArchiveCreationMessage();
		String socialMediaDashboardURL = objData.getSocialMediaDashboardURL();
		String successArchiveDeleteMessage = objData.getSuccessArchiveDeleteMessage();
		String dataCollectionLabel = objData.getDataCollectionLabel();
		String archiveurl;	
		String tweet = objTwitter.createARandomTweet("random tweet");
		String firstTweet;

		//Create Login Page object
		objLogin = new SocialMediaLogin(driver);
		//login to application
		objLogin.loginToSocialMedia(socialMediaUser, socialMediaPass);
		objDashboardPage = new SocialMediaDashboard(driver);
		objCreateArchiveFrom  = new SocialMediaCreateArchiveFrom(driver);
		// step 1 and 2 Click on Create Archive and Select Twitter
		objDashboardPage.clickCreateArchiveTwitter();
		// step 3 Write a twitter account
		objCreateArchiveFrom.writeURL(URL);
		//do not check the checkbox
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
		

		//ASSERT THE ARCHIVE CORRECTLY CREATED
		Assert.assertTrue(objCreateArchiveFrom.getToastMessage().equals(archiveCreateSuccessMessage));
		
		objDashboardPage.pause();
		objDashboardPage.clickDashboard();

		// step 1 find archive
		objDashboardPage.searchArchive(archive);

		// open archive
		objDashboardPage.openFirstArchive();
		archiveurl = driver.getCurrentUrl();
		// step 2 go to twitter and log in
		driver.get(objData.getTwitterURL());
		objTwitter.loginTwitter(twitterUser, twitterPass);
		// step 3 and 4 create a tweet
		objTwitter.createATweet(tweet);

		// step 5 go back to archive
		driver.get(archiveurl);
		
		if (!objTwitterArchive.getNoResults().equals(objData.getEmpty())) {
			Assert.fail("archive did not remain empty");
		}
		
		objTwitterArchive.clickDashboard();
		objDashboardPage.pause();
		objDashboardPage.searchArchive(archive);
		objDashboardPage.pause();
		objDashboardPage.deleteArchive();
		Assert.assertTrue(objCreateArchiveFrom.getToastMessage().equals(successArchiveDeleteMessage));


	}

}
