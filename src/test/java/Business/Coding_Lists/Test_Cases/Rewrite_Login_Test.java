package Business.Coding_Lists.Test_Cases;

import java.io.IOException;

import org.testng.annotations.Test;

import Test.Kit.Actions_Class.Login_Action;
import Test.Kit.Actions_Class.Rewrite_Login_Action;
import Wrappers.WebCommonPath;
import dataSources.PropertiesReader;
import initializer.BaseClass;

public class Rewrite_Login_Test extends BaseClass {
	public Rewrite_Login_Action login;
	
	@Test
	public void loginToRewrite() throws IOException, InterruptedException {

		login = new Rewrite_Login_Action(getDriver());
		
		login.login(PropertiesReader.getPropertyValue(WebCommonPath.testDatafile, "EmailID"),
				PropertiesReader.getPropertyValue(WebCommonPath.testDatafile, "Password"));
	
		
		
	}

}
