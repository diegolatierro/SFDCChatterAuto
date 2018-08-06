package test.twitter;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageFactory.Data;
import pageFactory.SocialMediaDashboard;
import pageFactory.SocialMediaLogin;
import pageFactory.Twitter;
import pageFactory.TwitterArchive;

public class TestExpandPost {

	WebDriver driver;
	SocialMediaLogin objLogin;
	SocialMediaDashboard objDashboardPage;
	WebDriverWait wait;
	Data objData;
	Twitter objTwitter;
	TwitterArchive objTwitterArchive;
	Actions action;

	@BeforeTest
	public void setup() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		objData = new Data(driver);
		objTwitter = new Twitter(driver);
		objTwitterArchive = new TwitterArchive(driver);
		driver.get(objData.getSocialMediaLoginURL());
		action = new Actions(driver);
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
	public void test_ExpandPost() throws InterruptedException  {
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
		objDashboardPage.pause();
		objTwitterArchive.doubleClickFirstPost();
		objDashboardPage.pause();
		if (objTwitterArchive.checkModal()) {
			Assert.assertTrue(true);
		} else {
			Assert.fail("modal was not opened");
		}
		


	}

}
