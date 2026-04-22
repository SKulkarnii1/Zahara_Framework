package ESCt;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Test.Kit.Actions_Class.Create_test_kit_Actions;
import Test.Kit.Actions_Class.Rewrite_Login_Action;
import Test.Kit.Preference_Actions_Class.Facilities_Action;
import Wrappers.WebCommonPath;
import dataSources.PropertiesReader;
import initializer.BaseClass;
import initializer.BaseClass2;


public class Preference_Test extends BaseClass2  {	
	public Rewrite_Login_Action login;
	public Facilities_Action FacActions;
	
	
//	@BeforeTest
//	public void Preferences() throws IOException, InterruptedException {
////		System.out.println("Before Test Executing");
////		loginRewrite = new Rewrite_Login_Test();
////		loginRewrite.loginToRewrite();
////		System.out.println("Before Test Executed");
//		
//		loginRewrite = new Rewrite_Login_Test();
//		loginRewrite.loginToRewrite(getDriver()); // ✅ pass driver
//		
//	}
	
	@BeforeMethod
	public void Preferences() throws IOException, InterruptedException {

         login = new Rewrite_Login_Action(getDriver());
		
		login.login(PropertiesReader.getPropertyValue(WebCommonPath.testDatafile, "EmailID"),
				PropertiesReader.getPropertyValue(WebCommonPath.testDatafile, "Password"));
	
	}
	
	@Test(priority =1, groups= {"smoke"})
	public void Preferences1() throws InterruptedException, IOException
	{
		FacActions = new Facilities_Action(getDriver());

		FacActions.FacilitiesAction(PropertiesReader.getPropertyValue(WebCommonPath.testDatafile, "fac"));
	}
	


}
