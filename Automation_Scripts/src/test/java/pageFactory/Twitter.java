package pageFactory;//Page factory

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Twitter {

    /**
     * All WebElements are identified by @FindBy annotation
     */

    WebDriver driver;
    WebDriverWait wait;
    
    @FindBy(css=".js-username-field")
    WebElement loginFieldUserName;  
    
    @FindBy(css=".js-password-field")
    WebElement loginFieldPassword;
    
    @FindBy(css="button.submit")
    WebElement loginButton;
    
    @FindBy(css="#global-new-tweet-button")
    WebElement createTweetButton;
    
    @FindBy(css="div[aria-labelledby='Tweetstorm-tweet-box-0-label Tweetstorm-tweet-box-0-text-label']")
    WebElement tweetField;
    
    //find a better selector
    @FindBy(xpath="//span[@class='button-text']")
    WebElement tweetButton;

    @FindBy(css="span[class='ng-isolate-scope']:nth-of-type(1)")
    WebElement firstTweet;
    
    @FindBy(css=".selected > section:nth-child(2) > section:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(3) > span:nth-child(1)")
    WebElement secondTweet;
    
    @FindBy(css="a[class='ProfileHeaderCard-screennameLink u-linkComplex js-nav']")
    WebElement userTweetsLink;
    
    
    @FindBy(css="button[data-modal='ProfileTweet-reply']:nth-of-type(1)")
    WebElement replyButtonFirstTweet;
    
    @FindBy(css="#tweet-box-global")
    WebElement replyFieldFirstTweet;
    
    @FindBy (css=".is-reply > div:nth-child(3) > div:nth-child(2) > button:nth-child(2)")
    WebElement sendReplyButton;
    
    @FindBy(css="button[data-modal='ProfileTweet-retweet']:nth-of-type(1)")
    WebElement retweetButtonFirstTweet;
    
    @FindBy(css="#retweet-with-comment")
    WebElement retweetFieldFirstTweet;
    
    @FindBy(css=".retweet-action")
    WebElement sendRetweetButton;
    
    @FindBy(css=".global-dm-nav:nth-of-type(1)")
    WebElement messagesButton;
    
    @FindBy(css="button.DMInbox-toolbar:nth-child(2)")
    WebElement newMessagesButton;
    
    @FindBy(css="div.DMDialogTypeahead:nth-child(1) > ul:nth-child(2) > li:nth-child(1) > textarea:nth-child(1)")
    WebElement messageSearchUserField;
    
    @FindBy(css="ul[id='DMComposeTypeaheadSuggestions']>li[role='option']")
    WebElement messagesUserButton;
    
    @FindBy(css=".dm-initiate-conversation")
    WebElement messagesNextButton;
    
    @FindBy(css="#tweet-box-dm-conversation")
    WebElement messagesField;
    
    @FindBy(css="button.tweet-action:nth-child(1)")
    WebElement messagesSendButton;
    
    @FindBy(css="#user-dropdown-toggle")
    WebElement userHeaderButton;
    
    @FindBy(css="#signout-button > button:nth-child(1)")
    WebElement logoutButton;
    
    String twitterPopupClosed = "//button[@class='EdgeButton EdgeButton--primary js-promptAction js-promptPrimaryCta']";
   
    public Twitter(WebDriver driver){
        this.driver = driver;
        //This initElements method will create all WebElements
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 10);
    }
    //Set user name in textbox
    public void setUserName(String strUserName){
    	loginFieldUserName.sendKeys(strUserName);      
    } 

    //Set password in password textbox
    public void setPassword(String strPassword){
    	loginFieldPassword.sendKeys(strPassword);
    }

    //Click on login button
    public void clickLogin(){
    	loginButton.click();
    	pause();
    	closePopup();
    }
    
    //click on new tweet button
    public void clickNewTweet(){
    	createTweetButton.click();
    }
    //Write a tweet
    public void writeATweet(String tweet){
    	tweetField.sendKeys(tweet);
    }
    //click on tweet button
    public void clickTweet(){
    	tweetButton.click();
    }

    //click on reply for first tweet button
    public void clickReplyFirstTweet() {
    	replyButtonFirstTweet.click();
    }
    
    //write a reply first tweet
    public void writeReplyFirstTweet (String reply) {
    	replyFieldFirstTweet.sendKeys(reply);
    }
    
    public void clickOnSendReplyButton() {
    	sendReplyButton.click();
    }
    
    //reply first tweet
    public void replyOnFirstTweet(String reply) {
    	this.clickReplyFirstTweet();
    	this.pause();
    	this.writeReplyFirstTweet(reply);
    	this.pause();
    	this.clickOnSendReplyButton();
    }

    public void retweetOnFirstTweet(String retweet) {
    	this.clickRetweetFirstTweet();
    	this.pause();
    	this.writeRetweetFirsttweet(retweet);
    	this.pause();
    	this.clickOnSendRetweetButton();
    }
    
    public void clickRetweetFirstTweet() {
    	this.pause();
    	this.retweetButtonFirstTweet.click();
    }
    
    public void writeRetweetFirsttweet(String retweet) {
    	this.retweetFieldFirstTweet.click();
    	this.retweetFieldFirstTweet.sendKeys(retweet);
    }
    
    public void clickOnSendRetweetButton() {
    	this.sendRetweetButton.click();
    }
    
    /**
     * This POM method will be exposed in test case to login in the application
     * @param strUserName
     * @param strPasword
     * @return
     * @throws InterruptedException 
     */

    public void loginTwitter(String strUserName,String strPasword) throws InterruptedException {
        //Fill user name
        this.setUserName(strUserName);
        Thread.sleep(1000);
        //Fill password
        this.setPassword(strPasword);
        //Click Login button
        Thread.sleep(1000);
        this.clickLogin();
    }
    public void createATweet(String tweet) {
    	this.clickNewTweet();
    	this.pause();
    	this.writeATweet(tweet);
    	wait.until(ExpectedConditions.elementToBeClickable(tweetButton));
    	this.clickTweet();
    	this.pause();
    }
     
    public String getTextOnFirstTweet() {
    	return this.firstTweet.getText();
    }
    
    public String getTextOnSecondTweet() {
    	return this.secondTweet.getText();
    }
    
    public void clickOnUserTweetsLink() {
    	this.userTweetsLink.click();
    }
    
    public String createARandomTweet(String random) {
    	Random r = new Random();
		String tweet = random + " " + Integer.toString(r.nextInt()) + " " + Integer.toString(r.nextInt());
		return tweet;
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

	public void clickOnMessageButton() {
		this.messagesButton.click();
	}
	public void clickOnNewMessageButton() {
		this.newMessagesButton.click();
	}
	public void typeMessageUserToMessage(String user) {
		this.messageSearchUserField.sendKeys(user);
	}
	public void clickOnMessageUserButton() {
		this.messagesUserButton.click();
	}
	public void clickOnMessageNextButton() {
		this.messagesNextButton.click();
	}
	public void typeOnMessageField(String message) {
		this.messagesField.sendKeys(message);
	}
	public void clickOnMessageSendButton() {
		this.messagesSendButton.click();
	}
	
  	public void createAMessageTo(String messageTo, String message) {
		// click on messages
		this.clickOnMessageButton();
		// click on new message
		this.clickOnNewMessageButton();
		// type the user
		this.typeMessageUserToMessage(messageTo);
		// click the user
		//this.clickOnMessageUserButton();
		// click on next
		this.pause();
		this.clickOnMessageNextButton();
		// type the message
		this.typeOnMessageField(message);
		this.pause();
		// click on send
		this.clickOnMessageSendButton();
	}
	public void logout() {
		this.userHeaderButton.click();
		this.logoutButton.click();		
	}
	
	public void closePopup () {
		List <WebElement> check = driver.findElements(By.xpath(twitterPopupClosed));
		if (check.size()==1) {
			check.get(0).click();
		}
	}
}