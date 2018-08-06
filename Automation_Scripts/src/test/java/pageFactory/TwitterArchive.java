package pageFactory;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TwitterArchive {

	/**
	 * All WebElements are identified by @FindBy annotation
	 */

	WebDriver driver;
	WebDriverWait wait;
	Actions actions;
	SocialMediaDashboard objDashboardPage;
	SocialMediaEditArchiveForm objSocialMediaEdit;

	@FindBy(xpath="//a[@class='social-url ng-binding']")
	WebElement networkLink;
	
	@FindBy(xpath="//div[@class='tw-posts-container activity-for-select selected']/activity-settings/section/section")
	WebElement optionsFirstPost;
	
	@FindBy(xpath="//div[@class='tw-posts-container activity-for-select selected']/activity-settings/section/section/div/div[2]/i")
	WebElement flagFirstPost;
	
	//@FindBy(css="div[class='tw-content']:nth-child(2)>span>span")
    @FindBy(css="div.TW-activity-block:nth-child(1) > section:nth-child(1) > section:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > section:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(3) > span:nth-child(1) > span:nth-child(1)")
    WebElement firstTweetReplyTextFromDashboard;
    
    @FindBy(css=".selected > section:nth-child(2) > section:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(3) > span:nth-child(1) > span:nth-child(1)")
	WebElement firstTweetRetweetTextFromDashboard;
    
    @FindBy(css=".tw-nav > li:nth-child(4) > a:nth-child(1)")
    WebElement messagesLink;
    
    @FindBy(css=".entity-for-select > div:nth-child(3)")
    WebElement firstMessageFromDashboard;
    
    @FindBy(css="a[ng-click='accountCtrl.createPdfUrl()']")
    WebElement exportArchiveButton;
    
    @FindBy(css="#ngdialog1-aria-describedby > div:nth-child(1) > input")
    WebElement exportEmailField;
    
    @FindBy(css="button.ng-binding:nth-child(2)")
    WebElement exportButton;
    
    @FindBy(xpath="//div[@class='direct-msg-title']")
    WebElement messageTitle;
    
    @FindBy(xpath="//div[@class='tw-posts-container activity-for-select selected']")
    WebElement latestPost;
    
    @FindBy(xpath="//div[@class='tw-posts-modal-container']")
    WebElement postModal;
    
    @FindBy(linkText="Dashboard")
    WebElement dashboardLink;
    
    @FindBy(xpath="//h2")
    WebElement noResults;
    
    String locate = "//div[@class='tw-posts-modal-container']";
    
	//open Twitter link
	public void openLink () {
		WebElement link = wait.until(ExpectedConditions.elementToBeClickable(networkLink));
		networkLink.click();
	}

	public TwitterArchive(WebDriver driver){
		this.driver = driver;
		//This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 10);
		actions = new Actions(driver);
		objSocialMediaEdit = new SocialMediaEditArchiveForm(driver);
	}

	public void scrollDown (){
		WebElement elem = driver.findElement(By.xpath("//body"));
	}
	
	public void clickFlagFirstPost() {
		actions.moveToElement(optionsFirstPost).click(flagFirstPost).build().perform();
	}

	public String flagStatus() {
		return flagFirstPost.getAttribute("class");
	}
	
	public String getFirstTweetReplyFromDashboard() {
		return firstTweetReplyTextFromDashboard.getText();
	}
	
	public String getFirstTweetRetweetFromDashboard() {
		return firstTweetRetweetTextFromDashboard.getText();
	}
	
	public void clickOnMessagesLink() {
		this.messagesLink.click();
	}
	
	public String getFirstMessageFromDashboard() {
		return firstMessageFromDashboard.getText();
	}
	
	public void clickOnExportArchive() {
		this.pause();
		this.exportArchiveButton.click();
	}
	
	public void typeEmailField(String email) {
		this.exportEmailField.sendKeys(email);
	}
	
	public void clearEmailfield() {
		this.pause();
		this.exportEmailField.clear();
	}
	
	public void clickOnExportButton() {
		this.exportButton.click();
	}
	
	public void clickDashboard() {
		dashboardLink.click();
	}
	
	public String getMessageValue() {
		return this.messageTitle.getText();
	}
	
	public String getNoResults() {
		return this.noResults.getText();
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
	public void forceCaptureOnArchive(String archive) {
		objDashboardPage = new SocialMediaDashboard(driver);
		objDashboardPage.searchArchive(archive);
		objDashboardPage.clickOnEditArchive();
		this.pause();
		objSocialMediaEdit.clickOnAdvanced();
		objSocialMediaEdit.clickForceCapture();
		driver.switchTo().activeElement();
		objSocialMediaEdit.clickConfirmForceCapture();
	}
	
	public void exportArchive(String email) {
		// click on export button
		this.clickOnExportArchive();
		// clear the email field
		this.clearEmailfield();
		// write email
		this.typeEmailField(email);
		// click on send/save
		this.clickOnExportButton();
	}
	
	public void doubleClickFirstPost() {
		actions.doubleClick(latestPost).build().perform();
	}
	
	public boolean checkModal() {
		List <WebElement> check = driver.findElements(By.xpath(locate));
		System.out.println(check.size());
		if (check.size()==1) {
			return true;
		} else {
			return false;
		}
	}
}
