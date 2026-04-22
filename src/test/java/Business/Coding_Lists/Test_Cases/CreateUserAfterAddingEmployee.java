package Business.Coding_Lists.Test_Cases;
import dataSources.emplyeeDataUtil;

import java.io.IOException;

import org.testng.annotations.Test;

import Test.Kit.Master_File_Action_Class.Employees_Action;
import Test.Kit.Preference_Actions_Class.Facilities_Action;
import Test.Kit.Preference_Actions_Class.Users_Action;
import initializer.BaseClass;

public class CreateUserAfterAddingEmployee extends BaseClass {
	
	public Facilities_Action FacActions;
	Rewrite_Login_Test loginRewrite;
	Preference_Test prefTest;
	MasterFile_Test CreateEmp;
	Users_Action user_actions;
	Employees_Action EmployeeActions;       
	
//	@Test
//	public void CreateEmployee() throws IOException, InterruptedException {
//		loginRewrite = new Rewrite_Login_Test();
//		loginRewrite.loginToRewrite();
//		CreateEmp = new MasterFile_Test();
//		CreateEmp.Master_File_CreateEmployee();
//		
//	}
	
	@Test
	public void AddNewUser() throws IOException, InterruptedException  {
//		int srNo =5;
//		loginRewrite = new Rewrite_Login_Test();
//		loginRewrite.loginToRewrite();
////		CreateEmp = new MasterFile_Test();
////		CreateEmp.Master_File_CreateEmployee();
//		
//		FacActions = new Facilities_Action(getDriver());
//		FacActions.ClickOnPreferences();
//		user_actions = new Users_Action(getDriver());
//		user_actions.userActions();
//	//	Employees_Action EmployeeActions = new Employees_Action();
//		Thread.sleep(3000);
//		user_actions.EnterUserDetails(EmployeeActions.EmployeeName(srNo));
//		
		
		int srNo = 5;

	    // Login
	    loginRewrite = new Rewrite_Login_Test();
	    loginRewrite.loginToRewrite();
//	    EmployeeActions = new Employees_Action(getDriver());
//	    String employee = EmployeeActions.EmployeeName(srNo);  

	    // Navigate to Preferences → Users
	    FacActions = new Facilities_Action(getDriver());
	    FacActions.ClickOnPreferences();

	    user_actions = new Users_Action(getDriver());
	    user_actions.userActions();
	    
	    String employee = emplyeeDataUtil.getEmployeeName(srNo); // fetch name from Excel only
	    user_actions.EnterUserDetails();
	    user_actions.SelectEmpFromDropdown(employee);
	    System.out.println("Given Employee is selected " +employee);
	   
	    
	}
//	
//
}
