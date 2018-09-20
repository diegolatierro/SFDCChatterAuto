package pageFactory;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import base.BaseClass;

//class will be replaced by json, xls or other external data provider format
public class Data extends BaseClass{

	WebDriver driver;
	Users objUser = new Users();
	
	// URLS
	String chatterDashboard = objUser.getOrg1();
	String gmailUrl = objUser.getGmailURL1();
	
	// Test Data fields
	String salesforceUserField = objUser.getOrg1User1();
	String salesforcePassField = objUser.getOrg1Pass1();
	String gmailUserField = objUser.getGmailUser1();
	String gmailPassField = objUser.getGmailPass1();

	// Packages
	String version1_10 = "https://login.salesforce.com/packaging/installPackage.apexp?p0=04tf4000003VV9w";
	String version1_11 = "https://login.salesforce.com/packaging/installPackage.apexp?p0=04tf4000003VVH8";
	String version1_12 = "https://login.salesforce.com/packaging/installPackage.apexp?p0=04tf4000003AeL4";
	String version1_12BETA = "https://login.salesforce.com/packaging/installPackage.apexp?p0=04tf4000003AeYa";
	
	
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

	public String getChatterUrl() {
		return this.chatterDashboard;
	}	
	public String getSalesforceUser() {
		return this.salesforceUserField;
	}
	public String getSalesforcePass() {
		return this.salesforcePassField;
	}
	
	public String createARandomText(String random) {
    	Random r = new Random();
		String text = "Automated message " + random + " " + Integer.toString(r.nextInt());
		return text;
    }

}
