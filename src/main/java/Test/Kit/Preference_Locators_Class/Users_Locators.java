package Test.Kit.Preference_Locators_Class;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Users_Locators {
	
	public WebDriver driver;

	public Users_Locators(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath = "//span[normalize-space()='User/Roles']")
	private WebElement User_RoleModule;

	public  WebElement getUser_RoleModule() {
		return User_RoleModule;
	}

	@FindBy(xpath = "//span[contains(text(),'User Management')]")
	private WebElement User_Management;

	public  WebElement getUser_Management() {
		return User_Management;
	}
	
	@FindBy(xpath = "//div[@class='col-md-6 text-end page-title-right']//button[@title='Add User'][normalize-space()='Add User']")
	private WebElement AddUser;

	public  WebElement getAddUser() {
		return AddUser;
	}
	
	@FindBy(xpath = "//span[contains(text(),'Select Employee')]")
	private WebElement SelectEmp;

	public  WebElement ClickOnSelectEmp() {
		return SelectEmp;
	}
	
	@FindBy(xpath = "//div//ul[@role='listbox']//li[@role='option']//span")
	private List<WebElement> ListOfEmployees;

	public List<WebElement> getListOfEmployees() {
		return ListOfEmployees;
	}
	
	
	
	
	


}
