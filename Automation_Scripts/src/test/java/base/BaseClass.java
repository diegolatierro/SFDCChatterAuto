package base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import pageFactory.Data;


public class BaseClass {

	protected WebDriver driver;
	protected WebDriverWait wait;
	protected Data objData;
	protected JavascriptExecutor js;
	
	@BeforeClass
	public void setup() {
        driver = new FirefoxDriver();
        objData = new Data(driver);
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        driver.get(objData.getChatterUrl());
        if (driver instanceof JavascriptExecutor) {
            js = (JavascriptExecutor)driver;
        }
        else {
            throw new IllegalStateException("This driver does not support JavaScript!");
        }
	}
	
    @AfterClass
	public void exit () {
		driver.close();
	}
    protected boolean isTextPresent(String text){
        try{
            boolean b = driver.getPageSource().contains(text);
            return b;
        }
        catch(Exception e){
            return false;
        }
      }
}
