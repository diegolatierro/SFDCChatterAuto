package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SocialMediaSettings {
	
	 /**
     * All WebElements are identified by @FindBy annotation
     */

    WebDriver driver;
    
    @FindBy(linkText="My Account")
    WebElement myAccount; 
    
    @FindBy(linkText="User Management")
    WebElement userManage;
    
    @FindBy(linkText="Group Management")
    WebElement groupManage;
    
    @FindBy(linkText="Archive Access Management")
    WebElement archiveAccess;
    
    @FindBy(linkText="Integrations")
    WebElement integrations;
    
    @FindBy(linkText="Records Retention")
    WebElement recordRetention;
    
    @FindBy(linkText="Public Portal")
    WebElement publicPortal;
    
    @FindBy(linkText="Enterprise Social Media")
    WebElement enterpriseSocial;
    
    public SocialMediaSettings(WebDriver driver) {
    	 this.driver = driver;
         //This initElements method will create all WebElements
         PageFactory.initElements(driver, this);
    }
    
    public void clickMyAccount () {
    	myAccount.click();
    }
    
    public void clickUserManage() {
    	userManage.click();
    }
    
    public void clickGroupManage () {
    	groupManage.click();
    }
    
    public void clickArchiveAccess() {
    	archiveAccess.click();
    }
    
    public void clickIntegrations () {
    	integrations.click();
    }
    
    public void clickRecordRetention() {
    	recordRetention.click();
    }
    
    public void clickPublicPortal () {
    	publicPortal.click();
    }
    
    public void clickEnterprise() {
    	enterpriseSocial.click();
    }
    
	//NOT WRITE BUT THE ONLY WORKAROUND THAT I FOUND
	public void pause() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void pauseToast() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
