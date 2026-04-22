package ESCt;
import dataSources.emplyeeDataUtil;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import Business.Coding_Lists.Test_Cases.MasterFile_Test;
import Business.Coding_Lists.Test_Cases.Rewrite_Login_Test;
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
	

	
	@Test(priority =1)
	public void AddNewUser() throws IOException, InterruptedException  {

		

	    loginRewrite = new Rewrite_Login_Test();
	    loginRewrite.loginToRewrite();

	    FacActions = new Facilities_Action(getDriver());
	    FacActions.ClickOnPreferences();

	    user_actions = new Users_Action(getDriver());
	    user_actions.userActions();
		
		int srNo = 5;
	    String employee = emplyeeDataUtil.getEmployeeName(srNo); // fetch name from Excel only
	    user_actions.EnterUserDetails();
	    user_actions.SelectEmpFromDropdown(employee);
	    System.out.println("Given Employee is selected " +employee);
	   
	    
	}
	@AfterMethod
	public void Thanks()
	{
		System.out.println("Thankssssssssss...");
		System.out.println("After Test Executed");
	}
//	
//
}
