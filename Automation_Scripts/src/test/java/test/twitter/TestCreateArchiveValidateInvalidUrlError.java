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

public class TestCreateArchiveValidateInvalidUrlError {

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
     * "1. Click on Create Archive
		2. Select Twitter
		3. fill out invalid url field 
		4. fill out admin email field 
		5. click next"
     * 		
     */

    @Test(priority=0)
    public void test_Create_Archive_Validate_Invalid_Url(){
  	
    	String URL = objData.getIncorrectUrlField();
    	String email = objData.getEmailField();
    	String socialMediaUser = objData.getSocialMediaUserField();
    	String socialMediaPass = objData.getSocialMediaPassField();
    	String errorMessage = objData.getErrorInvalidUrlMessage();
    	
    	objGmail = new Gmail(driver);
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
		// step 4 Write an admin email
		objCreateArchiveFrom.writeEmail(email);
		// step 5 Click on Next
		objCreateArchiveFrom.clickOnNext();
		//CAPTURE THE ERROR
		Assert.assertTrue(objCreateArchiveFrom.getURLErrorMessage().equals(errorMessage));
    }
    
    @AfterClass
	public void exit () {
		driver.close();
	}
}