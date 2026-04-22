package Business.Coding_Lists.Test_Cases;

import java.io.IOException;

import org.testng.annotations.Test;

import Test.Kit.Actions_Class.Create_test_kit_Actions;
import Test.Kit.Actions_Class.Rewrite_Login_Action;
import Test.Kit.Preference_Actions_Class.Facilities_Action;
import Wrappers.WebCommonPath;
import dataSources.PropertiesReader;
import initializer.BaseClass;

public class Preference_Test extends BaseClass  {	
	
	public Facilities_Action FacActions;
	Rewrite_Login_Test loginRewrite;
	
	@Test
	public void Preferences() throws IOException, InterruptedException {
		loginRewrite = new Rewrite_Login_Test();
		loginRewrite.loginToRewrite();
		FacActions = new Facilities_Action(getDriver());

		FacActions.FacilitiesAction(PropertiesReader.getPropertyValue(WebCommonPath.testDatafile, "fac"));
	}
	


}
