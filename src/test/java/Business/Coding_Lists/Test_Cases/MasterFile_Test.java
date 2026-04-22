package Business.Coding_Lists.Test_Cases;

import org.testng.annotations.Test;
import java.io.IOException;

import org.testng.annotations.Test;

import Test.Kit.Master_File_Action_Class.Employees_Action;
import Wrappers.WebCommonPath;
import dataSources.Excel;
import dataSources.RewriteExcel;
import initializer.BaseClass;

public class MasterFile_Test extends BaseClass {
	
	public Employees_Action EmpActions;
	Rewrite_Login_Test loginRewrite;
	Preference_Test preftest;
	 int srNo =5;
//@Test
//public void Master_File_Login() throws IOException, InterruptedException {
//
//    loginRewrite = new Rewrite_Login_Test();
//    loginRewrite.loginToRewrite();
//   
//}

@Test
public void Master_File_CreateEmployee() throws IOException, InterruptedException {
	 loginRewrite = new Rewrite_Login_Test();
     loginRewrite.loginToRewrite();
	 EmpActions = new Employees_Action(getDriver());
	    EmpActions.EmployeesAction();
	    int srNo =6;
	    String[] empData = EmpActions.sendEmployee(srNo);
	    String firstName = empData[0];
	    String lastName = empData[1];
	    String Employee = EmpActions.EmployeeName(srNo);
	    System.out.println("Added employee is "+Employee);
	    EmpActions.addNewEmployee(firstName, lastName);
	    EmpActions.searchEmployee(lastName);
	    EmpActions.deleteEmployee(firstName, lastName);
}

	}

