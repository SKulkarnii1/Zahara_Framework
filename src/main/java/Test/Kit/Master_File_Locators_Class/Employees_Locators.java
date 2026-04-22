package Test.Kit.Master_File_Locators_Class;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Employees_Locators {
	public WebDriver driver;

	public Employees_Locators(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath = "//span[contains(text(),'Master File')]")
	private WebElement MasterFileMenu;

	public  WebElement getMasterFileMenu() {
		return MasterFileMenu;
	}
	
	@FindBy(xpath = "//button[@title='Employees']//span[@class='k-button-icon k-icon ng-star-inserted']")
	private WebElement EmployeesTab;
	
	public WebElement getEmployeesTab()
	{
		return EmployeesTab;
	}
	
	@FindBy(xpath = "//button[@title='Add Employee' and @class='btn btn-primary btn-with-icon me-2 ng-star-inserted']")
	private WebElement AddEmployeeBtn;
	
	public WebElement getAddEmployeeBtn()
	{
		return AddEmployeeBtn;
	}
	
	@FindBy(xpath = "//input[@placeholder='Enter FirstName']")
	private WebElement FirstName;
	
	public WebElement getFirstName()
	{
		return FirstName;
	}
	
	@FindBy(xpath = "//input[@placeholder='Enter LastName']")
	private WebElement LastName;
	
	public WebElement getLastName()
	{
		return LastName;
	}
	
	
	@FindBy(xpath = "//div[@class='col-xl-6 shared-actions-left mb-2 mb-xl-0']//button[@title='Save'][normalize-space()='Save']")
	private WebElement SaveEmpBtn;
	
	public WebElement getSaveEmpBtn()
	{
		return SaveEmpBtn;
	}
	
	
	@FindBy(xpath = "//button[@type='button'][normalize-space()='Close']")
	private WebElement CloseEmpBtn;
	
	public WebElement getCloseEmpBtn()
	{
		return CloseEmpBtn;
	}
	
	
	@FindBy(xpath = "//input[@placeholder='Enter a name']")
	private WebElement SearchField;
	
	public WebElement getSearchField()
	{
		return SearchField;
	}
	
	@FindBy(xpath = "//button[@title='Search']")
	private WebElement SearchBtn;
	
	public WebElement getSearchBtn()
	{
		return SearchBtn;
	}
	
	
//	@FindBy(xpath = "//a[normalize-space()='Lee, Mary']/parent::td/preceding-sibling::td/button[@title=\"Delete\"]")
//	private WebElement DeleteEmpl;
//	
//	public WebElement getDeleteEmplBtn()
//	{
//		return DeleteEmpl;
//	}
	
	public WebElement getDeleteEmplBtn(String fname, String lname)
	{
	    String fullName = lname + ", " + fname;
	  
	    String xpath = "//a[normalize-space()='" + fullName + "']/parent::td/preceding-sibling::td/button[@title='Delete']";

	    return driver.findElement(By.xpath(xpath));
	}
	
	
	@FindBy(xpath = "//button[@title='Yes']")
	private WebElement ConfirmPopupBtn;
	
	public WebElement getConfirmPopupBtn()
	{
		return ConfirmPopupBtn;
	}
	
}
