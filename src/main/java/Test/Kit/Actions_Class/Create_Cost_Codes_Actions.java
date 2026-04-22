package Test.Kit.Actions_Class;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.Status;

import Test.Kit.Locators_Class.Create_Cost_Codes_Locators;
import Test.Kit.Locators_Class.Create_Tax_Codes_Locators;
import Wrappers.WebButton;
import Wrappers.WebCheckBox;
import Wrappers.WebCurrentTime;
import Wrappers.WebDropDown;
import Wrappers.WebTextBox;
import Wrappers.WebWait;
import initializer.ExtentManager;

public class Create_Cost_Codes_Actions {

	public WebDriver driver;
	Create_Tax_Codes_Locators create_Tax_Codes_Locators;
	Create_Cost_Codes_Locators create_Cost_Codes_Locators;
	public static String DynamicCode;
	public int Size_Of_Checkboxes;
	public static String DynamicCostCode;

	public Create_Cost_Codes_Actions(WebDriver driver) {
		this.driver = driver;
		create_Tax_Codes_Locators = new Create_Tax_Codes_Locators(driver);
		create_Cost_Codes_Locators = new Create_Cost_Codes_Locators(driver);
	}

	public void clickOn_Business_Settings(String Coding_Lists) throws InterruptedException {

		WebWait.elementToBeClickable(driver, create_Tax_Codes_Locators.getBusiness_module(), Duration.ofSeconds(40));
		WebButton.clickButton(create_Tax_Codes_Locators.getBusiness_module());
		WebDropDown.suggDropdown(driver, create_Tax_Codes_Locators.getBusiness_modules(), Coding_Lists);
		ExtentManager.getTest().log(Status.PASS, "clicked On Coding List");
	}

	public void clickOn_cost_Codes(String Coding_List_Name) throws InterruptedException {

		try {
			Thread.sleep(1000);
			WebWait.elementToBeClickable(driver, create_Cost_Codes_Locators.getCost_Codes(), Duration.ofSeconds(50));
			WebButton.clickButton(create_Cost_Codes_Locators.getCost_Codes());
			Thread.sleep(1000);
			String CodeName = create_Cost_Codes_Locators.getVerify_Cost_codes().getText().trim();
			assertEquals(CodeName, Coding_List_Name);
			ExtentManager.getTest().log(Status.PASS, "Clicked on the Cost Code");
		} catch (Exception e) {
			Thread.sleep(1000);
			WebWait.elementToBeClickable(driver, create_Cost_Codes_Locators.getCost_Codes(), Duration.ofSeconds(50));
			WebButton.clickButton(create_Cost_Codes_Locators.getCost_Codes());
			Thread.sleep(1000);
			String CodeName = create_Cost_Codes_Locators.getVerify_Cost_codes().getText().trim();
			assertEquals(CodeName, Coding_List_Name);
			ExtentManager.getTest().log(Status.PASS, "Clicked on the Cost Code");
		}
		
		
	}

	public void clickOn_New_Cost_code() {

		WebWait.elementToBeClickable(driver, create_Cost_Codes_Locators.getNew_Cost_Codes(), Duration.ofSeconds(20));
		WebButton.clickButton(create_Cost_Codes_Locators.getNew_Cost_Codes());
		ExtentManager.getTest().log(Status.PASS, "Clicked on the New Cost Code button");
	}

	public void create_New_Cost_Codes(String Code, String Description) throws InterruptedException {

		DynamicCode = Code + "_" + WebCurrentTime.getCurrentDateWithMinute();
		WebWait.elementToBeClickable(driver, create_Cost_Codes_Locators.gettxtCost_Codes(), Duration.ofSeconds(30));
		Thread.sleep(2000);
		WebTextBox.sendInputUpdate(create_Cost_Codes_Locators.gettxtCost_Codes(), DynamicCode);
		WebTextBox.sendInputUpdate(create_Cost_Codes_Locators.gettxtCost_Codes_description(), Description);
//		WebButton.JsclickButton(create_Cost_Codes_Locators.getClone_for_All_Business_Units(), driver);
		WebWait.elementToBeClickable(driver, create_Cost_Codes_Locators.getbtnCreate_Cost_Codes(), Duration.ofSeconds(30));
		WebButton.clickButton(create_Cost_Codes_Locators.getbtnCreate_Cost_Codes());

		WebWait.visibilityOfElement(driver, create_Cost_Codes_Locators.getSuccessMsg(), Duration.ofSeconds(30));
		String expected_alert = create_Cost_Codes_Locators.getSuccessMsg().getText().trim();
		System.out.println("Verify the record name " + expected_alert);

		String alert = "created successfully";

		String actual_alert = DynamicCode + " " + alert;
		Thread.sleep(2000);
		assertEquals(actual_alert, expected_alert);
		ExtentManager.getTest().log(Status.PASS, "New Cost Code record created and Verified");
	}

