package Test.Kit.Preference_Actions_Class;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import Test.Kit.Preference_Locators_Class.Facilities_Locators;
import Wrappers.WebButton;
import Wrappers.WebCommonPath;
import Wrappers.WebWait;
import dataSources.PropertiesReader;

public class Facilities_Action {
	public WebDriver driver;
	Facilities_Locators FLocators = null;

	public Facilities_Action(WebDriver driver) {
		this.driver = driver;
		FLocators = new Facilities_Locators(driver);
	}

	public void ClickOnPreferences() {
		WebWait.visibilityOfElement(driver,  FLocators.getPrefModule(), Duration.ofSeconds(70));
		WebWait.elementToBeClickable(driver, FLocators.getPrefModule(), Duration.ofSeconds(70));
		WebButton.JsclickButton(FLocators.getPrefModule(), driver);
	
	}
	
	public void clickLoginFacility() throws InterruptedException {
			
	    WebWait.elementToBeClickable(driver, FLocators.getFacilityTab(), Duration.ofSeconds(70));
	   
		WebButton.clickButton(FLocators.getFacilityTab());
	}
	
	public void clickEditFacility(String facilityName) throws IOException , InterruptedException
	{
		Thread.sleep(2000);	
		WebWait.visibilityOfElement(driver, FLocators.getEditFacilityBtn(facilityName), Duration.ofSeconds(50));
		WebButton.click_action(driver, FLocators.getEditFacilityBtn(facilityName));

	}

	
	public void clickOnSave() throws InterruptedException
	{
		WebWait.visibilityOfElement(driver,  FLocators.getFacSave(), Duration.ofSeconds(50));
		WebButton.click_action(driver , FLocators.getFacSave());
		Thread.sleep(2000);
	
	}
	
	public void FacilitiesAction(String facilityName) throws InterruptedException, IOException {

		ClickOnPreferences();
		clickLoginFacility();
		clickEditFacility(facilityName);
	
		clickOnSave();
		Thread.sleep(6000);
		
	}


	

}
