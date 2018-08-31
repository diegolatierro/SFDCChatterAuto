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
    WebElement chatterPostField;
    
    @FindBy(css="button[title='Click, or press Ctrl+Enter']")
    WebElement chatterShareButton;
    
    @FindBy(className="")
    WebElement chatterPostButton;
    
    @FindBy(css="a[data-tab-name=\"FeedItem.PollPost\"]")//a[data-tab-name='FeedItem.PollPost']
    WebElement chatterPollButton;
    
    @FindBy(css="a[data-tab-name='FeedItem.QuestionPost']")
    WebElement chatterQuestionButton;
    
    //unable to get the last post like this!
    @FindBy(css="div[class='feedBodyInner Desktop oneApp']>p>span")
    WebElement lastPost;
    
    @FindBy(css="textarea[placeholder='What would you like to ask?']")
    WebElement chatterPollfield;
    
    @FindBy(css="button[class='slds-button slds-button--neutral cuf-publisherShareButton qe-pollPostDesktop MEDIUM uiButton--default uiButton--brand uiButton']")
    WebElement chatterPollShareButton;
    
    //VERIFY IF CHOICES IS A SELECTOR OR TIMEOUT PROBLEM 
    @FindBy(css="input[class='inputField cuf-pollChoiceField input']:nth-of-type(1)")
    WebElement chatterPollChoice1field;
    
    @FindBy(css="li[class='choice']+li>div>div>input[class='inputField cuf-pollChoiceField input")
    WebElement chatterPollChoice2field;
    
    @FindBy(css="textarea[placeholder='What would you like to know?']")
    WebElement chatterQuestionField;
    
    @FindBy(css="div[data-placeholder='If you have more to say, add details here ...']")
    WebElement chatterQuestionDescField;
    
    @FindBy(css="button[title='Click, or press Ctrl+Enter']")
    WebElement chatterQuestionAskButton;
    
    @FindBy(css="textarea[placeholder='Write a comment...']:nth-of-type(1)")
    WebElement chatterActivationCommentForPost;
    
    @FindBy(css="textarea[placeholder='Write an answer...']:nth-of-type(1)")
    WebElement chatterActivationCommentForQuestion;
    
    @FindBy(css="div[data-placeholder='Write a comment...']")
    WebElement chatterCommentField;
    
    @FindBy(css="div[data-placeholder='Write an answer...']")
    WebElement chatterCommentFieldOnQuestion;
    
    @FindBy(css="button[class='slds-button slds-button--neutral  cuf-commentSubmit uiButton--default uiButton--brand uiButton']")
    WebElement chatterCreateCommentButton;
    
    @FindBy(css="button.slds-button--neutral:nth-child(2)")
    WebElement postEditSave;
    
    @FindBy(css=".slds-has-focus > div:nth-child(1) > div:nth-of-type(1)")
    WebElement postEditField;
    
    @FindBy(css="div[class='main ']>div>div>div>textarea")
    WebElement questionEditField;
    
    @FindBy(css="div[data-placeholder='Update your post...']")
    WebElement questionEditDescField;
    
    @FindBy(css="li.cuf-actionItem:nth-child(2) > a:nth-child(1)")
    WebElement postEditOption;
    
    @FindBy(css="div[class=\"cuf-media-right forceChatterOverflowActionMenu uiMenu\"]>a:nth-child(1)")
    WebElement postPicklist;
    
    @FindBy(css="a[title='Delete']")
    WebElement postDeleteOption;
        
    @FindBy(css="button[title='Delete']")
    WebElement postDeleteButton;
    
    @FindBy(css="button[class='slds-button slds-button_icon-bare']:nth-child(1)")
    WebElement commentPicklist;
    
    @FindBy(css="div[class='slds-dropdown-trigger slds-dropdown-trigger_click cuf-commentActionButton']>button[style='']+div>ul>li[title='Edit']>a")
    WebElement commentEditButton;
    
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
    
    public void clickOnDeleteOption() {
    	this.pause();
    	postDeleteOption.click();
    }
    
    public void clickOnDeleteButton() {
    	this.pause();
    	postDeleteButton.click();
    }
    
    //type automated post on textfield for post
    public void typeOnPostField (String message) {
    	chatterPostField.sendKeys(message);
    }
    
    //click on Share button for post
    public void clickOnPostShareButton(){
    	chatterShareButton.click();
    }
    
    //click on poll option
    public void clickOnPoll() {
    	this.pause();
    	chatterPollButton.click();
    }
    
    //click on question option
    public void clickOnQuestion() {
    	this.pause();
    	chatterQuestionButton.click();
    }
    
    //get last post
    public String getLastPost() {
    	return lastPost.getText();
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
    	this.pause();
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
		chatterPollShareButton.click();
	}
	private void typePollChoice2(String choice2) {
		this.pause();
		chatterPollChoice2field.sendKeys(choice2);
	}
	private void typePollChoice1(String choice1) {
		this.pause();
		chatterPollChoice1field.sendKeys(choice1);
	}
	private void typePollField(String message) {
		chatterPollfield.sendKeys(message);
	}
	public void createChatterQuestion(String message, String description) {
		this.clickOnQuestion();
    	this.typeQuestionField(message);
    	this.typeQuestionDescription(description);
    	this.clickOnQuestionAskButton();
	}
	private void clickOnQuestionAskButton() {
		chatterQuestionAskButton.click();
	}
	private void typeQuestionDescription(String description) {
		chatterQuestionDescField.sendKeys(description);
	}
	private void typeQuestionField(String message) {
		chatterQuestionField.sendKeys(message);
	}
	//NOT WRITE BUT THE ONLY WORKAROUND THAT I FOUND
  	public void pause() {
  		try {
  			Thread.sleep(6000);
  		} catch (InterruptedException e) {
  			// TODO Auto-generated catch block
  			e.printStackTrace();
  		}
  	}


	public void createChatterCommentForPost(String comment) {
    	this.pause();
    	this.clickOnPostCommentButtonForPost();
    	this.typeOnCommentField(comment);
    	this.clickOnCommentField();
	}
	public void createChatterCommentForQuestion(String comment) {
    	this.pause();
    	this.clickOnPostCommentButtonForQuestion();
    	this.typeOnCommentFieldOnQuestion(comment);
    	this.clickOnCommentField();
	}
	public void createChatterCommentForPoll(String comment) {
    	this.pause();
    	// CREATE
    	this.clickOnCommentFieldForPoll();
    	this.typeOnCommentFieldForPoll(comment);
    	this.clickOnPostCommentButtonForPoll();
	}
	
	private void clickOnPostCommentButtonForPost() {
		this.pause();
		chatterActivationCommentForPost.click();
	}
	
	private void clickOnPostCommentButtonForQuestion() {
		this.pause();
		chatterActivationCommentForQuestion.click();
	}
	private void typeOnCommentField(String comment) {
		this.chatterCommentField.sendKeys(comment);
	}
	
	private void typeOnCommentFieldOnQuestion(String comment) {
		this.chatterCommentFieldOnQuestion.sendKeys(comment);
	}
	
	private void clickOnCommentField() {
		this.chatterCreateCommentButton.click();
	}
	
	private void clickOnCommentFieldForPoll() {
		this.pause();
		chatterActivationCommentForPost.click();
	}
	private void clickOnPostCommentButtonForPoll() {
		this.chatterCreateCommentButton.click();
	}

	private void typeOnCommentFieldForPoll(String comment) {
		this.chatterCommentField.sendKeys(comment);
	}
	
	public void editPost(String newMessage) {
		// click on picklist
		this.clickOnPostOptions();
		//click on edit
		this.clickOnPostEdit();
		//type newMessage
		this.typeNewMessage(newMessage);
		//click on save
		this.clickOnPostEditSave();
	}
	public void editQuestion(String newMessage, String newDescription) {
		// click on picklist
		this.clickOnPostOptions();
		//click on edit
		this.clickOnPostEdit();
		//type newMessage
		this.typeNewMessageQuestion(newMessage);
		this.typeNewMessageQuestionDescription(newDescription);
		//click on save
		this.clickOnPostEditSave();
	}


	private void clickOnPostEditSave() {
		this.pause();
		this.postEditSave.click();
		
	}

	private void typeNewMessage(String newMessage) {
		this.pause();
		this.postEditField.sendKeys(newMessage);
	}
	private void typeNewMessageQuestion(String newMessage) {
		this.pause();
		this.questionEditField.sendKeys(newMessage);
	}
	
	private void typeNewMessageQuestionDescription(String newDescription) {
		this.pause();
		this.questionEditDescField.sendKeys(newDescription);
	}

	private void clickOnPostEdit() {
		this.pause();
		this.postEditOption.click();
	}

	private void clickOnPostOptions() {
		this.pause();
		this.postPicklist.click();
	}

	public void clickOnCommentPicklist() {
		this.pause();
		this.commentPicklist.click();
	}
	
	public void clickOnEditCommentOption() {
		this.pause();
		this.commentEditButton.click();
	}
	
	public void deletePost() {
		// click on picklist
		this.clickOnPostOptions();
		//click on delete option
		this.clickOnDeleteOption();
		//confirm the detele
		this.clickOnDeleteButton();
		
	}


	public void editChatterCommentForPost(String newComment) {
		// click on comment piclikst
		this.clickOnCommentPicklist();
		// click on edit option
		this.clickOnEditCommentOption();
		// type the new comment
		// click on save
	}
}