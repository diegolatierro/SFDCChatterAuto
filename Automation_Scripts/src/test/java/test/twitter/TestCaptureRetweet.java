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

public class TestCaptureRetweet {

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
	 * "1. Find archive in the dashboard and click on the name 
	 * 2. Open a new tab for twitter and log in  
	 * 3. Click on the `Tweet` Button in the upper right corner
	 * 4. Enter a random valid twiter entry and click `Tweet` 
	 * 5. Go back to the archive and refresh the page after waiting at max one minute 
	 * 6. If tweet does not appear wait a while longer with periodic refreshes
	 * @throws InterruptedException 
	 * 
	 */

	@Test(priority = 0)
	public void test_Capture_Retweet() throws InterruptedException  {
		String socialMediaUser = objData.getSocialMediaUserField();
    	String socialMediaPass = objData.getSocialMediaPassField();
		
		String retweet = objTwitter.createARandomTweet("random retweet");
		String tweet = objTwitter.createARandomTweet("random tweet");
		String twitterUser = objData.getTwitterUserField2();
		String twitterPass = objData.getTwitterPassField2();
		String archive = objData.getTwitterArchiveName();
		String archiveurl;
		String text; //text gotten from the page, should be the same as the reply 

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
		// step 3 and 4 create a tweet
		
		//create a tweet
		objTwitter.createATweet(tweet);
		
		//find tweet refresh to get the first tweet
		driver.get(objData.getTwitterURL());
		
		//create a reply
		objTwitter.retweetOnFirstTweet(retweet);
		//open archiveurl
		driver.get(archiveurl);
		//asserts

		text = objTwitterArchive.getFirstTweetRetweetFromDashboard();
		//System.out.println(text);
		//System.out.println(reply);
		Assert.assertEquals(text, retweet);
	}
	
	@Test(priority=1)
	public void test_FlagRetweet () {
		//from previous test create a new retweet to test flag on
		if (objTwitterArchive.flagStatus().contains("flagged")) {
			Assert.fail("Tweet alreaddy flagged");
		}
		//step 2 and 3 hover mouse on flag icon and click it
		objTwitterArchive.clickFlagFirstPost();
		objDashboardPage.pause();	
		//step 4 refresh the page
		driver.navigate().refresh();
		//check to see if flag status has changed
		if (!objTwitterArchive.flagStatus().contains("flagged")) {
			Assert.fail("Tweet was not flagged");
		}

	}

	@Test(priority=2)
	public void test_UnflagRetweet() {

		//check to see if it is flagged
		if (!objTwitterArchive.flagStatus().contains("flagged")) {
			Assert.fail("Tweet was not flagged");
		}
		//step 2 click on the flag icon again
		objTwitterArchive.clickFlagFirstPost();
		objDashboardPage.pause();	
		//step 3 refresh the page
		driver.navigate().refresh();
		//step 4 ensure tweet was unflagged
		if (objTwitterArchive.flagStatus().contains("flagged")) {
			Assert.fail("Tweet was not unflagged");
		}

	}
	
	@AfterClass
	public void exit () {
		driver.close();
	}

}
