package test.twitter;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageFactory.Data;
import pageFactory.SocialMediaDashboard;
import pageFactory.SocialMediaLogin;
import pageFactory.Twitter;
import pageFactory.TwitterArchive;

public class TestCaptureMessages {

	WebDriver driver;
	SocialMediaLogin objLogin;
	SocialMediaDashboard objDashboardPage;
	Data objData;
	Twitter objTwitter;
	TwitterArchive objTwitterArchive;

	@BeforeClass
	public void setup() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		objData = new Data(driver);
		objTwitter = new Twitter(driver);
		objTwitterArchive = new TwitterArchive(driver);
        driver.get(objData.getSocialMediaLoginURL());
	}

	/**
	 * add steps
	 * @throws InterruptedException 
	 * 
	 */

	@Test(priority = 0)
	public void test_CaptureTweet() throws InterruptedException  {
		String socialMediaUser = objData.getSocialMediaUserField();
    	String socialMediaPass = objData.getSocialMediaPassField();
    	
		String message = objTwitter.createARandomTweet("random message");
		String messageTo = objData.getTwitterUserField2();
		String twitterUser = objData.getTwitterUserField3();
		String twitterPass = objData.getTwitterPassField3();
		String archive = objData.getTwitterArchiveName();
		String archiveurl;	
		String firstMessage;
		
		// Create Login Page object
		objLogin = new SocialMediaLogin(driver);
		// login to application
		objLogin.loginToSocialMedia(socialMediaUser, socialMediaPass);
		objDashboardPage = new SocialMediaDashboard(driver);
		// step 1 find archive
		objDashboardPage.searchArchive(archive);
				
		// open archive
		objDashboardPage.openFirstArchive();
		archiveurl = driver.getCurrentUrl();
		// step 2 go to twitter and log in
		driver.get(objData.getTwitterURL());
		objTwitter.loginTwitter(twitterUser, twitterPass);
		// step 3 and 4 create a message to @tester_smc2
		
		
		objTwitter.createAMessageTo(messageTo,message);
		
		// step 5 go back to archive
		driver.get(archiveurl);
		
		//click on messages on the app
		objTwitterArchive.clickOnMessagesLink();
		//check top message and ensure it matches what was entered
		firstMessage = objTwitterArchive.getFirstMessageFromDashboard();
		//System.out.println(message);
		//System.out.println(firstMessage);
		Assert.assertEquals(message, firstMessage);
	}
	
	@AfterClass
	public void exit () {
		driver.close();
	}
}
