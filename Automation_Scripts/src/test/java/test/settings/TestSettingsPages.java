package test.settings;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageFactory.Data;
import pageFactory.SocialMediaDashboard;
import pageFactory.SocialMediaLogin;
import pageFactory.SocialMediaSettings;
import pageFactory.Twitter;
import pageFactory.TwitterArchive;

public class TestSettingsPages {

	WebDriver driver;
	SocialMediaLogin objLogin;
	SocialMediaDashboard objDashboardPage;
	SocialMediaSettings objSocialSettings;
	Data objData;

	@BeforeTest
	public void setup(){
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		objData = new Data(driver);
		driver.get(objData.getSocialMediaLoginURL());
	}

	@Test
	public void clickSettings() {
		String socialMediaUser = objData.getSocialMediaUserField();
		String socialMediaPass = objData.getSocialMediaPassField();

		// Create Login Page object
		objLogin = new SocialMediaLogin(driver);
		// login to application
		objLogin.loginToSocialMedia(socialMediaUser, socialMediaPass);
		objDashboardPage = new SocialMediaDashboard(driver);
		objDashboardPage.pause();
		objDashboardPage.clickSettings();
		objSocialSettings = new SocialMediaSettings(driver);
		objSocialSettings.pause();
		objSocialSettings.clickUserManage();
		objSocialSettings.pause();
		objSocialSettings.clickGroupManage();
		objSocialSettings.pause();
		objSocialSettings.clickArchiveAccess();
		objSocialSettings.pause();
		objSocialSettings.clickIntegrations();
		objSocialSettings.pause();
		objSocialSettings.clickRecordRetention();
		objSocialSettings.pause();
		objSocialSettings.clickPublicPortal();
		objSocialSettings.pause();
		objSocialSettings.clickEnterprise();
		objSocialSettings.pause();
		objSocialSettings.clickMyAccount();
		
	}

}
