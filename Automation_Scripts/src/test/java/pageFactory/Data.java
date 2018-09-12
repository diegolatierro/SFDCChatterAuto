package pageFactory;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

//class will be replaced by json, xls or other external data provider format
public class Data {

	WebDriver driver;

	// URLS
	String chatterDashboard = "https://na72.lightning.force.com/lightning/page/chatter";//56
	String gmailUrl = "https://mail.google.com/mail/u/0/h/1isycmedm1c6q/?&";
	
	// Test Data fields

	String salesforceUserField = "diegolatierro@pf.com";//"diegolatierro@pf2.com"
	String salesforcePassField = "latierro050985";
	String gmailUserField = "diegopagefreezer@gmail.com";
	String gmailPassField = "latierro050985";

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
