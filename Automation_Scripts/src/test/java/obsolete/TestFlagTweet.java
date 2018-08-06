package obsolete;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageFactory.Data;
import pageFactory.SocialMediaDashboard;
import pageFactory.SocialMediaLogin;
import pageFactory.Twitter;
import pageFactory.TwitterArchive;

public class TestFlagTweet {

	WebDriver driver;
	SocialMediaLogin objLogin;
	SocialMediaDashboard objDashboardPage;
	WebDriverWait wait;
	Data objData;
	Twitter objTwitter;
	TwitterArchive objTwitterArchive;

	@BeforeTest
	public void setup() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		objData = new Data(driver);
		objTwitter = new Twitter(driver);
		objTwitterArchive = new TwitterArchive(driver);
        driver.get(objData.getSocialMediaLoginURL());
	}

	/**
	 * 1. Find archive in the dashboard and click on the name 
	 * 2. Hover mouse over the newest regular tweet
	 * 3. Click on the flag icon
	 * 4. refresh the page
	 * 5. click on the flag icon
	 * 
	 */

	@Test(priority = 0)
	public void test_FlagTweet() throws InterruptedException  {
		String socialMediaUser = objData.getSocialMediaUserField();
    	String socialMediaPass = objData.getSocialMediaPassField();
		String archive = objData.getTwitterArchiveName();
		

		// Create Login Page object
		objLogin = new SocialMediaLogin(driver);
		// login to application
		objLogin.loginToSocialMedia(socialMediaUser, socialMediaPass);
		objDashboardPage = new SocialMediaDashboard(driver);
		// step 1 find archive
		objDashboardPage.searchArchive(archive);
		objDashboardPage.pause();		
		// open archive
		objDashboardPage.openFirstArchive();
		//check to ensure flag has not been already activated
		objDashboardPage.pause();
		if (objTwitterArchive.flagStatus().contains("flagged")) {
			Assert.fail("Tweet alreaddy flagged");
		}
		//step 2 and 3 hover mouse on flag icon and click it
		objTwitterArchive.clickFlagFirstPost();
		objDashboardPage.pause();	
		//step 4 refresh the page
		driver.navigate().refresh();
		System.out.println(objTwitterArchive.flagStatus());
		//check to see if flag status has changed
		if (!objTwitterArchive.flagStatus().contains("flagged")) {
			Assert.fail("Tweet was not flagged");
		}
		
		//step 4 click on the flag icon again
		objTwitterArchive.clickFlagFirstPost();
		

	}

}
