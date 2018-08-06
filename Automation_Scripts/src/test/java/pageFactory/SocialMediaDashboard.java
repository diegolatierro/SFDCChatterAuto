package pageFactory;//Page factory

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SocialMediaDashboard {

    /**
     * All WebElements are identified by @FindBy annotation
     */

    WebDriver driver;
    
    @FindBy(css="a[href='/alerts/result?alertId=all']")//(css="#bs-example-navbar-collapse-1 > ul:nth-child(1) > li:nth-child(4) > a")//
    WebElement alertHeaderButton;   
    @FindBy(css="button[href='/alerts/new/settings']")
    WebElement createNewAlertButton;
    
    @FindBy(xpath="//a[@ui-sref='main.dashboard']")
    WebElement dashboard;

    @FindBy(css=".btn-group > button:nth-child(1)")
    WebElement createArchive;

    @FindBy(css="a[href='/dashboard/archive?sm_type=TW']")
    WebElement createArchiveTwitterOption;
     
    @FindBy(css="button[title='filter name']")
    WebElement createArchiveSearchButton;
    
    @FindBy(css="input[placeholder='Filter Name']")
    WebElement createArchiveSearchField;
    
    @FindBy(css="td[class='sm_auth']")
    WebElement createArchiveDataCollectionLabel;
    
    @FindBy(css="#ngdialog1-aria-describedby")
    WebElement successModal;
    
    @FindBy(css=".mddialog-close")
    WebElement closeModal;
    
    @FindBy(css="i[tooltip-text='Edit']")
    WebElement editArchive;
    
    @FindBy(css=".delete-link")
    WebElement deleteArchiveLink;
    
    @FindBy(css="input.ng-empty:nth-child(2)")
    WebElement deleteArchiveField;
        
    @FindBy(css=".btn-danger")
    WebElement deleteArchiveButton;
    
    @FindBy(css=".toast-message")
    WebElement toastMessage;
    
    @FindBy(xpath="//table[@class='table table-hover dataTable accounts-table']/tbody/tr/td[3]/section/a")
    WebElement firstArchive;
    
    @FindBy(xpath="//table/tbody/tr/td[8]/span")
    WebElement lastCaptureTimeArchive;
    
    @FindBy(css="tr.ng-scope:nth-child(1) > td:nth-child(3) > section:nth-child(1) > a:nth-child(1)")
    WebElement firstElementOnSearch;
    
    @FindBy(linkText="Settings")
    WebElement settings;
    
 
    
    //Create Twitter Archive
    public void clickCreateArchiveTwitter () {
    	pause();
    	createArchive.click();
    	createArchiveTwitterOption.click();
    }
    
    //Search an archive @parameter 
    public void searchArchive (String archive) {
    	pause();
    	createArchiveSearchButton.click();
    	pause();
    	createArchiveSearchField.sendKeys(archive);
    	pause();
    }
    
    //Get label data collection searched row
    public String getArchiveDataCollectionStatus () {
    	pause();
    	return createArchiveDataCollectionLabel.getText();
    }
    
    public SocialMediaDashboard(WebDriver driver){
        this.driver = driver;
        //This initElements method will create all WebElements
        PageFactory.initElements(driver, this);
    }
    
    //go back to the dashboard
    public void clickDashboard () {
    	dashboard.click();
    }
    
    //go to settings
    public void clickSettings() {
    	settings.click();
    }

    //Click on alert header button
    public void clickAlertHeaderButton(){
    	pause();
    	alertHeaderButton.click();
    }

    //Click on alert header button
    public void clickNewAlertButton(){
    	pause();
    	createNewAlertButton.click();
    }

	public void goToAlertCreation() {
		this.clickAlertHeaderButton();
		this.clickNewAlertButton();
	}
	
	public String getSuccessModalAlert() {
		this.pause();
		return successModal.getText();
	}
	
	public void openFirstArchive() {
		firstArchive.click();
	}
	
	public String getLastCaptureTime() {
		return lastCaptureTimeArchive.getText();
	}
	
	public void clickOnEditArchive() {
		
		editArchive.click();
	}
	
	public void clickOnDeleteArchive() {
		deleteArchiveLink.click();
	}
	public void typeDeleteOnField() {
		deleteArchiveField.sendKeys("delete");
	}
	public void clickOnDeleteModal() {
		deleteArchiveButton.click();
	}
	
	public String getToastText() {
		return toastMessage.getText();
	}
	
	public void deleteArchive() {
		this.clickOnEditArchive();
		this.pause();
		this.clickOnDeleteArchive();
		this.typeDeleteOnField();
		this.clickOnDeleteModal();
		//this.pause();
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

	public Object getDuplicatedArchiveErrorToast() {
		this.pauseToast();
		return toastMessage.getText();
	}
	
	//Verify if archive exists 
    public boolean verifyIfArchiveExists (String archive) {
    	this.pause();
    	this.createArchiveSearchButton.click();
    	this.pause();
    	this.createArchiveSearchField.sendKeys(archive);
    	this.pause();
    	return this.firstElementOnSearch.isDisplayed();
    }
}