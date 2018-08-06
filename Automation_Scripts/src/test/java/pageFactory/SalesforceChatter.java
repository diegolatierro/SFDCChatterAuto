package pageFactory;//Page factory

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;

public class SalesforceChatter {

    /**
     * All WebElements are identified by @FindBy annotation
     */

    WebDriver driver;
    
 //   WebDriverWait wait = new WebDriverWait(driver, 10);
    
    @FindBy(css="button[title='Share an update...']")
    WebElement chatterActivationButton;  
    
    @FindBy(css="div[data-placeholder='Share an update...']")
    WebElement ChatterPostField;
    
    @FindBy(css="button[title='Click, or press Ctrl+Enter']")
    WebElement ChatterShareButton;
    
    @FindBy(className="")
    WebElement ChatterPostButton;
    
    @FindBy(css="a[data-tab-name=\"FeedItem.PollPost\"]")//a[data-tab-name='FeedItem.PollPost']
    WebElement ChatterPollButton;
    
    @FindBy(css="a[data-tab-name='FeedItem.QuestionPost']")
    WebElement ChatterQuestionButton;
    
    //unable to get the last post like this!
    @FindBy(css="div[class='feedBodyInner Desktop oneApp']>p>span")
    WebElement LastPost;
    
    @FindBy(css="textarea[placeholder='What would you like to ask?']")
    WebElement ChatterPollfield;
    
    @FindBy(css="button[class='slds-button slds-button--neutral cuf-publisherShareButton qe-pollPostDesktop MEDIUM uiButton--default uiButton--brand uiButton']")
    WebElement ChatterPollShareButton;
    
    //VERIFY IF CHOICES IS A SELECTOR OR TIMEOUT PROBLEM 
    @FindBy(css="input[class='inputField cuf-pollChoiceField input']:nth-of-type(1)")
    WebElement ChatterPollChoice1field;
    
    @FindBy(css="input[class='inputField cuf-pollChoiceField input'][data-interactive-lib-uid='5']")
    WebElement ChatterPollChoice2field;
    
    @FindBy(css="textarea[placeholder='What would you like to know?']")
    WebElement ChatterQuestionField;
    
    @FindBy(css="div[data-placeholder='If you have more to say, add details here ...']")
    WebElement ChatterQuestionDescField;
    
    @FindBy(css="button[title='Click, or press Ctrl+Enter']")
    WebElement ChatterQuestionAskButton;
    
    public SalesforceChatter(WebDriver driver){
        this.driver = driver;
        //This initElements method will create all WebElements
        PageFactory.initElements(driver, this);
    }
  
    
    //go to chatter page
    public void goToChatterURL() {
    	driver.get("https://na72.lightning.force.com/lightning/page/chatter");
    }
    
    //click on post option
    public void clickOnPost() {
    	
    }
    
    //click on post hidden field to activate the textfield
    public void clickOnPostField() {
    	this.pause();
    	chatterActivationButton.click();
    }
    
    //type automated post on textfield for post
    public void typeOnPostField (String message) {
    	ChatterPostField.sendKeys(message);
    }
    
    //click on Share button for post
    public void clickOnPostShareButton(){
    	ChatterShareButton.click();
    }
    
    //click on poll option
    public void clickOnPoll() {
    	this.pause();
    	ChatterPollButton.click();
    }
    
    //click on question option
    public void clickOnQuestion() {
    	ChatterQuestionButton.click();
    }
    
    //get last post
    public String getLastPost() {
    	return LastPost.getText();
    }
    
    /**
     * CREATE A POST
     * Activate the post field
     * click on textfield 
     * type a message on the textfield
     * click on share button
     */
    public void createChatterPost(String message) {
    	//this.goToChatterURL();
    	this.pause();
    	this.clickOnPostField();
    	this.typeOnPostField(message);
    	this.clickOnPostShareButton();
    }
    
    public boolean verifyTextPresent(String value)
    {
      return driver.getPageSource().contains(value);
    }
    
    /**
     * CREATE A POLL
     * Click on poll button
     * click on text field
     * type a message for the poll field
     * type a choice 1
     * type a choice 2
     * click on share button
     */
    public void createChatterPoll(String message, String choice1, String choice2) {
    	this.clickOnPoll();
    	this.typePollField(message);
    	this.typePollChoice1(choice1);
    	this.typePollChoice2(choice2);
    	this.clickOnPollShareButton();
    }
	private void clickOnPollShareButton() {
		ChatterPollShareButton.click();
	}
	private void typePollChoice2(String choice2) {
		this.pause();
		ChatterPollChoice2field.sendKeys(choice2);
	}
	private void typePollChoice1(String choice1) {
		this.pause();
		ChatterPollChoice1field.sendKeys(choice1);
	}
	private void typePollField(String message) {
		ChatterPollfield.sendKeys(message);
	}
	public void createChatterQuestion(String message, String description) {
		this.clickOnQuestion();
    	this.typeQuestionField(message);
    	this.typeQuestionDescription(description);
    	this.clickOnQuestionAskButton();
	}
	private void clickOnQuestionAskButton() {
		ChatterQuestionAskButton.click();
	}
	private void typeQuestionDescription(String description) {
		ChatterQuestionDescField.sendKeys(description);
	}
	private void typeQuestionField(String message) {
		ChatterQuestionField.sendKeys(message);
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
}