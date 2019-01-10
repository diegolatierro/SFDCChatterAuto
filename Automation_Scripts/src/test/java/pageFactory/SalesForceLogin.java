package pageFactory;//Page factory

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SalesForceLogin {

    /**
     * All WebElements are identified by @FindBy annotation
     */

    WebDriver driver;
    @FindBy(id="username")
    WebElement loginFieldUserName;   
    @FindBy(id="password")
    WebElement loginFieldPassword;
    @FindBy(id="Login")
    WebElement loginButton;
    /*@FindBy(name="btnLogin")
    WebElement login;*/
    public SalesForceLogin(WebDriver driver){
        this.driver = driver;
        //This initElements method will create all WebElements
        PageFactory.initElements(driver, this);
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
    }


    /**
     * This POM method will be exposed in test case to login in the application
     * @param strUserName
     * @param strPasword
     * @return
     */

    public void loginToSalesforce(String strUserName,String strPasword){
        //Fill user name
        this.setUserName(strUserName);
        //Fill password
        this.setPassword(strPasword);
        //Click Login button
        this.clickLogin();
        this.pause();
    }
  //NOT WRITE BUT THE ONLY WORKAROUND THAT I FOUND
  	public void pause() {
  		try {
  			Thread.sleep(6000);
  		} catch (InterruptedException e) {
  			e.printStackTrace();
  		}
  	}
}