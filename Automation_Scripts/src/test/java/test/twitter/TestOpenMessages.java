package test.twitter;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageFactory.Data;
import pageFactory.SocialMediaDashboard;
import pageFactory.SocialMediaLogin;
import pageFactory.TwitterArchive;

public class TestOpenMessages {

	WebDriver driver;
	SocialMediaLogin objLogin;
	SocialMediaDashboard objDashboardPage;
	Data objData;
	TwitterArchive objTwitterArchive;

	@BeforeTest
	public void setup() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		objData = new Data(driver);
		objTwitterArchive = new TwitterArchive(driver);
		driver.get(objData.getSocialMediaLoginURL());
	}

	@Test(priority=0)
	public void openMessages() {
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
		objTwitterArchive.clickOnMessagesLink();
		objDashboardPage.pause();
		if (!objTwitterArchive.getMessageValue().equals(objData.getTwitterMessageTitle())) {
			Assert.fail("Message tab was not opened");
		}
		

	}

}