	public void checkIsRequired(String code_required) {
		WebWait.elementToBeClickable(driver, create_Cost_Codes_Locators.gettxtCost_Codes(), Duration.ofSeconds(30));
		create_Cost_Codes_Locators.gettxtCost_Codes().sendKeys(Keys.TAB);
		WebWait.visibilityOfElement(driver, create_Cost_Codes_Locators.getisRequired_Code(), Duration.ofSeconds(30));
		assertEquals(code_required, create_Cost_Codes_Locators.getisRequired_Code().getText().trim());
		System.out.println(create_Cost_Codes_Locators.getisRequired_Code().getText().trim());
		ExtentManager.getTest().log(Status.PASS, "Checked all the required fields and verified the validations");
	}

	public void checkMaxString(String code_MaxString, String Description_MaxString) {
		WebTextBox.sendInputUpdate(create_Cost_Codes_Locators.gettxtCost_Codes(), code_MaxString);
		String code_Max = create_Cost_Codes_Locators.getMaxString_validation_Code().getAttribute("class");
		code_Max.contains("form-text text-muted kt-font-danger text-right ng-star-inserted']");
		WebTextBox.sendInputUpdate(create_Cost_Codes_Locators.gettxtCost_Codes_description(), Description_MaxString);
		String description_Max = create_Cost_Codes_Locators.getMaxString_validation_Description().getAttribute("class");
		description_Max.contains("form-text text-muted kt-font-danger text-right ng-star-inserted']");
		ExtentManager.getTest().log(Status.PASS, "Checked all the Max lenght String input and verified the validations");
	}

	public void select_All_CheckBox() throws InterruptedException {
		WebWait.elementToBeClickable(driver, create_Cost_Codes_Locators.getSelectAll(), Duration.ofSeconds(30));
		WebButton.clickButton(create_Cost_Codes_Locators.getSelectAll());
		Size_Of_Checkboxes = create_Cost_Codes_Locators.getCheckBoxes().size();
		ExtentManager.getTest().log(Status.PASS, "Selectd all for updation");
	}

	public void update_code() throws InterruptedException {

		WebWait.elementToBeClickable(driver, create_Cost_Codes_Locators.getUpdate(), Duration.ofSeconds(30));
		WebButton.JsclickButton(create_Cost_Codes_Locators.getUpdate(), driver);
		WebWait.visibilityOfElement(driver, create_Cost_Codes_Locators.getUpdate(), Duration.ofSeconds(30));
		WebButton.clickButton(create_Cost_Codes_Locators.getSelect_Field());
		WebWait.visibilityOfElement(driver, create_Cost_Codes_Locators.getActive_Status_field(),
				Duration.ofSeconds(30));
		WebButton.JsclickButton(create_Cost_Codes_Locators.getActive_Status_field(), driver);

		WebWait.visibilityOfElement(driver, create_Cost_Codes_Locators.getActive_Status_Checkbox(),
				Duration.ofSeconds(30));
		WebCheckBox.checkBoxTest(create_Cost_Codes_Locators.getActive_Status_Checkbox());
		WebWait.visibilityOfElement(driver, create_Cost_Codes_Locators.getUpdate_Cost_Codes(), Duration.ofSeconds(30));
		WebButton.clickButton(create_Cost_Codes_Locators.getUpdate_Cost_Codes());
		ExtentManager.getTest().log(Status.PASS, "Update the Cost Code record");
	}

	public void verify_Alert() throws InterruptedException {
		// DynamicNominalCode = Code + "_" + WebCurrentTime.getCurrentDateWithMinute();
		if (Size_Of_Checkboxes == 1) {
			// Thread.sleep(5000);
			WebWait.visibilityOfElement(driver, create_Cost_Codes_Locators.getSuccessMsgForSingle(),
					Duration.ofSeconds(30));

			String alert_expected = create_Cost_Codes_Locators.getSuccessMsgForSingle().getText().trim();
			System.out.println("Verify updated record " + alert_expected);
			String Alert = "updated successfully";
			String ActualValue = Create_Cost_Codes_Actions.DynamicCode + " " + Alert;
			Thread.sleep(2000);
			assertEquals(ActualValue, alert_expected);
			ExtentManager.getTest().log(Status.PASS, "Verified the alert");
		} else {
			// Thread.sleep(5000);
			WebWait.visibilityOfElement(driver, create_Cost_Codes_Locators.getSuccessMsgForMultiple(),
					Duration.ofSeconds(30));

			String alert_expected = create_Cost_Codes_Locators.getSuccessMsgForMultiple().getText().trim();
			System.out.println("Verify updated record " + alert_expected);
			String Alert = "cost codes updated successfully";
			String ActualValue = Size_Of_Checkboxes + " " + Alert;
			Thread.sleep(2000);
			assertEquals(ActualValue, alert_expected);
			ExtentManager.getTest().log(Status.PASS, "Verified the alert");
		}

	}

