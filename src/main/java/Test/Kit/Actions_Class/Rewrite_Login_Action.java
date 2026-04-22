package Test.Kit.Actions_Class;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import Test.Kit.Locators_Class.Login_Locators;
import Test.Kit.Locators_Class.Rewrite_Login_Locators;
import Wrappers.WebButton;
import Wrappers.WebCommonPath;
import Wrappers.WebDropDown;
import Wrappers.WebTextBox;
import Wrappers.WebWait;
import dataSources.PropertiesReader;

public class Rewrite_Login_Action {
	
	public WebDriver driver;
	Rewrite_Login_Locators RloginLocators = null;

	public Rewrite_Login_Action(WebDriver driver) {
		this.driver = driver;
		RloginLocators = new Rewrite_Login_Locators(driver);
	}
	
	public void enterEmailID(String EmailID) throws InterruptedException {
		WebWait.visibilityOfElement(driver, RloginLocators.getemailAddress(), Duration.ofSeconds(30));
		WebTextBox.sendInputUpdate(RloginLocators.getemailAddress(), EmailID);
	}

	public void enterPassword(String Password) {
		WebWait.visibilityOfElement(driver, RloginLocators.getpassword(), Duration.ofSeconds(30));
		WebTextBox.sendInputUpdate(RloginLocators.getpassword(), Password);
	}
	
	public void clickSubmitButton() {
		WebWait.elementToBeClickable(driver, RloginLocators.getLoginBtn(), Duration.ofSeconds(30));
		WebButton.clickButton(RloginLocators.getLoginBtn());
	}
	public void selectFacility() throws InterruptedException, IOException {
		WebWait.visibilityOfElement(driver, RloginLocators.getfacilityPopup(), Duration.ofSeconds(30));
		WebWait.visibilityOfElement(driver, RloginLocators.getDropdownBtn(), Duration.ofSeconds(30));
		WebButton.clickButton(RloginLocators.getDropdownBtn());
		//WebDropDown.suggDropdown(driver, RloginLocators.getFacilityList(), "QA ONLY ESCt WEB Rewrite_3Jun25 - QA ONLY ESCt WEB Rewrite 4Jun25");
		WebDropDown.suggDropdown(driver, RloginLocators.getFacilityList(), PropertiesReader.getPropertyValue(WebCommonPath.testDatafile, "facility"));

	}
	
	public void ConfirmationPopup() {
		WebWait.elementToBeClickable(driver, RloginLocators.getConfirmPopup(), Duration.ofSeconds(30));
		WebButton.clickButton(RloginLocators.getConfirmPopupYes());
	}
	public void clickLoginButton() {
		
		WebWait.elementToBeClickable(driver, RloginLocators.getLoginBtn1(), Duration.ofSeconds(30));
		WebButton.clickButton(RloginLocators.getLoginBtn1());
		
	}
	public void Facility_Under_Construction() {
		WebWait.elementToBeClickable(driver, RloginLocators.getFUC_Popup(), Duration.ofSeconds(20));
		WebButton.clickButton(RloginLocators.getFUC_Popup());
		WebWait.elementToBeClickable(driver, RloginLocators.getFUC_Popup_OkBtn(), Duration.ofSeconds(20));
		WebButton.clickButton(RloginLocators.getFUC_Popup_OkBtn());
	}
	
	
	
	public void login(String EmailID, String Password) throws InterruptedException, IOException {
		enterEmailID(EmailID);
		enterPassword(Password);
		clickSubmitButton();
		try {
	        ConfirmationPopup();  
	    } catch (NoSuchElementException e) {
	        System.out.println("Confirmation popup not displayed.");
	    }
		selectFacility();
		clickLoginButton();
		
		try {
			Facility_Under_Construction();  
	    } catch (NoSuchElementException e) {
	        System.out.println("Facility_Under_Construction popup not displayed.");
	    }
		

	}

}
