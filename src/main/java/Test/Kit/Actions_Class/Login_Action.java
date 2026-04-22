package Test.Kit.Actions_Class;

import java.time.Duration;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import Test.Kit.Locators_Class.Login_Locators;
import Wrappers.WebButton;
import Wrappers.WebTextBox;
import Wrappers.WebWait;


public class Login_Action {

	public WebDriver driver;
	Login_Locators loginLocators = null;

	public Login_Action(WebDriver driver) {
		this.driver = driver;
		loginLocators = new Login_Locators(driver);
	}

	public void enterEmailID(String EmailID) {
		// Performing action on Email ID Text Box
		WebTextBox.sendInputUpdate(loginLocators.getemailAddress(), EmailID);
		
		
	
	}

	public void enterPassword(String Password) {
		// Performing action on Password Text Box
		WebTextBox.sendInputUpdate(loginLocators.getpassword(), Password);
	}
	
	public void clickLoginButton() {
		// click on login 
		WebWait.elementToBeClickable(driver, loginLocators.getLoginBtn(), Duration.ofSeconds(30));
		WebButton.clickButton(loginLocators.getLoginBtn());
		//WebWait.waitForDOMLoad(driver, null);
	}
//	public void Facility_Under_Construction() {
//		WebWait.elementToBeClickable(driver, loginLocators.getFUC_Popup(), Duration.ofSeconds(20));
//		WebButton.clickButton(loginLocators.getFUC_Popup());
//		WebWait.elementToBeClickable(driver, loginLocators.getFUC_Popup_OkBtn(), Duration.ofSeconds(20));
//		WebButton.clickButton(loginLocators.getFUC_Popup_OkBtn());
//	}
//	
//	
	
	
	public void login(String EmailID, String Password) {
		enterEmailID(EmailID);
		enterPassword(Password);
		clickLoginButton();
		
		
	}
	
}