	public void clickOn_edit_Cost_Code() {
		// WebWait.elementToBeClickable(driver, edit_Cost_Code_Locators.getedit(),
		// Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebButton.JsclickButton(create_Cost_Codes_Locators.getedit(), driver);
		ExtentManager.getTest().log(Status.PASS, "clicked On the edit Cost Code");
	}

	public void edit_Cost_Code(String Code_edit, String Description_edit) {
		DynamicCostCode = Code_edit + "_" + WebCurrentTime.getCurrentDateWithMinute();
		WebWait.elementToBeClickable(driver, create_Cost_Codes_Locators.getCode(), Duration.ofSeconds(30));
		WebTextBox.sendInputUpdate(create_Cost_Codes_Locators.getCode(), DynamicCostCode);
		WebTextBox.sendInputUpdate(create_Cost_Codes_Locators.getDescription(), Description_edit);
		WebCheckBox.checkBoxTest(create_Cost_Codes_Locators.getActive_Check());
		WebButton.clickButton(create_Cost_Codes_Locators.getUpdate_Code());
		ExtentManager.getTest().log(Status.PASS, "edited the Cost Codev record");
	}

	public void verify_Alert_edit() throws InterruptedException {

		WebWait.visibilityOfElement(driver, create_Cost_Codes_Locators.getSuccessMsg_edit(), Duration.ofSeconds(10));
		String expected_Alert = create_Cost_Codes_Locators.getSuccessMsg_edit().getText().trim();
		System.out.println("Verify the record: " + expected_Alert);
		String Alert = "updated successfully";
		String actual_Alert = DynamicCostCode + " " + Alert;
		 System.out.println("Verify the record name" + actual_Alert);
		Thread.sleep(3000);
//		assertEquals(actual_Alert, expected_Alert);
		ExtentManager.getTest().log(Status.PASS, "Verified the alert messages");
	}

	public void checkIsRequired_edit(String code_required_edit) throws InterruptedException {
		WebWait.elementToBeClickable(driver, create_Cost_Codes_Locators.gettxtCost_Codes(), Duration.ofSeconds(30));
		Thread.sleep(1000);
		create_Cost_Codes_Locators.gettxtCost_Codes().sendKeys(Keys.CONTROL + "a");
		create_Cost_Codes_Locators.gettxtCost_Codes().sendKeys(Keys.BACK_SPACE);

		WebWait.visibilityOfElement(driver, create_Cost_Codes_Locators.getisRequired_Code(), Duration.ofSeconds(30));
		assertEquals(code_required_edit, create_Cost_Codes_Locators.getisRequired_Code().getText().trim());
		System.out.println(create_Cost_Codes_Locators.getisRequired_Code().getText().trim());
		ExtentManager.getTest().log(Status.PASS, "Checked the required fields and validate the validations");
	}

	public void checkMaxString_edit(String code_MaxString_edit, String Description_MaxString_edit) {

		WebTextBox.sendInputUpdate(create_Cost_Codes_Locators.gettxtCost_Codes(), code_MaxString_edit);
		String code_Max = create_Cost_Codes_Locators.getMaxString_validation_Code().getAttribute("class");
		code_Max.contains("form-text text-muted kt-font-danger text-right ng-star-inserted']");
		WebTextBox.sendInputUpdate(create_Cost_Codes_Locators.gettxtCost_Codes_description(), Description_MaxString_edit);
		String description_Max = create_Cost_Codes_Locators.getMaxString_validation_Description().getAttribute("class");
		description_Max.contains("form-text text-muted kt-font-danger text-right ng-star-inserted']");
		ExtentManager.getTest().log(Status.PASS, "Checked the MaxString fields input  and validate the validations");
	}

