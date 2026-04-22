package Test.Kit.Master_File_Action_Class;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;

import Test.Kit.Master_File_Locators_Class.Employees_Locators;
import Wrappers.WebButton;
import Wrappers.WebCommonPath;
import Wrappers.WebTextBox;
import Wrappers.WebWait;
import dataSources.Excel;
import dataSources.RewriteExcel;

public class Employees_Action {
	
	public WebDriver driver;
	Employees_Locators EMLocators = null;
	
	

	public Employees_Action(WebDriver driver) {
		this.driver = driver;
		EMLocators = new Employees_Locators(driver);
		
	}
	
	public void clickOnMasterFileMenu() throws InterruptedException {
		
	    WebWait.elementToBeClickable(driver, EMLocators.getMasterFileMenu(), Duration.ofSeconds(20));  
		WebButton.clickButton(EMLocators.getMasterFileMenu());
	}
	
	public void clickOnEmployees() {
		WebWait.elementToBeClickable(driver, EMLocators.getEmployeesTab(), Duration.ofSeconds(20));
		WebButton.clickButton(EMLocators.getEmployeesTab());
	}
	
	public String[] SendEmployee() throws IOException {
	    int srNo = 3;
	    String firstName = RewriteExcel.readDataFromExcel(
	            WebCommonPath.TestData, "Sheet1", "FirstName", srNo);
	    String lastName = RewriteExcel.readDataFromExcel(
	            WebCommonPath.TestData, "Sheet1", "LastName", srNo);

	    return new String[]{firstName, lastName};
	}
	
//	public void addNewEmployee(String fname, String lname)
//	{
//	    WebWait.elementToBeClickable(driver, EMLocators.getAddEmployeeBtn(), Duration.ofSeconds(20));
//	    WebButton.clickButton(EMLocators.getAddEmployeeBtn());
//	    WebTextBox.sendInputUpdate(EMLocators.getFirstName(), fname);
//	    WebTextBox.sendInputUpdate(EMLocators.getLastName(), lname);
//	    WebButton.clickButton(EMLocators.getSaveEmpBtn());
//	    WebWait.elementToBeClickable(driver, EMLocators.getCloseEmpBtn(), Duration.ofSeconds(20));
//	    WebButton.clickButton(EMLocators.getCloseEmpBtn());
//	}
	public String[] sendEmployee(int srNo) throws IOException {

	    String firstName = RewriteExcel.readDataFromExcel(
	            WebCommonPath.TestData, "Sheet1", "FirstName", srNo);

	    String lastName = RewriteExcel.readDataFromExcel(
	            WebCommonPath.TestData, "Sheet1", "LastName", srNo);

	    return new String[]{firstName, lastName};
	}
	
	public String EmployeeName(int srNo) throws IOException, InterruptedException {

	    String[] empData = sendEmployee(srNo);
	    String firstName = empData[0];
	    String lastName = empData[1];

	    addNewEmployee(firstName, lastName);

	    return lastName + " " + firstName;
	}
	
	public void addNewEmployee(String fname, String lname) throws InterruptedException
	{
	    WebWait.elementToBeClickable(driver, EMLocators.getAddEmployeeBtn(), Duration.ofSeconds(20));
	    WebButton.clickButton(EMLocators.getAddEmployeeBtn());
	    WebTextBox.sendInputUpdate(EMLocators.getFirstName(), fname);
	    WebTextBox.sendInputUpdate(EMLocators.getLastName(), lname);
	    WebButton.clickButton(EMLocators.getSaveEmpBtn());
	    WebWait.visibilityOfElement(driver, EMLocators.getCloseEmpBtn(), Duration.ofSeconds(50));
	    WebWait.elementToBeClickable(driver, EMLocators.getCloseEmpBtn(), Duration.ofSeconds(50));
	    WebButton.clickButton(EMLocators.getCloseEmpBtn());
	    Thread.sleep(2000);
	}
	
	
	public void searchEmployee(String fname)
	{
		WebWait.visibilityOfElement(driver, EMLocators.getSearchField(), Duration.ofSeconds(50));
		 WebWait.elementToBeClickable(driver, EMLocators.getSearchField(), Duration.ofSeconds(50));
		    WebButton.clickButton(EMLocators.getSearchField());
		    WebTextBox.sendInputUpdate(EMLocators.getSearchField(), fname);
		    WebWait.visibilityOfElement(driver, EMLocators.getSearchBtn(), Duration.ofSeconds(50));
			WebWait.elementToBeClickable(driver, EMLocators.getSearchBtn(), Duration.ofSeconds(50));
		    WebButton.clickButton(EMLocators.getSearchBtn());
	}
	
	public void deleteEmployee(String fname, String lname) throws InterruptedException
	{ 
	  Thread.sleep(6000);
	   WebWait.visibilityOfElement(driver, EMLocators.getDeleteEmplBtn(fname, lname), Duration.ofSeconds(50));	 
	  WebButton.clickButton(EMLocators.getDeleteEmplBtn(fname, lname));
	    WebWait.elementToBeClickable(driver, EMLocators.getConfirmPopupBtn(), Duration.ofSeconds(20));
	    WebButton.clickButton(EMLocators.getConfirmPopupBtn());
	}
	
	
	public void EmployeesAction() throws InterruptedException, IOException {

		clickOnMasterFileMenu();
		clickOnEmployees();
		
	}


}
