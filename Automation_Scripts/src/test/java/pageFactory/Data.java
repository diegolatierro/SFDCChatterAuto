package pageFactory;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

//class will be replaced by json, xls or other external data provider format
public class Data {

	WebDriver driver;

	// URLS
	String chatterDashboard = "https://na72.lightning.force.com/lightning/page/chatter";
	String gmailUrl = "https://mail.google.com/mail/u/0/h/1isycmedm1c6q/?&";
	
	// Test Data fields

	String salesforceUserField = "diegolatierro@pf.com";
	String salesforcePassField = "latierro050985";
	String gmailUserField = "diegopagefreezer@gmail.com";
	String gmailPassField = "latierro050985";
<<<<<<< HEAD
=======
	String archiveField = "DiegoTest";
	String socialMediaUserFieldAdmin = "diegolatierro@gmail.com";
	String socialMediaPassFieldAdmin = "Cohiba3672!";
	String socialMediaUserFieldUser = "richardho1@pagefreezer.com";
	String socialMediaPassFieldUser = "test123!";
	String socialMediaUserFieldRead = "richardho+1@pagefreezer.com";
	String socialMediaPassFieldRead = "Test123!";
	String urlIncorrectField = "www.fakeaddress.com";
	String emailIncorrectField = "diegopagefreezer";
	
	//archiveNames
	String twitterArchiveName = "automated_pf_TW";
	
	// Messages
	String errorInvalidEmailMessage = "Enter valid email.";
	String errorInvalidEmailMessage2 = "Enter the valid email.";
	String errorInvalidUrlMessage = "Enter valid url.";
	String errorEmptyEmailMessage = "Required field";
	String errorEmptyUrlMessage = "The Url is required.";
	String errorWrongUserorPassword = "user/password incorrect";
	String errorMissingEmail = "The Email is required.";
	String errorMissingPassword = "The Password is required.";

	String errorDuplicatedArchiveMessage = "account already exists: https://twitter.com/diegotest3";
	String successArchiveCreationMessage = "Account DiegoTest has been created";
	String successArchiveDeleteMessage = "Account DiegoTest has been removed";
	String successAuthenticationMessage = "You have been successfully authenticated";
	String dataCollectionLabel = "Public, Private";
	
	String successForceCapture = " has been scheduled for capture";
	String empty = "No results found";

	//Test Messages
	String errorMessagesRemain = "Error messages did not dissapear";
	String tweet = "automated tweet from DiegoBot";
	
	//Misc
	String twitterMessageTitle="Direct Messages";
>>>>>>> f1a32018eca9e9f0edf8c98939fb0d150357f743
	
	public Data(WebDriver driver) {
		this.driver = driver;
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
	}
	public String getGmailURL() {
		return gmailUrl;
	}
	public String getGmailUserField() {
		return gmailUserField;
	}
	public String getGmailPassField() {
		return gmailPassField;
	}
<<<<<<< HEAD
	public String getChatterUrl() {
		return this.chatterDashboard;
	}	
	public String getSalesforceUser() {
		return this.salesforceUserField;
	}
	public String getSalesforcePass() {
		return this.salesforcePassField;
	}
	
	public String createARandomTweet(String random) {
    	Random r = new Random();
		String text = "Automated message " + random + Integer.toString(r.nextInt());
		return text;
    }
=======

	public String getSocialMediaUserField() {
		return socialMediaUserFieldAdmin;
	}

	public String getSocialMediaPassField() {
		return socialMediaPassFieldAdmin;
	}

	public String getArchiveField() {
		return archiveField;
	}

	public String getTwitterArchiveName() {
		return twitterArchiveName;
	}

	//methods to get error messages
	public String getIncorrectUrlField() {
		return urlIncorrectField;
	}

	public String getIncorrectEmailField() {
		return emailIncorrectField;
	}

	public String getErrorInvalidEmailMessage() {
		return errorInvalidEmailMessage;
	}

	public String getErrorInvalidUrlMessage() {
		return errorInvalidUrlMessage;
	}

	public String getErrorEmptyEmailMessage() {
		return errorEmptyEmailMessage;
	}

	public String getErrorEmptyUrlMessage() {
		return errorEmptyUrlMessage;
	}

	public String getErrorEmptyEmailMessage2() {
		return errorMissingEmail;
	}

	public String getErrorEmptyPasswordMessage() {
		return errorMissingPassword;
	}

	public String getErrorDuplicatedArchiveMessage() {
		return errorDuplicatedArchiveMessage;
	}

	public String getErrorWrongPasswordMessage() {
		return errorWrongUserorPassword;
	}

	public String getSuccessArchiveCreationMessage() {
		return successArchiveCreationMessage;
	}

	public String getSuccessArchiveDeleteMessage() {
		return successArchiveDeleteMessage;
	}

	public String getSuccessAuthenticationMessage() {
		return successAuthenticationMessage;
	}

	public String getEmpty() {
		return empty;
	}

	public String getTwitterUrl() {
		return twitterUrl;
	}

	public String getSuccessForceCapture() {
		return successForceCapture;
	}

	public String getDataCollectionLabel() {
		return dataCollectionLabel;
	}

	public String getSocialMediaDashboardUrl() {
		return socialMediaDashboardUrl;
	}

	public String getSocialMediaLoginUrl() {
		return socialMediaLoginUrl;
	}

	public String getGmailUrl() {
		return gmailUrl;
	}

	public String getUrlIncorrectField() {
		return urlIncorrectField;
	}

	public String getEmailIncorrectField() {
		return emailIncorrectField;
	}

	public String getErrorWrongUserorPassword() {
		return errorWrongUserorPassword;
	}

	public String getErrorMissingEmail() {
		return errorMissingEmail;
	}

	public String getErrorMissingPassword() {
		return errorMissingPassword;
	}

	public String getErrorMessagesRemain() {
		return errorMessagesRemain;
	}

	public String getErrorInvalidEmailMessage2() {
		return errorInvalidEmailMessage2;
	}
	public String getTweet() {
		return tweet;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public String getSocialMediaUserFieldAdmin() {
		return socialMediaUserFieldAdmin;
	}

	public String getSocialMediaPassFieldAdmin() {
		return socialMediaPassFieldAdmin;
	}

	public String getSocialMediaUserFieldUser() {
		return socialMediaUserFieldUser;
	}

	public String getSocialMediaPassFieldUser() {
		return socialMediaPassFieldUser;
	}

	public String getSocialMediaUserFieldRead() {
		return socialMediaUserFieldRead;
	}

	public String getSocialMediaPassFieldRead() {
		return socialMediaPassFieldRead;
	}

	public String getTwitterMessageTitle() {
		return twitterMessageTitle;
	}
	
>>>>>>> f1a32018eca9e9f0edf8c98939fb0d150357f743
}