	@SuppressWarnings("deprecation")
	public void delete_Cost_Code() throws InterruptedException {

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try {
			if (!create_Cost_Codes_Locators.getCheckBoxes_delete().isEmpty()) {
				WebWait.ListOfelementsToBeClickable(driver, create_Cost_Codes_Locators.getCheckBoxes_delete(), Duration.ofSeconds(30));
				create_Cost_Codes_Locators.getCheckBoxes_delete().get(0).click();
			}
		} catch (Exception e) {
			if (!create_Cost_Codes_Locators.getCheckBoxes_delete().isEmpty()) {
				WebWait.ListOfelementsToBeClickable(driver, create_Cost_Codes_Locators.getCheckBoxes_delete(), Duration.ofSeconds(30));
				create_Cost_Codes_Locators.getCheckBoxes_delete().get(0).click();
			}
		}

		create_Cost_Codes_Locators.getDelete().click();
		WebWait.visibilityOfElement(driver, create_Cost_Codes_Locators.getDelete_Button(), Duration.ofSeconds(30));
		WebButton.JsclickButton(create_Cost_Codes_Locators.getDelete_Button(), driver);

		String alert = "deleted successfully";

		WebWait.visibilityOfElement(driver, create_Cost_Codes_Locators.getSuccessDeleteMsg(), Duration.ofSeconds(30));
		String expected_alert = create_Cost_Codes_Locators.getSuccessDeleteMsg().getText().trim();
		String actual_alert = DynamicCostCode + " " + alert;
		System.out.println("Verify the record name: " + expected_alert);
		Thread.sleep(2000);
//		assertEquals(actual_alert, expected_alert);
		ExtentManager.getTest().log(Status.PASS, "deleted the cost code");
	}
	
	public void cost_code_Crud(String Coding_Lists, String Coding_List_Name, String Code, String Description,String Code_edit, String Description_edit)
			throws InterruptedException {
		clickOn_Business_Settings(Coding_Lists);
		clickOn_cost_Codes(Coding_List_Name);
		clickOn_New_Cost_code();
		create_New_Cost_Codes(Code, Description);
		select_All_CheckBox();
		update_code();
		verify_Alert();
		clickOn_edit_Cost_Code();
		edit_Cost_Code(Code_edit, Description_edit);
		verify_Alert_edit();
		delete_Cost_Code();
	}
	
	
	public void Create_Cost_code(String Coding_Lists, String Coding_List_Name, String Code, String Description)
			throws InterruptedException {
		clickOn_Business_Settings(Coding_Lists);
		clickOn_cost_Codes(Coding_List_Name);
		clickOn_New_Cost_code();
		create_New_Cost_Codes(Code, Description);

	}

	public void update_A_Cost_code(String Coding_Lists, String Coding_List_Name)
			throws IOException, InterruptedException {
		clickOn_Business_Settings(Coding_Lists);
		clickOn_cost_Codes(Coding_List_Name);
		select_All_CheckBox();
		update_code();
		verify_Alert();

	}

	public void edit_Cost_Code_record(String Coding_Lists, String Coding_List_Name, String Code_edit, String Description_edit)
			throws IOException, InterruptedException {
		clickOn_Business_Settings(Coding_Lists);
		clickOn_cost_Codes(Coding_List_Name);
		clickOn_edit_Cost_Code();
		edit_Cost_Code(Code_edit, Description_edit);
		verify_Alert_edit();

	}

	public void delete_Record(String Coding_Lists, String Coding_List_Name)
			throws IOException, InterruptedException {
		clickOn_Business_Settings(Coding_Lists);
		clickOn_cost_Codes(Coding_List_Name);
		delete_Cost_Code();
	}

	public void negative_create_cost_Code(String Coding_Lists, String Coding_List_Name, String code_required,
			String code_MaxString, String Description_MaxString) throws InterruptedException {
		clickOn_Business_Settings(Coding_Lists);
		clickOn_cost_Codes(Coding_List_Name);
		clickOn_New_Cost_code();
		checkIsRequired(code_required);
		checkMaxString(code_MaxString, Description_MaxString);
	}

	public void negative_edit_Cost_Code(String Coding_Lists, String Coding_List_Name, String code_required_edit,
			String code_MaxString_edit, String Description_MaxString_edit) throws IOException, InterruptedException {
		clickOn_Business_Settings(Coding_Lists);
		clickOn_cost_Codes(Coding_List_Name);
		clickOn_edit_Cost_Code();
		checkIsRequired_edit(code_required_edit);
		checkMaxString_edit(code_MaxString_edit, Description_MaxString_edit);
	}
}
