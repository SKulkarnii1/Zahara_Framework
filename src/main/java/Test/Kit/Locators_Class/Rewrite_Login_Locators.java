package Test.Kit.Locators_Class;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Rewrite_Login_Locators {
	
	public WebDriver driver;

	public Rewrite_Login_Locators(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath = "//input[@placeholder='Enter your email']")
	private WebElement txtUsername;

	public WebElement getemailAddress() {
		return txtUsername;
	}

	@FindBy(xpath = "//input[@placeholder='Enter your password']")
	private WebElement txtPassword;

	public WebElement getpassword() {
		return txtPassword;
	}
	
	
	@FindBy(xpath = "//div[@role='dialog']//kendo-dialog-titlebar//span[text()=' Select Facility ']")
	private WebElement facilityPopup;

	public WebElement getfacilityPopup() {
		return facilityPopup;
	}
//	

	@FindBy(xpath = "//kendo-dropdownlist[@textfield='name']")
	private WebElement DropdownBtn;

	public WebElement getDropdownBtn() {
		return DropdownBtn;
	}
	
	@FindBy(xpath = "//ul[@role='listbox']//li[@role='option']//span")
	private List<WebElement> FacilityList;

	public List<WebElement> getFacilityList() {
		return FacilityList;
	}
	

	@FindBy(xpath = "//button[@type='submit' and @class='w-100 btn btn-primary mb-2 ng-star-inserted']")
	private WebElement btnLogin;

	public WebElement getLoginBtn() {
		return btnLogin;
	}
	
	@FindBy(xpath = "//div[@role='dialog']")
	private WebElement ConfirmPopup;

	public WebElement getConfirmPopup() {
		return ConfirmPopup;
	}
	
	@FindBy(xpath = "//button[normalize-space()='Yes']")
	private WebElement ConfirmPopupYes;

	public WebElement getConfirmPopupYes() {
		return ConfirmPopupYes;
	}
	
	@FindBy(xpath = "//span[normalize-space()='Login']")
	private WebElement btnLogin1;

	public WebElement getLoginBtn1() {
		return btnLogin1;
	}

	@FindBy(xpath = "//div[@role='dialog']//kendo-dialog-titlebar//span[contains(text(),'Facility Under Construction')]")
	private WebElement FUC_Popup;

	public  WebElement getFUC_Popup() {
		return FUC_Popup;
	}
	
	@FindBy(xpath = "//button[normalize-space()='OK']")
	private WebElement FUC_Popup_OkBtn;

	public  WebElement getFUC_Popup_OkBtn() {
		return FUC_Popup_OkBtn;
	}
	
}
