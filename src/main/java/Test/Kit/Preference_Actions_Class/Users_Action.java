package Test.Kit.Preference_Actions_Class;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

import Test.Kit.Preference_Locators_Class.Users_Locators;
import Wrappers.WebButton;
import Wrappers.WebCommonPath;
import Wrappers.WebDropDown;
import Wrappers.WebWait;
import dataSources.PropertiesReader;

public class Users_Action {
	
	public WebDriver driver;
	Users_Locators ULocators = null;

	public Users_Action(WebDriver driver) {
		this.driver = driver;
		ULocators = new Users_Locators(driver);
	}
	public void ClickOnUser_RoleModule() {
		WebWait.visibilityOfElement(driver,  ULocators.getUser_RoleModule(), Duration.ofSeconds(10));
		WebButton.clickButton(ULocators.getUser_RoleModule());
	}
	
	public void ClickOnUserManagement()
	{
		WebWait.visibilityOfElement(driver,  ULocators.getUser_Management(), Duration.ofSeconds(10));
		WebButton.clickButton(ULocators.getUser_Management());
	}
	
	public void ClickOnAddUser()
	{
		WebWait.visibilityOfElement(driver,  ULocators.getAddUser(), Duration.ofSeconds(10));
		WebButton.clickButton(ULocators.getAddUser());
	}
	
	public void EnterUserDetails() throws InterruptedException
	{
		Thread.sleep(6000);
		WebWait.visibilityOfElement(driver, ULocators.ClickOnSelectEmp(), Duration.ofSeconds(10));
		WebButton.clickButton(ULocators.ClickOnSelectEmp());

		//WebWait.visibilityOfElement(driver, ULocators.getListOfEmployees(), Duration.ofSeconds(30));
//		Thread.sleep(6000);
//		WebWait.visibilityListOfElements(driver, ULocators.getListOfEmployees(), Duration.ofSeconds(30));
//		Thread.sleep(6000);
//		WebDropDown.suggDropdown(driver, ULocators.getListOfEmployees(), Employee);
	}
	
	public void SelectEmpFromDropdown(String Employee) throws InterruptedException
	{
		WebWait.visibilityListOfElements(driver, ULocators.getListOfEmployees(), Duration.ofSeconds(30));
		
		WebDropDown.suggDropdown(driver, ULocators.getListOfEmployees(), Employee);
		Thread.sleep(6000);
	}
	
	
	
	public void userActions()
	{
		ClickOnUser_RoleModule();
		ClickOnUserManagement();
		ClickOnAddUser();
	}

}
